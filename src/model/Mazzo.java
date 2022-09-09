package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * classe per la creazione del mazzo di carte
 */
public class Mazzo implements Iterator<Carta> {

    /**
     * contatore per i metodi next e hasNext
     */
    private int cont = 0;
    /**
     * inizializzazione del mazzo tramite un array di carte
     */
    public static ArrayList<Carta> mazzo = new ArrayList<Carta>();

    /**
     * costruttore che crea il mazzo di carte
     */
    public Mazzo() {
        int c = 0;
        int v = 0;
        for (c = 0; c <= 3; c++) {
            for (v = 1; v <= 12; v++) {
                mazzo.add(new Carta(v, c));
                mazzo.add(new Carta(v, c));
                mazzo.add(new Carta(v, c));
                mazzo.add(new Carta(v, c));
            }
        }
        c = 0;
        v = 0;
        for (c = 0; c <= 1; c++) {
            mazzo.add(new Carta(v, c));
            mazzo.add(new Carta(v, c));
        }
        c = 4;
        for ( v=13; v<=14;v++) {
       		mazzo.add(new Carta(v,c));
            mazzo.add(new Carta(v,c));
            mazzo.add(new Carta(v,c));
            mazzo.add(new Carta(v,c));
            mazzo.add(new Carta(v,c));
            mazzo.add(new Carta(v,c));
            mazzo.add(new Carta(v,c));
            mazzo.add(new Carta(v,c));
        }
       	mescola();
    }

    /**
     * scambia due carte, metodo usato nel metodo mescola
     * @param i prima carta
     * @param j seconda carta
     */
    public void scambia(int i, int j) {
        Carta x;
        x = mazzo.get(i);
        mazzo.set(i, mazzo.get(j));
        mazzo.set(j, x);
    }

    /**
     * metodo che scambia ripetutamente due carte a caso nel mazzo mescolandolo
     */
    public void mescola() {
        for (int i = mazzo.size() - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i));
            this.scambia(i, j);
        }
    }

    /**
     *metodo che stampa le carte del mazzo sottoforma di stringa
     */
    public String toString() {
        String st = "";
        for (int i = 0; i < mazzo.size(); i++)
            st += this.mazzo.get(i) + "\n";
        return st;
    }

    /**
     * metodo della classe Java Scanner che restituisce true se questo scanner ha un altro token nel suo input
     * @return
     */
    @Override
    public boolean hasNext() {
        if (cont < mazzo.size())
            return true;
        return false;
    }

    /**
     * metodo della classe Java Scanner che trova e restituisce il prossimo token completo dallo scanner in uso.
     * @return
     */
    @Override
    public Carta next() {
        return mazzo.get(cont++);
    }

    /**
     * metodo per pescare una carta dal mazzo
     * @return la carta pescata
     */
    public Carta pesca() {
        Carta cartaPescata = mazzo.get(mazzo.size() - 1);
        mazzo.remove(mazzo.size() - 1);
        return cartaPescata;
    }
}