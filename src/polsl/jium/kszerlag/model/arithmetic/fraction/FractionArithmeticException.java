package polsl.jium.kszerlag.model.arithmetic.fraction;

/**
 * Thrown when an exceptional condition has occurred during creating or making operation
 * on Fraction objects. For example, passing in denominator integer zero value.
 * 
 * @version 3.0
 * @author Kamil Szerląg
 */
public class FractionArithmeticException extends ArithmeticException {

    /**
     * Constructor provides message with information about reasons for
     * occurance.
     * 
     * @param s excepition message. Should contains reason for occurance. 
     */
    public FractionArithmeticException(String s) {
        super(s);
    }
    
}
