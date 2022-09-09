package view;

import model.*;
import javax.swing.*;
import controller.Eventi;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import static view.ProfiloPanel.immagine;
import static view.ProfiloPanel.nome;

public class PartitaPanel extends JPanel {
     
    /**
     * Timer che gestisce la cadenza dei turni di gioco
     */
    public static Timer t;
    /**
     * intero che determina la modalita di gioco
     */
    private int mod;
    /**
     * JLabel che rappresentano gli avatar dei giocatori
     */
    private JLabel foto, foto1, foto2, foto3;
    /**
     * JLabel che rappresenta il nome del giocatore
     */
    private JLabel nomegiocatore;
    /**
     * JButton che il giocatore deve cliccare quando rimane con una sola carta
     */
    private JButton uno;
    /**
     * JButton che conterrà la rappresentazione grafica della carta scartata
     */
    private JButton scartoButton ;
    /**
     * JButton che permette al giocatore di passare il turno
     */
    private JButton passo;
    /**
     * JButton che rappresentano i quattro colori tra i quali il giocatore deve scegliere quando tira una carta cambio colore
     */
    private JButton coloreRosso, coloreGiallo, coloreVerde, coloreBlu;
    /**
     * ArrayList di JButton composto dalle carte cliccabili in mano al giocatore
     */
    private ArrayList<JButton> posti;
    /**
     * mazzo dal quale vengono generate tutte le carte della partita
     */
    private Mazzo mazzo; 
    /**
     * mani di tutti e quattro i giocatori, di tipo Mano
     */
    private Mano manoOvest, manoNord, manoEst, mano;
    /**
     * Carta che rappresenta l'ultima carta scartata posizionata vicino al mazzo
     */
    private Carta cartaScarto;
    /**
     * panel della schermata della partita
     */
    private PiattoPanel tavolo;
    /**
     * istanza di partitaPanel
     */
    public PartitaPanel partitaPanel;
    /**
     * GridBagConstraints della schermata della partita
     */
    private GridBagConstraints gbc10;
    /**
     * panels che rappresentano le postazioni dei rispettivi giocatori
     */
    private PostazionePanel postazione, postazioneNord, postazioneOvest, postazioneEst;
    /**
     * panel che rappresenta la postazione delle carte centrali del gioco, mazzo e carta scarto
     */
    private PostazionePanel postazionePiatto;

