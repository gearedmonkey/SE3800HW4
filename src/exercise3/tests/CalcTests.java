package exercise3.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
		int expected = 0;
		int result = calc.quotient(list);
		assertEquals(expected, result, DELTA);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testZeroQuotient(){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(5);
		nums.add(0);
		nums.add(4);
		//should throw exception due to nums containing a zero. 
		calc.quotient(nums);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testTooFewQuotient() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		calc.quotient(nums);
	}
	
	@Test
	public void testDiffSum() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(5);
		nums.add(6);
		nums.add(7);
		int expected = -8;
		int result = calc.sumDifference(list, nums);
		assertEquals(expected, result, DELTA);
	}
}
