package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Mano implements Iterator<Carta> {

    private Mazzo m;
    private int cont = 0;
    public ArrayList<Carta> mano = new ArrayList<Carta>();

    public Mano(Mazzo m) {
        this.m = m;
        distribuisci();
    }
    public void distribuisci() {
        for (int i = 0; i < 7; i++)
            mano.add(m.pesca());
    }

    @Override
    public boolean hasNext() {
        if (cont < mano.size())
            return true;
        return false;
    }

    @Override
    public Carta next() {
        return mano.get(cont++);
    }

    public String toString() {
        String st = "";
        for (int i = 0; i < mano.size(); i++)
            st += this.mano.get(i) + "\n";
        return st;
    }
}
