package net.daumcorp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	
	private final String defaultDelimeter = ",|\n";
	private final String customDelimeterMark = "//";
	private final String customDelimeterRegex = "//(.)\n(.*)";
	private final int zero = 0;

	public int calculate(String string) throws RuntimeException {
		// TODO Auto-generated method stub
		if (string.length() == zero) {
			return zero;
		}

		String[] numbers = getSplitNumbers(string);
					
		int sum = 0;
		for (String number : numbers) {
			sum += negativeCheck(Integer.parseInt(number));
		}

		return  sum;
	} 
	
	private String[] getSplitNumbers(String string) {
		if (string.startsWith(customDelimeterMark)) {
			Matcher m = Pattern.compile(customDelimeterRegex).matcher(string);
			m.find();
			return m.group(2).split(Pattern.quote(m.group(1)));
		}
		else {
			return string.split(defaultDelimeter);
		}
	}
	
	private int negativeCheck(int value) throws RuntimeException {
		if (value <= zero) {
			throw new RuntimeException();
		}
		else {
			return value;
		}
	}
}
