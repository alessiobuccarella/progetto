package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Questa classe crea una mano di 7 carte;
 * 
 * ogni giocatore inizia con 7 carte in mano
 *
 */

public class Mano implements Iterator<Carta> {

    /**
     * istanza della classe mazzo
     */
    private Mazzo m;
    /**
     * contatore intero per i metodi next() e hasNext()
     */
    private int cont = 0;
    /**
     * Array di carte
     */
    public ArrayList<Carta> mano = new ArrayList<Carta>();

    /**
     * @param m
     * costruttore che chiede in input un'istanza di mazzo
     */
    public Mano(Mazzo m) {
        this.m = m;
        distribuisci();
    }
    /**
     * metodo che pesca 7 carte dal mazzo e distribuisce la mano iniziale al giocatore
     */
    public void distribuisci() {
        for (int i = 0; i < 7; i++)
            mano.add(m.pesca());
    }

    /**
     *metodo per capire se ci sono altre carte in mano
     */
    @Override
    public boolean hasNext() {
        if (cont < mano.size())
            return true;
        return false;
    }

    /**
     *metodo che restituisce la prossima carta in mano
     */
    @Override
    public Carta next() {
        return mano.get(cont++);
    }

    /**
     *metodo che stampa la mano di carte del giocatore
     */
    public String toString() {
        String st = "";
        for (int i = 0; i < mano.size(); i++)
            st += this.mano.get(i) + "\n";
        return st;
    }
}
