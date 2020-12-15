package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Mail;

@CrossOrigin
@RestController
@RequestMapping("/email")
public class MailRestController {

	@Autowired
	private JavaMailSender sender;
	@PostMapping
	public ResponseEntity<?> sendMail(@RequestBody Mail m)
	{
		
		try {
			System.out.println(m.getDestEmail()+m.getSubject());
			SimpleMailMessage mesg=new SimpleMailMessage();
			mesg.setTo(m.getDestEmail());
			mesg.setSubject(m.getSubject());
			mesg.setText(m.getMessage());
			sender.send(mesg);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
