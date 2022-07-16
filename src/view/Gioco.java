package view;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Gioco extends Canvas implements KeyListener{
	BufferedImage sfondo;
	private void caricaRisorse() {
		CaricatoreImmagini loader = new CaricatoreImmagini();
		sfondo = loader.caricaImmagine("/immagini/sfondo.png");
	}
	public static void main(String[]args) {
		new Gioco();
		
	
	}
	public Gioco() 
	{
		Gioco gioco = new Gioco();
		JFrame finestra_gioco = new JFrame("JUno");
		
		Dimension dimensione_finestra = new Dimension(1000,700);
		finestra_gioco.setSize(1000, 700);
		finestra_gioco.add(gioco);
		finestra_gioco.addKeyListener(gioco);
		
		finestra_gioco.pack();
		finestra_gioco.setVisible(true);
		
	}
	public void disegna() 
	{
		Graphics g = this.getGraphics();
		g.drawImage(sfondo,0,0,1000,700,this);
		g.dispose();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		disegna();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
