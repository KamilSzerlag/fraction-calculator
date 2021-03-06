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
 * Class provides methods for evaluating basic mathematics expression which 
 * contains arithmetic operations on fraction like "2/3 + 1/2" or "1/2 + 1/2" 
 * 
 * @version 2.0
 * @author szerlag
 */
public class SimpleFractionExpressionEvaluator implements EvaluationExpressionStrategy<Fraction>{
    
    private static final char[] ARITHMETIC_OPERATORS = {'+', '-', '*', ':', '^'}; 
    private static final char FRACTION_CHAR = '/';
    
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
        List<Fraction> fractionToCalculate = new ArrayList<>();
        char arithmeticOperator = 'x';
        for (int i = 0; i < expression.length(); i++) {
            char sym = expression.charAt(i);
            if (EvaluationExpressionUtil.isNumber(sym)) {
                sb.append(sym);
            }
            if (sym == FRACTION_CHAR) {
                sb.append(sym);
            }
            if (EvaluationExpressionUtil.isAritchmeticOperator(sym)) {
                Fraction fraction = Fraction.valueOf(sb.toString());
                fractionToCalculate.add(fraction);
                sb = new StringBuilder();
                arithmeticOperator = sym;
            }
            if (i + 1 == expression.length()) {
                Fraction fraction = Fraction.valueOf(sb.toString());
                fractionToCalculate.add(fraction);
            }
        }
        return doFractionArithmeticOperation(fractionToCalculate, arithmeticOperator);
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
        if (!EvaluationExpressionUtil.isAritchmeticOperator(operator)) {
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
    
}
