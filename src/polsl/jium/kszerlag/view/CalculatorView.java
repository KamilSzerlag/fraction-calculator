/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import polsl.jium.kszerlag.controller.FractionCalculatorController;
import polsl.jium.kszerlag.model.arithmetic.fraction.Fraction;

/**
 *
 * @author szerlag
 */
public class CalculatorView extends JFrame {
    
    private static final String PATH_TO_FONT_FILE = "src/resources/digital-7.ttf";
    
    private static final String FRAME_TITLE = "Fraction calculator";
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HIGHT = 700;
    private static final int CALC_WINDOW_POS_X = 50;
    private static final int CALC_WINDOW_POS_Y = 20;
    private static final int CALC_WINDOW_WIDTH = 300;
    private static final int CALC_WINDOW_HIGHT = 50;
    private static final int BUTTON_POS_X_GAP = 30;
    private static final int BUTTON_POS_Y_GAP = 30;
    private static final int PANEL_BUTTONS_WIDTH = 200;
    private static final int PANEL_BUTTONS_HIGHT = 400;
    private static final int PANEL_OPERATIONS_WIDTH = 125;
    private static final int PANEL_OPERATIONS_HIGHT = 400;
    private static final int BUTTON_SIZE_WIDTH = 50;
    private static final int BUTTON_SIZE_HIGHT = 50;
    
    private JTextField calculatorWindow;

    private FractionCalculatorController calculatorController;
    
    public CalculatorView() throws HeadlessException {
        initComponents();
    }
    
