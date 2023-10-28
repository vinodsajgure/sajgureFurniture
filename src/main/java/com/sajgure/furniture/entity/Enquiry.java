package com.sajgure.furniture.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.sajgure.furniture.constant.EnquiryStatus;

@Entity
@Table(name = "enquiry")
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enquiry_id")
	private int enquiryId;

	@Size(min = 3, message = "Please enter name.")
	@NotNull
	private String name, email;

	@Column(name = "phone_no")
	// @Length(min = 10, max = 10)
	private Long phoneNo;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private EnquiryStatus status;

	@NotNull
	@Length(min = 5)
	private String message;

	@Column(name = "created_date")
	private Date createdDate;

	public int getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public EnquiryStatus getStatus() {
		return status;
	}

	public void setStatus(EnquiryStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "{enquiryId:" + enquiryId + ", name:\"" + name + "\", email:\"" + email + "\", phoneNo:" + phoneNo
				+ ", status:\"" + status + "\", message:\"" + message + "\", createdDate:\"" + createdDate + "\"}";
	}
	
	

}
