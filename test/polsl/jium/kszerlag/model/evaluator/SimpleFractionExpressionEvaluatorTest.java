package polsl.jium.kszerlag.model.evaluator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import polsl.jium.kszerlag.model.arithmetic.fraction.Fraction;
import polsl.jium.kszerlag.model.arithmetic.fraction.InvalidFractionFormatException;

/**
 *
 * @author Kamil Szerląg
 */
public class SimpleFractionExpressionEvaluatorTest {
    
    private SimpleFractionExpressionEvaluator instance;
    
    @Before
    public void setUp() {
        instance = new SimpleFractionExpressionEvaluator();
    }

    /**
     * Test of eval method, of class SimpleFractionExpressionEvaluator.
     * @throws polsl.jium.kszerlag.model.evaluator.EvaluationExpressionException
     */
    @Test
    public void should_Return_Correct_Addition_Expression_Value() throws EvaluationExpressionException {
        String expression = "1/2+3/4";
        Fraction expResult = new Fraction(10, 8);
        Fraction result = instance.eval(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void should_Return_Incorrect_Addition_Expression_Value() throws EvaluationExpressionException {
        String expression = "1/3+3/4";
        Fraction expResult = new Fraction(10, 8);
        Fraction result = instance.eval(expression);
        assertNotEquals(expResult, result);
    }
    
    @Test
    public void should_Return_Correct_Subtraction_Expression_Value() throws EvaluationExpressionException {
        String expression = "5/2-3/4";
        Fraction expResult = new Fraction(7, 4);
        Fraction result = instance.eval(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void should_Return_Incorrect_Subtraction_Expression_Value() throws EvaluationExpressionException {
        String expression = "5/2-3/4";
        Fraction expResult = new Fraction(3, 5);
        Fraction result = instance.eval(expression);
        assertNotEquals(expResult, result);
    }
    
    @Test
    public void should_Return_Correct_Multiplication_Expression_Value() throws EvaluationExpressionException {
        String expression = "1/2*3/4";
        Fraction expResult = new Fraction(3, 8);
        Fraction result = instance.eval(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void should_Return_Incorrect_Multiplication_Expression_Value() throws EvaluationExpressionException {
        String expression = "1/2*3/4";
        Fraction expResult = new Fraction(3, 1);
        Fraction result = instance.eval(expression);
        assertNotEquals(expResult, result);
    }
    
    @Test
    public void should_Return_Correct_Division_Expression_Value() throws EvaluationExpressionException {
        String expression = "1/3:4/3";
        Fraction expResult = new Fraction(3, 12);
        Fraction result = instance.eval(expression);
        assertEquals(expResult, result);
    }
    
    @Test
    public void should_Return_Incorrect_Division_Expression_Value() throws EvaluationExpressionException {
        String expression = "1/3:4/3";
        Fraction expResult = new Fraction(1, 12);
        Fraction result = instance.eval(expression);
        assertNotEquals(expResult, result);
    }
    
    @Test 
    public void should_Return_Fraction_From_Expression() throws EvaluationExpressionException {
        String expression = "1/2";
        Fraction expResult = new Fraction(1, 2);
        Fraction result = instance.eval(expression);
        assertEquals(expResult, result);
    }
    
    @Test(expected = EvaluationExpressionException.class)
    public void should_Throws_Evaluation_Expression_Exception_Caused_By_Too_Many_Operators_In_Expression() throws EvaluationExpressionException {
        String expression = "1/2+1/3+4/3";
        instance.eval(expression);
    }
    
    @Test(expected = InvalidFractionFormatException.class)
    public void should_Throws_Evaluation_Expression_Exception_Caused_By_Invalid_Fraction_Format() throws EvaluationExpressionException {
        String expression = "1/3/3/4";
        instance.eval(expression);
    }
    
    @Test(expected = EvaluationExpressionException.class)
    public void should_Throws_EvaluationExpressionException_Caused_By_Unsupported_Symbol_() throws EvaluationExpressionException {
        String expression = "1/3x3/4";
        instance.eval(expression);
    }
    
    @Test
    public void should_Return_Null_Caused_By_Passed_Null_Argument() throws EvaluationExpressionException {
        String expression = null;
        Fraction result = instance.eval(expression);
        assertNull(result);
    }
    
    @Test
    public void should_Return_Null_Caused_By_Passed_Empty_String() throws EvaluationExpressionException {
        String expression = "";
        Fraction result = instance.eval(expression);
        assertNull(result);
    }
}
