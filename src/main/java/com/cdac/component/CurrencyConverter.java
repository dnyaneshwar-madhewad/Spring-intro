package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("cc")
public class CurrencyConverter {
	public double convert(String from, String to, double amount) {
		if(from.equals("USD") && to.equals("INR"))
			return amount * 74.47;
		else
			return -1;

}
}