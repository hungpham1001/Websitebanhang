package com.study;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailSenderConfig {
	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mail = new JavaMailSenderImpl();
		mail.setHost("smtp.gmail.com");
		mail.setPort(587);
		mail.setUsername("pmhungdev@gmail.com");
		mail.setPassword("123456789@Aa");
		Properties prop = mail.getJavaMailProperties();
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		return mail;
	}
}
