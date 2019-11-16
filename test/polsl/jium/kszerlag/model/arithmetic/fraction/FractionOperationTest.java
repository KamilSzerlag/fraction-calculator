package polsl.jium.kszerlag.model.arithmetic.fraction;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
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
     */
    @Test
    public void should_Return_Correct_Addition_Value() {
        Fraction firstSummand = new Fraction(1, 2);
        Fraction secondSummand = new Fraction(3, 4);
        Fraction expResult = new Fraction(10, 8);
        Fraction result = instance.add(firstSummand, secondSummand);
        assertEquals(expResult, result);
    }

    @Test
    public void should_Return_Incorect_Addition_Value() {
        Fraction firstSummand = new Fraction(1, 2);
        Fraction secondSummand = new Fraction(3, 4);
        Fraction expResult = new Fraction(1, 2);
        Fraction result = instance.add(firstSummand, secondSummand);
        assertNotEquals(expResult, result);
    }
    
    /**
     * Test of subtruct method, of class FractionOperation.
     */
    @Test(expected = IllegalArgumentValueException.class)
    public void should_Throws_IllegalArgumentException_Caused_By_First_Arg() {
        Fraction firstSummand = null;
        Fraction secondSummand = new Fraction(3, 4);
        instance.add(firstSummand, secondSummand);
    }
    
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
        assertEquals(expResult, result);
    }

    @Test
    public void should_Return_Incorrect_Multiply_Value() {
        Fraction firstFactor = new Fraction(1, 4);
        Fraction secondFactor = new Fraction(1, 4);
        Fraction expResult = new Fraction(1, 8);
        Fraction result = instance.multiply(firstFactor, secondFactor);
        assertNotEquals(expResult, result);
    }
    /**
     * Test of divide method, of class FractionOperation.
     */
    @Test
    public void should_Return_Correct_Divide_Value() {
        Fraction dividend = new Fraction(1, 3);
        Fraction devisor = new Fraction(4, 3);
        Fraction expResult = new Fraction(3, 12);
        Fraction result = instance.divide(dividend, devisor);
        assertEquals(expResult, result);
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
        assertNotEquals(expResult, result);
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
        assertEquals(expResult, result);
    }
    
}
