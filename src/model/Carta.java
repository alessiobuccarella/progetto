package model;

import java.awt.image.BufferedImage;

public class Carta extends Thread {

    private int valore;
    private int colore;
    private int speciale;
    private boolean isSpecial;
    public final String[] V = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "salta", "cambioGiro", "+2", "cambioColore", "+4"};
    public final String[] C = {"rosso", "giallo", "blu", "verde", "speciale"};
    public final String[] S = {"cambioColore", "+4"};
    String path;
    BufferedImage dorso;
    public Carta(int v, int c) {
        this.valore = v;
        this.colore = c;
        this.isSpecial = false;
        this.path = "./src/immagini/" + v + c + ".png";
    }
    public Carta(int s) {
        this.speciale = s;
        this.isSpecial = true;
        this.path = "./src/immagini/" + s + ".png";
    }
    public void setC(int colore) {
        this.colore = colore;
    }
    public int getV() {
        return valore;
    }
    public int getC() {
        return colore;
    }

    public int getS() {
        return speciale;
    }
    public String getPath() {
        return path;
    }
    public String toString() {
        String st = "";
        if (isSpecial == false) {
            st = V[this.valore] + " " + C[this.colore];
        } else
            st = S[this.speciale] + "";
        return st;
    }
}