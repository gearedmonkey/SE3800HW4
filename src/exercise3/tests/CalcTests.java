package exercise3.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import exercise3.CalculatorInterface;
import exercise3.Calculator;

public class CalcTests {
	
	CalculatorInterface calc;

	@Before
	public void setUp() throws Exception {
		calc = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
