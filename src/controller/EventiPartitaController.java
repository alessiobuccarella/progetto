package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import model.Carta;
import model.Database;
import model.Mano;
import model.Mazzo;
import model.Profilo;
import model.Senso;
import view.DisegnaCarta;
import view.PartitaPanel;
import view.PiattoPanel;
import view.PostazionePanel;
import view.ProfiloPanel;

/**
 *questa classe gestisce il comportamento dei giocatori e tutti gli eventi della partita
 */
public class EventiPartitaController {
	
    /**
     * intero che conta il numero di turni giocati
     */
    private int contatore;
    /**
     * intero che designa il giocatore che effettuera la prossima mossa
     */
    private int turno;
    /**
     * booleano che assume il valore true quando si presenta
     * la circostanza di dover gridare uno
     */
    private boolean deviGridareUno;
    /**
     * booleano che indica se è stato gridato uno
     */
    private boolean gridatoUno;
    /**
     * booleano che indica se il giocatore ha gia pescato
     */
    private boolean pescato;
    /**
     * booleano che indica il verdetto finale
     */
    private boolean vinto;
    /**
     * AudioButtonManager per l'audio della partita
     */
    private AudioButtonManager musicObjectBot;
    /**
     * enum di tipo Senso che indica se il senso attuale è orario o antiorario
     */
    private Senso senso;
    /**
     * carta che rappresenta l'ultima carta lanciata
     */
    private Carta cartaScarto;
    /**
     * panel della partita
     */
    private PartitaPanel partitaPanel;
    /**
     * panel del profilo
     */
    private ProfiloPanel profiloPanel;
    /**
     * la card layout per navigare
     */
    private CardLayout cardLayout;
    /**
     * in container padre per navigare
     */
    private Container parent;
    
    private JLabel passato;

    /**
     * costruttore che prende in input un'istanza di partitaPanel
     * e inizializza i campi
     * @param partitaPanel istanza di partitaPanel
     */
    public EventiPartitaController(PartitaPanel partitaPanel, ProfiloPanel profiloPanel, CardLayout cardLayout, Container parent) {
        this.partitaPanel = partitaPanel;
        this.profiloPanel = profiloPanel;
        this.cardLayout = cardLayout;
        this.parent = parent;
        
        musicObjectBot = new AudioButtonManager();
        cartaScarto = partitaPanel.getCartaScarto();
        contatore = 0;
        setTurno(0);
        deviGridareUno=false;
        gridatoUno=false;
        pescato=false;
        passato= new JLabel("Il giocatore ha passato il turno");
        passato.setFont(new Font("Dialog", Font.PLAIN, 20));
        passato.setForeground(Color.white);
        /**
         * enum senso
         */
        senso = Senso.ORARIO;
    }

