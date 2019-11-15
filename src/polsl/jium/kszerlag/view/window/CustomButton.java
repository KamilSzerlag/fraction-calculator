package polsl.jium.kszerlag.view.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Custom button component. This class is intended for implementation of the
 * <code>CalculatorView</code> logic requirements.
 * 
 * @version 1.0
 * @author Kamil Szerląg
 */
public class CustomButton extends JButton {

    public CustomButton(String text) {
        super(text);
    }
    
    /**
     * Adding button text value to JTextField passed as argument object.
     * 
     * Overloading addActionListener method form JButton base class.
     * 
     * @param textField JTexField object where button text value should be append.
     */
    void addActionListener(JTextField textField) {
        super.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + getText());
            }
        });
    } 
}
