package polsl.jium.kszerlag.model.arithmetic.fraction;

/**
 * Exeption called when the passed string format is incorrect.
 *
 * @version 2.0
 * @author Kamil Szerląg
 */
public class InvalidFractionFormatException extends IllegalArgumentException {

    public InvalidFractionFormatException() {
    }

    public InvalidFractionFormatException(String message) {
        super(message);
    }
    
}
