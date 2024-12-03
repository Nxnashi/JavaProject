package View;

public class JFrame extends javax.swing.JFrame {
    public JFrame() {
        super("Social Media Platform");
        getContentPane().setBackground(GUIconstants.background);
        setSize(900, 625);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
