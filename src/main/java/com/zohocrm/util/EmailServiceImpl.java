package com.zohocrm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender sendMail;

	@Override
	public void sendEMail(String to, String sub, String content) {

		SimpleMailMessage m = new SimpleMailMessage();
		m.setTo(to);
		m.setSubject(sub);
		m.setText(content);
		
		sendMail.send(m);
	}

}
