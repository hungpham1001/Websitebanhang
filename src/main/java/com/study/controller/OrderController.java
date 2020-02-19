package com.study.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.study.Services.CartServices;
import com.study.dao.CustomerDaoImpl;
import com.study.dao.OrderDaoImpl;
import com.study.dao.OrderDetailDaoImpl;
import com.study.entity.Customer;
import com.study.entity.Order;
import com.study.entity.OrderDetail;
import com.study.entity.Product;

@Controller
public class OrderController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	OrderDaoImpl odao;
	@Autowired
	CustomerDaoImpl cdao;
	@Autowired
	OrderDetailDaoImpl oddao;
	@Autowired
	CartServices cart;
	
	@PostMapping("/order/success-guest")
	public String orderSuccess(@Valid @ModelAttribute("user") Customer user,BindingResult result,@RequestParam("description") String description, Model model) {
		if(result.hasErrors()) {
			return "basket/basket-detail-guest";
		}
		user.setPhoneNumber(user.getId());
		Customer customer = cdao.findById(user.getId());
		if(customer==null) {
			cdao.save(user);			
		} else if(!customer.getAddress().equalsIgnoreCase(user.getAddress())) {
			cdao.update(user);
		}
		Order order = new Order();
		order.setCustomer(user);
		order.setAmount(cart.getTotal());
		order.setDescription(user.getAddress()+" "+description);
		Date date = new Date();
		order.setOrderDate(date);
		List<OrderDetail> details = new ArrayList<OrderDetail>();
		Collection<Product> products = cart.getAllItems();
		for(Product product : products) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setProduct(product);
			orderDetail.setDiscount(product.getDiscount());
			orderDetail.setOrder(order);
			orderDetail.setQuantity(product.getQuantity());
			orderDetail.setUnitPrice(product.getUnitPrice());
			details.add(orderDetail);
		}
		order.setOrderDetails(details);
		odao.saveWithOrderDetail(order,details);
		cart.clearBasket();
		model.addAttribute("message","Your order is success! We will packed and send to you soon!");
		return "order/success";
	}

	@RequestMapping("/order/success-mem")
	public String orderSuccessMem(Model model) {
		HttpSession session = request.getSession();
		Customer cust = (Customer) session.getAttribute("user");
		Order order = new Order();
		if(cart.getTotal()==0) {
			model.addAttribute("basketMessage", "Please add items into basket");
			return "basket/basketDetailMem";
		} else {
			order.setAmount(cart.getTotal());
			order.setCustomer(cust);
			Date date = new Date();
			order.setOrderDate(date);
			List<OrderDetail> details = new ArrayList<OrderDetail>();
			Collection<Product> products = cart.getAllItems();
			for(Product product : products) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setProduct(product);
				orderDetail.setDiscount(product.getDiscount());
				orderDetail.setOrder(order);
				orderDetail.setQuantity(product.getQuantity());
				orderDetail.setUnitPrice(product.getUnitPrice());
				details.add(orderDetail);
			}
			order.setOrderDetails(details);
			odao.saveWithOrderDetail(order,details);
			cart.clearBasket();
			model.addAttribute("message","Your order is success! We will packed and send to you soon!");
			return "order/success";
		}
	}
	@RequestMapping("/order/order-detail") 
	public String orderDetail(Model model) {
		HttpSession session = request.getSession();
		Customer cust = (Customer) session.getAttribute("user");
		List<Order> orders = odao.findByCustomerId(cust.getId());
		model.addAttribute("orderList",orders);
		return "order/orderDetail";
	}
	
	@RequestMapping("/order/order-detail/{id}") 
	public String orderDetail1(@PathVariable("id") Integer id,Model model) {
		HttpSession session = request.getSession();
		Customer cust = (Customer) session.getAttribute("user");
		List<Order> orders = odao.findByCustomerId(cust.getId());
		model.addAttribute("orderList",orders);
		Order order = odao.findById(id);
		List<OrderDetail> list = order.getOrderDetails();
		model.addAttribute("orderDetail",list);
		System.out.println(id);
		return "order/orderDetailList" ;
	}
}
