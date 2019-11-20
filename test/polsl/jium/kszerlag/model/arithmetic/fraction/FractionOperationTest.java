package polsl.jium.kszerlag.model.arithmetic.fraction;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for <code>FractionOperation</code> class.
 * 
 * @version 1.0
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
    
    /**
     * Test of add method, of class FractionOperation.
     * 
     * Testing if method add throws IllegalArgumentValueException, when 
     * one of passed arguments is null.
     */
    @Test(expected = IllegalArgumentValueException.class)
    public void should_Throws_IllegalArgumentException_Caused_By_First_Arg() {
        Fraction firstSummand = null;
        Fraction secondSummand = new Fraction(3, 4);
        instance.add(firstSummand, secondSummand);
    }
    
    /**
     * Test of add method, of class FractionOperation.
     * 
     * Testing if method add throws IllegalArgumentValueException, when
     * one of passed arguments is null.
     */
    @Test(expected = IllegalArgumentValueException.class)
    public void should_Throws_IllegalArgumentException_Caused_By_Second_Arg() {
        Fraction firstSummand = new Fraction(3, 4);
        Fraction secondSummand = null;
        instance.add(firstSummand, secondSummand);
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
