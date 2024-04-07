package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    double num1 = 0, num2 = 0, result = 0;
    int calculation;
    JFrame screen = new JFrame("A Fucking Calculator");
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JRadioButton onRadioButton = new JRadioButton("ON");
    JRadioButton offRadioButton = new JRadioButton("OFF");
    JButton  buttonZero = new JButton("0");
    JButton  buttonOne = new JButton("1");
    JButton  buttonTwo = new JButton("2");
    JButton  buttonThree = new JButton("3");
    JButton  buttonFour = new JButton("4");
    JButton  buttonFive = new JButton("5");
    JButton  buttonSix = new JButton("6");
    JButton  buttonSeven = new JButton("7");
    JButton  buttonEight = new JButton("8");
    JButton  buttonNine = new JButton("9");
    JButton  buttonPlus = new JButton("+");
    JButton  buttonMinus = new JButton("-");
    JButton  buttonDivide = new JButton("÷");
    JButton  buttonMultiply = new JButton("×");
    JButton  buttonSquare = new JButton("x\u00b2");
    JButton  buttonSquareRoot = new JButton("x\u221A");
    JButton  buttonReciprocal = new JButton("1/x");
    JButton  buttonDot= new JButton(".");
    JButton  buttonClear= new JButton("C");
    JButton  buttonDel = new JButton("DEL");
    JButton  buttonEquals = new JButton("=");
    public Calculator(){
        initializeGUI();
        addComponents();
        addActionEvent();

    }
    public void initializeGUI(){
        screen.setSize(300,500);
        screen.getContentPane().setBackground(Color.black); // Set background color to black directly on the content pane
        screen.setLayout(null);
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponents(){
        label.setBounds(240,0,50,50);
        label.setForeground(Color.white);
        screen.add(label);

        textField.setBounds(10,40,270,40);
        textField.setFont(new Font("Arial",Font.BOLD,20));
        textField.setEditable(false);
        textField.setFocusable(false); // Remove focusable property
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        screen.add(textField);

        onRadioButton.setBounds(10,95,60,40);
        onRadioButton.setSelected(true);
        onRadioButton.setFont(new Font("Arial",Font.BOLD,14));
        onRadioButton.setBackground(Color.black);
        onRadioButton.setForeground(Color.white);
        onRadioButton.setFocusable(false);
        screen.add(onRadioButton);

        offRadioButton.setBounds(10,120,60,40);
        offRadioButton.setSelected(false);
        offRadioButton.setFont(new Font("Arial",Font.BOLD,14));
        offRadioButton.setBackground(Color.black);
        offRadioButton.setForeground(Color.white);
        offRadioButton.setFocusable(false);
        screen.add(offRadioButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(onRadioButton);
        buttonGroup.add(offRadioButton);

        buttonSeven.setBounds(10,230,60,40);
        buttonSeven.setFont(new Font("Arial",Font.BOLD,20));
        buttonSeven.setFocusable(false);
        screen.add(buttonSeven);

        buttonEight.setBounds(80,230,60,40);
        buttonEight.setFont(new Font("Arial",Font.BOLD,20));
        buttonEight.setFocusable(false);
        screen.add(buttonEight);

        buttonNine.setBounds(150,230,60,40);
        buttonNine.setFont(new Font("Arial",Font.BOLD,20));
        buttonNine.setFocusable(false);
        screen.add(buttonNine);

        buttonFour.setBounds(10,290,60,40);
        buttonFour.setFont(new Font("Arial",Font.BOLD,20));
        buttonFour.setFocusable(false);
        screen.add(buttonFour);

        buttonFive.setBounds(80,290,60,40);
        buttonFive.setFont(new Font("Arial",Font.BOLD,20));
        buttonFive.setFocusable(false);
        screen.add(buttonFive);

        buttonSix.setBounds(150,290,60,40);
        buttonSix.setFont(new Font("Arial",Font.BOLD,20));
        buttonSix.setFocusable(false);
        screen.add(buttonSix);

        buttonOne.setBounds(10,350,60,40);
        buttonOne.setFont(new Font("Arial",Font.BOLD,20));
        buttonOne.setFocusable(false);
        screen.add(buttonOne);

        buttonTwo.setBounds(80,350,60,40);
        buttonTwo.setFont(new Font("Arial",Font.BOLD,20));
        buttonTwo.setFocusable(false);
        screen.add(buttonTwo);

        buttonThree.setBounds(150,350,60,40);
        buttonThree.setFont(new Font("Arial",Font.BOLD,20));
        buttonThree.setFocusable(false);
        screen.add(buttonThree);

        buttonDot.setBounds(150,410,60,40);
        buttonDot.setFont(new Font("Arial",Font.BOLD,20));
        buttonDot.setFocusable(false);
        screen.add(buttonDot);

        buttonZero.setBounds(10,410,130,40);
        buttonZero.setFont(new Font("Arial",Font.BOLD,20));
        buttonZero.setFocusable(false);
        screen.add(buttonZero);

        buttonEquals.setBounds(220,350,60,100);
        buttonEquals.setFont(new Font("Arial",Font.BOLD,20));
        buttonEquals.setBackground(new Color(239,188,2));
        buttonEquals.setFocusable(false);
        screen.add(buttonEquals);

        buttonDivide.setBounds(220,110,60,40);
        buttonDivide.setFont(new Font("Arial",Font.BOLD,20));
        buttonDivide.setBackground(new Color(239,188,2));
        buttonDivide.setFocusable(false);
        screen.add(buttonDivide);

        buttonSquareRoot.setBounds(10,170,60,40);
        buttonSquareRoot.setFont(new Font("Arial",Font.BOLD,20));
        buttonSquareRoot.setFocusable(false);
        screen.add(buttonSquareRoot);

        buttonMultiply.setBounds(220,230,60,40);
        buttonMultiply.setFont(new Font("Arial",Font.BOLD,20));
        buttonMultiply.setBackground(new Color(239,188,2));
        buttonMultiply.setFocusable(false);
        screen.add(buttonMultiply);

        buttonMinus.setBounds(220,170,60,40);
        buttonMinus.setFont(new Font("Arial",Font.BOLD,20));
        buttonMinus.setBackground(new Color(239,188,2));
        buttonMinus.setFocusable(false);
        screen.add(buttonMinus);

        buttonPlus.setBounds(220,290,60,40);
        buttonPlus.setFont(new Font("Arial",Font.BOLD,20));
        buttonPlus.setBackground(new Color(239,188,2));
        buttonPlus.setFocusable(false);
        screen.add(buttonPlus);

        buttonSquare.setBounds(80,170,60,40);
        buttonSquare.setFont(new Font("Arial",Font.BOLD,20));
        buttonSquare.setFocusable(false);
        screen.add(buttonSquare);

        buttonReciprocal.setBounds(150,170,60,40);
        buttonReciprocal.setFont(new Font("Arial",Font.BOLD,15));
        buttonReciprocal.setFocusable(false);
        screen.add(buttonReciprocal);

        buttonDel.setBounds(150,110,60,40);
        buttonDel.setFont(new Font("Arial",Font.BOLD,12));
        buttonDel.setBackground(Color.red);
        buttonDel.setForeground(Color.white);
        buttonDel.setFocusable(false);
        screen.add(buttonDel);

        buttonClear.setBounds(80,110,60,40);
        buttonClear.setFont(new Font("Arial",Font.BOLD,12));
        buttonClear.setBackground(Color.red);
        buttonClear.setForeground(Color.white);
        buttonClear.setFocusable(false);
        screen.add(buttonClear);

    }
    public void addActionEvent(){
        onRadioButton.addActionListener(this);
        offRadioButton.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDel.addActionListener(this);
        buttonDivide.addActionListener(this);
        buttonSquare.addActionListener(this);
        buttonSquareRoot.addActionListener(this);
        buttonReciprocal.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonSeven.addActionListener(this);
        buttonEight.addActionListener(this);
        buttonNine.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonFour.addActionListener(this);
        buttonFive.addActionListener(this);
        buttonSix.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonOne.addActionListener(this);
        buttonTwo.addActionListener(this);
        buttonThree.addActionListener(this);
        buttonEquals.addActionListener(this);
        buttonZero.addActionListener(this);
        buttonDot.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == onRadioButton) {
            enable();
        } else if (source == offRadioButton) {
            disable();
        } else if (source == buttonClear) {
            label.setText("");
            textField.setText("");
            num1 = 0;
            num2 = 0;
        } else if (source == buttonDel) {
            int length = textField.getText().length();
            int val = length - 1;
            if (length > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(val);
                textField.setText(back.toString());
            }
            if (textField.getText().endsWith("")) {
                label.setText("");
            }
        } else if (source == buttonZero) {
            if (textField.getText().equals("0")) {
                return;
            } else {
                textField.setText(textField.getText() + "0");
            }
        } else if (source == buttonOne) {
            textField.setText(textField.getText() + "1");
        } else if (source == buttonTwo) {
            textField.setText(textField.getText() + "2");
        } else if (source == buttonThree) {
            textField.setText(textField.getText() + "3");
        } else if (source == buttonFour) {
            textField.setText(textField.getText() + "4");
        } else if (source == buttonFive) {
            textField.setText(textField.getText() + "5");
        } else if (source == buttonSix) {
            textField.setText(textField.getText() + "6");
        } else if (source == buttonSeven) {
            textField.setText(textField.getText() + "7");
        } else if (source == buttonEight) {
            textField.setText(textField.getText() + "8");
        } else if (source == buttonNine) {
            textField.setText(textField.getText() + "9");
        } else if (source == buttonDot) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        } else if (source == buttonPlus) {
            String str = textField.getText();
            num1 = Double.parseDouble(str);
            calculation = 1;
            textField.setText("");
            label.setText(str + "+");
        } else if (source == buttonMinus) {
            String str = textField.getText();
            num1 = Double.parseDouble(str);
            calculation = 2;
            textField.setText("");
            label.setText(str + "-");
        } else if (source == buttonMultiply) {
            String str = textField.getText();
            num1 = Double.parseDouble(str);
            calculation = 3;
            textField.setText("");
            label.setText(str + "×");
        } else if (source == buttonDivide) {
            String str = textField.getText();
            num1 = Double.parseDouble(str);
            calculation = 4;
            textField.setText("");
            label.setText(str + "÷");
        } else if (source == buttonSquare) {
            num1 = Double.parseDouble(textField.getText());
            double square = Math.pow(num1, 2);
            String string = Double.toString(square);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
        } else if (source == buttonSquareRoot) {
            num1 = Double.parseDouble(textField.getText());
            double sqrt = Math.sqrt(num1);
            textField.setText(Double.toString(sqrt));
        } else if (source == buttonReciprocal) {
            num1 = Double.parseDouble(textField.getText());
            double reciprocal = 1 / num1;
            String string = Double.toString(reciprocal);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
        } else if (source == buttonEquals) {
            num2 = Double.parseDouble(textField.getText());
            switch (calculation) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    result = num1 / num2;
                    break;
                default:
                    break;
            }
            if (Double.toString(result).endsWith(".0")) {
                textField.setText(Double.toString(result).replace(".0", ""));
            } else {
                textField.setText(Double.toString(result));
            }
            label.setText("");
            System.out.println("\n"+num1+"\n"+num2+"\n"+result);
            num2 = 0;
            result = num1;
            System.out.println("\n"+num1+"\n"+num2+"\n"+result);
        }
    }

    private void enable() {
        onRadioButton.setEnabled(false);
        offRadioButton.setEnabled(true);
        textField.setEnabled(true);
        label.setEnabled(true);
        onRadioButton.setEnabled(true);
        offRadioButton.setEnabled(true);
        buttonClear.setEnabled(true);
        buttonDel.setEnabled(true);
        buttonDivide.setEnabled(true);
        buttonSquare.setEnabled(true);
        buttonSquareRoot.setEnabled(true);
        buttonReciprocal.setEnabled(true);
        buttonMinus.setEnabled(true);
        buttonSeven.setEnabled(true);
        buttonEight.setEnabled(true);
        buttonNine.setEnabled(true);
        buttonMultiply.setEnabled(true);
        buttonFour.setEnabled(true);
        buttonFive.setEnabled(true);
        buttonSix.setEnabled(true);
        buttonPlus.setEnabled(true);
        buttonOne.setEnabled(true);
        buttonTwo.setEnabled(true);
        buttonThree.setEnabled(true);
        buttonEquals.setEnabled(true);
        buttonZero.setEnabled(true);
        buttonDot.setEnabled(true);


    }
    private void disable() {
        onRadioButton.setEnabled(true);
        offRadioButton.setEnabled(false);
        textField.setEnabled(false);
        label.setEnabled(false);
        label.setText("");
        textField.setText("");
        onRadioButton.setEnabled(false);
        offRadioButton.setEnabled(false);
        buttonClear.setEnabled(false);
        buttonDel.setEnabled(false);
        buttonDivide.setEnabled(false);
        buttonSquare.setEnabled(false);
        buttonSquareRoot.setEnabled(false);
        buttonReciprocal.setEnabled(false);
        buttonMinus.setEnabled(false);
        buttonSeven.setEnabled(false);
        buttonEight.setEnabled(false);
        buttonNine.setEnabled(false);
        buttonMultiply.setEnabled(false);
        buttonFour.setEnabled(false);
        buttonFive.setEnabled(false);
        buttonSix.setEnabled(false);
        buttonPlus.setEnabled(false);
        buttonOne.setEnabled(false);
        buttonTwo.setEnabled(false);
        buttonThree.setEnabled(false);
        buttonEquals.setEnabled(false);
        buttonZero.setEnabled(false);
        buttonDot.setEnabled(false);


    }
    public static void main(String[] args) {
        new Calculator();
    }
}
