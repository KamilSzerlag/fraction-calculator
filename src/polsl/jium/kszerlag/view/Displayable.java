/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.view;

import polsl.jium.kszerlag.model.arithmetic.fraction.Fraction;

/**
 *  Interface with methods for supporting content displaying.
 * 
 * @version 1.0
 * @author Kamil Szerląg
 */
public interface Displayable {
    
    /**
     * Displaying calculation result.
     * 
     * @param fraction <code>Fraction</code> class object.
     */
    void displayCalculationResult(Fraction fraction);

    /**
     * Displaying warning.
     * 
     * @param e exception extended RuntimeException class.
     */
    void displayWarningMsg(RuntimeException e);

    /**
     * Displaying error.
     * 
     * @param e exception extended Exception class.
     */
    void displayErrorMsg(Exception e);
    
}
