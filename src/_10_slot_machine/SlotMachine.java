package _10_slot_machine;


import javax.swing.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class SlotMachine {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton spin = new JButton();
    Random ran = new Random();
    String cherry = "cherry.png";
    String lime = "lime.jpg";
    String orange = "orange.jpg";
    JLabel label;
    JLabel label2;
    JLabel label3;
    
    public void run() {
    	
    	frame.add(panel);
    	frame.setVisible(true);
    	for (int i = 0; i<3; i++) {
    		randomizeEachSlot();
    	}
    }

    public void randomizeEachSlot(){
    	try {
			label = createLabelImage(cherry);
			label2 = createLabelImage(lime);
			label3 = createLabelImage(orange);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int random = ran.nextInt(3);
    	if (random == 0) {
          panel.add(label);
        }
        else if (random == 1) {
        	panel.add(label2);
        }
        else if (random == 2){
        	panel.add(label3);
        }
    	frame.pack();
   
    }
    private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
    
}
