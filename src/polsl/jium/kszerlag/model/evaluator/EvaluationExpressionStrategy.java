/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.model.evaluator;

import polsl.jium.kszerlag.model.arithmetic.Calculable;

/**
 * Strategy for eval math expressions. 
 * 
 * @version 1.0
 * @author szerlag
 * @param <T>
 */
public interface EvaluationExpressionStrategy<T extends Calculable> {
    
    T eval(String expression) throws EvaluationExpressionException;
    
}