    /**
     * metodo che gestisce il click del giocatore su una carta
     * controlla se è stato cliccato "uno" prima di terminare le carte altrimenti pesca due carte di penalita
     * controlla che la carta cliccata sia valida, se lo è controlla il senso della partita, gestisce le carte speciali,
     * gestisce la riproduzione di suoni ed effetti grafici
     * gestisce tutte le modalita di gioco tramite controlli che fanno uso della variabile mod
     * @param gbc10 gridBagConstraints del panel della partita
     * @param mano di carte del giocatore
     * @param indiceCarta posizione della carta nella mano del giocatore
     * @param posto JButton corrispondente alla carta cliccata
     * @param postazione panel corrispondente alla postazione del giocatore
     * @param piatto panel corrispondente alla parte centrale del tavolo (mazzo e carta scartata)
     * @param manoOvest mano di carte del giocatore a ovest
     * @param manoNord mano di carte del giocatore a nord
     * @param manoEst mano di carte del giocatore a est
     * @param postazioneOvest panel corrispondente alla postazione del giocatore a ovest
     * @param postazioneNord panel corrispondente alla postazione del giocatore a nord
     * @param postazioneEst panel corrispondente alla postazione del giocatore a est
     * @param posti array di jbutton che rappresentano le carte cliccabili dal giocatore
     * @param mazzo mazzo di carte
     * @param postazionePiatto panel corrispondente alla schermata di gioco 
     */
    public void cliccato(GridBagConstraints gbc10, Mano mano, int indiceCarta, JButton posto, PostazionePanel postazione, PiattoPanel piatto,  Mano manoOvest, Mano manoNord, Mano manoEst, PostazionePanel postazioneOvest, PostazionePanel postazioneNord, PostazionePanel postazioneEst, ArrayList<JButton> posti, Mazzo mazzo, PostazionePanel postazionePiatto) {
        if (mano.mano.size() > 1) deviGridareUno = false;
        else deviGridareUno = true;
        if (deviGridareUno == true && gridatoUno == false) {
            System.out.println("Penalità: non hai gridato 1! Peschi due carte.");
            mano.mano.add(mazzo.pesca());
            posti.get(mano.mano.size() - 1).setBorder(null);
            mano.mano.add(mazzo.pesca());
            posti.get(mano.mano.size() - 1).setBorder(null);
        }
        if ((mano.mano.get(indiceCarta).getC() == getCartaScarto().getC() || mano.mano.get(indiceCarta).getV() == getCartaScarto().getV() || mano.mano.get(indiceCarta).getC() == 4) && (getTurno() % 4 == 0)) {
        	piatto.remove(passato);

        	if(getCartaScarto().getV() < 10) {
                musicObjectBot.playButtonMusic("./src/audio/normal_card_audio.wav");
                if ((partitaPanel.getMod() == 2)&&(getCartaScarto().getV()!=10 )&&(getCartaScarto().getV() != 11 )) {
                    musicObjectBot.playButtonMusic("./src/audio/Charmander_audio.wav");
                    partitaPanel.getFoto1().setBorder(new LineBorder(Color.RED, 5));
                }
            }
            cartaScarto=mano.mano.get(indiceCarta);
            postazionePiatto.remove(partitaPanel.getScartoButton());
            partitaPanel.setScartoButton(DisegnaCarta.disegnaCarta(getCartaScarto()));
            gbc10.anchor = GridBagConstraints.LINE_END;
            gbc10.weightx = 0;
            gbc10.weighty = 0;
            gbc10.gridx = 7;
            gbc10.gridy = 1;
            postazionePiatto.add(partitaPanel.getScartoButton());
            piatto.invalidate();
            piatto.validate();
            piatto.repaint();
            mano.mano.remove(indiceCarta);
            postazione.removeAll();
            int count = 0;
            for (Carta x : mano.mano) {
                Icon immagine = new ImageIcon("./src/immagini/" + x.getV() + x.getC() + ".png");
                posti.get(count).setIcon(immagine);
                posti.get(count).setBorder(null);
                postazione.add(posti.get(count));
                count++;
            }
            postazione.invalidate();
            postazione.validate();
            if (getCartaScarto().getV() == 11) {
                musicObjectBot.playButtonMusic("./src/audio/special_card_audio.wav");
                cambiaSenso();
                if (partitaPanel.getMod() == 2) setTurno(0);
            }
            if (senso == Senso.ORARIO) {
                if (partitaPanel.getMod() != 2) {
                    setTurno(1);
                    if (partitaPanel.getMod() != 2) musicObjectBot.playButtonMusic("./src/audio/Bulbasaur_audio.wav");
                    partitaPanel.getFoto().setBorder(new LineBorder(Color.RED, 5));
                    partitaPanel.getFoto2().setBorder(new LineBorder(null));
                }
                else setTurno(2);
            }
            if (senso == Senso.ANTIORARIO) {
                if (partitaPanel.getMod() != 2) {
                    setTurno(3);
                    partitaPanel.getFoto2().setBorder(new LineBorder(Color.RED, 5));
                    if (getTurno() == 0) musicObjectBot.playButtonMusic("./src/audio/Squirtle_audio.wav");
                    partitaPanel.getFoto().setBorder(new LineBorder(null));
                }
                else setTurno(2);
            }
            if (getCartaScarto().getV() == 10) {
                if (partitaPanel.getMod() != 2) {
                    setTurno(2);
                    musicObjectBot.playButtonMusic("./src/audio/Charmander_audio.wav");
                    partitaPanel.getFoto1().setBorder(new LineBorder(Color.RED, 5));
                    partitaPanel.getFoto2().setBorder(new LineBorder(null));
                    partitaPanel.getFoto().setBorder(new LineBorder(null));
                }
                else setTurno(0);

            }
        }
        if (getCartaScarto().getV() == 12) {

            if (partitaPanel.getMod() == 2) {
                manoNord.mano.add(mazzo.pesca());
                manoNord.mano.add(mazzo.pesca());
            }
            if (getTurno() % 4 == 1 && partitaPanel.getMod() != 2 ) {
                for (int i = 0; i < 2; i++)
                    manoOvest.mano.add(mazzo.pesca());
                postazioneOvest.invalidate();
                postazioneOvest.validate();
            } else if (partitaPanel.getMod()!=2) {
                for (int i = 0; i < 2; i++)
                    manoEst.mano.add(mazzo.pesca());
            }
        }
        postazioneEst.invalidate();
        postazioneEst.validate();
        if (getCartaScarto().getV() == 14) {
            if (partitaPanel.getMod() == 2) {
                manoNord.mano.add(mazzo.pesca());
                manoNord.mano.add(mazzo.pesca());
                manoNord.mano.add(mazzo.pesca());
                manoNord.mano.add(mazzo.pesca());

            }
            if (getTurno() % 4 == 1 && partitaPanel.getMod() != 2) {
                for (int i = 0; i < 4; i++)
                    manoOvest.mano.add(mazzo.pesca());
                postazioneOvest.invalidate();
                postazioneOvest.validate();
            } else {
                for (int i = 0; i < 4; i++)
                    manoEst.mano.add(mazzo.pesca());
                postazioneEst.invalidate();
                postazioneEst.validate();
            }
            if (partitaPanel.getMod()!= 2) aggiornaTurno(mano,mazzo);
            else {
                setTurno(2);
                musicObjectBot.playButtonMusic("./src/audio/Charmander_audio.wav");
                partitaPanel.getFoto1().setBorder(new LineBorder(Color.RED, 5));
                partitaPanel.getFoto2().setBorder(new LineBorder(null));
                partitaPanel.getFoto().setBorder(new LineBorder(null));
            }
        }
        if (mano.mano.size() == 0) {
            String frase = "Congratulazioni hai vinto!!";
            risultatoPartita(true, partitaPanel.getNomegiocatore().getText(), frase);
            vaiMenu();
        }
    }
    /**
     * metodo che viene invocato dal timer e designa il prossimo giocatore a tirare tramite la variabile turno
     * gestisce anche il contatore usato nella modalita lampo e chiama la fine della partita
     * @param gbc10 gridBagConstraints del panel della partita
     * @param turno indica il giocatore che effettuerà la prossima mossa
     * @param manoOvest indica le carte in mano al giocatore
     * @param manoNord indica le carte in mano al giocatore
     * @param manoEst indica le carte in mano al giocatore
     * @param piatto panel della postazione centrale
     * @param postazioneOvest postazione del giocatore
     * @param postazioneNord postazione del giocatore
     * @param postazioneEst postazione del giocatore
     * @param mazzo mazzo della partita
     * @param postazione postazione del giocatore
     * @param mano mano del giocatore
     * @param postazionePiatto postazione centrale
     */
    public void avanti(GridBagConstraints gbc10, int turno, Mano manoOvest, Mano manoNord, Mano manoEst, PiattoPanel piatto, PostazionePanel postazioneOvest, PostazionePanel postazioneNord, PostazionePanel postazioneEst, Mazzo mazzo, PostazionePanel postazione, Mano mano, PostazionePanel postazionePiatto) {
        if (partitaPanel.getMod() == 3) {
            contatore++;
            if (contatore >= 20) {
                vincitoreLampo(manoOvest,manoNord,manoEst,mano);
            }
        }

        switch (turno % 4) {
            case 1:
                mossaOvest(gbc10,mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst, postazionePiatto);
                if (senso == Senso.ORARIO && getCartaScarto().getV() != 10 && getCartaScarto().getV() != 11) {
                    partitaPanel.getFoto2().setBorder(null);
                    musicObjectBot.playButtonMusic("./src/audio/Charmander_audio.wav");
                    partitaPanel.getFoto1().setBorder(new LineBorder(Color.RED, 5));
                    partitaPanel.getFoto().setBorder(null);
                }
                else if (senso == Senso.ANTIORARIO && getCartaScarto().getV() != 10 && getCartaScarto().getV() != 11) {
                    partitaPanel.getFoto2().setBorder(null);
                    partitaPanel.getFoto1().setBorder(null);
                    partitaPanel.getFoto().setBorder(null);
                }
                else {
                    partitaPanel.getFoto2().setBorder(null);
                    partitaPanel.getFoto1().setBorder(null);
                    partitaPanel.getFoto().setBorder(null);
                }
                break;
            case 2:
                mossaNord(gbc10, mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst, postazionePiatto);
                if (senso == Senso.ORARIO && getCartaScarto().getV() != 10 && getCartaScarto().getV() != 11) {
                    if (partitaPanel.getMod() != 2)musicObjectBot.playButtonMusic("./src/audio/Squirtle_audio.wav");
                    partitaPanel.getFoto2().setBorder(new LineBorder(Color.RED, 5));
                    partitaPanel.getFoto1().setBorder(null);
                    partitaPanel.getFoto().setBorder(null);
                }
                else if (senso == Senso.ANTIORARIO && getCartaScarto().getV() != 10 && getCartaScarto().getV() != 11) {
                    partitaPanel.getFoto2().setBorder(null);
                    partitaPanel.getFoto1().setBorder(null);
                    if (partitaPanel.getMod() != 2)musicObjectBot.playButtonMusic("./src/audio/Bulbasaur_audio.wav");
                    partitaPanel.getFoto().setBorder(new LineBorder(Color.RED, 5));
                }
                else {
                    partitaPanel.getFoto2().setBorder(null);
                    partitaPanel.getFoto1().setBorder(null);
                    partitaPanel.getFoto().setBorder(null);
                }
                break;
            case 3:
                mossaEst(gbc10, mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst, postazionePiatto);
                if (senso == Senso.ORARIO && getCartaScarto().getV() != 10 && getCartaScarto().getV() != 11) {
                    partitaPanel.getFoto2().setBorder(null);
                    partitaPanel.getFoto1().setBorder(null);
                    partitaPanel.getFoto().setBorder(null);}
                else if (senso == Senso.ANTIORARIO && getCartaScarto().getV() != 10 && getCartaScarto().getV() != 11) {
                    partitaPanel.getFoto2().setBorder(null);
                    musicObjectBot.playButtonMusic("./src/audio/Charmander_audio.wav");
                    partitaPanel.getFoto1().setBorder(new LineBorder(Color.RED, 5));
                    partitaPanel.getFoto().setBorder(null);
                }
                else {
                    partitaPanel.getFoto2().setBorder(null);
                    partitaPanel.getFoto1().setBorder(null);
                    partitaPanel.getFoto().setBorder(null);
                }
                break;
            default:
                break;
        }
    }

