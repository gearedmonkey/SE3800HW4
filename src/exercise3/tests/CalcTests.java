package exercise3.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import exercise3.CalculatorInterface;
import exercise3.Calculator;

public class CalcTests {
	
	CalculatorInterface calc;
	List<Integer> list;
	double DELTA = .001;

	@Before
	public void setUp() throws Exception {
		calc = new Calculator();
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testAdd() {
		int expected = 10;
		int result = calc.add(list);
		assertEquals(expected, result, DELTA);
	}

	@Test
	public void testSubtract() {
		int expected = -8;
		int result = calc.subtract(list);
		assertEquals(expected, result,DELTA);
	}
	
	@Test
	public void testProduct() {
		int expected = 24;
		int result = calc.product(list);
		assertEquals(expected, result, DELTA);
	}
	
	@Test
	public void testQuotient() {
		
	}
	
	@Test
	public void testDiffSum() {
		fail("Not yet implemented");
	}
}
