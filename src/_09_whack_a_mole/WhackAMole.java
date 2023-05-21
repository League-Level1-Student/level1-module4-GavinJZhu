package _09_whack_a_mole;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    Random ran = new Random();
    Date startTime = new Date();
    JButton mole = new JButton();
    int molesWhacked = 0;
    public void run() {

        
        frame.setVisible(true);

        frame.setSize(250, 325);
        drawButtons(ran.nextInt(24));

        mole.addActionListener(this);

        mole.setText("Mole!");
        frame.add(panel);
        
    if (molesWhacked == 10){
        
    }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mole)){
        molesWhacked = molesWhacked+1;
        drawButtons(ran.nextInt(24));
        System.out.println("mole clicked!");
         
    }
       
        if (molesWhacked == 10) {
        	endGame(startTime, 10);
		}  
        else{
            //speak("That isn't exactly the mole!");
        }
    }

    public void drawButtons(int moleNumber) {
    	System.out.println(moleNumber);
    	frame.remove(panel);
    	panel = new JPanel();
        for (int j = 0; j < 24; j++) {

            if (j == moleNumber) {
                panel.add(mole);
            } 
            else {
                JButton blank = new JButton();
                panel.add(blank);
                blank.addActionListener(this);
            }
        }
        panel.setPreferredSize(new Dimension(250, 315));
        frame.add(panel);
        frame.pack();
    }

    static void speak(String words) {
        if (System.getProperty("os.name").contains("Windows")) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec(cmd).waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec("say " + words).waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    private void endGame(Date timeAtStart, int molesWhacked) {
        Date timeAtEnd = new Date();
        JOptionPane.showMessageDialog(null, "Your whack rate is "
                + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
                + " moles per second.");
    }
}
