package com.sajgure.furniture.dao;

import com.sajgure.furniture.constant.EnquiryStatus;
import com.sajgure.furniture.dto.EnquiryCountsDTO;
import com.sajgure.furniture.entity.Enquiry;

public interface EnquiryDao extends Dao<Enquiry> {

	Enquiry findById(int id);

	void changeEnquiryStatus(int id, EnquiryStatus status);

	EnquiryCountsDTO findAllStatusCounts();

}