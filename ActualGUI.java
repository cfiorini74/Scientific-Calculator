package RealCalculator;

import javax.swing.*;

import java.math.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

//Class to set up GUI for the calculator
public class ActualGUI extends JFrame {
  JTextField textfield1 = new JTextField("                            ");
  JButton button1 = new JButton("1");
  JButton button2 = new JButton("2");
  JButton button3 = new JButton("3");
  JButton button4 = new JButton("4");
  JButton button5 = new JButton("5");
  JButton button6 = new JButton("6");
  JButton button7 = new JButton("7");
  JButton button8 = new JButton("8");
  JButton button9 = new JButton("9");
  JButton button0 = new JButton("0");
  JButton buttonSin=new JButton("sin");
  JButton buttonCos=new JButton("cos");
  JButton buttonTan=new JButton("tan");
  JButton buttonPoint=new JButton(".");
  
  JButton addition = new JButton("+");
  JButton subtract = new JButton("-");
  JButton multi = new JButton("x");
  JButton divide = new JButton("%");
  JButton square= new JButton("x^2");
  
  JButton calculate = new JButton("Calculate!");
  JButton erase = new JButton("C");
  public static boolean textUsed=false;
  public static void main(String[] args) {
    new ActualGUI();
  }

  public ActualGUI() {
    this.setSize(350, 500);
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension dim = tk.getScreenSize();
    int xPos = dim.width / 2 - this.getWidth() / 2;
    int yPos = dim.height / 2 - this.getHeight() / 2;
    this.setLocation(xPos, yPos);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Calculator");

    JPanel pane = new JPanel();
    GridBagLayout g = new GridBagLayout();
    pane.setLayout(g);
    GridBagConstraints gbc = new GridBagConstraints();

    NumbListen listen = new NumbListen();
    gbc.gridx = 0;
    gbc.gridy = 1;
    pane.add(button1, gbc);
    button1.addActionListener(listen);

    gbc.gridx = 1;
    gbc.gridy = 1;
    pane.add(button2, gbc);
    button2.addActionListener(listen);

    gbc.gridx = 2;
    gbc.gridy = 1;
    pane.add(button3, gbc);
    button3.addActionListener(listen);

    gbc.gridx = 0;
    gbc.gridy = 2;
    pane.add(button4, gbc);
    button4.addActionListener(listen);

    gbc.gridx = 1;
    gbc.gridy = 2;
    pane.add(button5, gbc);
    button5.addActionListener(listen);

    gbc.gridx = 2;
    gbc.gridy = 2;
    pane.add(button6, gbc);
    button6.addActionListener(listen);

    gbc.gridx = 0;
    gbc.gridy = 3;
    pane.add(button7, gbc);
    button7.addActionListener(listen);

    gbc.gridx = 1;
    gbc.gridy = 3;
    pane.add(button8, gbc);
    button8.addActionListener(listen);

    gbc.gridx = 2;
    gbc.gridy = 3;
    pane.add(button9, gbc);
    button9.addActionListener(listen);

    gbc.gridx = 1;
    gbc.gridy = 4;
    pane.add(button0, gbc);
    button0.addActionListener(listen);

    gbc.gridx = 0;
    gbc.gridy = 5;
    pane.add(calculate, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    pane.add(textfield1, gbc);
    gbc.gridx = 7;
    gbc.gridy = 0;
    pane.add(addition, gbc);
    gbc.gridx = 8;
    gbc.gridy = 0;
    pane.add(subtract, gbc);

    gbc.gridx = 7;
    gbc.gridy = 1;
    pane.add(multi, gbc);

    gbc.gridx = 8;
    gbc.gridy = 1;
    pane.add(divide, gbc);

    gbc.gridx = 0;
    gbc.gridy = 7;
    pane.add(erase, gbc);
    
    gbc.gridx=0;
    gbc.gridy=8;
    pane.add(buttonPoint,gbc);
  
    gbc.gridx=0;
    gbc.gridy=9;
    pane.add(buttonSin,gbc);
    
    
    gbc.gridx=1;
    gbc.gridy=9;
    pane.add(buttonCos,gbc);
    
    gbc.gridx=2;
    gbc.gridy=9;
    pane.add(buttonTan,gbc);
    trig trigonometry=new trig();
    buttonSin.addActionListener(trigonometry);
    buttonCos.addActionListener(trigonometry);
    buttonTan.addActionListener(trigonometry);
    
    function func = new function();
    addition.addActionListener(func);
    subtract.addActionListener(func);
    multi.addActionListener(func);
    divide.addActionListener(func);
    
    buttonPoint.addActionListener(listen);
    calculate calc = new calculate();
    calculate.addActionListener(calc);
    
    gbc.gridx=1;
    gbc.gridy=7;
    pane.add(square,gbc);
    square.addActionListener(calc);
    
    Erase c = new Erase();
    erase.addActionListener(c);
    this.add(pane);
    TextUsed t=new TextUsed();
    textfield1.addKeyListener(t);
    this.setVisible(true);
  }
  
//Class to implement the ActionListener parent class, allowing this class to 
//create a number string in the text area 
  private class NumbListen implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == button0) {
        if (textfield1.getText().charAt(0)==0||textfield1.getText().equals("0.0")) {
          textfield1.setText("0");
        } else {
          textfield1.setText(textfield1.getText() + "0");
        }
      } else if (e.getSource() == button1) {
        textfield1.setText(textfield1.getText() + "1");
      } else if (e.getSource() == button2) {
        textfield1.setText(textfield1.getText() + "2");
      } else if (e.getSource() == button3) {
        textfield1.setText(textfield1.getText() + "3");
      } else if (e.getSource() == button4) {
        textfield1.setText(textfield1.getText() + "4");
      } else if (e.getSource() == button5) {
        textfield1.setText(textfield1.getText() + "5");
      } else if (e.getSource() == button6) {
        textfield1.setText(textfield1.getText() + "6");
      } else if (e.getSource() == button7) {
        textfield1.setText(textfield1.getText() + "7");
      } else if (e.getSource() == button8) {
        textfield1.setText(textfield1.getText() + "8");
      } else if (e.getSource() == button9) {
        textfield1.setText(textfield1.getText() + "9");
      }  else if (e.getSource()==buttonPoint) {
        if (!textfield1.getText().contains(".")) {
        textfield1.setText(textfield1.getText()+".");
        }
      }
    }
  }
  
  //Class to detect if text box has been used
  private class TextUsed implements KeyListener{


    @Override
    public void keyPressed(KeyEvent arg0) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
      textUsed=true;
      
    }
    
  }

