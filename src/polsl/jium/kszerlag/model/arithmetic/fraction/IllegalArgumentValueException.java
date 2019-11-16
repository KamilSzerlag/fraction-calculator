/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.model.arithmetic.fraction;

/**
 * An exception is thrown when passed value in argument is incorrect.
 * 
 * @author szerlag
 */
public class IllegalArgumentValueException extends IllegalArgumentException {

    public IllegalArgumentValueException() {
    }

    public IllegalArgumentValueException(String message) {
        super(message);
    }
    
    
}
