package com.sajgure.furniture.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sajgure.furniture.constant.EnquiryStatus;
import com.sajgure.furniture.dao.EnqiryDataRepository;
import com.sajgure.furniture.dao.EnquiryDao;
import com.sajgure.furniture.dto.EnquiryCountsDTO;
import com.sajgure.furniture.entity.Enquiry;
import com.sajgure.furniture.service.EmailService;
import com.sajgure.furniture.service.EnquiryService;
import com.sajgure.furniture.util.Utility;

@Service
@Transactional
public class EnquiryServiceImpl implements EnquiryService{

	@Autowired
	private EnquiryDao enquiryDao;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EnqiryDataRepository repo;

	@Override
	public List<Enquiry> getAllEnquiries() {
		return (List<Enquiry> )repo.findAll();
		//return enquiryDao.findAll();
	}

	@Override
	public void saveEnquiry(Enquiry enquiry) {
		enquiry.setCreatedDate(new Date());
		
		if(enquiry.getEnquiryId() == 0) {
			enquiry.setStatus(EnquiryStatus.NEW);
		}
		
		enquiryDao.save(enquiry);
		//String to, String from, String subject, String fileToAttach
		
		String name = enquiry.getName();
		String userEmail = enquiry.getEmail();
		String msg = enquiry.getMessage();
		String subject = "Enquiry From " + name;
		
		
		String body = createMailBody(name, userEmail, msg);
		emailService.sendMailWithInlineResources("sajgurefurniture@gmail.com" , userEmail, subject, body, null);
		
		String subjectForUserEmail = "Enquiry Received with #" + enquiry.getEnquiryId();
		String userMailBody =  createUserMailBody(name);
		
		emailService.sendMailWithInlineResources(userEmail, "sajgurefurniture@gmail.com", subjectForUserEmail, userMailBody, null);
		
	}

	private String createMailBody(String name, String email, String message) {
		return "<h3>Hi,</h3>"
				+ "<h3>Email From: " + name + "</h3>"
				+ "<h3>Email Address: " + email + "</h3>"
				+ "<h3>Message: " + message + "</h3>";
	}
	
	
	private String createUserMailBody(String name) {
		return "<h3>Hi "+ name +",</h3>"
				+ "<h4>We have received your enquiry and we will get back to you soon.<br><br>"
				+ "Thanks and Regards<br>"
				+ "Sajgure Furniture</h4>";
	}

	@Override
	public void updateEnquiryStatus(int id, EnquiryStatus enquiryStatus) {
		// TODO Auto-generated method stub
		enquiryDao.changeEnquiryStatus(id, enquiryStatus);
	}

	@Override
	public EnquiryCountsDTO getEnquiryCounts() {
		EnquiryCountsDTO counts = enquiryDao.findAllStatusCounts();
		counts.setNewPerc(Utility.percent(counts.getInNew(), counts.getTotal()));
		counts.setInprogressPerc(Utility.percent(counts.getInProgress(), counts.getTotal()));
		counts.setCompletedPerc(Utility.percent(counts.getCompleted(), counts.getTotal()));
		return counts;
	}
}
