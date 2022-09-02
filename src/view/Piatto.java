package view;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Piatto extends JPanel {
    private static final long serialVersionUID = 1L;

    private ImageIcon imgIconSfondo;
    public Piatto() {
    	 imgIconSfondo = new ImageIcon(getClass().getResource("/immagini/sfondo.png"));
        //setLayout(null);

    	setLayout(new GridBagLayout());
     }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgIconSfondo.getImage(), 0, 0, this);
    }
}
