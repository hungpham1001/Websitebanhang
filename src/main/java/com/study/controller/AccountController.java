package com.study.controller;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.study.CookieService.CookieService;
import com.study.Services.MailServices;
import com.study.bean.MailForm;
import com.study.dao.CustomerDaoImpl;
import com.study.entity.Customer;

@Controller
public class AccountController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	@Autowired
	CustomerDaoImpl cus;
	@Autowired
	ServletContext app;
	@Autowired
	MailServices mail;
	@Autowired
	CookieService ck;
	@GetMapping("account/login")
	public String getLogin() {
		return "account/login";
	}
	@PostMapping("account/login")
	public String login(Model model,@RequestParam("user") String user,@RequestParam("pw") String pw,
										@RequestParam(name = "rmb", defaultValue = "false") boolean rmb) throws IOException {
		HttpSession session = request.getSession();
		Customer cust = cus.findById(user);
		System.out.println(rmb+"check remember");
		if(cust==null) {
			session.setAttribute("errorMessageLogin", "Wrong user name");
			return "redirect:/account/login";
		} else if(!cust.isActivated()) {
			session.setAttribute("errorMessageLogin","Your account is inactivated! Please check your email to activate");
			return "redirect:/account/login";
		} else if(!cust.getPassword().equals(pw)) {
			session.setAttribute("errorMessageLogin", "Wrong password");
			return "redirect:/account/login";
		} else {
				System.out.println("login");
				if(rmb) {
					ck.create("accrmb", user, 30);
					ck.create("accrmb1", pw, 30);
				} else {
					ck.delete("accrmb");
					ck.delete("accrmb1");
				}
				session.removeAttribute("errorMessageLogin");
				session.setAttribute("user", cust);
				String uri = (String) session.getAttribute("backUri");
				System.out.println(uri+"login");
				return "redirect:"+uri;
		}
	}
	@GetMapping("account/registration")
	public String regist(@ModelAttribute("user") Customer user) {
		return "account/registration";
	}
	@PostMapping("account/registration")
	public String regist2(@Valid @ModelAttribute("user") Customer user,BindingResult resutl,Model model,
			@RequestParam("attach") MultipartFile attach,
			@RequestParam("confirmPass") String confirmPass) throws IllegalStateException, IOException{
		if(resutl.hasErrors()) {
			return "account/registration";
		}
		HttpSession session = request.getSession();
		if(attach.isEmpty()) {
			user.setPhoto("male_user_icon.png");
		} else {
			user.setPhoto(attach.getOriginalFilename());
			File file = new File(app.getRealPath("/static/picture/user/"+user.getPhoto()));
			attach.transferTo(file);
		}
		if(!user.getPassword().equals(confirmPass)) {
			model.addAttribute("userExist","Confirm Password not match with Password");
			return "account/registration";
		} else if(cus.findById(user.getId())!=null) {
			model.addAttribute("userExist","user was exist");
			return "account/registration";
		} else if(cus.findByEmail(user.getEmail())!=null) {
			model.addAttribute("userExist","Your email was already used");
			return "account/registration";
		} 
		cus.save(user);
		session.setAttribute("userRegist", user);
		session.setAttribute("success","Success! Please check your email for activate account");
		return "redirect:/account/registrationSuccess";
	}
	
	@RequestMapping("account/registrationSuccess")
	public String registSuccess(Model model) throws MessagingException  {
		HttpSession session = request.getSession();
		Customer user =(Customer) session.getAttribute("userRegist");
		String text = "Please click a link below to activate your account<br>http://localhost:8080/account/activate/"
								+user.getId();	
		MailForm form = new MailForm(user.getEmail(), "Activate account from websitebanhang", text);
			mail.send(form);
			return "account/registrationSuccess";
	}
	
	@RequestMapping("account/activate/{user}")
	public String activateSuccess(@PathVariable("user") String userId,Model model) {
				Customer cust = cus.findById(userId);
				if(cust!=null) {
					if(cust.isActivated()==false) {
						cust.setActivated(true);
						cus.update(cust);
						model.addAttribute("message", "Your account is activated!");
					} else {
						model.addAttribute("message", "Your account have been activated already!");
					}
					return "account/activateSuccess";
				} else{
				model.addAttribute("message", "User does not exist!");
				return  "account/activateSuccess";
			}
	}
	@GetMapping("account/edit")
	public String edit(Model model) {
		HttpSession session = request.getSession();
		Customer user = (Customer) session.getAttribute("user");
		model.addAttribute("user",user);
		return "account/editAccount";
	}
	@PostMapping("account/edit")
	public String edit2(@ModelAttribute("user") Customer user,Model model,@RequestParam("attach") MultipartFile attach) throws IllegalStateException, IOException{
		HttpSession session = request.getSession();
		if(!attach.isEmpty()) {
			user.setPhoto(attach.getOriginalFilename());
			File file = new File(app.getRealPath("/static/picture/user/"+user.getPhoto()));
			attach.transferTo(file);
		} 
			cus.update(user);
			session.setAttribute("user", user);
			session.setAttribute("userEdit", "Update Success!");
			return "redirect:/account/edit";
	}
	@GetMapping("account/logout")
	public String logout() throws IOException{
		HttpSession session = request.getSession();
		ck.delete("accrmb");
		ck.delete("accrmb1");
		session.removeAttribute("user");
		String uri = session.getAttribute("backUri").toString();
		System.out.println("logout");
		return "redirect:"+uri;
	}
	@GetMapping("account/forgot")
	public String forgot() {
		return "account/forgot";
	}
	@PostMapping("account/forgot")
	public String forgot2(@RequestParam("email") String email,Model model) throws MessagingException {
		Customer cust = cus.findByEmail(email);
		if(cust!=null) {
			String id = Base64.getEncoder().encodeToString(cust.getId().getBytes());
			String text = "<p style='color: red'><a href='http://www.localhost:8080/account/forgot/"+id+"'>Click this link</a> to change your password</p>";
			MailForm mailer = new MailForm(email,"Link to change your password on Websitebanhang",text);
			mail.send(mailer);
			model.addAttribute("message","Link to change password was send to your mail");
		} else {
			model.addAttribute("message","Your email is not exist on website");
		}
		return "account/forgot"; 
	}
	@GetMapping("account/forgot/{userId}")
	public String forgotPass(@PathVariable("userId") String userId) {
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		return "account/changePass";
	}
	@GetMapping("account/forgot/userId")
	public String error() {
		return "redirect:/account/login";
	}
	@PostMapping("account/forgot/userId")
	public String forgotPass1(@RequestParam("pass") String pass,
			@RequestParam("confirm") String confirm, Model model) {
		if(pass.equals(confirm)) {
			HttpSession session = request.getSession();
			String id = session.getAttribute("userId").toString();
			String userdecode = new String(Base64.getDecoder().decode(id.getBytes()));
			System.out.println(userdecode);
			Customer cust = cus.findById(userdecode);
			cust.setPassword(pass);
			cus.update(cust);
			model.addAttribute("message", "Change pass success");
		} else {
			model.addAttribute("message","Your confirm password not match");
		}
		return "account/changePass";
	}
	@GetMapping("account/change-password")
	public String changePass() {
		return "account/changePass2";
	}
	@PostMapping("account/change-password")
	public String changePass1(@RequestParam("pass") String pass,
			@RequestParam("confirm") String confirm, Model model) {
		if(pass.equals(confirm)) {
			HttpSession session = request.getSession();
			Customer cust = (Customer) session.getAttribute("user");
			cust.setPassword(pass);
			cus.update(cust);
			model.addAttribute("message", "Change pass success");
		} else {
			model.addAttribute("message","Your confirm password not match");
		}
		return "account/changePass2";
	}
}
