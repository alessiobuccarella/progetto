package view2;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Questa classe crea il pannello con il tavolo da gioco
 */
public class PiattoPanel extends JPanel {
    /**
     * immagine dello sfondo
     */
    private ImageIcon imgIconSfondo;

    /**
     * costruttore che costruisce il design del tavolo da gioco
     */
    public PiattoPanel() {
        imgIconSfondo = new ImageIcon(getClass().getResource("/immagini/sfondo.png"));
    	setLayout(new GridBagLayout());
     }

    /**
     * metodo che disegna i componenti
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgIconSfondo.getImage(), 0, 0, this);
    }
}
