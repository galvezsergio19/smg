package com.smg.springmvc.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

	private Pattern pattern;
	private Matcher matcher;

	/**
	 *  6 to 20 in Length
	 *  at Least 1 digit
	 *  at Least 1 small character
	 *  at Least 1 capital character
	 */
	
	private static final String PASSWORD_PATTERN =
        "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	public PasswordValidator(){
		pattern = Pattern.compile(PASSWORD_PATTERN);
	}

	public boolean validate(final String password){
		matcher = pattern.matcher(password);
		return matcher.matches();
}

}
