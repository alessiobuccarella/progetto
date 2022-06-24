package controller;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.Carta;
import model.Mano;
import model.Mazzo;
import model.Senso;
import view.Menu;
import view.Piatto;
import view.PostazioneGiocatore;
import view.PostazioneLaterale;

public class Eventi {
    public static void cliccato(Mano mano, int indiceCarta, JButton bottone, PostazioneGiocatore postazione, Piatto piatto, int turno, Mano manoOvest, Mano manoNord, Mano manoEst, PostazioneLaterale postazioneOvest, PostazioneGiocatore postazioneNord, PostazioneLaterale postazioneEst, JButton[] listaBottoni, Mazzo mazzo) {
        for (int i = 0; i < listaBottoni.length; i++) {
            if (listaBottoni[i] == null) System.out.println(1);
        }
        if (mano.mano.get(indiceCarta).getC() == Menu.cartaScarto.getC() || mano.mano.get(indiceCarta).getV() == Menu.cartaScarto.getV() || mano.mano.get(indiceCarta).getC() == 4) {
            System.out.println(postazione.getComponentZOrder(bottone));
            Menu.cartaScarto = mano.mano.get(indiceCarta);
            aggiornaPostazione(indiceCarta, listaBottoni, mano, postazione);
            piatto.remove(Menu.scartoButton);
            Menu.scartoButton = bottone;
            piatto.add(Menu.scartoButton);
            piatto.invalidate();
            piatto.validate();
            postazione.invalidate();
            postazione.validate();
            if (Menu.cartaScarto.getV() == 11)
                cambiaSenso();
            if (Menu.senso == Senso.ORARIO)
                Menu.turno = 1;
            if (Menu.senso == Senso.ANTIORARIO)
                Menu.turno = 3;
            if (Menu.cartaScarto.getV() == 10)
                Menu.turno = 2;
            if (Menu.cartaScarto.getV() == 14) {
                Menu.firstTime = true;
                if (Menu.turno == 1) {
                    for (int i = 0; i < 4; i++)
                        manoOvest.mano.add(mazzo.pesca());
                    postazioneOvest.removeAll();
                    for (Carta y : manoOvest.mano) {
                        postazioneOvest.add(new JLabel(new ImageIcon("./src/immagini/dorso90.png")));
                        postazioneOvest.add(Box.createRigidArea(new Dimension(0, 5)));
                    }
                    postazioneOvest.invalidate();
                    postazioneOvest.validate();
                } else {
                    for (int i = 0; i < 4; i++) manoEst.mano.add(mazzo.pesca());
                    postazioneEst.removeAll();
                    for (Carta y : manoEst.mano) {
                        postazioneEst.add(new JLabel(new ImageIcon("./src/immagini/dorso90s.png")));
                        postazioneEst.add(Box.createRigidArea(new Dimension(0, 5)));
                    }
                    postazioneEst.invalidate();
                    postazioneEst.validate();
                }
                piatto.add(Menu.rosso);
                piatto.add(Menu.giallo);
                piatto.add(Menu.blu);
                piatto.add(Menu.verde);
            }
            if (Menu.cartaScarto.getV() == 13) {
                Menu.firstTime = true;
                piatto.add(Menu.rosso);
                piatto.add(Menu.giallo);
                piatto.add(Menu.blu);
                piatto.add(Menu.verde);
            }
            if (Menu.cartaScarto.getV() == 12) {
                Menu.firstTime = true;
                if (Menu.turno == 1) {
                    for (int i = 0; i < 2; i++)
                        manoOvest.mano.add(mazzo.pesca());
                    postazioneOvest.removeAll();
                    for (Carta y : manoOvest.mano) {
                        postazioneOvest.add(new JLabel(new ImageIcon("./src/immagini/dorso90.png")));
                        postazioneOvest.add(Box.createRigidArea(new Dimension(0, 5)));
                    }
                    postazioneOvest.invalidate();
                    postazioneOvest.validate();
                } else {
                    for (int i = 0; i < 2; i++)
                        manoEst.mano.add(mazzo.pesca());
                    postazioneEst.removeAll();
                    for (Carta y : manoEst.mano) {
                        postazioneEst.add(new JLabel(new ImageIcon("./src/immagini/dorso90s.png")));
                        postazioneEst.add(Box.createRigidArea(new Dimension(0, 5)));
                    }
                    postazioneEst.invalidate();
                    postazioneEst.validate();
                }
            }
            piatto.invalidate();
            piatto.validate();
            postazione.invalidate();
            postazione.validate();
        } else
            System.out.println("mossa non valida: " + Menu.cartaScarto.toString() + " non  compatibile con " + mano.mano.get(indiceCarta).toString());

    }

