package polsl.jium.kszerlag.view.window;

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
import polsl.jium.kszerlag.view.Displayable;

/**
 * Class representing main calculator view
 * 
 * @version 2.0
 * @author Kamil Szerląg
 */
public class CalculatorView extends JFrame implements Displayable {
    
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
    
    private JTextField calculatorTextField;

    private FractionCalculatorController calculatorController;
    
    /**
     * Constructing calculator view presented in the application window.
     * 
     * @throws HeadlessException 
     */
    public CalculatorView() throws HeadlessException {
        initComponents();
    }
    
    /**
     * Initializing CalculatorView components
     */
    private void initComponents() {
        setTitle(FRAME_TITLE);
        setBounds(0, 0, FRAME_WIDTH, FRAME_HIGHT);
        setLayout(null);
        setVisible(true);    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("Fraction calculator by K_Szerlag");
        
        Font font;
        try {
            File file = new File(PATH_TO_FONT_FILE);
            font = Font.createFont(Font.TRUETYPE_FONT, file);
            font = font.deriveFont(Font.BOLD, 35);
        } catch (FontFormatException | IOException e) {
            font = new Font("Arial", Font.BOLD, 35);
        }
         
        calculatorTextField = new JTextField();
        calculatorTextField.setFont(font);
        calculatorTextField.setHorizontalAlignment(JTextField.RIGHT);
        calculatorTextField.setBounds(
                CALC_WINDOW_POS_X,
                CALC_WINDOW_POS_Y,
                CALC_WINDOW_WIDTH,
                CALC_WINDOW_HIGHT);
        calculatorTextField.setVisible(true);
        calculatorTextField.setText("HELLO!");
        add(calculatorTextField);
        
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
        buttonOne.addActionListener(calculatorTextField);
        buttonsPanel.add(buttonOne);
        
        CustomButton buttonTwo = new CustomButton(ButtonsConst.NUMBER_TWO);
        buttonTwo.addActionListener(calculatorTextField);
        buttonsPanel.add(buttonTwo);
        
        CustomButton buttonThree = new CustomButton(ButtonsConst.NUMBER_THREE);
        buttonThree.addActionListener(calculatorTextField);
        buttonsPanel.add(buttonThree);
        
        CustomButton buttonFour = new CustomButton(ButtonsConst.NUMBER_FOUR);
        buttonFour.addActionListener(calculatorTextField);
        buttonsPanel.add(buttonFour);
        
        CustomButton buttonFive = new CustomButton(ButtonsConst.NUMBER_FIVE);
        buttonFive.addActionListener(calculatorTextField);
        buttonsPanel.add(buttonFive);
        
        CustomButton buttonSix = new CustomButton(ButtonsConst.NUMBER_SIX);
        buttonSix.addActionListener(calculatorTextField);
        buttonsPanel.add(buttonSix);
        
        CustomButton buttonSeven = new CustomButton(ButtonsConst.NUMBER_SEVEN);
        buttonSeven.addActionListener(calculatorTextField);
        buttonsPanel.add(buttonSeven);
        
        CustomButton buttonEight = new CustomButton(ButtonsConst.NUMBER_EIGHT);
        buttonEight.addActionListener(calculatorTextField);
        buttonsPanel.add(buttonEight);
        
        CustomButton buttonNine = new CustomButton(ButtonsConst.NUMBER_NINE);
        buttonNine.addActionListener(calculatorTextField);
        buttonsPanel.add(buttonNine);
        
        CustomButton buttonZero = new CustomButton(ButtonsConst.NUMBER_ZERO);
        buttonZero.addActionListener(calculatorTextField);
        buttonZero.setBounds(
                CALC_WINDOW_POS_X - 20,
                CALC_WINDOW_POS_Y + CALC_WINDOW_HIGHT + BUTTON_POS_Y_GAP + PANEL_BUTTONS_HIGHT + 20,
                PANEL_BUTTONS_WIDTH,
                50
                );
        buttonZero.setVisible(true);
        add(buttonZero);
        
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
        plusButton.addActionListener(calculatorTextField);
        operationsPanel.add(plusButton);
        
        CustomButton minusButton = new CustomButton(ButtonsConst.MINUS);
        minusButton.addActionListener(calculatorTextField);
        operationsPanel.add(minusButton);
        
        CustomButton multButton = new CustomButton(ButtonsConst.MULT);
        multButton.addActionListener(calculatorTextField);
        operationsPanel.add(multButton);
        
        CustomButton divButton = new CustomButton(ButtonsConst.DIV);
        divButton.addActionListener(calculatorTextField);
        operationsPanel.add(divButton);
        
        CustomButton fracButton = new CustomButton(ButtonsConst.FRACTION);
        fracButton.addActionListener(calculatorTextField);
        operationsPanel.add(fracButton);
        
        JButton calculateButton = new JButton(ButtonsConst.CALCULATE);
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatorController.calculate(calculatorTextField.getText());
            }
        });
        operationsPanel.add(calculateButton);
        
        JButton clearButton = new JButton(ButtonsConst.CLEAR);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatorTextField.setText("");
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
    
    /**
     * Setting initalizing calculatorController field.
     * 
     * @param controller FractionCalculatorController class object. 
     */
    public void setController(FractionCalculatorController controller) {
        this.calculatorController = controller;
    }
    
    @Override
    public void displayCalculationResult(Fraction fraction) {
        calculatorTextField.setText(fraction.getNumerator() + "/" + fraction.getDenominator());
    }

    @Override
    public void displayWarningMsg(RuntimeException e) {
        JOptionPane.showMessageDialog(rootPane, e, "WARNING", 1);
        calculatorTextField.setText(e.getMessage());
    }

    @Override
    public void displayErrorMsg(Exception e) {
        JOptionPane.showMessageDialog(rootPane, e, "ERROR", 0);
        calculatorTextField.setText(e.getMessage());
    }
    
    
}
