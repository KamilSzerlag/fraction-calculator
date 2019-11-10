/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.model.arithmetic;

/**
 * An Interface with basic 
 * arithmetic operations addition, subtraction, multiplication and division.
 * Additionaly this interface in next version could contains more advanced 
 * operations.
 *
 * @version 1.0
 * @author szerlag
 * @param <T>
 */
public interface ArithmeticOperation<T extends Calculable> {
    
    /**
     * Addition(+)
     * summand + summand = sum
     * 
     * @param firstSummand
     * @param secondSummand
     * @return 
     */
    T add(T firstSummand, T secondSummand);
    
    /**
     * Subtraction(-)
     * minuend - subtrahend = difference
     * 
     * @param minuend
     * @param subtrahend
     * @return 
     */
    T subtruct(T minuend, T subtrahend);
    
    /**
     * Multiplication(x)
     * factor * factor = product
     * 
     * @param firstFactor 
     * @param secondFactor 
     * @return 
     */
    T multiply(T firstFactor, T secondFactor);
    
    /**
     * Division(:) 
     * dividend/divisor = fraction 
     * 
     * @param dividend
     * @param devisor
     * @return 
     */
    T divide(T dividend, T devisor);
    
    /**
     * Exponentation(^)
     * base ^ exponent = power
     * 
     * @param base
     * @param exponent
     * @return 
     */
    T power(T base, int exponent);
}
