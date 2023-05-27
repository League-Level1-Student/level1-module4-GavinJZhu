package _10_slot_machine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class SlotMachine implements MouseListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel cherryLabel;
    JLabel orangeLabel;
    JLabel limeLabel;

    JButton spin = new JButton();
    Random ran = new Random();
    String cherry = "cherry.png";
    String lime = "lime.jpg";
    String orange = "orange.jpg";

    public void run() {
        cherryLabel = createLabelImage(cherry);
        limeLabel = createLabelImage(lime);
        orangeLabel = createLabelImage(orange);
        panel.add(cherryLabel);
        panel.add(limeLabel);
        panel.add(orangeLabel);
        panel.add(spin);
        frame.setVisible(true);
        frame.add(panel);

        spin.setText("Spin");

        frame.pack();
    }

    public void randomizeEachSlot(int numberOfSlots) {
        for (int i = 0; i < numberOfSlots; i++) {
            int imageNumber = ran.nextInt(3);
            if (imageNumber == 0) {
                panel.add(orangeLabel);
            } else if (imageNumber == 1) {
                panel.add(limeLabel);
            } else {
                panel.add(cherryLabel);
            }
        }
        frame.add(panel);
    }

    private JLabel createLabelImage(String fileName)  {
        URL imageURL = getClass().getResource(fileName);
        if (imageURL == null){
            System.err.println("Could not find image " + fileName);
            return new JLabel();
        }
        Icon icon = new ImageIcon(imageURL);
        JLabel imageLabel = new JLabel(icon);
        return imageLabel;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.equals(spin)) {
            randomizeEachSlot(3);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

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



