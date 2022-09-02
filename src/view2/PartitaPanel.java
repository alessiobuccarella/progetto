package view2;

import controller.DisegnaCarta;
import controller.Eventi;
import model.Carta;
import model.Mano;
import model.Mazzo;
import view.Campo;
import view.Piatto;
import view.Postazione;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class PartitaPanel extends JPanel {
	private boolean firstTime = true;
	private int turno;
	private Carta cartaScarto = new Carta(0, 0);
    public PartitaPanel(){
        JLabel redLabel = new JLabel(new ImageIcon("./src/immagini/0.png"));
        JLabel yellowLabel = new JLabel(new ImageIcon("./src/immagini/1.png"));
        JLabel blueLabel = new JLabel(new ImageIcon("./src/immagini/2.png"));
        JLabel greenLabel = new JLabel(new ImageIcon("./src/immagini/3.png"));
        JLabel deckLabel = new JLabel(new ImageIcon("./src/immagini/mazzo.png"));
        JButton coloreRosso = new JButton();
        coloreRosso.add(redLabel);
        coloreRosso.setBorder(null);
        JButton coloreGiallo = new JButton();
        coloreGiallo.add(yellowLabel);
        coloreGiallo.setBorder(null);
        JButton coloreBlu = new JButton();
        coloreBlu.add(blueLabel);
        coloreBlu.setBorder(null);
        JButton coloreVerde = new JButton();
        coloreVerde.add(greenLabel);
        coloreVerde.setBorder(null);
        JButton deckButton = new JButton();
        deckButton.setBorder(null);
        deckButton.setHorizontalTextPosition(SwingConstants.CENTER);
        deckButton.add(deckLabel);
        Campo campo = new Campo();
        Postazione postazione = new Postazione(1);
        Postazione postazionePiatto = new Postazione(1);
        Postazione postazioneColori = new Postazione(1);
        postazione.setBackground(null);
        postazione.setOpaque(false);
        Mazzo mazzo = new Mazzo();
        Mano mano = new Mano(mazzo);
        Mano manoOvest = new Mano(mazzo);
        Mano manoNord = new Mano(mazzo);
        Mano manoEst = new Mano(mazzo);
        ArrayList<JButton> posti = new ArrayList<>();
        for (int i=0;i<30;i++)posti.add(new JButton());
        ImageIcon avatar1png = new ImageIcon("./src/immagini/avatar1.png");
        ImageIcon avatar2png = new ImageIcon("./src/immagini/avatar1.png");
        ImageIcon avatar3png = new ImageIcon("./src/immagini/avatar1.png");
        JButton scartoButton = new JButton();
        
        for (int i=0;i<mano.mano.size();i++)
            posti.set(i, DisegnaCarta.disegnaCarta(mano.mano.get(i)));
        for (int i=0;i<mano.mano.size();i++)
            postazione.add(posti.get(i));
        Postazione postazioneOvest = new Postazione(0);
        Postazione postazioneEst = new Postazione(0);
    
        postazioneEst.setBackground(null);
        postazioneEst.setOpaque(false);
        postazioneOvest.setBackground(null);
        postazioneOvest.setOpaque(false);
        Postazione postazioneNord = new Postazione(1);
        postazioneNord.add(new JLabel(new ImageIcon("./src/immagini/dorsonord7.png")));
        postazioneNord.setOpaque(false);
        Piatto tavolo = new Piatto();

        JLabel foto = new JLabel(avatar1png);
        JLabel foto1 = new JLabel(avatar2png);
        JLabel foto2 = new JLabel(avatar3png);

        GridBagConstraints gbc10= new GridBagConstraints();
        campo.add(tavolo, BorderLayout.CENTER);
        JButton uno= new JButton("UNO!");
        JButton passo = new JButton("PASSO");

        gbc10.anchor=GridBagConstraints.PAGE_START;
        gbc10.gridx=5;
        gbc10.gridy=0;
        gbc10.weightx=0.0;
        gbc10.weighty=0;
        gbc10.gridwidth=3;
        tavolo.add(foto1,gbc10);
        gbc10.gridx=5;
        gbc10.gridy=2;
        gbc10.weightx=0.0;
        gbc10.weighty=0;
        gbc10.gridwidth=3;
        tavolo.add(postazioneNord,gbc10);
        gbc10.anchor=GridBagConstraints.LINE_END;
        gbc10.gridx=2;
        gbc10.gridy=7;
        gbc10.weightx=0.0;
        gbc10.weighty=1;
        gbc10.gridwidth=1;
        tavolo.add(uno,gbc10);
        gbc10.anchor=GridBagConstraints.LINE_START;
        gbc10.gridx=4;
        gbc10.gridy=7;
        gbc10.weightx=0;
        gbc10.weighty=0;
        gbc10.gridwidth=1;
        tavolo.add(passo,gbc10);
        gbc10.anchor=GridBagConstraints.CENTER;
        gbc10.gridx=0;
        gbc10.gridy=0;
        gbc10.weighty=1;
        gbc10.weightx=0;
        gbc10.gridwidth=3;
        gbc10.gridheight=1;
        postazioneColori.setBackground(null);
        postazioneColori.setOpaque(false);
        postazioneColori.add(coloreRosso);
        postazioneColori.add((coloreGiallo));
        postazioneColori.add((coloreVerde));
        postazioneColori.add((coloreBlu));
        gbc10.anchor=GridBagConstraints.LINE_START;tavolo.add(postazioneColori,gbc10);
        postazionePiatto.add(deckLabel);
        postazionePiatto.add(scartoButton);
        postazionePiatto.setOpaque(false);
        deckButton.setBorder(null);
        gbc10.gridx=5;
        gbc10.gridy=4;
        gbc10.weighty=1;
        gbc10.weightx=0;
        gbc10.gridwidth=1;
        tavolo.add(postazionePiatto,gbc10);
        //////////////////////////////////////////////////// sinistra
        gbc10.gridx=0;
        gbc10.gridy=4;
        gbc10.weighty=0;
        gbc10.weightx=0;
        tavolo.add(foto,gbc10);
        gbc10.gridx=2;
        gbc10.gridy=4;
        gbc10.weighty=1;
        gbc10.weightx=1;
        gbc10.gridwidth=3;
        tavolo.add(postazioneOvest,gbc10);
        postazioneOvest.add((new JLabel(new ImageIcon("./src/immagini/dorsosx7.png"))),gbc10);
        ///////////////////////////////////////////////////////destra
        gbc10.gridx=6;
        gbc10.gridy=4;
        gbc10.weighty=1;
        gbc10.weightx=1;
        gbc10.gridwidth=3;
        tavolo.add(postazioneEst,gbc10);
        postazioneEst.add((new JLabel(new ImageIcon("./src/immagini/dorsodx7.png"))),gbc10);
        gbc10.gridx=9;
        gbc10.gridy=4;
        gbc10.weighty=1;
        gbc10.weightx=0;
        gbc10.gridwidth=1;
        tavolo.add(foto2,gbc10);
        gbc10.anchor=GridBagConstraints.PAGE_START;
        gbc10.gridx=5;
        gbc10.gridy=5;
        gbc10.weighty=2;
        tavolo.add(postazione,gbc10);
        
        
        ActionListener avanti = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
                if (firstTime == false)
                    Eventi.avanti(gbc10, turno, manoOvest, manoNord, manoEst, tavolo, postazioneOvest, postazioneNord, postazioneEst, mazzo, postazione, mano,postazionePiatto);
                else {
                    firstTime = false;
                }
            }
        };
        Timer t = new Timer(3000, avanti);
        passo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
            	
                repaint();
                t.start();
                Eventi.passo(gbc10, mano, 0, null, postazione, tavolo, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, mazzo,postazionePiatto);
            }
        });
        coloreRosso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              cartaScarto.setC(0);
              Eventi.passo(gbc10, mano, 0, null, postazione, tavolo, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, mazzo,postazionePiatto);
              
            }
        });
        coloreGiallo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              cartaScarto.setC(1);
              Eventi.passo(gbc10, mano, 0, null, postazione, tavolo, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, mazzo,postazionePiatto);
              
            }
        });
        coloreVerde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              cartaScarto.setC(2);
              Eventi.passo(gbc10, mano, 0, null, postazione, tavolo, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, mazzo,postazionePiatto);
              
            }
        });
        coloreBlu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              cartaScarto.setC(3);
              Eventi.passo(gbc10, mano, 0, null, postazione, tavolo, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, mazzo,postazionePiatto);
              
            }
        });
        for (JButton posto : posti) {
            posto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    repaint();
                    	t.start();
                    	Eventi.cliccato(gbc10, mano, postazione.getComponentZOrder(posto), posto, postazione, tavolo, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, posti, mazzo,postazionePiatto);
                    	if (cartaScarto.getC()==4)
                            t.stop();
                    }
            }); 
            posto.addMouseListener(new MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    posto.setLocation(posto.getX(), posto.getY()-5);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    posto.setLocation(posto.getX(), posto.getY()+5);
                }
            });
        }
        
    }
    
}
