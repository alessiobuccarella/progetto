package view;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Postazione extends JPanel {
    public Postazione(int layout) {
        if (layout==0)
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        else setLayout(new FlowLayout());
    }
}


