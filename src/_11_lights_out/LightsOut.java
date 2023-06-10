package _11_lights_out;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.*;

/**
 * Lights Out is a puzzle game with a grid of lights that are either on (light
 * gray) or off (white). Pressing any light will toggle it and its adjacent
 * lights. The goal of the game is to switch all the lights off.
 * <p>
 * Follow the instructions below to create your own version of Lights Out
 */
public class LightsOut implements MouseListener {

    JPanel gamePanel = new JPanel();
    JFrame gameFrame = new JFrame();

    public LightsOut() {

        /** PART 1. CREATE YOUR LIGHT BOARD **/
        //1. Make your gamePanel a 5x5 grid with setLayout(new GridLayout(5, 5));
        gamePanel.setLayout(new GridLayout(5, 5));

        //2. Add 25 JLabels to your gamePanel (these are your lights)
        createLights();
        //3. Use setText() to add a position number to each light (0-24).

        //4. Set the background of each light to LIGHT_GRAY
        // - you will also have to set the background to opaque.
        // - Use light.setOpaque(true);

        //5. Add a mouseListener to each light


        //6. Add your panel to a frame
        gameFrame.add(gamePanel);
        //7. Set the size of the frame
        gameFrame.setSize(500, 500);
        gameFrame.setVisible(true);
        randomizeBoard();

    }

    private void createLights() {
        for (int i = 0; i < 25; i++) {
            JLabel light = new JLabel();
            gamePanel.add(light);
            light.setText(String.valueOf(i)); //setting number position
            light.setBackground(Color.LIGHT_GRAY);
            light.setOpaque(true);
            light.addMouseListener(this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        /** PART 2: TOGGLE NEIGHBORING LIGHTS **/
        // 1. Get the light that was clicked on `(JLabel) e.getSource`
        JLabel light = (JLabel) e.getSource();
        // 2. Get the number (position) of the light
        String lightNumber = light.getText();
        // 3. Now use the makeMove method to code which lights turn on and off.
        makeMove(Integer.parseInt(lightNumber));
        // 4.Check if the player has won (e.g. all the lights are off)
        // ---- HINT: use `getLightAtPosition` to get the light at each position
        // ---------- use 'getBackground' to get the light color
        if (isGameOver()){
            JOptionPane.showMessageDialog(null,"You win!");
        }
        /** PART 3: RANDOMIZE YOUR BOARD **/
        // Now that your game works can you make the game start with some lights on?
    }

    private void randomizeBoard() {
        Random ran = new Random();
        for (int positionOfLight=0; positionOfLight<25; positionOfLight++){
            //randomize each light
            int oneOrTwo = ran.nextInt(2);
            if (oneOrTwo == 1){
                turnOffLight(positionOfLight);
            } else {
                turnOnLight(positionOfLight);
            }
        }
    }
    private void turnOnLight(int lightPosition){
        JLabel light = getLightAtPosition(lightPosition);
        light.setBackground(Color.WHITE);
    }
    private void turnOffLight(int lightPosition){
        JLabel light = getLightAtPosition(lightPosition);
        light.setBackground(Color.LIGHT_GRAY);
    }
    boolean isGameOver() {
        // 4.Check if the player has won (e.g. all the lights are off)
        // ---- HINT: use `getLightAtPosition` to get the light at each position
        // ---------- use 'getBackground' to get the light color
        boolean gameOver = false;
        for (int j = 0; j < 25; j++) {
            JLabel light = getLightAtPosition(j);
            Color background = light.getBackground();
            if (isLightOff(background)){
                //light is off, check next light
                //do nothing, jump back to for-loop
            }
            else{
                //light is on
                //no need to keep checking
                return false;
            }
        }
        //true means game is over, because for loop ended
        return true;
    }

    private boolean isLightOff(Color background) {
        boolean off = false;
        if (background.equals(Color.LIGHT_GRAY)){
            off = true;
        }
        return off;
    }

    void makeMove(int pos) {
        toggle((JLabel) gamePanel.getComponent(pos));
        if (pos >= 5) {
            toggle((JLabel) gamePanel.getComponent(pos - 5));
        }
        if ((pos + 1) % 5 != 0) {
            toggle((JLabel) gamePanel.getComponent(pos + 1));
        }
        if (pos % 5 != 0) {
            toggle((JLabel) gamePanel.getComponent(pos - 1));
        }
        if (pos + 5 <= 24) {
            toggle((JLabel) gamePanel.getComponent(pos + 5));
        }
    }

    JLabel getLightAtPosition(int lightPosition) {
        return (JLabel) gamePanel.getComponent(lightPosition);
    }

    void toggle(JLabel label) {
        if (label.getBackground() == Color.WHITE) {
            label.setBackground(Color.LIGHT_GRAY);

        } else {
            label.setBackground(Color.WHITE);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }
}
