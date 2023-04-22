package _05_fortune_teller;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import game_tools.Sound;

public class FortuneTeller extends JPanel implements Runnable, MouseListener {

    JFrame frame = new JFrame();

    int frameWidth = 500;
    int frameHeight = 500;

    FortuneTeller() throws Exception {
        // 1. Choose an image for your fortune teller and put it in your default package
        fortuneTellerImage = ImageIO.read(getClass().getResource("fortune teller.png"));

        // 2. Adjust the frameWidth and frameHeight variables to fit your image nicely (doesn’t need a new line of code)

        // 3. Complete the begin() method in the FortuneTellerRunner class

        // 4. add a mouse listener to the frame
        frame.addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        // 5. Print the mouseX variable
        System.out.println(mouseX + mouseY);
        // 6. Add the mouseY variable to the previous line so that it prints out too (no new line)

        // 7. Adjust your secret location co-ordinates here:
        int secretLocationX = 69;
        int secretLocationY = 420;

        // If the mouse co-ordinates and secret location are close, we'll let them ask a question.
        if (areClose(mouseX, secretLocationX) && areClose(mouseY, secretLocationY)) {
            // 8. Find a spooky sound and put it in your _05_fortune_teller package (freesound.org)
            //    play("creepy-noise.wav");

            // 9. Play the sound
            play("spookysound.mp3");
            // 10. Insert your completed Magic 8 ball code here
            // 2. Make a variable that will hold a random number and put a random number into this variable using "new Random().nextInt(4)"
            int random = new Random().nextInt(4);
            // 3. Print out this variable
            System.out.println(random);
            // 4. Get the user to enter a question for the 8 ball
            JOptionPane.showInputDialog(null, "Enter in a yes or no question.");
            // 5. If the random number is 0
            if (random == 0) {
                // -- tell the user "Yes"
                JOptionPane.showMessageDialog(null, "Yes.");
            }
            // 6. If the random number is 1
            else if (random == 1) {
                // -- tell the user "No"
                JOptionPane.showMessageDialog(null, "no");
            }
            // 7. If the random number is 2
            else if (random == 2) {
                // -- tell the user "Maybe you should ask Google?"
                JOptionPane.showMessageDialog(null, "Maybe you should ask Google?");
            }
            // 8. If the random number is 3
            else if (random == 3) {
                // -- write your own answer
                JOptionPane.showMessageDialog(null, "Do a coin flip, heads being yes.");
            }

        }
    }


    private boolean areClose(int mouseX, int secretLocationX) {
        return mouseX < secretLocationX + 15 && mouseX > secretLocationX - 15;
    }

    private void pause(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**************** don't worry about the stuff under here *******************/

    BufferedImage fortuneTellerImage;

    @Override
    public void run() {
        frame.add(this);
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static synchronized void play(final String fileName) {
        Sound sound = new Sound("_05_fortune_teller/" + fileName);
        sound.play();
    }

    private void showAnotherImage(String imageName) {
        try {
            fortuneTellerImage = ImageIO.read(getClass().getResource(imageName));
        } catch (Exception e) {
            System.err.println("Couldn't find this image: " + imageName);
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(fortuneTellerImage, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}