    public static void aggiornaPostazione(int indiceCarta, JButton[] listaBottoni, Mano mano, PostazioneGiocatore postazione) {
        postazione.removeAll();
        if (indiceCarta != -1) {
            mano.mano.remove(indiceCarta);
            elimina(listaBottoni, indiceCarta);
        }
        for (int j = 0; j < mano.mano.size(); j++) {
            {
                aggiornaBottone(listaBottoni[j], DisegnaCarta.disegnaCarta(mano.mano.get(j)));
                postazione.add(listaBottoni[j]);
            }
        }
        postazione.invalidate();
        postazione.validate();
    }

    public static void elimina(JButton[] listaBottoni, int indiceCarta) {
        for (int i = 0; i < listaBottoni.length - 1; i++)
            if (i >= indiceCarta) listaBottoni[i] = listaBottoni[i + 1];

    }

    public static void avanti(int turno, Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, PostazioneLaterale postazioneOvest, PostazioneGiocatore postazioneNord, PostazioneLaterale postazioneEst, Mazzo mazzo, PostazioneGiocatore postazione, Mano mano) {
        switch (turno) {
            case 1:
                mossaOvest(mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord);
                break;
            case 2:
                mossaNord(manoOvest, manoNord, manoEst, piatto, postazioneNord, mazzo);
                break;
            case 3:
                mossaEst(manoOvest, manoNord, manoEst, piatto, postazioneEst, mazzo);
                break;
            default:
                break;
        }
    }

    public static void aggiornaBottone(JButton bottone, JButton disegno) {
        bottone = disegno;
    }

    public static void cambiaSenso() {
        if (Menu.senso == Senso.ANTIORARIO) Menu.senso = Senso.ORARIO;
        else Menu.senso = Senso.ANTIORARIO;
    }

