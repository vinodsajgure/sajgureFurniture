package com.sajgure.furniture.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CountsDTO {

	private BigInteger total;
	private BigDecimal active;
	private BigDecimal inactive;
	private BigDecimal activePerc;
	private BigDecimal inactivePerc;

	public CountsDTO() {
		// TODO Auto-generated constructor stub
	}

	public BigInteger getTotal() {
		return total;
	}

	public void setTotal(BigInteger total) {
		this.total = total;
	}

	public BigDecimal getActive() {
		return active;
	}

	public void setActive(BigDecimal active) {
		this.active = active;
	}

	public BigDecimal getInactive() {
		return inactive;
	}

	public void setInactive(BigDecimal inactive) {
		this.inactive = inactive;
	}

	public BigDecimal getActivePerc() {
		return activePerc;
	}

	public void setActivePerc(BigDecimal activePerc) {
		this.activePerc = activePerc;
	}

	public BigDecimal getInactivePerc() {
		return inactivePerc;
	}

	public void setInactivePerc(BigDecimal inactivePerc) {
		this.inactivePerc = inactivePerc;
	}

}
