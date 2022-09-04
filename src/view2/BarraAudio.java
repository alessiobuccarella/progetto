package view2;

import javax.swing.*;
import java.awt.*;

public class BarraAudio extends JPanel {
    public BarraAudio() {
        setBackground(Color.black);
        JButton audioButton = new JButton("Audio");
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(audioButton);
    }
}