    public static void mossaOvest(Mano mano, Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, PostazioneLaterale postazioneOvest, Mazzo mazzo, PostazioneGiocatore postazione, PostazioneGiocatore postazioneNord) {
        int celo = 0;
        Menu.pronto = false;
        System.out.println("OVEST: " + manoOvest.mano.toString());
        for (Carta x : manoOvest.mano) {
            if (x.getV() == Menu.cartaScarto.getV() || x.getC() == Menu.cartaScarto.getC() || x.getC() == 4) {
                celo++;
                Menu.pescato = 0;
                System.out.println("Ovest ha tirato " + x.toString());
                piatto.remove(Menu.scartoButton);
                Menu.scartoButton = DisegnaCarta.disegnaCarta(x);
                Menu.cartaScarto = x;
                piatto.add(Menu.scartoButton);
                manoOvest.mano.remove(x);
                postazioneOvest.removeAll();
                if (Menu.cartaScarto.getV() == 11)
                    cambiaSenso();
                if (Menu.senso == Senso.ORARIO)
                    Menu.turno = 2;
                if (Menu.cartaScarto.getV() == 10)
                    Menu.turno = 3;
                if (Menu.senso == Senso.ANTIORARIO)
                    Menu.turno = 0;
                for (Carta y : manoOvest.mano) {
                    postazioneOvest.add(new JLabel(new ImageIcon("./src/immagini/dorso90.png")));
                    postazioneOvest.add(Box.createRigidArea(new Dimension(0, 5)));
                }
                if (Menu.cartaScarto.getV() == 14) {
                    Menu.firstTime = true;
                    if (Menu.turno == 2) {
                        for (int i = 0; i < 4; i++)
                            manoNord.mano.add(mazzo.pesca());
                        postazioneNord.removeAll();
                        for (Carta y : manoEst.mano) {
                            postazioneNord.add(new JLabel(new ImageIcon("./src/immagini/dorso180.png")));
                            postazioneNord.add(Box.createRigidArea(new Dimension(0, 5)));
                        }
                        postazioneNord.invalidate();
                        postazioneNord.validate();
                    } else {
                        for (int i = 0; i < 4; i++)
                            mano.mano.add(mazzo.pesca());
                        postazione.removeAll();
                        for (int i = 0; i <= mano.mano.size() - 1; i++) {
                            postazione.add(Menu.listaBottoni[i]);
                        }
                        postazione.invalidate();
                        postazione.validate();
                    }
                    for (Carta y : manoOvest.mano) {
                        if (y.getC() != 4) {
                            Menu.cartaScarto.setC(y.getC());
                            System.out.println("colore: " + y.getC());
                        }
                    }
                }
                piatto.invalidate();
                piatto.validate();
                postazioneOvest.invalidate();
                postazioneOvest.validate();
                break;
            }
        }
        if (celo == 0 && Menu.pescato == 0) {
            manoOvest.mano.add(mazzo.pesca());
            Menu.pescato = 1;
            postazioneOvest.removeAll();
            for (Carta y : manoOvest.mano) {
                postazioneOvest.add(new JLabel(new ImageIcon("./src/immagini/dorso90.png")));
                postazioneOvest.add(Box.createRigidArea(new Dimension(0, 5)));
            }
            mossaOvest(mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord);
            postazioneOvest.invalidate();
            postazioneOvest.validate();
        }
        piatto.invalidate();
        piatto.validate();
        postazioneOvest.invalidate();
        postazioneOvest.validate();
        if (celo == 0 && Menu.pescato == 1) {
            Menu.pescato = 0;
            if (Menu.senso == Senso.ORARIO)
                Menu.turno = 2;
            if (Menu.senso == Senso.ANTIORARIO)
                Menu.turno = 0;
            System.out.println("OVEST: " + manoOvest.mano.toString());
        }
        if (celo == 1 && Menu.pescato == 1)
        {
            Menu.pescato = 0;
            if (Menu.senso == Senso.ORARIO)
                Menu.turno = 2;
            if (Menu.senso == Senso.ANTIORARIO)
                Menu.turno = 0;
            piatto.remove(Menu.scartoButton);
            Menu.scartoButton = DisegnaCarta.disegnaCarta(manoOvest.mano.get(-1));
            Menu.cartaScarto = manoOvest.mano.get(-1);
            piatto.add(Menu.scartoButton);
            manoOvest.mano.remove(-1);
            postazioneOvest.removeAll();
            for (Carta y : manoOvest.mano) {
                postazioneOvest.add(new JLabel(new ImageIcon("./src/immagini/dorso90.png")));
                postazioneOvest.add(Box.createRigidArea(new Dimension(0, 5)));}
            System.out.println("OVEST: ho tirato quella che ho pescato");
        }
    }

    private static void mossaNord(Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, PostazioneGiocatore postazioneNord, Mazzo mazzo) {
        int celo = 0;
        System.out.println("NORD: " + manoNord.mano.toString());
        Menu.pronto = false;
        for (Carta x : manoNord.mano) {
            if (x.getV() == Menu.cartaScarto.getV() || x.getC() == Menu.cartaScarto.getC()) {
                celo++;
                Menu.pescato = 0;
                System.out.println("Nord ha tirato " + x.toString());
                piatto.remove(Menu.scartoButton);
                Menu.scartoButton = DisegnaCarta.disegnaCarta(x);
                Menu.cartaScarto = x;
                piatto.add(Menu.scartoButton);
                manoNord.mano.remove(x);
                postazioneNord.removeAll();
                if (Menu.cartaScarto.getV() == 11)
                    cambiaSenso();
                if (Menu.senso == Senso.ORARIO)
                    Menu.turno = 3;
                if (Menu.senso == Senso.ANTIORARIO)
                    Menu.turno = 1;
                if (Menu.cartaScarto.getV() == 10)
                    Menu.turno = 0;
                for (Carta y : manoNord.mano) {
                    postazioneNord.add(new JLabel(new ImageIcon("./src/immagini/dorso180.png")));
                    postazioneNord.add(Box.createRigidArea(new Dimension(0, 5)));
                }
                piatto.invalidate();
                piatto.validate();
                postazioneNord.invalidate();
                postazioneNord.validate();
                break;
            }
        }
        if (celo == 0 && Menu.pescato == 0) {
            manoNord.mano.add(mazzo.pesca());
            Menu.pescato = 1;
            postazioneNord.removeAll();
            for (Carta y : manoNord.mano) {
                postazioneNord.add(new JLabel(new ImageIcon("./src/immagini/dorso180.png")));
                postazioneNord.add(Box.createRigidArea(new Dimension(0, 5)));
            }
            postazioneNord.invalidate();
            postazioneNord.validate();
        }
        piatto.invalidate();
        piatto.validate();
        postazioneNord.invalidate();
        postazioneNord.validate();
        if (celo == 0 && Menu.pescato == 1) {
            Menu.pescato = 0;
            if (Menu.senso == Senso.ORARIO)
                Menu.turno = 3;
            if (Menu.senso == Senso.ANTIORARIO)
                Menu.turno = 1;
            System.out.println("OVEST: " + manoNord.mano.toString());
        }
    }

