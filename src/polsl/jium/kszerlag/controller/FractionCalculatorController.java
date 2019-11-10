/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.controller;

import polsl.jium.kszerlag.model.arithmetic.fraction.Fraction;
import polsl.jium.kszerlag.model.evaluator.EvaluationExpressionException;
import polsl.jium.kszerlag.model.evaluator.SimpleFractionExpressionEvaluator;
import polsl.jium.kszerlag.view.CalculatorView;

/**
 *
 * @author szerlag
 */
public class FractionCalculatorController {
    private SimpleFractionExpressionEvaluator evaluator;
    private CalculatorView calculatorView; 

    public FractionCalculatorController(SimpleFractionExpressionEvaluator evaluator, CalculatorView calculatorView) {
        this.evaluator = evaluator;
        this.calculatorView = calculatorView;
    }
    
    public void evalExpression(String expression) throws EvaluationExpressionException {
        calculatorView.displayCalculationResult(evaluator.eval(expression));
    }
    
    
}
