import javax.swing.*;

import view2.MainFrame;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
