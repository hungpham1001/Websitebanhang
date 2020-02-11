package com.study.Services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.study.bean.MailForm;

@Service
public class MailServices {
	@Autowired
	JavaMailSender mailer;
	public void send(MailForm mailForm) throws MessagingException {
		MimeMessage message = mailer.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		helper.setTo(mailForm.getTo());
		helper.setSubject(mailForm.getSubject());
		helper.setText(mailForm.getText(), true);
		mailer.send(message);
	}
}
