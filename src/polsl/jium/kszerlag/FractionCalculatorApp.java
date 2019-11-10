/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag;

import polsl.jium.kszerlag.controller.FractionCalculatorController;
import polsl.jium.kszerlag.model.evaluator.SimpleFractionExpressionEvaluator;
import polsl.jium.kszerlag.view.CalculatorView;

/**
 *
 * @author szerlag
 * @version 1.0
 */
public class FractionCalculatorApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleFractionExpressionEvaluator evaluator = new SimpleFractionExpressionEvaluator();
        CalculatorView calculatorView = new CalculatorView();
        FractionCalculatorController controller = new FractionCalculatorController(evaluator, calculatorView);
        calculatorView.setController(controller);
    }
    
}
