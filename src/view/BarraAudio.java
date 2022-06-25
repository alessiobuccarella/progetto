package view;

import javax.swing.*;
import java.awt.*;

public class BarraAudio extends JPanel {
    BarraAudio() {
        setBackground(Color.black);
        JButton audioButton = new JButton("Audio");
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(audioButton);
    }
}
