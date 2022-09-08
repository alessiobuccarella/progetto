package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Mazzo implements Iterator<Carta> {

    private int cont = 0;
    public static ArrayList<Carta> mazzo = new ArrayList<Carta>();

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

    public void scambia(int i, int j) {
        Carta x;
        x = mazzo.get(i);
        mazzo.set(i, mazzo.get(j));
        mazzo.set(j, x);
    }

    public void mescola() {
        for (int i = mazzo.size() - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i));
            this.scambia(i, j);
        }
    }

    public String toString() {
        String st = "";
        for (int i = 0; i < mazzo.size(); i++)
            st += this.mazzo.get(i) + "\n";
        return st;
    }

    @Override
    public boolean hasNext() {
        if (cont < mazzo.size())
            return true;
        return false;
    }

    @Override
    public Carta next() {
        return mazzo.get(cont++);
    }

    public Carta pesca() {
        Carta cartaPescata = mazzo.get(mazzo.size() - 1);
        mazzo.remove(mazzo.size() - 1);
        return cartaPescata;
    }
}