    /**
     * metodo che gestisce la mossa del giocatore a ovest e la rappresentazione grafica delle sue carte
     * @param gbc10 GridBagConstraints del panel della partita
     * @param mano mano del giocatore
     * @param manoOvest mano del giocatore
     * @param manoNord mano del giocatore
     * @param manoEst mano del giocatore
     * @param piatto postazione centrale
     * @param postazioneOvest postazione del giocatore
     * @param mazzo mazzo della partita
     * @param postazione postazione del giocatore
     * @param postazioneNord postazione del giocatore
     * @param postazioneEst postazione del giocatore
     * @param postazionePiatto postazione del giocatore
     */
    public void mossaOvest(GridBagConstraints gbc10, Mano mano, Mano manoOvest, Mano manoNord, Mano manoEst, PiattoPanel piatto, PostazionePanel postazioneOvest, Mazzo mazzo, PostazionePanel postazione, PostazionePanel postazioneNord, PostazionePanel postazioneEst, PostazionePanel postazionePiatto) {
        if (cartaScarto.getC() == 4){
            int x = (int)(Math.random() * 4);
            if (cartaScarto.getV() >= 13) {
                getCartaScarto().setC(x);
                String filename = "./src/immagini/" + getCartaScarto().getC() + "+0.png";
                ImageIcon img = new ImageIcon(filename);
                JButton colore = new JButton(img);
            }
        }
        Carta x = cartaUtile(manoOvest);
        if (x != null) {
        	piatto.remove(passato);
            lanciaCarta(gbc10, piatto, manoOvest, postazioneOvest, x,"./src/immagini/dorso90.png", postazionePiatto);
            postazioneOvest.removeAll();
            switch(manoOvest.mano.size()) {
                case 0: break;
                case 1:
                    postazioneOvest.add((new JLabel(new ImageIcon("./src/immagini/dorsosx1.png"))),gbc10);
                    break;
                case 2:
                    postazioneOvest.add((new JLabel(new ImageIcon("./src/immagini/dorsosx2.png"))),gbc10);
                    break;
                case 3:
                    postazioneOvest.add((new JLabel(new ImageIcon("./src/immagini/dorsosx3.png"))),gbc10);
                    break;
                case 4:
                    postazioneOvest.add((new JLabel(new ImageIcon("./src/immagini/dorsosx4.png"))),gbc10);
                    break;
                case 5:
                    postazioneOvest.add((new JLabel(new ImageIcon("./src/immagini/dorsosx5.png"))),gbc10);
                    break;
                case 6:
                    postazioneOvest.add((new JLabel(new ImageIcon("./src/immagini/dorsosx6.png"))),gbc10);
                    break;
                case 7:
                    postazioneOvest.add((new JLabel(new ImageIcon("./src/immagini/dorsosx7.png"))),gbc10);
                    break;
                default:
                    postazioneOvest.add((new JLabel(new ImageIcon("./src/immagini/dorsosx7+.png"))),gbc10);
            }
            if(x.getV() >= 12 && senso == Senso.ORARIO) {
                aggiornaSpeciale(manoNord, postazioneNord, piatto, x, mazzo,"./src/immagini/dorso.png");
            }
            if(x.getV() >= 12 && senso == Senso.ANTIORARIO) {
                aggiornaSpecialeUmano(mano, mazzo, x, postazione);
            }
            aggiornaVista(piatto, postazioneOvest);
            aggiornaTurno(mano,mazzo);
            if(senso == Senso.ORARIO) {
                if (cartaScarto.getV() != 10) {
                    partitaPanel.getFoto().setBorder(null);
                    musicObjectBot.playButtonMusic("./src/audio/Charmander_audio.wav");
                    partitaPanel.getFoto1().setBorder(new LineBorder(Color.RED, 5));
                    partitaPanel.getFoto2().setBorder(null);
                }
                else {
                    partitaPanel.getFoto().setBorder(null);
                    if (partitaPanel.getMod() != 2) musicObjectBot.playButtonMusic("./src/audio/Squirtle_audio.wav");
                    partitaPanel.getFoto1().setBorder(null);
                    partitaPanel.getFoto2().setBorder(new LineBorder(Color.RED, 5));
                }
            }
            else {
                partitaPanel.getFoto().setBorder(null);
                partitaPanel.getFoto1().setBorder(null);
                partitaPanel.getFoto2().setBorder(null);
            }
        }
        else if (pescato == false) {
            manoOvest.mano.add(mazzo.pesca());
            aggiornaVista(piatto, postazioneOvest);
            pescato = true;
            mossaOvest(gbc10, mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst, postazionePiatto);
        }
        else if (x == null && pescato == true) {
            pescato = false;
            aggiornaTurno(mano,mazzo);
            System.out.println("BULBASAUR HA PASSATO");
            piatto.add(passato);
        }
        if (manoOvest.mano.size() == 0) {
            String frase = "Purtroppo hai perso!!";
            risultatoPartita(false, partitaPanel.getNomegiocatore().getText(), frase);
            vaiMenu();
        }
    }

