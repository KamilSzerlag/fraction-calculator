/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author szerlag
 */
public class CustomButton extends JButton {

    public CustomButton(String text) {
        super(text);
    }
    
    public void addActionListener(JTextField textField) {
        super.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + getText());
            }
        });
    } 
}
