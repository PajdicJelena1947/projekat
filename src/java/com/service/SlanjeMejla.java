/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;


import com.entity.Karton;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

/**
 *
 * @author jelena.pajdic
 */
@Service("slanjeMejla")
public class SlanjeMejla {
    Properties mailServerProperties;
	 Session getMailSession;
	MimeMessage generateMailMessage;
        
        
        public  void generateAndSendEmail(Karton karton,String email,String tekst) throws AddressException, MessagingException {
 
		
		
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		
		
		getMailSession = javax.mail.Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		generateMailMessage.setSubject("Pacijent-lekar");
		
		generateMailMessage.setContent(tekst, "text/html");
		
 
		// Step3
		
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com",karton.getEmail(), karton.getPassword());
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}
