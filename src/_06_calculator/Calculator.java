package _06_calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator implements ActionListener{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextField number1 = new JTextField(7);
    JTextField number2 = new JTextField(7);
    JButton add = new JButton();
    JButton sub = new JButton();
    JButton mul = new JButton();
    JButton div = new JButton();
    
    JLabel label = new JLabel();
    public void run(){
    add.setText("add");
    sub.setText("sub");
    mul.setText("mul");
    div.setText("div");
    label.setText("0000");
    panel.add(label);
    panel.add(add);
    panel.add(sub);
    panel.add(mul);
    panel.add(div);
    panel.add(number1);
    panel.add(number2);
    frame.add(panel);
    frame.setVisible(true);
    add.addActionListener(this);
    sub.addActionListener(this);
    mul.addActionListener(this);
    div.addActionListener(this);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
   panel.setPreferredSize(new Dimension(650, 35));
    frame.add(panel);
    frame.pack();
    }
    public int addition(int n1, int n2){
    	return n1+n2;
    }
    public int multiply(int n1, int n2){
    	return n1*n2;
    }
    public int subtract(int n1, int n2){
return n1-n2;
    }
    public int divide(int n1, int n2){
return n1/n2;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(add)) {
			
			label.setText(String.valueOf(addition(Integer.parseInt(number1.getText()), Integer.parseInt(number2.getText()))));
		}
		else if (e.getSource().equals(mul)) {
			
			label.setText(String.valueOf(multiply(Integer.parseInt(number1.getText()), Integer.parseInt(number2.getText()))));
		}
		else if (e.getSource().equals(sub)) {
			
			label.setText(String.valueOf(subtract(Integer.parseInt(number1.getText()), Integer.parseInt(number2.getText()))));
		}
		else if (e.getSource().equals(div)) {
			
			label.setText(String.valueOf(divide(Integer.parseInt(number1.getText()), Integer.parseInt(number2.getText()))));
		}
	}
}
