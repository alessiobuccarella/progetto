package view2;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CaricatoreImmagini {
	BufferedImage image;

	public BufferedImage caricaImmagine (String posizione)
	{
		try {
			image= ImageIO.read(getClass().getResource(posizione));
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return image;
	}
}
