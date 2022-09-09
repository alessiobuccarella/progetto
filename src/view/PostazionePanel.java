package view;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Questa classe crea il pannello con le postazioni di gioco nord sud est ovest
 */
public class PostazionePanel extends JPanel {

    /**
     * costruttore che costruisce il design delle postazioni di gioco
     * @param layout
     */
    public PostazionePanel(int layout) {
        if (layout==0) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
        else {
            setLayout(new FlowLayout());
        }
    }
}
