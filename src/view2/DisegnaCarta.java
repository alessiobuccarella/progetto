package view2;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import model.Carta;

/**
 * classe che restituisce la rappresentazione grafica della carta
 */
public class DisegnaCarta {

    /**
     * metodo che disegna la carta su un JButton costruendo il percorso dell'immagine 
     * tramite i getter della cart
     * @param carta da disegnare
     * @return JButton che rappresenta graficamente la carta
     */
    public static JButton disegnaCarta(Carta carta) {
        String filename = "./src/immagini/" + carta.getV() + carta.getC() + ".png";
        ImageIcon img = new ImageIcon(filename);
        JButton button = new JButton(img);
        button.setBorder(null);
        return button;
    }
}
