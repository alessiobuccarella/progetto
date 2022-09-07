package view2;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import model.Carta;

public class DisegnaCarta {

    public static JButton disegnaCarta(Carta carta) {
        String filename = "./src/immagini/" + carta.getV() + carta.getC() + ".png";
        ImageIcon img = new ImageIcon(filename);
        JButton button = new JButton(img);
        button.setBorder(null);
        return button;
    }
}
