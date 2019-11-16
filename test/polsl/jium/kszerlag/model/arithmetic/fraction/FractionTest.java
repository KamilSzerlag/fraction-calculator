package polsl.jium.kszerlag.model.arithmetic.fraction;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kamil Szerląg
 */
public class FractionTest {

    /**
     * Test of valueOf method, of class Fraction.
     */
    @Test
    public void should_Return_Correct_Fraction_Obcject_With_Value_Of_String() {
        String fraction = "4/3";
        Fraction expResult = new Fraction(4, 3);
        Fraction result = Fraction.of(fraction);
        assertEquals(expResult, result);
    }
    
    @Test
    public void should_Return_Incorrect_Fraction_Obcject_With_Value_Of_String() {
        String fraction = "4/3";
        Fraction expResult = new Fraction(3, 4);
        Fraction result = Fraction.of(fraction);
        assertNotEquals(expResult, result);
    }

    @Test(expected = NullPointerException.class)
    public void should_Throws_NullPointerException_Caused_By_Null_Arg() {
        String fraction = null;
        Fraction.of(fraction);
    }
    
    @Test(expected = NullPointerException.class)
    public void should_Throws_NullPointerException_Caused_By_Empty_String_Arg() {
        String fraction = "";
        Fraction.of(fraction);
    }
    
    @Test(expected = NumberFormatException.class)
    public void should_Throws_NumberFormatException() {
        String fraction = "1-5";
        Fraction.of(fraction);
    }
    
    @Test(expected = InvalidFractionFormatException.class)
    public void should_Throws_InvalidFormatException() {
        String fraction = "1/2/4";
        Fraction.of(fraction);
    }
    
    @Test
    public void should_Return_Correct_String_Format() {
        Fraction instance = new Fraction(1, 2);
        String expResult = "1\n-\n2";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of hashCode method, of class Fraction.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Fraction instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Fraction.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Fraction instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Fraction.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Fraction other = null;
        Fraction instance = null;
        int expResult = 0;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doubleValue method, of class Fraction.
     */
    @Test
    public void should_Return_DoubleValue() {
        Fraction instance = new Fraction(1, 2);
        double expResult = 0.5;
        double result = instance.doubleValue();
        assertEquals(expResult, result, 0.01);
    }
    
}