package view2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class BarraAudio extends JPanel {
    private JButton audioButton;
    public BarraAudio() {
        setBackground(Color.black);
        audioButton = new JButton("Audio");
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(audioButton);
    }
}
