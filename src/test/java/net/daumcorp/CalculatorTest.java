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
	

	// �׽�Ʈ ���̽� ���� ���� ���� ����ȴ�
	// ���� new �ص� ������ JUNIT���� �����ϴ� �ٴ� �Ʒ��� ����
	@Before
	public void setup() {
		calculator = new Calculator();
	}
	
	// �޼ҵ� �̸� ���� Ŀ���� ���� �׽�Ʈ�� �����ϸ� �ش� �޼ҵ常 �׽�Ʈ�Ѵ�
	@Test
	public void add() {
		logger.debug("add: {} ", calculator.add(1, 2));
		assertEquals(3, calculator.add(1, 2));
		// hamcrest matchers �̿�
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

	// �׽�Ʈ ���� �� �����
	// ����� ��! - ���� �׽�Ʈ�� ���������� ����Ǹ�, ���̽����� Before-After�� ���ԵǾ� ����
	// ex) setup - add - teardown, setup - subtract - teardown
	@After
	public void teardown() {
	}

}
