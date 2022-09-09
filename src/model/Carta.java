package model;

import java.awt.image.BufferedImage;

/**
 * classe per la creazione di una carta
 */
public class Carta extends Thread {

    /**
     * intero che rappresenta il valoe di una carta
     */
    private int valore;
    /**
     * intero che rappresenta il colore di una carta
     */
    private int colore;
    
    /**
     * intero che rappresenta il valore della carta speciale
     */
    private int speciale;
    
    /**
     * booleano per distinguere una carta speciale da una normale
     */
    private boolean isSpecial;
    /**
     * array di stringhe che rappresentano i valori delle carte
     */
    public final String[] V = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "salta", "cambioGiro", "+2", "cambioColore", "+4"};
    /**
     * array di stringhe che rappresentano i colori delle carte
     */
    public final String[] C = {"rosso", "giallo", "blu", "verde", "speciale"};
    /**
     * array di stringhe che rappresentano i valori delle carte speciali
     */
    public final String[] S = {"cambioColore", "+4"};
    /**
     * stringa che rappresenta il percorso del file dell'immagine
     */
    String path;

    /**
     * costruttore della generica carta non speciale
     * @param v valore della carta
     * @param c colore della carta
     */
    public Carta(int v, int c) {
        this.valore = v;
        this.colore = c;
        this.isSpecial = false;
        this.path = "./src/immagini/" + v + c + ".png";
    }
    /**
     * costruttore carte speciali
     * @param s intero che rappresenta il valore della carta speciale
     */
    public Carta(int s) {
        this.speciale = s;
        this.isSpecial = true;
        this.path = "./src/immagini/" + s + ".png";
    }
    /**
     * setter del colore di una carta
     * @param colore intero che rappresenta il colore di una carta
     */
    public void setC(int colore) {
        this.colore = colore;
    }
    /**
     * getter del valore di una carta
     * @return il valore della carta
     */
    public int getV() {
        return valore;
    }
    /**
     * getter del colore di una carta
     * @return il colore della carta
     */
    public int getC() {
        return colore;
    }

    /**
     * getter del valore di una carta speciale
     * @return il valore della carta
     */
    public int getS() {
        return speciale;
    }
    /**
     * getter del percorso dell'immagine della carta
     * @return il percorso dell'immagine della carta
     */
    public String getPath() {
        return path;
    }
    /**
     *stampa la carta sottoforma di stringa
     */
    public String toString() {
        String st = "";
        if (isSpecial == false) {
            st = V[this.valore] + " " + C[this.colore];
        } else
            st = S[this.speciale] + "";
        return st;
    }
}