package com.sajgure.furniture.service.impl;

import java.io.File;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.sajgure.furniture.service.EmailService;

@Service()
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender emailSender;

	/**
	 * This method will send compose and send the message
	 */
	public void sendMail(String to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		emailSender.send(message);
	}

	/**
	 * This method will send a pre-configured message
	 */
//	public void sendPreConfiguredMail(String message) {
//		SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
//		mailMessage.setText(message);
//		mailSender.send(mailMessage);
//	}

	public void sendMailWithAttachment(String to, String from, String subject, String body, String fileToAttach) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
				mimeMessage.setFrom(new InternetAddress(from));
				mimeMessage.setSubject(subject);
				mimeMessage.setText(body);

				FileSystemResource file = new FileSystemResource(new File(fileToAttach));
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				helper.addAttachment("logo.jpg", file);
			}
		};

		try {
			emailSender.send(preparator);
		} catch (MailException ex) {
			// simply log it and go on...
			System.err.println(ex.getMessage());
		}
	}

	// Inline image
	public void sendMailWithInlineResources(String to, String from, String subject, String body, String fileToAttach) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
				mimeMessage.setFrom(new InternetAddress(from));
				mimeMessage.setSubject(subject);

				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

				helper.setText("<html><body><h1> " + body + " </h1></body></html>", true);

				if (fileToAttach != null) {
					FileSystemResource res = new FileSystemResource(new File(fileToAttach));
					helper.addInline("identifier1234", res);
				}
			}
		};

		try {
			emailSender.send(preparator);
		} catch (MailException ex) {
			// simply log it and go on...
			System.err.println(ex.getMessage());
		}
	}

	@Override
	public void sendEnquiryEmailConfirmationToUser(String to, String from, String subject, String body,
			String fileToAttach) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
				mimeMessage.setFrom(new InternetAddress(from));
				mimeMessage.setSubject(subject);

				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

				helper.setText("<html><body><h1> " + body + " </h1></body></html>", true);

				if (fileToAttach != null) {
					FileSystemResource res = new FileSystemResource(new File(fileToAttach));
					helper.addInline("identifier1234", res);
				}
			}
		};

		try {
			emailSender.send(preparator);
		} catch (MailException ex) {
			// simply log it and go on...
			System.err.println(ex.getMessage());
		}

	}
}