    public static void mossaEst(Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, PostazioneLaterale postazioneEst, Mazzo mazzo) {
        int celo = 0;
        System.out.println("EST: " + manoEst.mano.toString());
        Menu.pronto = false;
        for (Carta x : manoEst.mano) {
            if (x.getV() == Menu.cartaScarto.getV() || x.getC() == Menu.cartaScarto.getC()) {
                celo++;
                Menu.pescato = 0;
                System.out.println("Est ha tirato " + x.toString());
                piatto.remove(Menu.scartoButton);
                Menu.scartoButton = DisegnaCarta.disegnaCarta(x);
                Menu.cartaScarto = x;
                piatto.add(Menu.scartoButton);
                manoEst.mano.remove(x);
                postazioneEst.removeAll();
                if (Menu.cartaScarto.getV() == 11)
                    Eventi.cambiaSenso();
                if (Menu.senso == Senso.ANTIORARIO)
                    Menu.turno = 2;
                if (Menu.senso == Senso.ORARIO)
                    Menu.turno = 0;
                if (Menu.cartaScarto.getV() == 10)
                    Menu.turno = 1;
                for (Carta y : manoEst.mano) {
                    postazioneEst.add(new JLabel(new ImageIcon("./src/immagini/dorso90s.png")));
                    postazioneEst.add(Box.createRigidArea(new Dimension(0, 5)));
                }
                piatto.invalidate();
                piatto.validate();
                postazioneEst.invalidate();
                postazioneEst.validate();
                break;
            }
        }
        if (celo == 0 && Menu.pescato == 0) {
            manoEst.mano.add(mazzo.pesca());
            Menu.pescato = 1;
            postazioneEst.removeAll();
            for (Carta y : manoEst.mano) {
                postazioneEst.add(new JLabel(new ImageIcon("./src/immagini/dorso90s.png")));
                postazioneEst.add(Box.createRigidArea(new Dimension(0, 5)));
            }
            postazioneEst.invalidate();
            postazioneEst.validate();
        }
        piatto.invalidate();
        piatto.validate();
        postazioneEst.invalidate();
        postazioneEst.validate();
        if (celo == 0 && Menu.pescato == 1) {
            Menu.pescato = 0;
            if (Menu.senso == Senso.ORARIO)
                Menu.turno = 0;
            if (Menu.senso == Senso.ANTIORARIO)
                Menu.turno = 2;
            System.out.println("EST: " + manoEst.mano.toString());
        }
    }

    public static void passo(Mano mano, int i, JButton posto0, PostazioneGiocatore postazione, Piatto piatto, int turno, Mano manoOvest, Mano manoNord, Mano manoEst, PostazioneLaterale postazioneOvest, PostazioneGiocatore postazioneNord, PostazioneLaterale postazioneEst, Mazzo mazzo) {
        if (Menu.senso == Senso.ANTIORARIO)
            Menu.turno = 3;
        if (Menu.senso == Senso.ORARIO)
            Menu.turno = 1;
        avanti(turno, manoOvest, manoNord, manoEst, piatto, postazioneOvest, postazioneNord, postazioneEst, mazzo, postazioneNord, manoEst);
    }
}
