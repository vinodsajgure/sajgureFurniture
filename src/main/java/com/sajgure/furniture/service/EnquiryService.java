package com.sajgure.furniture.service;

import java.util.List;

import javax.validation.Valid;

import com.sajgure.furniture.constant.EnquiryStatus;
import com.sajgure.furniture.dto.EnquiryCountsDTO;
import com.sajgure.furniture.entity.Enquiry;

public interface EnquiryService {

	List<Enquiry> getAllEnquiries();

	void saveEnquiry(Enquiry enquiry);

	void updateEnquiryStatus(int enquiryId, @Valid EnquiryStatus enquiryStatus);

	EnquiryCountsDTO getEnquiryCounts();

}
