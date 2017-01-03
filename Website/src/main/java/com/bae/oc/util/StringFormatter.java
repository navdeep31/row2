package com.bae.oc.util;

public class StringFormatter {

	public static String properCasing(String string) {
		String properCasedString = "";
		
		properCasedString = string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
		
		return properCasedString;
	}
	
}
