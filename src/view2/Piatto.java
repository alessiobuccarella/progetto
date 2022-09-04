package view2;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Piatto extends JPanel {

    private static final long serialVersionUID = 1L;
    private ImageIcon imgIconSfondo;

    public Piatto() {
        imgIconSfondo = new ImageIcon(getClass().getResource("/immagini/sfondo.png"));
    	setLayout(new GridBagLayout());
     }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgIconSfondo.getImage(), 0, 0, this);
    }
}
