package view2;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PostazionePanel extends JPanel {

    public PostazionePanel(int layout) {
        if (layout==0) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
        else {
            setLayout(new FlowLayout());
        }
    }
}
