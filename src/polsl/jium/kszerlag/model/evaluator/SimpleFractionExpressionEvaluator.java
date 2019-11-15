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
 * @version 2.0
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
     * @param expression - contains mathematic expression in <code>Sting</code>.
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
            if (isNumber(symbol)) {
                sb.append(symbol);
            }
            if (symbol == FRACTION_SYMBOL) {
                sb.append(symbol);
            }
            if (isAritchmeticOperators(symbol)) {
                Fraction fraction = Fraction.valueOf(sb.toString());
                fractions.add(fraction);
                sb = new StringBuilder();
                arithmeticOperator = symbol;
            }
            if (i + 1 == expression.length()) {
                Fraction fraction = Fraction.valueOf(sb.toString());
                fractions.add(fraction);
            }
        }
        return doFractionArithmeticOperation(fractions, arithmeticOperator);
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
        if (!isAritchmeticOperators(operator)) {
            throw new EvaluationExpressionException("No such arithmetic operation!");
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
    
    /**
     * Determines whether the symbol is supported arithmetic operator.
     * 
     * @param symbol - char contains arithmetic operator.
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
     * Determines wheather the symbol is a number.
     * 
     * @param symbol char symbol.
     * @return true if symbol is a number.
     */
    private boolean isNumber(char symbol) {
        return (symbol >= '0') && (symbol <= '9');
    }
}
