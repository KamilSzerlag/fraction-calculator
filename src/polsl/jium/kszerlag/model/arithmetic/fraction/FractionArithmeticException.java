package polsl.jium.kszerlag.model.arithmetic.fraction;

/**
 * Thrown when an exceptional condition has occurred during creating Fraction object. For
 * example, passing in denominator integer zero value.
 * 
 * @version 2.0
 * @author Kamil Szerląg
 */
public class FractionArithmeticException extends ArithmeticException {

    /**
     * Constructor provides message 
     * 
     * @param s excepition message. 
     */
    public FractionArithmeticException(String s) {
        super(s);
    }
    
}
