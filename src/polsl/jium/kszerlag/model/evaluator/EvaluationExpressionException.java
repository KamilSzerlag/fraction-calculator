package polsl.jium.kszerlag.model.evaluator;

/**
 * An exception is thrown when it is impossible to evaluate the passed expression.
 * 
 * @version 3.0
 * @author Kamil Szerląg
 */
public class EvaluationExpressionException extends Exception {

    /**
     * Constructor creating Exception object contains message about reason for
     * occurance.
     * 
     * @param message should contains information about reason for occurance.
     */
    public EvaluationExpressionException(String message) {
        super(message);
    }
    
}
