package polsl.jium.kszerlag.model.arithmetic.fraction;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for <code>FractionOperation</code> class.
 * 
 * @version 3.0
 * @author Kamil Szerląg
 */
public class FractionOperationTest {
    
    private FractionOperation instance;
    
    @Before
    public void setUp() {
        instance = new FractionOperation();
    }

    /**
     * Test of add method, of class FractionOperation.
     * 
     * Testing if fractions addition operation is correct.
     */
    @Test
    public void should_Return_Correct_Addition_Value() {
        Fraction firstSummand = new Fraction(1, 2);
        Fraction secondSummand = new Fraction(3, 4);
        Fraction expResult = new Fraction(10, 8);
        Fraction result = instance.add(firstSummand, secondSummand);
        assertEquals("Addition test failed. Incorrect result.",expResult, result);
    }
    
    /**
     * Test of add method, of class FractionOperation.
     * 
     * Testing if result of fractions addition operation is inncorrect.
     */
    @Test
    public void should_Return_Incorect_Addition_Value() {
        Fraction firstSummand = new Fraction(1, 2);
        Fraction secondSummand = new Fraction(3, 4);
        Fraction expResult = new Fraction(1, 2);
        Fraction result = instance.add(firstSummand, secondSummand);
        assertNotEquals("Addition test failed. Should return different value then expected.", expResult, result);
    }
    
    @Test(expected = FractionArithmeticException.class)
    public void should_Thrown_FractionArithmeticException_Addition_Null() {
        Fraction secondSummand = new Fraction(3, 4);
        instance.add(null, secondSummand);
        fail("Addition test failed. FractionAritheticException should be thrown.");
    }
    
    @Test
    public void should_Return_Correct_Subtraction_Value() {
        Fraction firstSummand = new Fraction(4, 2);
        Fraction secondSummand = new Fraction(1, 2);
        Fraction expResult = new Fraction(3, 2);
        Fraction result = instance.subtruct(firstSummand, secondSummand);
        assertEquals("Subtraction test failed. Incorrect result.",expResult, result);
    }
    
    /**
     * Test of add method, of class FractionOperation.
     * 
     * Testing if result of fractions addition operation is inncorrect.
     */
    @Test
    public void should_Return_Incorect_Subtraction_Value() {
        Fraction firstSummand = new Fraction(5, 2);
        Fraction secondSummand = new Fraction(3, 2);
        Fraction expResult = new Fraction(1, 2);
        Fraction result = instance.subtruct(firstSummand, secondSummand);
        assertNotEquals("Subtraction test failed. Should return different value then expected.", expResult, result);
    }
    
    @Test(expected = FractionArithmeticException.class)
    public void should_Thrown_FractionArithmeticException_Subtraction_Null() {
        Fraction secondSummand = new Fraction(3, 4);
        instance.subtruct(null, secondSummand);
        fail("Subtraction test failed. FractionAritheticException should be thrown.");
    }
    
    /**
     * Test of multiply method, of class FractionOperation.
     */
    @Test
    public void should_Return_Correct_Multiply_Value() {
        Fraction firstFactor = new Fraction(1, 2);
        Fraction secondFactor = new Fraction(1, 4);
        Fraction expResult = new Fraction(1, 8);
        Fraction result = instance.multiply(firstFactor, secondFactor);
        assertEquals("Multiplication test failed. Incorrect result.", expResult, result);
    }

    /**
     * Test of multiply method, of class FractionOperation.
     * 
     * Testing if result of mulitiplication is incorrect.
     */
    @Test
    public void should_Return_Incorrect_Multiply_Value() {
        Fraction firstFactor = new Fraction(1, 4);
        Fraction secondFactor = new Fraction(1, 4);
        Fraction expResult = new Fraction(1, 8);
        Fraction result = instance.multiply(firstFactor, secondFactor);
        assertNotEquals("Multiplication test failed. Result should be different then expected value", expResult, result);
    }
    
    @Test(expected = FractionArithmeticException.class)
    public void should_Thrown_FractionArithmeticException_Multiply_Null() {
        Fraction firstFactor = new Fraction(1, 4);
        instance.multiply(firstFactor, null);
        fail("Multiplication test failed. Should thrown FractionArithmeticException");
    }
    /**
     * Test of divide method, of class FractionOperation.
     * 
     * Testing if result of division is correct.
     */
    @Test
    public void should_Return_Correct_Divide_Value() {
        Fraction dividend = new Fraction(1, 3);
        Fraction devisor = new Fraction(4, 3);
        Fraction expResult = new Fraction(3, 12);
        Fraction result = instance.divide(dividend, devisor);
        assertEquals("Division test failed. Incorrect result.", expResult, result);
    }

     /**
     * Test of divide method, of class FractionOperation.
     */
    @Test
    public void should_Return_Incorrect_Divide_Value() {
        Fraction dividend = new Fraction(4, 3);
        Fraction devisor = new Fraction(4, 3);
        Fraction expResult = new Fraction(3, 12);
        Fraction result = instance.divide(dividend, devisor);
        assertNotEquals("Division test failed. Result should be different then expected.", expResult, result);
    }
    
    
    @Test(expected = FractionArithmeticException.class)
    public void should_Thrown_FractionArithmeticException_Division_Null() {
        Fraction devisor = new Fraction(4, 3);
        instance.divide(null, devisor);
        fail("Division test failed. Should thrown FractionArithmeticException.");
    }
    
    /**
     * Test of power method, of class FractionOperation.
     */
    @Test
    public void should_Return_Correct_Power_Value() {
        Fraction base = new Fraction(1, 2);
        int exponent = 2;
        Fraction expResult = new Fraction(1, 4);
        Fraction result = instance.power(base, exponent);
        assertEquals("Power test fialed. Incorrect result.", expResult, result);
    }
    
}
