package _10_slot_machine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class SlotMachine implements ActionListener {
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
        spin.addActionListener(this);
        frame.add(panel);
        spin.setText("Spin");
        frame.pack();
        frame.setVisible(true);
    }

    public void randomizeEachSlot(int numberOfSlots) {
        panel.removeAll();
        for (int i = 0; i < numberOfSlots; i++) {

            int imageNumber = ran.nextInt(3);
            System.out.println(imageNumber);
            if (imageNumber == 0) {
                panel.add(createLabelImage(orange));
            } else if (imageNumber == 1) {
                panel.add(createLabelImage(lime));
            } else {
                panel.add(createLabelImage(cherry));
            }
        }
        panel.add(spin);
        frame.pack();
    }

    private JLabel createLabelImage(String fileName) {
        URL imageURL = getClass().getResource(fileName);
        if (imageURL == null) {
            System.err.println("Could not find image " + fileName);
            return new JLabel();
        }
        Icon icon = new ImageIcon(imageURL);
        JLabel imageLabel = new JLabel(icon);
        return imageLabel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(spin)) {
            randomizeEachSlot(3);
        }
    }
}



