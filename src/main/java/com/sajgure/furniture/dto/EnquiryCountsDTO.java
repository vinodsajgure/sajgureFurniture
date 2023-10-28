package com.sajgure.furniture.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class EnquiryCountsDTO {

	private BigInteger total;
	private BigDecimal inNew;
	private BigDecimal inProgress;
	private BigDecimal completed;

	private BigDecimal newPerc;
	private BigDecimal inprogressPerc;
	private BigDecimal completedPerc;

	public EnquiryCountsDTO() {
		// TODO Auto-generated constructor stub
	}

	public BigInteger getTotal() {
		return total;
	}

	public void setTotal(BigInteger total) {
		this.total = total;
	}

	public BigDecimal getInNew() {
		return inNew;
	}

	public void setInNew(BigDecimal inNew) {
		this.inNew = inNew;
	}

	public BigDecimal getInProgress() {
		return inProgress;
	}

	public void setInProgress(BigDecimal inProgress) {
		this.inProgress = inProgress;
	}

	public BigDecimal getCompleted() {
		return completed;
	}

	public void setCompleted(BigDecimal completed) {
		this.completed = completed;
	}

	public BigDecimal getNewPerc() {
		return newPerc;
	}

	public void setNewPerc(BigDecimal newPerc) {
		this.newPerc = newPerc;
	}

	public BigDecimal getInprogressPerc() {
		return inprogressPerc;
	}

	public void setInprogressPerc(BigDecimal inprogressPerc) {
		this.inprogressPerc = inprogressPerc;
	}

	public BigDecimal getCompletedPerc() {
		return completedPerc;
	}

	public void setCompletedPerc(BigDecimal completedPerc) {
		this.completedPerc = completedPerc;
	}

}