//Implements the used of the buttons for the various operators, i.e. +, -, *
  private class function implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      double prevInput = Double.parseDouble(textfield1.getText());
      calculator.setPrev(prevInput);
      textfield1.setText("");
      int whichFunction = 0;
      textUsed=false;
      if (e.getSource() == addition) {
        whichFunction = 1;
      }
      else if (e.getSource() == subtract) {
        whichFunction = 2;
      }
      else if (e.getSource() == multi) {
        whichFunction = 3;
      }
      else if (e.getSource() == divide) {
        whichFunction = 4;
      }
      calculator.setInput(whichFunction);
      if (calculator.getCalculated()==true) {
        calculator.fUsed=true;
      }
    }
  }
//Interfaces with the calculator class. Also checks if calculate! has 
//already been used, allowing repeated presses of the calculate! button
//without pressing any of the function buttons
  private class calculate implements ActionListener {


    public void actionPerformed(ActionEvent e) {
      
      if (textUsed==true) {
        TextParser t=new TextParser(textfield1.getText());
        try { 
          String s = Double.toString(t.parse());
          textfield1.setText(s);
          calculator.fUsed=false;
        } catch (Exception e1) {
          
        }
      }
      else if (e.getSource() == calculate && calculator.getCalculated() == false) {
        double currInput = Double.parseDouble(textfield1.getText());
        calculator.setCurr(Double.parseDouble(textfield1.getText()));
        String answer = "" + calculator.setFunction();
        textfield1.setText(answer);
        calculator.setPrev(Double.parseDouble(textfield1.getText()));
        calculator.setCalculated(true);
      } else if (e.getSource() == calculate
          && calculator.getCalculated() == true && calculator.fUsed == false) {//method to repeat function when calculate is pressed repeatedly
        String answer = "" + calculator.setFunction();
        textfield1.setText(answer);
        calculator.setPrev(Double.parseDouble(textfield1.getText()));
      } else if (e.getSource() == calculate
          && calculator.getCalculated() == true && calculator.fUsed == true) {//method to conduct new function after functions are used
        calculator.setCurr(Double.parseDouble(textfield1.getText()));
        String answer = "" + calculator.setFunction();
        textfield1.setText(answer);
        calculator.setPrev(Double.parseDouble(textfield1.getText()));
        calculator.fUsed = false;
      }else if (e.getSource()==square) {
        calculator.setPrev(Double.parseDouble(textfield1.getText()));
        calculator.setPrev(calculator.getPrev()*calculator.getPrev());
        textfield1.setText(String.valueOf(calculator.getPrev()));
      }
    }

  }
//Completely resets calculator
  private class Erase implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == erase) {
        calculator.setCurr(0);
        calculator.setPrev(0);
        calculator.setCalculated(false);
        textfield1.setText("");
        calculator.setOutput(0);
        calculator.fUsed = false;
        textUsed=false;
      }
    }

  }
  

  private class trig implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource()==buttonSin) {
        System.out.println(Double.parseDouble(textfield1.getText()));
        Double d=Math.asin(Double.parseDouble(textfield1.getText()));
        System.out.println(d);
        textfield1.setText(String.valueOf((d)));
      }
      else if (e.getSource()==buttonCos) {
        textfield1.setText(String.valueOf((Math.acos(Double.parseDouble(textfield1.getText())))));
      }
      else if (e.getSource()==buttonTan) {
        Double d=Math.atan(Double.parseDouble(textfield1.getText()));
        textfield1.setText(String.valueOf((Math.atan(Double.parseDouble(textfield1.getText())))));
      }
    }
    
  }
}
