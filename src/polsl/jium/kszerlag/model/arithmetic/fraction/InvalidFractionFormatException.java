/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.model.arithmetic.fraction;

/**
 * Exeption called when the passed string format is incorrect.
 *
 * @author szerlag
 */
public class InvalidFractionFormatException extends IllegalArgumentException {

    public InvalidFractionFormatException() {
    }

    public InvalidFractionFormatException(String message) {
        super(message);
    }
    
}
