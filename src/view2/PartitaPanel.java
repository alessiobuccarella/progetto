package view2;

import model.*;
import javax.swing.*;

import controller.Eventi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PartitaPanel extends JPanel {

	Mazzo mazzo = new Mazzo();
	private Postazione postazioneNord;
	private Postazione postazioneOvest;
	private Postazione postazioneEst;
	private Postazione postazionePiatto;
	private Mano manoOvest;
	private Mano manoNord;
	private Mano manoEst;
	private Mano mano;
	private GridBagConstraints gbc10;
	private JButton passo;
	private Timer t;
	private JLabel foto;
	private JLabel foto1;
	private JLabel foto2;
	private JLabel foto3;
	private ArrayList<JButton> posti = new ArrayList<>();
	private Piatto tavolo;
	private Postazione postazione;
	private int turno;
	private Carta cartaScarto = new Carta(0, 0);
	private Icon redLabel = new ImageIcon("./src/immagini/0.png");
	private Icon yellowLabel = new ImageIcon("./src/immagini/1.png");
	private Icon blueLabel = new ImageIcon("./src/immagini/2.png");
	private Icon greenLabel = new ImageIcon("./src/immagini/3.png");
	private JButton uno;
	private JButton scartoButton ;
	private JButton coloreRosso = new JButton();
	private JButton coloreGiallo = new JButton();
	private JButton coloreVerde = new JButton();
	private JButton coloreBlu = new JButton();

	public PartitaPanel(int x) {
    	setLayout(new BorderLayout());
    	do
            cartaScarto=mazzo.next();
        while (cartaScarto.getV() > 12);
    	manoOvest = new Mano(mazzo);
    	manoNord = new Mano(mazzo);
    	manoEst = new Mano(mazzo);
    	mano = new Mano(mazzo);
    	
        JLabel redLabel = new JLabel(new ImageIcon("./src/immagini/0.png"));
        JLabel yellowLabel = new JLabel(new ImageIcon("./src/immagini/1.png"));
        JLabel blueLabel = new JLabel(new ImageIcon("./src/immagini/2.png"));
        JLabel greenLabel = new JLabel(new ImageIcon("./src/immagini/3.png"));
        JLabel deckLabel = new JLabel(new ImageIcon("./src/immagini/mazzo.png"));
        scartoButton = new JButton();
        passo= new JButton("PASSO");
        postazione = new Postazione(1);
        
        for (int i = 0; i < 30; i++)
            posti.add(new JButton());
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
        postazionePiatto = new Postazione(1);
        Postazione postazioneColori = new Postazione(1);
        postazione.setBackground(null);
        postazione.setOpaque(false);
        for (int i = 0; i < 30; i++)
            posti.add(new JButton());
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
        /*ImageIcon avatar4png = new ImageIcon(profilo.getAvatarImg());
        Image image4 = avatar4png.getImage();
        Image newimg4 = image4.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar4png = new ImageIcon(newimg4);
        System.out.println(profilo.getAvatarImg());*/
        scartoButton = DisegnaCarta.disegnaCarta(cartaScarto);
        for (int i = 0;i < mano.mano.size(); i++)
            posti.set(i, DisegnaCarta.disegnaCarta(mano.mano.get(i)));
        for (int i = 0; i < mano.mano.size(); i++)
            postazione.add(posti.get(i));
        postazioneOvest = new Postazione(0);
        postazioneEst = new Postazione(0);
        postazioneEst.setBackground(null);
        postazioneEst.setOpaque(false);
        postazioneOvest.setBackground(null);
        postazioneOvest.setOpaque(false);
        postazioneNord = new Postazione(1);
        postazioneNord.add(new JLabel(new ImageIcon("./src/immagini/dorsonord7.png")));
        postazioneNord.setOpaque(false);
        tavolo = new Piatto();
        foto = new JLabel(avatar1png);
        foto1 = new JLabel(avatar2png);
        foto2 = new JLabel(avatar3png);
        //foto3 = new JLabel(avatar4png);
        gbc10 = new GridBagConstraints();
        this.add(tavolo, BorderLayout.CENTER);
        uno= new JButton("UNO!");
        if (x==1)gbc10.anchor = GridBagConstraints.CENTER;
        else gbc10.anchor = GridBagConstraints.LINE_START;
        gbc10.gridx = 6;
        gbc10.gridy = 0;
        gbc10.weightx = 0;
        gbc10.weighty = 0;
        gbc10.gridwidth = 3;
        tavolo.add(foto1,gbc10);
        if (x==1)gbc10.gridx = 4;
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
        gbc10.gridx = 5;
        gbc10.gridy = 7;
        gbc10.weightx = 0;
        gbc10.weighty = 0;
        gbc10.gridwidth = 1;
        //tavolo.add(foto3,gbc10);
        gbc10.anchor = GridBagConstraints.LINE_START;
        gbc10.gridx = 0;
        gbc10.gridy = 0;
        gbc10.weighty = 1;
        gbc10.weightx = 0;
        gbc10.gridwidth = 3;
        gbc10.gridheight = 1;
        postazioneColori.setBackground(null);
        postazioneColori.setOpaque(false);
        postazioneColori.add(coloreRosso);
        postazioneColori.add((coloreGiallo));
        postazioneColori.add((coloreVerde));
        postazioneColori.add((coloreBlu));
        gbc10.anchor = GridBagConstraints.LINE_START;
        tavolo.add(postazioneColori,gbc10);
        postazionePiatto.add(deckLabel);
        postazionePiatto.add(scartoButton);
        postazionePiatto.setOpaque(false);
        deckButton.setBorder(null);
        
        gbc10.anchor = GridBagConstraints.CENTER;
        if (x==1) gbc10.gridx = 4;
        else gbc10.gridx = 3;
        gbc10.gridy = 5;
        
        gbc10.weighty = 4;
        tavolo.add(postazione,gbc10);
        if (x==1)gbc10.gridx = 5;
        else gbc10.gridx = 4;
        gbc10.gridy = 4;
        gbc10.weighty = 1;
        gbc10.weightx = 0;
        gbc10.gridwidth = 1;
        tavolo.add(postazionePiatto,gbc10);
        //////////////////////////////////////////////////// sinistra
        gbc10.gridx = 0;
        gbc10.gridy = 4;
        gbc10.weighty = 0;
        gbc10.weightx = 0;
        if (x==1) {
        	tavolo.add(foto,gbc10);
        }
        gbc10.gridx = 1;
        gbc10.gridy = 4;
        gbc10.weighty = 1;
        gbc10.weightx = 1;
        gbc10.gridwidth = 3;
        if (x==1) {
        	tavolo.add(postazioneOvest,gbc10);
        	postazioneOvest.add((new JLabel(new ImageIcon("./src/immagini/dorsosx7.png"))),gbc10);
        }
        ///////////////////////////////////////////////////////destra
        gbc10.gridx = 7;
        gbc10.gridy = 4;
        gbc10.weighty = 1;
        gbc10.weightx = 1;
        gbc10.gridwidth = 3;
        if (x==1) {
        	tavolo.add(postazioneEst,gbc10);
        	postazioneEst.add((new JLabel(new ImageIcon("./src/immagini/dorsodx7.png"))),gbc10);
        }
        gbc10.gridx = 10;
        gbc10.gridy = 4;
        gbc10.weighty = 1;
        gbc10.weightx = 0;
        gbc10.gridwidth = 1;
        if (x==1) {
        	tavolo.add(foto2,gbc10);
        }
        gbc10.anchor = GridBagConstraints.PAGE_START;
        gbc10.gridx = 4;
        gbc10.gridy = 6;
        gbc10.weighty = 2;
        //tavolo.add(xxxxxx,gbc10);
     
        /*
        passo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
                t.start();
                Eventi.passo(gbc10, mano, 0, null, postazione, tavolo, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, mazzo,postazionePiatto);
            }
        });
        */
        
        for (JButton posto : posti) {
        	
            posto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    repaint();
                    	t.start();
                    	
						eventi.cliccato(gbc10, mano, postazione.getComponentZOrder(posto), posto, postazione, tavolo, manoOvest, manoNord,
								manoEst, postazioneOvest, postazioneNord, postazioneEst, posti, mazzo, postazionePiatto);
                    	//if (cartaScarto.getC()==4)
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
                    Eventi eventi = new Eventi();
                    eventi.avanti(gbc10, turno, manoOvest, manoNord, manoEst, tavolo, postazioneOvest, postazioneNord, postazioneEst, mazzo, postazione, mano,postazionePiatto);
                }
            };
            t = new Timer(3000, avanti);
            t.start();
        }
    }

    public JLabel getFoto(int foto) {
        switch(foto) {
            case 1:
                return foto1;
            case 2:
                return foto2;
            case 3:
                return foto3;
            default:
                return this.foto;
        }
    }

    public  void aggiornaPostazione(Mano mano) {
        postazione.removeAll();
        for (int i = 0; i < mano.mano.size(); i++)
            posti.set(i, DisegnaCarta.disegnaCarta(mano.mano.get(i)));
        for (int i = 0; i < mano.mano.size(); i++)
            postazione.add(posti.get(i));
        postazione.invalidate();
        postazione.validate();
        postazione.repaint();
    }

    public void funzioneUno(ActionListener actionListener) {
        uno.addActionListener(actionListener);
    }

    public void funzionePasso(ActionListener actionListener) {
        passo.addActionListener(actionListener);
    }

    public void funzioneRosso(ActionListener actionListener) {
        coloreRosso.addActionListener(actionListener);
    }

    public void funzioneGiallo(ActionListener actionListener) {
        coloreGiallo.addActionListener(actionListener);
    }

    public void funzioneVerde(ActionListener actionListener) {
        coloreVerde.addActionListener(actionListener);
    }

    public void funzioneBlu(ActionListener actionListener) {
        coloreBlu.addActionListener(actionListener);
    }
}
