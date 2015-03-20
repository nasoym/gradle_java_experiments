package something;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingExample extends JFrame {

    public SwingExample() {
       setTitle("Simple example");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
       SwingExample ex = new SwingExample();
       ex.setVisible(true);
    }
}
