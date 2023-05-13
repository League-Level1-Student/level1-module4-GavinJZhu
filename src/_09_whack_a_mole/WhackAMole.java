package _09_whack_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    Random ran = new Random();

    JButton mole = new JButton();
    int molesWhacked = 0;
    public void run() {

        frame.add(panel);
        frame.setVisible(true);

        frame.setSize(250, 325);
        drawButtons(ran.nextInt(24));
    if (molesWhacked == 10){
        endGame(, 10);
    }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mole)){
        mole.setText("Mole!");
        molesWhacked = molesWhacked+1;
        drawButtons(ran.nextInt(24));

    }
        else{
            speak("That isn't exactly the mole!");
        }
    }

    public void drawButtons(int moleNumber) {
        for (int j = 0; j < 23; j++) {

            if (j == moleNumber) {
                panel.add(mole);
                mole.addActionListener(this);
            } else {
                JButton blank = new JButton();
                panel.add(blank);
                blank.addActionListener(this);
            }
        }

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
