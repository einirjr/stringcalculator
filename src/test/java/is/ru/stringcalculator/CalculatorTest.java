package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(5, Calculator.add("5"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(10, Calculator.add("1,2,3,4"));
    }

    @Test
    public void testNewLine() {
    	assertEquals(9, Calculator.add("1\n8"));
    }

    @Test
    public void testManyNewLines() {
    	assertEquals(19, Calculator.add("1\n8,2\n3\n5"));
    }

    @Test
    public void testOneNegative() {
    	try {
    		Calculator.add("-1,2");
    	}
    	catch (IllegalArgumentException e) {
    		assertEquals("Negatives not allowed: -1", e.getMessage());
    	}
    }

    @Test
    public void testManyNegatives() {
    	try {
    		Calculator.add("-1,-2,5,-89,33");
    	}
    	catch (IllegalArgumentException e) {
    		assertEquals("Negatives not allowed: -1, -2, -89", e.getMessage());
    	}
    }

    @Test
    public void testManyNegativesWithNewline() {
    	try {
    		Calculator.add("-1\n-2,5\n-89,33");
    	}
    	catch (IllegalArgumentException e) {
    		assertEquals("Negatives not allowed: -1, -2, -89", e.getMessage());
    	}
    }

    @Test
    public void testTooHighNumbers() {
    	assertEquals(29, Calculator.add("1\n8,2\n3\n1005,1001\n5,10"));
    }

    @Test
    public void testDiffDelim() {
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void testBigDiffDelim() {
    	assertEquals(10, Calculator.add("//&&&\n3&&&7"));
    }
}