package _06_calculator;

import javax.swing.*;

public class Calculator {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton add = new JButton();
    JButton sub = new JButton();
    JButton mul = new JButton();
    JButton div = new JButton();

    public void run(){
    add.setText("add");
    sub.setText("sub");
    mul.setText("mul");
    div.setText("div");
    panel.add(add);
    panel.add(sub);
    panel.add(mul);
    panel.add(div);
    frame.add(panel);
    frame.setVisible(true);

    }
    public void add(){

    }
    public void multiply(){

    }
    public void subtract(){

    }
    public void divide(){

    }
}
