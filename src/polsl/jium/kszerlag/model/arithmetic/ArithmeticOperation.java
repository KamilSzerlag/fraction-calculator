package polsl.jium.kszerlag.model.arithmetic;

/**
 * An Interface with basic 
 * arithmetic operations addition, subtraction, multiplication and division.
 * Additionaly this interface in next version could contains more advanced 
 * operations.
 *
 * @version 1.0
 * @author Kamil Szerląg
 * @param <T> T class must implements Calculable marker interface.
 */
public interface ArithmeticOperation<T extends Calculable> {
    
    /**
     * Addition(+)
     * summand + summand = sum
     * 
     * @param firstSummand
     * @param secondSummand
     * @return result of addition as T class.
     */
    T add(T firstSummand, T secondSummand);
    
    /**
     * Subtraction(-)
     * minuend - subtrahend = difference
     * 
     * @param minuend 
     * @param subtrahend
     * @return result of subtraction as T class.
     */
    T subtruct(T minuend, T subtrahend);
    
    /**
     * Multiplication(x)
     * factor * factor = product
     * 
     * @param firstFactor 
     * @param secondFactor 
     * @return result of multiplication as T class.
     */
    T multiply(T firstFactor, T secondFactor);
    
    /**
     * Division(:) 
     * dividend/divisor = fraction 
     * 
     * @param dividend
     * @param devisor
     * @return result of devision as T class.
     */
    T divide(T dividend, T devisor);
    
    /**
     * Exponentation(^)
     * base ^ exponent = power
     * 
     * @param base
     * @param exponent
     * @return result of exponentation as T class.
     */
    T power(T base, int exponent);
}
