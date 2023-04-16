package _05_fortune_teller;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class FortuneTellerRunner {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new FortuneTeller());
        begin();
    }

    static void begin() {
        // Welcome the user. Give them a hint for the secret location.
    	JOptionPane.showMessageDialog(null, "hi, the secret location is very funny");
    }
}
