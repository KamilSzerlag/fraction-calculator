package polsl.jium.kszerlag.model.evaluator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import polsl.jium.kszerlag.model.arithmetic.ArithmeticOperation;
import polsl.jium.kszerlag.model.arithmetic.fraction.Fraction;
import polsl.jium.kszerlag.model.arithmetic.fraction.FractionOperation;

/**
 * Class provides methods for evaluating basic mathematics expression which 
 * contains arithmetic operations on fraction like "2/3 + 1/2" or "1/2 + 1/2" 
 * 
 * @version 3.0
 * @author Kamil Szerląg
 */
public class SimpleFractionExpressionEvaluator {
    
    /**
     * Constant Array of Arithmetic operators.
     */
    private static final char[] ARITHMETIC_OPERATORS = {'+', '-', '*', ':', '^'};
    
    /**
     * Constant represents fraction line in expression.
     * The part before slash is a number above the line known as numerator.
     * The part after slash is a number below the line known as denominator.
     */
    private static final char FRACTION_SYMBOL = '/';
    
    /**
     * Evaluating mathematics expression like "2/1 + 7/5".
     * 
     * @param expression contains mathematical expression in <code>String</code>.
     * @return result of expression as <code>Fraction</code> object.
     * @throws EvaluationExpressionException when expression contains unsupported expression.
     */
    public Fraction eval(String expression) throws EvaluationExpressionException {
        if (expression == null || expression.isEmpty()) {
            return null;
        }
        expression = expression.trim();
        StringBuilder sb = new StringBuilder();
        List<Fraction> fractions = new ArrayList<>();
        char arithmeticOperator = 0;
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            checkSupportedSymbol(symbol);
            if (isNumber(symbol)) {
                sb.append(symbol);
            }
            if (symbol == FRACTION_SYMBOL) {
                sb.append(symbol);
            }
            if (isAritchmeticOperators(symbol)) {
                if (arithmeticOperator != 0) {
                    throw new EvaluationExpressionException("Too many operators in expression!");
                }
                Fraction fraction = new Fraction();
                fraction = fraction.parseFraction(sb.toString());
                fractions.add(fraction);
                sb = new StringBuilder();
                arithmeticOperator = symbol;
            }
            if (i + 1 == expression.length()) {
                Fraction fraction = new Fraction();
                fraction = fraction.parseFraction(sb.toString());
                fractions.add(fraction);
            }
        }
        return doFractionArithmeticOperation(fractions, arithmeticOperator);
    }
    
    /**
     * Checking if symbol is supported by evaluator algorithm.
     * 
     * @throws EvaluationExpressionException if symbol is unsupported by algorithm.
     */
    private void checkSupportedSymbol(char symbol) throws EvaluationExpressionException {
        if (!isNumber(symbol) && !isAritchmeticOperators(symbol) && symbol != FRACTION_SYMBOL) {
            throw new EvaluationExpressionException("Unsupported symbol!");
        }
    }
    
    /**
     * Determines wheather the symbol is a number.
     * 
     * @return true if symbol is a number.
     */
    private boolean isNumber(char symbol) {
        return (symbol >= '0') && (symbol <= '9');
    }
    
    /**
     * Determines whether the symbol is supported arithmetic operator.
     * 
     * @param symbol char contains arithmetic operator.
     * @return true if operator is supported, else false.
     */
    private boolean isAritchmeticOperators(char symbol) {
        for (char arithmeticOperator : ARITHMETIC_OPERATORS) {
            if(symbol == arithmeticOperator) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Resolving which arithmetic operations sholud be done. Performing operation, if is supported
     * otherwise throws EvaluationExpressionException.
     * Supported arithmetic operators are collected in <code>ARITHMETIC_OPERATORS</code>
     * const field.
     * 
     * @param fractions - <code>List</code> collected of Fraction objects.
     * @param operator - char contains <b>basic arithmetic operator</b> 
     * @return result of arithmetic operation on fraction.
     * @throws EvaluationExpressionException when operator is unsupported.
     */
    private Fraction doFractionArithmeticOperation(List<Fraction> fractions, char operator) throws EvaluationExpressionException {
        if (fractions == null || fractions.isEmpty()) {
            return null;
        }
        
        Iterator<Fraction> iterator = fractions.iterator();
        Fraction firstFraction = iterator.next();
        if (!iterator.hasNext()) {
            return firstFraction;
        }
        Fraction secondFraction = iterator.next();
        
        ArithmeticOperation<Fraction> arithmeticOperation = new FractionOperation();
        if (operator == '+') {
            return arithmeticOperation.add(firstFraction, secondFraction);
        }
        if (operator == '-') {
            return arithmeticOperation.subtruct(firstFraction, secondFraction);
        }
        if (operator == '*') {
            return arithmeticOperation.multiply(firstFraction, secondFraction);
        }
        if (operator == ':') {
            return arithmeticOperation.divide(firstFraction, secondFraction);
        }
        return firstFraction;
    }
}
