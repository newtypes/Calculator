package net.daumcorp;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringCalculatorTest {
	private static final Logger logger = LoggerFactory
			.getLogger(StringCalculatorTest.class);
	
	StringCalculator cal;
	
	@Before
	public void setup() {
		cal = new StringCalculator();
	}
	
	@Test
	public void emptyStringTest() throws Exception {				
		logger.debug("empty string test : {}" , cal.calculate(""));
		assertThat(0, is(cal.calculate("")));		
	}
	
	@Test
	public void integerParseTest() throws Exception {
		logger.debug("integer parse test : {}", cal.calculate("2"));
		assertThat(2, is(cal.calculate("2")));
	}
	
	@Test
	public void sumTest() throws Exception {
		logger.debug("sum test : {}", cal.calculate("3,4"));
		assertThat(7, is(cal.calculate("3,4")));		
	}
	
	@Test
	public void totalSumTest() throws Exception {
		logger.debug("total sum test: {}", cal.calculate("2,3,4,5,6"));
		assertThat(20, is(cal.calculate("2,3,4,5,6")));
	}
	
	@Test
	public void newlineTest() throws Exception {
		logger.debug("newline test : {}", cal.calculate("1,2\n3"));
		assertThat(6, is(cal.calculate("1,2\n3")));
	}
	
	@Test
	public void customDelimeterTest() throws Exception {
		logger.debug("custom delimeter test : {}", cal.calculate("//;\n1;2;3;"));
		assertThat(6, is(cal.calculate("//;\n1;2;3")));
	}
	
	@Test
	public void reservedDelimeterTest() throws Exception {
		logger.debug("reserved delimeter test : {}", cal.calculate("//.\n1.2.3"));
		assertThat(6, is(cal.calculate("//.\n1.2.3")));
	}
	
	@Test (expected=RuntimeException.class)
	public void negativeCheckTest() throws Exception {
		logger.debug("reserved delimeter test : {}", cal.calculate("-1,2,3"));		
	}

}
