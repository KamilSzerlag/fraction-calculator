/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.model.evaluator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import polsl.jium.kszerlag.model.arithmetic.ArithmeticOperation;
import polsl.jium.kszerlag.model.arithmetic.fraction.Fraction;
import polsl.jium.kszerlag.model.arithmetic.fraction.FractionOperation;

/**
 * @version 1.0
 * @author szerlag
 */
public class SimpleFractionExpressionEvaluator {
    
    private static final char[] ARITHMETIC_OPERATORS = {'+', '-', '*', ':', '^'}; 
    private static final char FRACTION_CHAR = '/';
            
    public Fraction eval(String expression) throws EvaluationExpressionException {
        if (expression == null || expression.isEmpty()) {
            return null;
        }
        expression = expression.trim();
        StringBuilder sb = new StringBuilder();
        List<Fraction> fractionToCalculate = new ArrayList<>();
        char arithmeticOperator = 'x';
        for (int i = 0; i < expression.length(); i++) {
            if ((expression.charAt(i) >= '0') && (expression.charAt(i) <= '9')) {
                sb.append(expression.charAt(i));
            }
            if (expression.charAt(i) == FRACTION_CHAR) {
                sb.append(expression.charAt(i));
            }
            if (isAritchmeticOperators(expression.charAt(i))) {
                Fraction fraction = Fraction.valueOf(sb.toString());
                fractionToCalculate.add(fraction);
                sb = new StringBuilder();
                arithmeticOperator = expression.charAt(i);
            }
            if (i + 1 == expression.length()) {
                Fraction fraction = Fraction.valueOf(sb.toString());
                fractionToCalculate.add(fraction);
            }
        }
        return doFractionArithmeticOperation(fractionToCalculate, arithmeticOperator);
    }
    
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
    
    private boolean isAritchmeticOperators(char c) {
        for (char operator : ARITHMETIC_OPERATORS) {
            if(c == operator) {
                return true;
            }
        }
        return false;
    }
    
}