    /** metodo che gestisce le mosse del giocatore a nord e la rappresentazione grafica delle sue carte, inoltre tramite dei 
     * controlli designati dalla modalita due gestisce i diversi tipi di partite
     * @param gbc10 GridBagConstraints del panel della partita
     * @param mano mano del giocatore
     * @param manoOvest mano del giocatore
     * @param manoNord mano del giocatore
     * @param manoEst mano del giocatore
     * @param piatto postazione centrale 
     * @param postazioneOvest postazione del giocatore
     * @param mazzo mazzo della partita
     * @param postazione postazione del giocatore
     * @param postazioneNord postazione del giocatore
     * @param postazioneEst postazione del giocatore
     * @param postazionePiatto panel della partita
     */
    public void mossaNord(GridBagConstraints gbc10, Mano mano, Mano manoOvest, Mano manoNord, Mano manoEst, PiattoPanel piatto, PostazionePanel postazioneOvest, Mazzo mazzo, PostazionePanel postazione, PostazionePanel postazioneNord, PostazionePanel postazioneEst, PostazionePanel postazionePiatto) {
        if (cartaScarto.getC() == 4){
            int x = (int)(Math.random() * 4);
            if (cartaScarto.getV() >= 13) {
                getCartaScarto().setC(x);
                String filename = "./src/immagini/" + getCartaScarto().getC() + "+0.png";
                ImageIcon img = new ImageIcon(filename);
                JButton colore = new JButton(img);
            }
        }
        Carta x = cartaUtile(manoNord);
        // se il giocatore ha una carta utile
        if (x != null) {
        	piatto.remove(passato);
            lanciaCarta(gbc10,piatto,manoNord,postazioneNord,x,"./src/immagini/dorso.png",postazionePiatto);
            postazioneNord.removeAll();
            switch(manoNord.mano.size()) {
                case 0: break;
                case 1:
                    postazioneNord.add((new JLabel(new ImageIcon("./src/immagini/dorsonord1.png"))),gbc10);
                    break;
                case 2:
                    postazioneNord.add((new JLabel(new ImageIcon("./src/immagini/dorsonord2.png"))),gbc10);
                    break;
                case 3:
                    postazioneNord.add((new JLabel(new ImageIcon("./src/immagini/dorsonord3.png"))),gbc10);
                    break;
                case 4:
                    postazioneNord.add((new JLabel(new ImageIcon("./src/immagini/dorsonord4.png"))),gbc10);
                    break;
                case 5:
                    postazioneNord.add((new JLabel(new ImageIcon("./src/immagini/dorsonord5.png"))),gbc10);
                    break;
                case 6:
                    postazioneNord.add((new JLabel(new ImageIcon("./src/immagini/dorsonord6.png"))),gbc10);
                    break;
                case 7:
                    postazioneNord.add((new JLabel(new ImageIcon("./src/immagini/dorsonord7.png"))),gbc10);
                    break;
                default:
                    postazioneNord.add((new JLabel(new ImageIcon("./src/immagini/dorsonord7+.png"))),gbc10);
            }
            if(x.getV() >= 12 && senso == Senso.ORARIO) {
                if (partitaPanel.getMod()!=2) aggiornaSpeciale(manoEst,postazioneEst,piatto, x,mazzo,"./src/immagini/dorso90s.png");
                else aggiornaSpecialeUmano(mano, mazzo, x, postazione);

            }
            if(x.getV() >= 12 && senso == Senso.ANTIORARIO) {
                if (partitaPanel.getMod()!=2)aggiornaSpeciale(manoOvest,postazioneOvest,piatto, x,mazzo,"./src/immagini/dorso90.png");
                else aggiornaSpecialeUmano(mano, mazzo, x, postazione);
            }
            aggiornaVista(piatto, postazioneNord);
            aggiornaTurno(mano,mazzo);
        }
        else if (pescato == false) {
            manoNord.mano.add(mazzo.pesca());
            aggiornaVista(piatto, postazioneNord);
            pescato = true;
            mossaNord(gbc10, mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst, postazionePiatto);
        }
        else if (x == null && pescato == true) {
            pescato = false;
            aggiornaTurno(mano,mazzo);
            System.out.println("CHARMANDAR HA PASSATO");
            piatto.add(passato);
        }
        if (manoNord.mano.size() == 0) {
            String frase = "Purtroppo hai perso!!";
            risultatoPartita(false, partitaPanel.getNomegiocatore().getText(), frase);
            vaiMenu();
        }
    }
    /**
     * metodo che gestisce le mosse del giocatore a est e la rappresentazione grafica delle sue carte
     * @param gbc10 GridBagConstraints del panel della partita
     * @param mano mano del giocatore
     * @param manoOvest mano del giocatore
     * @param manoNord mano del giocatore
     * @param manoEst mano del giocatore
     * @param piatto postazione centrale
     * @param postazioneOvest postazione del giocatore
     * @param mazzo mazzo della partita
     * @param postazione postazione del giocatore
     * @param postazioneNord postazione del giocatore
     * @param postazioneEst postazione del giocatore
     * @param postazionePiatto postazione centrale
     */
    public void mossaEst(GridBagConstraints gbc10, Mano mano, Mano manoOvest, Mano manoNord, Mano manoEst, PiattoPanel piatto, PostazionePanel postazioneOvest, Mazzo mazzo, PostazionePanel postazione, PostazionePanel postazioneNord, PostazionePanel postazioneEst, PostazionePanel postazionePiatto) {
        if (cartaScarto.getC() == 4){
            int x = (int)(Math.random() * 4);
            if (cartaScarto.getV() >= 13) {
                getCartaScarto().setC(x);
                String filename = "./src/immagini/" + getCartaScarto().getC() + "+0.png";
                ImageIcon img = new ImageIcon(filename);
                JButton colore = new JButton(img);
            }
        }
        Carta x = cartaUtile(manoEst);
        if (x != null) {
        	piatto.remove(passato);
            lanciaCarta(gbc10,piatto,manoEst,postazioneEst,x,"./src/immagini/dorso90s.png",postazionePiatto);
            postazioneEst.removeAll();
            switch(manoEst.mano.size()) {
                case 0: break;
                case 1:
                    postazioneEst.add((new JLabel(new ImageIcon("./src/immagini/dorsodx1.png"))),gbc10);
                    break;
                case 2:
                    postazioneEst.add((new JLabel(new ImageIcon("./src/immagini/dorsodx2.png"))),gbc10);
                    break;
                case 3:
                    postazioneEst.add((new JLabel(new ImageIcon("./src/immagini/dorsodx3.png"))),gbc10);
                    break;
                case 4:
                    postazioneEst.add((new JLabel(new ImageIcon("./src/immagini/dorsodx4.png"))),gbc10);
                    break;
                case 5:
                    postazioneEst.add((new JLabel(new ImageIcon("./src/immagini/dorsodx5.png"))),gbc10);
                    break;
                case 6:
                    postazioneEst.add((new JLabel(new ImageIcon("./src/immagini/dorsodx6.png"))),gbc10);
                    break;
                case 7:
                    postazioneEst.add((new JLabel(new ImageIcon("./src/immagini/dorsodx7.png"))),gbc10);
                    break;
                default:
                    postazioneEst.add((new JLabel(new ImageIcon("./src/immagini/dorsodx7+.png"))),gbc10);
            }
            if(x.getV() >= 12 && senso == Senso.ORARIO) {
                aggiornaSpecialeUmano(mano, mazzo, x, postazione);
            }
            if(x.getV() >= 12 && senso == Senso.ANTIORARIO) {
                aggiornaSpeciale(manoNord, postazioneNord, piatto, x, mazzo, "./src/immagini/dorso.png");
            }
            aggiornaVista(piatto, postazioneEst);
            aggiornaTurno(mano,mazzo);
            if(senso == Senso.ORARIO) {
                partitaPanel.getFoto2().setBorder(null);
                partitaPanel.getFoto1().setBorder(null);
                partitaPanel.getFoto().setBorder(null);
                if (getCartaScarto().getV() == 11) {
                    if (partitaPanel.getMod() == 2) setTurno(0);
                    partitaPanel.getFoto1().setBorder(null);
                    if (partitaPanel.getMod() != 2)partitaPanel.getFoto1().setBorder(new LineBorder(Color.RED, 5));
                    partitaPanel.getFoto().setBorder(null);
                    if (partitaPanel.getMod() != 2)musicObjectBot.playButtonMusic("./src/audio/Charmander_audio.wav");
                }
            } else {
                partitaPanel.getFoto2().setBorder(null);
                if (partitaPanel.getMod() != 2) partitaPanel.getFoto1().setBorder(new LineBorder(Color.RED, 5));
                partitaPanel.getFoto().setBorder(null);
                if (partitaPanel.getMod() != 2)musicObjectBot.playButtonMusic("./src/audio/Charmander_audio.wav");
            }
            if (getCartaScarto().getV() == 10) {
                partitaPanel.getFoto2().setBorder(null);
                partitaPanel.getFoto1().setBorder(null);
                partitaPanel.getFoto().setBorder(new LineBorder(Color.RED, 5));
                if (partitaPanel.getMod() != 2) musicObjectBot.playButtonMusic("./src/audio/Bulbasaur_audio.wav");;
            }
        }
        else if (pescato == false) {
            manoEst.mano.add(mazzo.pesca());
            aggiornaVista(piatto, postazioneEst);
            pescato = true;
            mossaEst(gbc10, mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
        }
        else if (x == null && pescato == true) {
            pescato = false;
            if (senso == Senso.ORARIO) setTurno(getTurno() + 1);
            else setTurno(getTurno() - 1);
            System.out.println("SQUIRTLE HA PASSATO");
            piatto.add(passato);
        }
        if (manoEst.mano.size() == 0) {
            String frase = "Purtroppo hai perso!!";
            risultatoPartita(false, partitaPanel.getNomegiocatore().getText(), frase);
            vaiMenu();
        }
    }

    /**
     * metodo che viene invocato quando un giocatore tira la carta cambiogiro e inverte il senso
     * da orario a antiorario e viceversa
     */
    public void cambiaSenso() {
        if (senso == Senso.ANTIORARIO) senso = Senso.ORARIO;
        else senso = Senso.ANTIORARIO;
    }

    /**
     * controlla se il giocatore di turno ha una carta affine all'ultima carta scartata e in caso affermativo la ritorna
     * @param manoGiocatore la mano del giocatore da analizzare
     * @return la carta da lanciare
     */
    public Carta cartaUtile(Mano manoGiocatore) {
        for (Carta x : manoGiocatore.mano)
            if (x.getV() == getCartaScarto().getV() || x.getC() == getCartaScarto().getC() || x.getC() == 4)
                return x;
        return null;
    }

    /**
     * metodo che aggiorna graficamente la situazione dopo il lancio di una carta
     * @param gbc10 GridBagConstraints del panel della partita
     * @param piatto postazione centrale
     * @param mano mano del giocatore
     * @param postazione postazione del giocatore
     * @param carta carta lanciata
     * @param pathDorso il percorso dell'immagine del dorso della carta
     * @param postazionePiatto panel della partita
     */
    public void lanciaCarta(GridBagConstraints gbc10, PiattoPanel piatto, Mano mano, PostazionePanel postazione, Carta carta, String pathDorso, PostazionePanel postazionePiatto) {
        postazionePiatto.remove(partitaPanel.getScartoButton());
        partitaPanel.setScartoButton(DisegnaCarta.disegnaCarta(carta));
        cartaScarto=carta;
        postazionePiatto.add(partitaPanel.getScartoButton());
        piatto.repaint();
        mano.mano.remove(carta);
    }

    /**
     * metodo che gestisce il lancio di carte speciali
     * @param manoVittima la mano del giocatore che subira i danni del lancio della carta speciale
     * @param postazioneVittima la postazione della vittima
     * @param piatto il panel che rappresenta il centro del tavolo con mazzo e carta scartata
     * @param x la carta speciale che è stata lanciata
     * @param mazzo il mazzo della partita
     * @param path percorso dell'immagine della carta
     */
    public  void aggiornaSpeciale(Mano manoVittima, PostazionePanel postazioneVittima, PiattoPanel piatto, Carta x, Mazzo mazzo, String path) {
        if (x.getV() == 12) {
            manoVittima.mano.add(mazzo.pesca());manoVittima.mano.add(mazzo.pesca());
            aggiornaVista(piatto, postazioneVittima);
        }
        if (x.getV() == 13) {
            getCartaScarto().setC((int)(Math.random() * 4));
            String filename = "./src/immagini/" + getCartaScarto().getC() + "+0.png";
            ImageIcon img = new ImageIcon(filename);
            JButton colore = new JButton(img);
            colore.setBorder(null);
            partitaPanel.getScartoButton().add(colore);
        }
        if (x.getV() == 14) {
            manoVittima.mano.add(mazzo.pesca());
            manoVittima.mano.add(mazzo.pesca());
            manoVittima.mano.add(mazzo.pesca());
            manoVittima.mano.add(mazzo.pesca());
            aggiornaVista(piatto, postazioneVittima);
            getCartaScarto().setC((int)(Math.random() * 4));
            String filename = "./src/immagini/" + getCartaScarto().getC() + "+4.png";
            ImageIcon img = new ImageIcon(filename);
            JButton colore = new JButton(img);
            colore.setBorder(null);
            partitaPanel.getScartoButton().add(colore);
        }
    }

    /**
     * metodo che gestisce il lancio di carte speciali quando la vittima è il giocatore umano
     * @param mano mano del giocatore
     * @param mazzo mazzo della partita
     * @param x carta lanciata
     * @param postazione postazione del giocatore
     */
    public  void aggiornaSpecialeUmano(Mano mano, Mazzo mazzo, Carta x, PostazionePanel postazione) {
        if (x.getV() == 12) {
            pesca(mazzo,mano);
            pesca(mazzo,mano);
        }
        if (x.getV() == 13) {
            getCartaScarto().setC((int)(Math.random() * 4));
            String filename = "./src/immagini/" + getCartaScarto().getC() + "+0.png";
            ImageIcon img = new ImageIcon(filename);
            JButton colore = new JButton(img);
            colore.setBorder(null);
            partitaPanel.getScartoButton().add(colore);
        }
        if (x.getV() == 14) {
            getCartaScarto().setC((int)(Math.random() * 4));
            String filename = "./src/immagini/" + getCartaScarto().getC() + "+4.png";
            ImageIcon img = new ImageIcon(filename);
            JButton colore = new JButton(img);
            colore.setBorder(null);
            partitaPanel.getScartoButton().add(colore);
            pesca(mazzo,mano);
            pesca(mazzo,mano);
            pesca(mazzo,mano);
            pesca(mazzo,mano);
            postazione.repaint();
        }
    }

    /**
     * metodo che aggiorna la vista del panel piatto e del panel postazione
     * @param piatto postazione centrale
     * @param postazione postazione del giocatore
     */
    public  void aggiornaVista(PiattoPanel piatto, PostazionePanel postazione) {
        piatto.invalidate();
        piatto.validate();
        postazione.invalidate();
        postazione.validate();
    }

    /**
     * metodo che gestisce il turno successivo in base al senso e alla carta lanciata
     * @param mano mano del giocatore
     * @param mazzo mazzo della partita
     */
    public  void aggiornaTurno(Mano mano,Mazzo mazzo) {
        if (getCartaScarto().getV() == 11) {
            musicObjectBot.playButtonMusic("./src/audio/special_card_audio.wav");
            cambiaSenso();
            if (senso == Senso.ORARIO) {
                if (partitaPanel.getMod() != 2) setTurno(getTurno() + 1);
            }
            else {
                if (partitaPanel.getMod() != 2) setTurno(getTurno() - 1);
            }
        }
        if (getCartaScarto().getV() == 10)
            if (partitaPanel.getMod() != 2) setTurno(getTurno() + 2);
            else setTurno(getTurno() + 4);
        if (senso == Senso.ORARIO && getCartaScarto().getV() != 10 && getCartaScarto().getV() != 11)
            if (partitaPanel.getMod() != 2)setTurno(getTurno() + 1);
            else setTurno(getTurno() + 2);
        if (senso == Senso.ANTIORARIO && getCartaScarto().getV() != 10 && getCartaScarto().getV() != 11)
            if (partitaPanel.getMod() != 2) setTurno(getTurno() - 1);
            else setTurno(getTurno() + 2);
        Carta x = cartaUtile(mano);
        if (getTurno() % 4 == 0) musicObjectBot.playButtonMusic("./src/audio/it's me_audio.wav");
        if (getTurno() % 4 == 0 && x == null) {
            pesca(mazzo, mano);
        }

    }

    /**
     * metodo usato per far pescare una carta a un giocatore quando è sprovvisto di una carta utile
     * o per dare le carte quando un giocatore subisce un attacco o una penalita
     * @param mazzo mazzo della partita
     * @param mano mano del giocatore
     */
    public  void pesca(Mazzo mazzo, Mano mano) {
        Carta carta=mazzo.pesca();
        mano.mano.add(carta);
        Icon immagine = new ImageIcon("./src/immagini/" + carta.getV() + carta.getC() + ".png");
        partitaPanel.getPosti().get(mano.mano.size() - 1).setIcon(immagine);
        partitaPanel.getPosti().get(mano.mano.size() - 1).setBorder(null);
        partitaPanel.getPostazione().add(partitaPanel.getPosti().get(mano.mano.size() - 1));
        partitaPanel.getPostazione().invalidate();
        partitaPanel.getPostazione().validate();
        partitaPanel.getTavolo().invalidate();
        partitaPanel.getTavolo().validate();
    }

    /**
     * metodo che chiama il giocatore successivo quando un giocatore deve passare il turno
     */
    public  void passo() {
        if (senso == Senso.ANTIORARIO) {
            if (partitaPanel.getMod() != 2) setTurno(3);
            else setTurno(2);
            partitaPanel.getFoto2().setBorder(new LineBorder(Color.RED, 5));
            if (partitaPanel.getMod() != 2) musicObjectBot.playButtonMusic("./src/audio/Squirtle_audio.wav");
        }
        if (senso == Senso.ORARIO) {
            if (partitaPanel.getMod() != 2) setTurno(1);
            else setTurno(2);
            partitaPanel.getFoto().setBorder(new LineBorder(Color.RED, 5));
            if (partitaPanel.getMod() != 2) musicObjectBot.playButtonMusic("./src/audio/Bulbasaur_audio.wav");

        }
    }

    /**
     * metodo che conta i punteggi rimanenti nelle mani dei giocatori e calcola il vincitore
     * @param manoOvest mano del giocatore 
     * @param manoNord mano del giocatore
     * @param manoEst mano del giocatore
     * @param mano mano del giocatore
     */
    public void vincitoreLampo(Mano manoOvest, Mano manoNord, Mano manoEst, Mano mano)
    {
        String frase = "";
        int y = 0;
        int ovest=0;
        int nord=0;
        int est=0;
        int giocatore=0;
        for (Carta x:manoOvest.mano) {ovest += x.getV();}
        for (Carta x:manoNord.mano) {nord += x.getV();}
        for (Carta x:manoEst.mano) {est += x.getV();}
        for (Carta x:mano.mano) {giocatore += x.getV();}
        int min = Math.min(Math.min(Math.min(ovest,nord),est),giocatore);
        if (ovest == min) {
            frase =  "Ha vinto Bulbasaur con " + min + " punti";
            risultatoPartita(false, partitaPanel.getNomegiocatore().getText(), frase);
        } else if (nord == min) {
            frase =  "Ha vinto Charamnder con " + min + " punti";
            risultatoPartita(false, partitaPanel.getNomegiocatore().getText(), frase);
        } else if (est == min) {
            frase =  "Ha vinto Squirtle con " + min + " punti";
            risultatoPartita(false, partitaPanel.getNomegiocatore().getText(), frase);
        } else {
            frase =  "Ha vinto " + partitaPanel.getNomegiocatore().getText() + " con " + min + " punti";
            risultatoPartita(true, partitaPanel.getNomegiocatore().getText(), frase);
        }
        vaiMenu();
    }

    /**
     * metodo che lancia il joptionpane alla fine della partita con un messaggio che include il verdetto
     * @param b booleano che indica se il giocatore ha vinto o meno la partita
     * @param giocatore nome del giocatore
     * @param frase stringa che comunica il verdetto finale
     */
    public void risultatoPartita(boolean b, String giocatore, String frase) {
        if (!b) {
            musicObjectBot.playButtonMusic("./src/audio/defeat_audio.wav");
            JOptionPane.showMessageDialog(null, "" + frase);
        } else {
            musicObjectBot.playButtonMusic("./src/audio/victory_audio.wav");
            JOptionPane.showMessageDialog(null, "" + frase);
        }
        
        Database db2 = Database.getInstance();
        db2.updateDatabase(giocatore, b);
        
        Profilo profilo = db2.cercaProfilo(giocatore);
        profiloPanel.printProfilo(profilo);
    }
    
    public void vaiMenu() {
    	this.cardLayout.show(parent, "inizio2");
    }

    /**
     * setter di gridatoUno
     * @param x booleano che indica se è stato gridato uno
     */
    public void setGridatoUno(boolean x) {
        gridatoUno = x;
    }

    /**
     * getter di cartaScarto
     * @return cartaScarto
     */
    public Carta getCartaScarto() {
        return cartaScarto;
    }

    /**
     * setter del colore della carta scarto
     * @param c intero che rappresenta il colore scelto
     */
    public void setCartaScarto(int c) {
        this.cartaScarto.setC(c);
    }

    /**
     * getter di turno
     * @return intero che rappresenta il giocatore di turno
     */
    public int getTurno() {
        return turno;
    }

    /**
     * setter di turno
     * @param turno intero che rappresenta il giocatore di turno
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }
}
