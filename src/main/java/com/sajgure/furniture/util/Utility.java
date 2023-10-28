package com.sajgure.furniture.util;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Utility<T> {

	public static BigDecimal percent(BigDecimal value, BigInteger total) {

        if (total == null || total.intValue() < 1) {
            return new BigDecimal("0");
        }
        if (value == null || value.intValue() < 1) {
            value = new BigDecimal("0");
        }

        BigDecimal porc = new BigDecimal("100");
        return value.multiply(porc).divide(
                new BigDecimal(total), 2, BigDecimal.ROUND_HALF_EVEN);
    }

}
