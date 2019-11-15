/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.model.evaluator;

import java.util.Iterator;
import java.util.List;
import polsl.jium.kszerlag.model.arithmetic.ArithmeticOperation;
import polsl.jium.kszerlag.model.arithmetic.fraction.FractionOperation;

/**
 *
 * @author szerlag
 */
public class EvaluationExpressionUtil {
    
    /**
     * Determines whether the operation is supported.
     * 
     * @param sym - symbol to check.
     * @return true if operator is supported, else false.
     */
    static boolean isAritchmeticOperator(char sym) {
        for (char arithmeticOperator : ExpressionEvaluatorConst.ARITHMETIC_OPERATORS) {
            if(sym == arithmeticOperator) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checking if passed argument is a number.
     * 
     * @param sym - symbol to check.
     * @return 
     */
    static boolean isNumber(char sym) {
        return sym >= '0' && sym <= '9';
    }
    
       
    /**
     * Resolving which arithmetic operations sholud be done. Performing operation, if is supported
     * otherwise throws EvaluationExpressionException.
     * Supported arithmetic operators are collected in <code>ARITHMETIC_OPERATORS</code>
     * const field.
     * 
     * @param numbers - <code>List</code> collected of Fraction objects.
     * @param operator - char contains <b>basic arithmetic operator</b> 
     * @return result of arithmetic operation on fraction.
     * @throws EvaluationExpressionException when operator is unsupported.
     */
    private <T> T doArithmeticOperation(List<T> numbers, char operator) throws EvaluationExpressionException {
        if (numbers == null || numbers.isEmpty()) {
            return null;
        }
        if (!EvaluationExpressionUtil.isAritchmeticOperator(operator)) {
            throw new EvaluationExpressionException("No such arithmetic operation!");
        }
        
        Iterator<T> iterator = numbers.iterator();
        T firstNumber = iterator.next();
        if (!iterator.hasNext()) {
            return firstNumber;
        }
        T secondFraction = iterator.next();
        
        ArithmeticOperation<T> arithmeticOperation = new FractionOperation();
        if (operator == '+') {
            return arithmeticOperation.add(firstNumber, secondFraction);
        }
        if (operator == '-') {
            return arithmeticOperation.subtruct(firstNumber, secondFraction);
        }
        if (operator == '*') {
            return arithmeticOperation.multiply(firstNumber, secondFraction);
        }
        if (operator == ':') {
            return arithmeticOperation.divide(firstNumber, secondFraction);
        }
        return firstNumber;
    }
}
