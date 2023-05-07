package _09_whack_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class whack_a_mole implements ActionListener{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    Random ran = new Random();
	public void run() {
	   
	   frame.add(panel);
	   frame.setVisible(true);
	  
	   frame.setSize(250,325); 
	   drawButtons(ran.nextInt(24));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public void drawButtons(int i){
		for (int j = 0; j<24; j++) {
			   JButton amogus = new JButton();
			   panel.add(amogus);
			   amogus.addActionListener(this);
			   if (j == i) {
				   amogus.setText("mole!");
			   }
		   }
			
	}
}
