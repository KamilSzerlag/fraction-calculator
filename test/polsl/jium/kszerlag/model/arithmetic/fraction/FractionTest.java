package polsl.jium.kszerlag.model.arithmetic.fraction;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Unit tests for <code>Fraction</code> class.
 * 
 * @version 1.0
 * @author Kamil Szerląg
 */
public class FractionTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    /**
     * Test of of method, of class Fraction.
     * 
     * Testing if method throws IllegalArgumentValueException, when denominator 
     * is zero.
     */
    @Test
    public void should_Throws_IllegalArgumentValueException_When_Denominator_Is_Zero() {
        expectedException.expect(FractionArithmeticException.class);
        expectedException.expectMessage("Denominator must not be 0!");
        String fraction = "4/0";
        Fraction.of(fraction);
    }
    
    /**
     * Test of of method, of class Fraction.
     * 
     * Testing whether created object is correct.
     */
    @Test
    public void should_Return_Correct_Fraction_Obcject_With_Value_Of_String() {
        String fraction = "4/3";
        Fraction expResult = new Fraction(4, 3);
        Fraction result = Fraction.of(fraction);
        assertEquals(assertionFailedMsg("Return incorrect fraction object, object should be correct.", expResult, result),expResult, result);
    }
    
    /**
     * Test of of method, of class Fraction.
     * 
     * Testing whether created object is incorrect.
     */
    @Test
    public void should_Return_Incorrect_Fraction_Obcject_With_Value_Of_String() {
        String fraction = "4/3";
        Fraction expResult = new Fraction(3, 4);
        Fraction result = Fraction.of(fraction);
        assertNotEquals(assertionFailedMsg("Return correct fraction object, object should be incorrect", expResult, result), expResult, result);
    }

    /**
     * Test of of method, of class Fraction.
     * 
     * Checking if method of throwing expected NullPointerException when null
     * is passed as argument.
     */
    @Test(expected = NullPointerException.class)
    public void should_Throws_NullPointerException_Caused_By_Null_Arg() {
        String fraction = null;
        Fraction.of(fraction);
    }
    
    /**
     * Test of of method, of class Fraction.
     * 
     * Checking whether method of throwing expected NullPointerException empty
     * string is passed as argument.
     */
    @Test(expected = NullPointerException.class)
    public void should_Throws_NullPointerException_Caused_By_Empty_String_Arg() {
        String fraction = "";
        Fraction.of(fraction);
    }
    
    /**
     * Test of of method, of class Fraction.
     * 
     * Checking whether method of throwing expected NumberFormatException, when
     * String contiains unexpected chars.
     */
    @Test(expected = NumberFormatException.class)
    public void should_Throws_NumberFormatException() {
        String fraction = "1-5";
        Fraction.of(fraction);
    }
    
    /**
     * Test of of method, of class Fraction.
     * 
     * Checking whether method of throwing expected InvalidFractionFormatException, when
     * String contains unsupported format of fraction.
     */
    @Test(expected = InvalidFractionFormatException.class)
    public void should_Throws_InvalidFormatException() {
        String fraction = "1/2/4";
        Fraction.of(fraction);
    }
    
    /**
     * Testing of toString method of class Fraction
     * 
     * Checking whether String returned by to String method contains proper 
     * format.
     */
    @Test
    public void should_Return_Correct_String_Format() {
        Fraction instance = new Fraction(1, 2);
        String expResult = "1\n-\n2";
        String result = instance.toString();
        assertEquals("toString method failed. Returned Fraction String format is incorrect.", expResult, result);
    }
    
    /**
     * Test of hashCode method, of class Fraction.
     * 
     * 
     */
    @Test
    public void should_Compare_Symmetric_HashCode_Equality() {
        Fraction first = new Fraction(1, 14);
        Fraction second = new Fraction(1, 14);
        assertTrue("hashCode method test failed. Objects are not equal.",first.equals(second) && second.equals(first));
        assertTrue("equals method test failed. Generated hash code from equals object are not the same.",first.hashCode() == second.hashCode());
    }

    /**
     * Test of equals method, of class Fraction.
     */
    @Test
    public void should_Return_True_For_Symmetrical_Equality() {
        Fraction first = new Fraction(2, 4);
        Fraction second = new Fraction(1, 2);
        assertTrue("equals method test failed. Objects are not equal.", first.equals(second) && second.equals(first));
    }
    
    /**
     * Test of equals method of class Fraction.
     * 
     */
    @Test
    public void should_Return_False_For_Symmetrical_Equality() {
        Fraction first = new Fraction(2, 8);
        Fraction second = new Fraction(1, 2);
        assertFalse("equals method test failed. Comparision of not equals object return true.", first.equals(second) && second.equals(first));
    }

    /**
     * Test of compareTo method, of class Fraction.
     */
    @Test
    public void should_Return_Proper_Int_Value_After_Compering_With_Other_Object() {
        Fraction sample = new Fraction(2, 4);
        Fraction lower = new Fraction(3, 4);
        Fraction greater = new Fraction(1, 4);
        Fraction equals = new Fraction(1, 2);
        
        assertEquals("compareTo method test failed. Method returns that" + sample.toString() + "is not lower then" + lower.toString(), sample.compareTo(lower), -1);
        assertEquals("compareTo method test failed. Method returns that" + sample.toString() + "is not greater then" + greater.toString(), sample.compareTo(greater), 1);
        assertEquals("compareTo method test failed. Method returns that" + sample.toString() + "is not equal then" + equals.toString(), sample.compareTo(equals), 0);
    }

    @Test(expected = NullPointerException.class)
    public void should_Throws_NullPointerException_When_Null_Is_Passed() {
        Fraction instance = new Fraction(1, 2);
        instance.compareTo(null);
    }
    
    
    /**
     * Test of doubleValue method, of class Fraction.
     */
    @Test
    public void should_Return_DoubleValue() {
        Fraction instance = new Fraction(1, 2);
        double expResult = 0.5;
        double result = instance.doubleValue();
        assertEquals("doubleValue method test failed.",expResult, result, 0.01);
    }
    
    private String assertionFailedMsg(String reason, Fraction expected, Fraction actual) {
        return String.format(
                "Assertion Failed! Reason: %s\n Expected: %s \n Actual: %s\n", 
                reason, 
                expected != null ? expected.toString() : "null" , 
                actual != null ? actual.toString() : "null"
        );
    }
}
