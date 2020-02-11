package com.study.bean;

import org.springframework.stereotype.Service;

@Service
public class MailForm {
	String to;
	String Subject;
	String Text;
	
	public MailForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MailForm(String to, String subject, String text) {
		super();
		this.to = to;
		Subject = subject;
		Text = text;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		this.Text = text;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
}
