import javax.swing.*;

import view2.MainFrame;

/**
 * Questa è la classe main del progetto
 * @author Alessio e Fabio
 * 
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
