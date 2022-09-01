
import javax.swing.*;

import view2.MainFrame;

public class App {
    public static void main(String[] args) {
        // runs in AWT thread
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
