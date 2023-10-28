package com.sajgure.furniture.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class UserCountDTO {

	private BigInteger total;
	private BigDecimal enabled;
	private BigDecimal disabled;

	private BigDecimal enabledPerc;
	private BigDecimal disabledPerc;

	public BigInteger getTotal() {
		return total;
	}

	public void setTotal(BigInteger total) {
		this.total = total;
	}

	public BigDecimal getEnabled() {
		return enabled;
	}

	public void setEnabled(BigDecimal enabled) {
		this.enabled = enabled;
	}

	public BigDecimal getDisabled() {
		return disabled;
	}

	public void setDisabled(BigDecimal disabled) {
		this.disabled = disabled;
	}

	public BigDecimal getEnabledPerc() {
		return enabledPerc;
	}

	public void setEnabledPerc(BigDecimal enabledPerc) {
		this.enabledPerc = enabledPerc;
	}

	public BigDecimal getDisabledPerc() {
		return disabledPerc;
	}

	public void setDisabledPerc(BigDecimal disabledPerc) {
		this.disabledPerc = disabledPerc;
	}

}
