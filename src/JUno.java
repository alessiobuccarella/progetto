import javax.swing.*;

import view.MainFrame;

/**
 * Questa è la classe main del progetto
 * @author Alessio e Fabio
 * 
 */
public class JUno {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
