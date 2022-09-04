package view2;

import controller.DisegnaCarta;
import controller.Eventi;
import model.Carta;
import model.Database;
import model.Mano;
import model.Mazzo;
import model.Senso;
import view.Campo;
import view.Menu;
import view.Piatto;
import view.Postazione;
import javax.swing.*;

import static view.Menu.nomeutente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class PartitaPanel extends JPanel {
	Mazzo mazzo = new Mazzo();
	private boolean firstTime = true;
	private static int turno;
	private static Carta cartaScarto = new Carta(0, 0);
	static Icon redLabel = new ImageIcon("./src/immagini/0.png");
	static Icon yellowLabel = new ImageIcon("./src/immagini/1.png");
	static Icon blueLabel = new ImageIcon("./src/immagini/2.png");
	static Icon greenLabel = new ImageIcon("./src/immagini/3.png");
	static JButton scartoButton = new JButton();
    public PartitaPanel(){
    	setLayout(new BorderLayout());
    	do cartaScarto=mazzo.next(); while(cartaScarto.getV()>12);
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
        Postazione postazione = new Postazione(1);
        Postazione postazionePiatto = new Postazione(1);
        Postazione postazioneColori = new Postazione(1);
        postazione.setBackground(null);
        postazione.setOpaque(false);
        
        Mano mano = new Mano(mazzo);
        Mano manoOvest = new Mano(mazzo);
        Mano manoNord = new Mano(mazzo);
        Mano manoEst = new Mano(mazzo);
        ArrayList<JButton> posti = new ArrayList<>();
        for (int i=0;i<30;i++)posti.add(new JButton());
        ImageIcon avatar1png = new ImageIcon("./src/immagini/avatar1.png");
        avatar1png = new ImageIcon("./src/immagini/avatar1.png");
        Image image1 = avatar1png.getImage();
        Image newimg1 = image1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar1png = new ImageIcon(newimg1);
       
        ImageIcon avatar2png = new ImageIcon("./src/immagini/avatar1.png");
        avatar2png = new ImageIcon("./src/immagini/avatar2.png");
        Image image2 = avatar2png.getImage();
        Image newimg2 = image2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar2png = new ImageIcon(newimg2);
        
        ImageIcon avatar3png = new ImageIcon("./src/immagini/avatar1.png");
        avatar3png = new ImageIcon("./src/immagini/avatar3.png");
        Image image3 = avatar3png.getImage();
        Image newimg3 = image3.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar3png = new ImageIcon(newimg3);
        
        scartoButton = DisegnaCarta.disegnaCarta(cartaScarto);
        
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
        this.add(tavolo, BorderLayout.CENTER);
        JButton uno= new JButton("UNO!");
        JButton passo = new JButton("PASSO");

        gbc10.anchor=GridBagConstraints.PAGE_START;
        gbc10.gridx=4;
        gbc10.gridy=0;
        gbc10.weightx=0.7;
        gbc10.weighty=0;
        gbc10.gridwidth=3;
        tavolo.add(foto1,gbc10);
        gbc10.gridx=4;
        gbc10.gridy=1;
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
        gbc10.anchor=GridBagConstraints.PAGE_START;
        gbc10.gridx=4;
        gbc10.gridy=6;
        gbc10.weighty=2;
 ///////tavolo.add(xxxxxx,gbc10);
        
        
        ActionListener avanti = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                repaint();
                //if (firstTime == false)
                System.out.println("turno: "+turno);
                    Eventi.avanti(gbc10, turno, manoOvest, manoNord, manoEst, tavolo, postazioneOvest, postazioneNord, postazioneEst, mazzo, postazione, mano,postazionePiatto);
               // else {
                //    firstTime = false;
                //}
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
                    	cliccato(gbc10, mano, postazione.getComponentZOrder(posto), posto, postazione, tavolo,  manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, posti, mazzo,postazionePiatto);
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
    public static void cliccato(GridBagConstraints gbc10, Mano mano, int indiceCarta, JButton posto, Postazione postazione, Piatto piatto,  Mano manoOvest, Mano manoNord, Mano manoEst, Postazione postazioneOvest, Postazione postazioneNord, Postazione postazioneEst, ArrayList<JButton> posti, Mazzo mazzo, Postazione postazionePiatto) {
    	if (mano.mano.size()>1) Menu.deviGridareUno=false;
    	if (Menu.deviGridareUno==true&&Menu.gridatoUno==false) {
    		System.out.println("Penalità: non hai gridato 1!");
    		mano.mano.add(mazzo.pesca());
             posti.get(mano.mano.size() - 1).setBorder(null);
            mano.mano.add(mazzo.pesca());
           posti.get(mano.mano.size() - 1).setBorder(null);
    	}
    	if ((mano.mano.get(indiceCarta).getC() == cartaScarto.getC() || mano.mano.get(indiceCarta).getV() == cartaScarto.getV() || mano.mano.get(indiceCarta).getC() == 4)&&(Menu.turno%4==0)) {
    		System.out.println("ok");
    		cartaScarto=mano.mano.get(indiceCarta);postazionePiatto.remove(scartoButton);scartoButton=DisegnaCarta.disegnaCarta(cartaScarto);
    	    gbc10.anchor=GridBagConstraints.LINE_END;
            gbc10.weightx=0;
            gbc10.weighty=0;
            gbc10.gridx=7;
            gbc10.gridy=1;
            postazionePiatto.add(scartoButton);
    		piatto.invalidate();piatto.validate();piatto.repaint();
    		mano.mano.remove(indiceCarta);postazione.removeAll();/*Menu.posti.clear();*/postazione.invalidate();postazione.validate();
    		int count=0;
    		for (Carta x:mano.mano)
    		{
    			Icon immagine= new ImageIcon("./src/immagini/" + x.getV() + x.getC() + ".png");
    			posti.get(count).setIcon(immagine);posti.get(count).setBorder(null);
    			postazione.add(posti.get(count));
    			count++;
    		}
            postazione.invalidate();
            postazione.validate();
            if (cartaScarto.getV() == 11)
                Eventi.cambiaSenso();
            if (Menu.senso == Senso.ORARIO)
                turno = 1;
            if (Menu.senso == Senso.ANTIORARIO)
                turno = 3;
            if (cartaScarto.getV() == 10)
                turno = 2;
        }
            if (Menu.cartaScarto.getV() == 12) {
                Menu.firstTime = true;
                if (turno %4== 1) {
                    for (int i = 0; i < 2; i++)
                        manoOvest.mano.add(mazzo.pesca());
                    }
                    postazioneOvest.invalidate();
                    postazioneOvest.validate();
                } else {
                    for (int i = 0; i < 2; i++)
                        manoEst.mano.add(mazzo.pesca());
                    }
                    postazioneEst.invalidate();
                    postazioneEst.validate();
            if (Menu.cartaScarto.getV() == 13) {
                Menu.firstTime = true;
                Menu.rosso.setIcon(redLabel);Menu.giallo.setIcon(yellowLabel);Menu.verde.setIcon(greenLabel);Menu.blu.setIcon(blueLabel);
                Menu.rosso.setEnabled(true);Menu.giallo.setEnabled(true);Menu.verde.setEnabled(true);Menu.blu.setEnabled(true);
                Menu.postazioneColori.invalidate();
                Menu.postazioneColori.validate();
            }
            if (Menu.cartaScarto.getV() == 14) {
                Menu.firstTime = true;
                if (turno == 1) {
                    for (int i = 0; i < 4; i++)
                        manoOvest.mano.add(mazzo.pesca());
                
                    postazioneOvest.invalidate();
                    postazioneOvest.validate();
                } else {
                    for (int i = 0; i < 4; i++) manoEst.mano.add(mazzo.pesca());
                  
                    postazioneEst.invalidate();
                    postazioneEst.validate();
                }
                Menu.rosso.setEnabled(true);Menu.giallo.setEnabled(true);Menu.verde.setEnabled(true);Menu.blu.setEnabled(true);
            }            
            if (mano.mano.size()==0) {
                Database db2 = Database.getInstance();
                db2.updateBD2(nomeutente, true);
            }
    }
    
}
