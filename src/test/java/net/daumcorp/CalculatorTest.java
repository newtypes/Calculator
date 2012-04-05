package net.daumcorp;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class CalculatorTest {

	private Calculator calculator;
	private static final Logger logger = LoggerFactory
			.getLogger(CalculatorTest.class);
	

	// 테스트 케이스 수행 전에 먼저 수행된다
	// 위에 new 해도 되지만 JUNIT에서 제안하는 바는 아래와 같다
	@Before
	public void setup() {
		calculator = new Calculator();
	}
	
	// 메소드 이름 위에 커서를 놓고 테스트를 실행하면 해당 메소드만 테스트한다
	@Test
	public void add() {
		logger.debug("add: {} ", calculator.add(1, 2));
		assertEquals(3, calculator.add(1, 2));
		// hamcrest matchers 이용
		assertThat(calculator.add(1,2), is(3));
	}

	@Test
	public void subtract() {
		assertEquals(-1, calculator.subtract(1, 2));
	}

	@Test
	public void multiply() {
		assertThat(calculator.multiply(2,3), is(6));
	}

	// 테스트 수행 후 실행됨
	// 명심할 것! - 단위 테스트는 독립적으로 실행되며, 케이스별로 Before-After가 포함되어 실행
	// ex) setup - add - teardown, setup - subtract - teardown
	@After
	public void teardown() {
	}

}