    /**
     * costruttore che prende in input la modalita della partita e posiziona tutti gli elementi grafici sul JPanel
     * @param x intero che rappresenta la modalita della partita selezionata
     */
    public PartitaPanel(int x) {
        setLayout(new BorderLayout());
        mazzo = new Mazzo();
        do
            setCartaScarto(mazzo.next());
        while (getCartaScarto().getV() > 12);
        coloreRosso = new JButton();
        coloreGiallo = new JButton();
        coloreVerde = new JButton();
        coloreBlu = new JButton();
        posti = new ArrayList<>();
        manoOvest = new Mano(mazzo);
        manoNord = new Mano(mazzo);
        manoEst = new Mano(mazzo);
        mano = new Mano(mazzo);
        partitaPanel = this;
        tavolo = new PiattoPanel();
        partitaPanel.coloreRosso.setEnabled(true);
        partitaPanel.coloreGiallo.setEnabled(true);
        partitaPanel.coloreVerde.setEnabled(true);
        partitaPanel.coloreBlu.setEnabled(true);
        JLabel redLabel = new JLabel(new ImageIcon("./src/immagini/0.png"));
        JLabel yellowLabel = new JLabel(new ImageIcon("./src/immagini/1.png"));
        JLabel blueLabel = new JLabel(new ImageIcon("./src/immagini/2.png"));
        JLabel greenLabel = new JLabel(new ImageIcon("./src/immagini/3.png"));
        JLabel deckLabel = new JLabel(new ImageIcon("./src/immagini/mazzo.png"));
        setScartoButton(new JButton());
        passo = new JButton("PASSO");
        setPostazione(new PostazionePanel(1));
        mod = x;
        for (int i = 0; i < 30; i++)
            getPosti().add(new JButton());
        coloreRosso.add(redLabel);
        coloreRosso.setBorder(null);
        coloreGiallo.add(yellowLabel);
        coloreGiallo.setBorder(null);
        coloreBlu.add(blueLabel);
        coloreBlu.setBorder(null);
        coloreVerde.add(greenLabel);
        coloreVerde.setBorder(null);
        JButton deckButton = new JButton();
        deckButton.setBorder(null);
        deckButton.setHorizontalTextPosition(SwingConstants.CENTER);
        deckButton.add(deckLabel);
        postazionePiatto = new PostazionePanel(1);
        PostazionePanel postazioneColori = new PostazionePanel(1);
        getPostazione().setBackground(null);
        getPostazione().setOpaque(false);
        for (int i = 0; i < 30; i++)
            getPosti().add(new JButton());
        ImageIcon avatar1png = new ImageIcon("./src/immagini/Bulbasaur.png");
        Image image1 = avatar1png.getImage();
        Image newimg1 = image1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar1png = new ImageIcon(newimg1);
        ImageIcon avatar2png = new ImageIcon("./src/immagini/Charmander.png");
        Image image2 = avatar2png.getImage();
        Image newimg2 = image2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar2png = new ImageIcon(newimg2);
        ImageIcon avatar3png = new ImageIcon("./src/immagini/Squirtle.png");
        Image image3 = avatar3png.getImage();
        Image newimg3 = image3.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar3png = new ImageIcon(newimg3);
        ImageIcon avatar4png = new ImageIcon(immagine);
        Image image4 = avatar4png.getImage();
        Image newimg4 = image4.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar4png = new ImageIcon(newimg4);
        setScartoButton(DisegnaCarta.disegnaCarta(getCartaScarto()));
        for (int i = 0;i < mano.mano.size(); i++)
            getPosti().set(i, DisegnaCarta.disegnaCarta(mano.mano.get(i)));
        for (int i = 0; i < mano.mano.size(); i++)
            getPostazione().add(getPosti().get(i));
        postazioneOvest = new PostazionePanel(0);
        postazioneEst = new PostazionePanel(0);
        postazioneEst.setBackground(null);
        postazioneEst.setOpaque(false);
        postazioneOvest.setBackground(null);
        postazioneOvest.setOpaque(false);
        postazioneNord = new PostazionePanel(1);
        postazioneNord.add(new JLabel(new ImageIcon("./src/immagini/dorsonord7.png")));
        postazioneNord.setOpaque(false);
        setFoto(new JLabel(avatar1png));
        setFoto1(new JLabel(avatar2png));
        setFoto2(new JLabel(avatar3png));
        setFoto3(new JLabel(avatar4png));
        setNomegiocatore(new JLabel(nome));
        gbc10 = new GridBagConstraints();
        this.add(tavolo, BorderLayout.CENTER);
        uno = new JButton("UNO!");
        if (x != 2) gbc10.anchor = GridBagConstraints.CENTER;
        else gbc10.anchor = GridBagConstraints.LINE_START;
        gbc10.gridx = 6;
        gbc10.gridy = 0;
        gbc10.weightx = 0;
        gbc10.weighty = 0;
        gbc10.gridwidth = 3;
        tavolo.add(getFoto1(),gbc10);
        if (x != 2) gbc10.gridx = 4;
        else gbc10.gridx = 3;
        gbc10.gridy = 0;
        gbc10.weightx = 0;
        gbc10.weighty = 0;
        gbc10.gridwidth = 3;
        tavolo.add(postazioneNord,gbc10);
        gbc10.anchor=GridBagConstraints.LINE_END;
        gbc10.gridx = 3;
        gbc10.gridy = 7;
        gbc10.weightx = 0.0;
        gbc10.weighty = 1;
        gbc10.gridwidth = 1;
        tavolo.add(uno,gbc10);
        gbc10.anchor = GridBagConstraints.LINE_START;
        gbc10.gridx = 4;
        gbc10.gridy = 7;
        gbc10.weightx = 0;
        gbc10.weighty = 0;
        gbc10.gridwidth = 1;
        tavolo.add(passo,gbc10);
        gbc10.anchor = GridBagConstraints.LINE_START;
        gbc10.gridx = 6;
        gbc10.gridy = 7;
        gbc10.weightx = 0;
        gbc10.weighty = 0;
        gbc10.gridwidth = 1;
        tavolo.add(getNomegiocatore(),gbc10);
        nomegiocatore.setFont(new Font("Dialog", Font.PLAIN, 20));
        nomegiocatore.setForeground(Color.green);
        gbc10.anchor = GridBagConstraints.LINE_START;
        gbc10.gridx = 6;
        gbc10.gridy = 6;
        gbc10.weightx = 0;
        gbc10.weighty = 0;
        gbc10.gridwidth = 1;
        tavolo.add(getFoto3(),gbc10);
        gbc10.anchor = GridBagConstraints.LINE_START;
        gbc10.gridx = 0;
        gbc10.gridy = 0;
        gbc10.weighty = 1;
        gbc10.weightx = 0;
        gbc10.gridwidth = 3;
        gbc10.gridheight = 1;
        postazioneColori.setBackground(null);
        postazioneColori.setOpaque(false);
        postazioneColori.add(getColoreRosso());
        postazioneColori.add((getColoreGiallo()));
        postazioneColori.add((getColoreVerde()));
        postazioneColori.add((getColoreBlu()));
        gbc10.anchor = GridBagConstraints.LINE_START;
        tavolo.add(postazioneColori,gbc10);
        postazionePiatto.add(deckLabel);
        postazionePiatto.add(getScartoButton());
        postazionePiatto.setOpaque(false);
        deckButton.setBorder(null);
        gbc10.anchor = GridBagConstraints.CENTER;
        if (x != 2) gbc10.gridx = 4;
        else gbc10.gridx = 3;
        gbc10.gridy = 5;
        gbc10.weighty = 4;
        tavolo.add(getPostazione(),gbc10);
        if (x != 2) gbc10.gridx = 5;
        else gbc10.gridx = 4;
        gbc10.gridy = 4;
        gbc10.weighty = 1;
        gbc10.weightx = 0;
        gbc10.gridwidth = 1;
        tavolo.add(postazionePiatto,gbc10);
        gbc10.gridx = 0;
        gbc10.gridy = 4;
        gbc10.weighty = 0;
        gbc10.weightx = 0;
        if (x != 2) tavolo.add(getFoto(),gbc10);
        gbc10.gridx = 1;
        gbc10.gridy = 4;
        gbc10.weighty = 1;
        gbc10.weightx = 1;
        gbc10.gridwidth = 3;
        if (x != 2) {
            tavolo.add(postazioneOvest,gbc10);
            postazioneOvest.add((new JLabel(new ImageIcon("./src/immagini/dorsosx7.png"))),gbc10);
        }
        gbc10.gridx = 7;
        gbc10.gridy = 4;
        gbc10.weighty = 1;
        gbc10.weightx = 1;
        gbc10.gridwidth = 3;
        if (x != 2) {
            tavolo.add(postazioneEst,gbc10);
            postazioneEst.add((new JLabel(new ImageIcon("./src/immagini/dorsodx7.png"))),gbc10);
        }
        gbc10.gridx = 10;
        gbc10.gridy = 4;
        gbc10.weighty = 1;
        gbc10.weightx = 0;
        gbc10.gridwidth = 1;
        if (x != 2) tavolo.add(getFoto2(),gbc10);
        gbc10.anchor = GridBagConstraints.PAGE_START;
        gbc10.gridx = 4;
        gbc10.gridy = 6;
        gbc10.weighty = 2;
        Eventi eventi = new Eventi(partitaPanel);
        passo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.start();
                eventi.passo();
            }
        });

        uno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventi.setGridatoUno(true);
            }
        });

        coloreRosso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventi.setCartaScarto(0);
            }
        });

        coloreGiallo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventi.setCartaScarto(1);
            }
        });

        coloreBlu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventi.setCartaScarto(2);
            }
        });

        coloreVerde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventi.setCartaScarto(3);
            }
        });

        for (JButton posto : getPosti()) {
            posto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    repaint();
                    t.start();
                    eventi.cliccato(gbc10, mano, getPostazione().getComponentZOrder(posto), posto, getPostazione(), getTavolo(), manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, getPosti(), mazzo, postazionePiatto);
                }
            });
            posto.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    posto.setLocation(posto.getX(), posto.getY() - 5);
                }
                public void mouseExited(MouseEvent evt) {
                    posto.setLocation(posto.getX(), posto.getY() + 5);
                }
            });
            ActionListener avanti = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    repaint();
                    eventi.avanti(gbc10, eventi.getTurno(), manoOvest, manoNord, manoEst, tavolo, postazioneOvest, postazioneNord, postazioneEst, mazzo, getPostazione(), mano,postazionePiatto);
                }
            };
            t = new Timer(6000, avanti);
        }
    }

    /**
     * getter della modalita di gioco
     * @return intero che rappresenta la modalita di gioco
     */
    public int getMod() {
        return mod;
    }

    /**
     * getter immagine giocatore
     * @return Jlabel che rappresenta l'immagine del giocatore
     */
    public JLabel getFoto() {
        return foto;
    }
    /**
     * setter immagine giocatore
     */
    public void setFoto(JLabel foto) {
        this.foto = foto;
    }
    /**
     * getter immagine giocatore
     * @return Jlabel che rappresenta l'immagine del giocatore
     */
    public JLabel getFoto1() {
        return foto1;
    }
    /**
     * setter immagine giocatore
     */
    public void setFoto1(JLabel foto1) {
        this.foto1 = foto1;
    }
    /**
     * getter immagine giocatore
     */
    public JLabel getFoto2() {
        return foto2;
    }
    /**
     * setter immagine giocatore
     */
    public void setFoto2(JLabel foto2) {
        this.foto2 = foto2;
    }
    /**
     * getter immagine giocatore
     * @return Jlabel che rappresenta l'immagine del giocatore
     */
    public JLabel getFoto3() {
        return foto3;
    }
    /**
     * setter immagine giocatore
     */
    public void setFoto3(JLabel foto3) {
        this.foto3 = foto3;
    }
    
    /**
     * getter nome giocatore
     * @return JLabel del nome del giocatore
     */
    public JLabel getNomegiocatore() {
        return nomegiocatore;
    }

    /**
     * setter nomegiocatore
     * @param nomegiocatore
     */
    public void setNomegiocatore(JLabel nomegiocatore) {
        this.nomegiocatore = nomegiocatore;
    }

    /**
     * getter del bottone che rappresenta la carta scartata
     * @return JButton scartoButton
     */
    public JButton getScartoButton() {
        return scartoButton;
    }

    /**
     * setter del bottone che rappresenta la carta scartata
     * @param scartoButton
     */
    public void setScartoButton(JButton scartoButton) {
        this.scartoButton = scartoButton;
    }

    /**
     * getter dei JButton che rappresentano i quattro colori tra i quali il giocatore deve scegliere quando tira una carta cambio colore
     * @return JButton coloreRosso
     */
    public JButton getColoreRosso() {
        return coloreRosso;
    }

    /**
     * getter dei JButton che rappresentano i quattro colori tra i quali il giocatore deve scegliere quando tira una carta cambio colore
     * @return JButton coloreGiallo
     */
    public JButton getColoreGiallo() {
        return coloreGiallo;
    }

    /**
     * getter dei JButton che rappresentano i quattro colori tra i quali il giocatore deve scegliere quando tira una carta cambio colore
     * @return JButton coloreVerde
     */
    public JButton getColoreVerde() {
        return coloreVerde;
    }

    /**
     * getter dei JButton che rappresentano i quattro colori tra i quali il giocatore deve scegliere quando tira una carta cambio colore
     * @return JButton coloreBlu
     */
    public JButton getColoreBlu() {
        return coloreBlu;
    }
    
    /**
     * getter dell'arrayList posti
     * @return posti
     */
    public ArrayList<JButton> getPosti() {
        return posti;
    }
    
    /**
     * getter postazione 
     * @return postazione
     */
    public PostazionePanel getPostazione() {
        return postazione;
    }

    /**
     * setter  postazione
     * @param postazione
     */
    public void setPostazione(PostazionePanel postazione) {
        this.postazione = postazione;
    }
    
    /**
     * getter tavolo
     * @return tavolo
     */
    public PiattoPanel getTavolo() {
        return tavolo;
    }

    /**
     * getter cartaScarto
     * @return cartaScarto
     */
    public Carta getCartaScarto() {
        return cartaScarto;
    }

    /**
     * setter cartaScarto
     * @param cartaScarto la carta scartata vicino al mazzo
     */
    public void setCartaScarto(Carta cartaScarto) {
        this.cartaScarto = cartaScarto;
    }
}
