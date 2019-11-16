package polsl.jium.kszerlag.model.arithmetic.fraction;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kamil Szerląg
 */
public class FractionTest {

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
        assertEquals(expResult, result);
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
        assertNotEquals(expResult, result);
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
        assertEquals(expResult, result);
    }
    
    /**
     * Test of hashCode method, of class Fraction.
     */
    @Test
    public void should_Compare_Symmetric_HashCode_Equality() {
        Fraction first = new Fraction(1, 14);
        Fraction second = new Fraction(1, 14);
        assertTrue(first.equals(second) && second.equals(first));
        assertTrue(first.hashCode() == second.hashCode());
    }

    /**
     * Test of equals method, of class Fraction.
     */
    @Test
    public void should_Return_True_For_Symmetrical_Equality() {
        Fraction first = new Fraction(2, 4);
        Fraction second = new Fraction(1, 2);
        assertTrue(first.equals(second) && second.equals(first));
    }
    
    /**
     * Test of equals method of class Fraction.
     * 
     */
    @Test
    public void should_Return_False_For_Symmetrical_Equality() {
        Fraction first = new Fraction(2, 8);
        Fraction second = new Fraction(1, 2);
        assertFalse(first.equals(second) && second.equals(first));
    }

    /**
     * Test of compareTo method, of class Fraction.
     */
    @Test
    public void should_Return_Proper_Int_Value_After_Compering_With_Other_Object() {
        Fraction first = new Fraction(2, 4);
        Fraction second = new Fraction(3, 4);
        Fraction third = new Fraction(1, 4);
        Fraction fourth = new Fraction(1, 2);
        
        assertEquals(first.compareTo(second), -1);
        assertEquals(first.compareTo(third), 1);
        assertEquals(first.compareTo(fourth), 0);
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