    private void initComponents() {
        setTitle(FRAME_TITLE);
        setBounds(0, 0, FRAME_WIDTH, FRAME_HIGHT);
        setLayout(null);
        setVisible(true);    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("Fraction calculator by K_Szerlag");
        
        Font font = null;
        try {
            File file = new File(PATH_TO_FONT_FILE);
            font = Font.createFont(Font.TRUETYPE_FONT, file);
            font = font.deriveFont(Font.BOLD, 35);
        } catch (FontFormatException | IOException e) {
            font = new Font("Arial", Font.BOLD, 35);
        }
         
        calculatorWindow = new JTextField();
        calculatorWindow.setFont(font);
        calculatorWindow.setHorizontalAlignment(JTextField.RIGHT);
        calculatorWindow.setBounds(
                CALC_WINDOW_POS_X,
                CALC_WINDOW_POS_Y,
                CALC_WINDOW_WIDTH,
                CALC_WINDOW_HIGHT);
        calculatorWindow.setVisible(true);
        calculatorWindow.setText("HELLO!");
        add(calculatorWindow);
        
        GridLayout layout = new GridLayout(3, 3);
        layout.setVgap(20);
        layout.setHgap(10);
        
        JPanel buttonsPanel = new JPanel(layout);
        add(buttonsPanel);
        buttonsPanel.setBounds(
                CALC_WINDOW_POS_X - 20,
                CALC_WINDOW_POS_Y + CALC_WINDOW_HIGHT + BUTTON_POS_Y_GAP,
                PANEL_BUTTONS_WIDTH,
                PANEL_BUTTONS_HIGHT);
        buttonsPanel.setVisible(true);
        
        CustomButton buttonOne = new CustomButton(ButtonsConst.NUMBER_ONE);
        buttonOne.addActionListener(calculatorWindow);
        buttonsPanel.add(buttonOne);
        
        CustomButton buttonTwo = new CustomButton(ButtonsConst.NUMBER_TWO);
        buttonTwo.addActionListener(calculatorWindow);
        buttonsPanel.add(buttonTwo);
        
        CustomButton buttonThree = new CustomButton(ButtonsConst.NUMBER_THREE);
        buttonThree.addActionListener(calculatorWindow);
        buttonsPanel.add(buttonThree);
        
        CustomButton buttonFour = new CustomButton(ButtonsConst.NUMBER_FOUR);
        buttonFour.addActionListener(calculatorWindow);
        buttonsPanel.add(buttonFour);
        
        CustomButton buttonFive = new CustomButton(ButtonsConst.NUMBER_FIVE);
        buttonFive.addActionListener(calculatorWindow);
        buttonsPanel.add(buttonFive);
        
        CustomButton buttonSix = new CustomButton(ButtonsConst.NUMBER_SIX);
        buttonSix.addActionListener(calculatorWindow);
        buttonsPanel.add(buttonSix);
        
        CustomButton buttonSeven = new CustomButton(ButtonsConst.NUMBER_SEVEN);
        buttonSeven.addActionListener(calculatorWindow);
        buttonsPanel.add(buttonSeven);
        
        CustomButton buttonEight = new CustomButton(ButtonsConst.NUMBER_EIGHT);
        buttonEight.addActionListener(calculatorWindow);
        buttonsPanel.add(buttonEight);
        
        CustomButton buttonNine = new CustomButton(ButtonsConst.NUMBER_NINE);
        buttonNine.addActionListener(calculatorWindow);
        buttonsPanel.add(buttonNine);
        
        CustomButton buttonZero = new CustomButton(ButtonsConst.NUMBER_ZERO);
        buttonZero.addActionListener(calculatorWindow);
        buttonZero.setBounds(
                CALC_WINDOW_POS_X - 20,
                CALC_WINDOW_POS_Y + CALC_WINDOW_HIGHT + BUTTON_POS_Y_GAP + PANEL_BUTTONS_HIGHT + 20,
                PANEL_BUTTONS_WIDTH,
                50
                );
        buttonZero.setVisible(true);
        add(buttonZero);
        repaint();
        revalidate();
        
        JPanel operationsPanel = new JPanel(new GridLayout(2,2));
        add(operationsPanel);
        operationsPanel.setBounds(
                CALC_WINDOW_POS_X - 30 + PANEL_BUTTONS_WIDTH + BUTTON_POS_X_GAP,
                CALC_WINDOW_POS_Y + CALC_WINDOW_HIGHT + BUTTON_POS_Y_GAP,
                PANEL_OPERATIONS_WIDTH,
                PANEL_OPERATIONS_HIGHT                
        );
        operationsPanel.setVisible(true);
        
        CustomButton plusButton = new CustomButton(ButtonsConst.PLUS);
        plusButton.addActionListener(calculatorWindow);
        operationsPanel.add(plusButton);
        
        CustomButton minusButton = new CustomButton(ButtonsConst.MINUS);
        minusButton.addActionListener(calculatorWindow);
        operationsPanel.add(minusButton);
        
        CustomButton multButton = new CustomButton(ButtonsConst.MULT);
        multButton.addActionListener(calculatorWindow);
        operationsPanel.add(multButton);
        
        CustomButton divButton = new CustomButton(ButtonsConst.DIV);
        divButton.addActionListener(calculatorWindow);
        operationsPanel.add(divButton);
        
        CustomButton fracButton = new CustomButton(ButtonsConst.FRACTION);
        fracButton.addActionListener(calculatorWindow);
        operationsPanel.add(fracButton);
        
        JButton calculateButton = new JButton(ButtonsConst.CALCULATE);
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    calculatorController.evalExpression(calculatorWindow.getText());
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, ex, "ERROR", 0);
                    calculatorWindow.setText("ERROR");
                }
            }
        });
        operationsPanel.add(calculateButton);
        
        JButton clearButton = new JButton(ButtonsConst.CLEAR);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatorWindow.setText("");
            }
        });
        clearButton.setBounds(
                CALC_WINDOW_POS_X - 30 + PANEL_BUTTONS_WIDTH + BUTTON_POS_X_GAP,
                CALC_WINDOW_POS_Y + CALC_WINDOW_HIGHT + BUTTON_POS_Y_GAP + PANEL_BUTTONS_HIGHT + 20,
                PANEL_OPERATIONS_WIDTH,
                50
                );
        add(clearButton);
        repaint();
        revalidate();
    }
    
    public void setController(FractionCalculatorController controller) {
        this.calculatorController = controller;
    }
    
    public void displayCalculationResult(Fraction fraction) {
        calculatorWindow.setText(fraction.getNumerator() + "/" + fraction.getDenominator());
    }
}
