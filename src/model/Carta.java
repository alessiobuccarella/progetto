package model;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Carta extends Thread {
	private int valore;
	private int colore;
	private int speciale;
	private boolean isSpecial;
	public static final String[] V={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "salta", "cambioGiro", "+2","+4","cambioColore"};
	public static final String[] C={"rosso","giallo","blu","verde","speciale"};
	public static final String[] S= {"+4","cambioColore"};
	private int x;
	private int y;
	private int altezza;
	private int larghezza;

	String path;
	BufferedImage dorso;
	BufferedImage faccia;
	public Carta(int v, int c) 
		{
		
		 this.valore = v;
		 this.colore = c;
		 this.isSpecial= false;
		 this.path="./src/immagini/"+v+c+".png"; 
		}
	public Carta(int s) 
		{
		 this.speciale = s;
		 this.isSpecial= true;
		 this.path="./src/immagini/"+s+".png";
		}
	public void setC(int colore)
	{this.colore=colore;}
	public int getV(){return valore;}
	public int getC(){return colore;}
	public int getS(){return speciale;}
	public String getPath() {return path;}
	public String toString() 
		{
		 String st="";
		 if (isSpecial==false)
		 	{st = V[this.valore] + " " + C[this.colore];}	
		 else
		     st = S[this.speciale]+"";
		 return st; 
		}
	public void run()
	{aggiorna();}
	private void aggiorna() {
		
	}
	public void disegna(Graphics g)
	{g.drawImage(dorso, x,y,larghezza,altezza,null);}
}