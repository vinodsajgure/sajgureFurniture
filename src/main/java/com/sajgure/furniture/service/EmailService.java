package com.sajgure.furniture.service;

public interface EmailService {
	
	void sendMail(String to, String subject, String body);
	
//	void sendPreConfiguredMail(String message);
	
	void sendMailWithAttachment(String to, String from, String subject, String body, String fileToAttach);
	
	void sendMailWithInlineResources(String to, String from, String subject, String body, String fileToAttach);
	
	void sendEnquiryEmailConfirmationToUser(String to, String from, String subject, String body, String fileToAttach);

}
