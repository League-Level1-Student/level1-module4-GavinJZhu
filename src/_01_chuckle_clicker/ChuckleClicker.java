package _01_chuckle_clicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChuckleClicker implements ActionListener {
    JButton button;
    JButton button2;

    public static void main(String[] args) {
        ChuckleClicker chuckleClicker = new ChuckleClicker();
        chuckleClicker.makeButtons();

    }

    public void makeButtons() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        button = new JButton();
        button2 = new JButton();
        button.setText("Joke");
        button2.setText("Punchline");
        panel.add(button);
        panel.add(button2);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        button.addActionListener(this);
        button2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicked = e.getSource();
        if (clicked == button){
            JOptionPane.showMessageDialog(null,"I recently got diagnosed with colorblindness.");
        }
        if (clicked == button2){
            JOptionPane.showMessageDialog(null,"The diagnosis came completely out of the purple.");
        }
    }
}
