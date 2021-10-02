package com.ablackpikatchu.refinement.core.util.text;

import java.math.BigDecimal;

public class NumberFormatting {
	
	public static double round(double value, int numberOfDigitsAfterDecimalPoint) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(numberOfDigitsAfterDecimalPoint,
                BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }

	public static String toThousandsFormat(int number, int decimals) {
		return round(number / 1000.0, decimals) + "K";
	}
	
}
