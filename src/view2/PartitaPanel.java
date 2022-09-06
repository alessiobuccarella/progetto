package view2;

import controller.Eventi;
import model.Carta;
import model.Database;
import model.Mano;
import model.Mazzo;
import model.Senso;
import view.Menu;

import javax.swing.*;

import static view.Menu.nomeutente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class PartitaPanel extends JPanel {
	Mazzo mazzo = new Mazzo();
	private JButton passo;
	public static ArrayList<JButton> posti = new ArrayList<>();
	private static Piatto tavolo;
	private static Postazione postazione;
	private static boolean pescato=false;
	private boolean firstTime = true;
	public static int turno;
	public static Senso senso = Senso.ORARIO;
	public static Carta cartaScarto = new Carta(0, 0);
	static Icon redLabel = new ImageIcon("./src/immagini/0.png");
	static Icon yellowLabel = new ImageIcon("./src/immagini/1.png");
	static Icon blueLabel = new ImageIcon("./src/immagini/2.png");
	static Icon greenLabel = new ImageIcon("./src/immagini/3.png");
	public static  JButton scartoButton ;
	public JButton coloreRosso = new JButton();
	public JButton coloreGiallo = new JButton();
	public JButton coloreVerde = new JButton();
	public JButton coloreBlu = new JButton();
	public PartitaPanel(){
    	setLayout(new BorderLayout());
    	do cartaScarto=mazzo.next(); while(cartaScarto.getV()>12);
        JLabel redLabel = new JLabel(new ImageIcon("./src/immagini/0.png"));
        JLabel yellowLabel = new JLabel(new ImageIcon("./src/immagini/1.png"));
        JLabel blueLabel = new JLabel(new ImageIcon("./src/immagini/2.png"));
        JLabel greenLabel = new JLabel(new ImageIcon("./src/immagini/3.png"));
        JLabel deckLabel = new JLabel(new ImageIcon("./src/immagini/mazzo.png"));
        
        
        scartoButton = new JButton();
        passo= new JButton("PASSO");
        postazione = new Postazione(1);
        Mano mano = new Mano(mazzo);
        Mano manoOvest = new Mano(mazzo);
        Mano manoNord = new Mano(mazzo);
        Mano manoEst = new Mano(mazzo);
        for (int i=0;i<30;i++)posti.add(new JButton());
        for (int i=0;i<mano.mano.size();i++)
            posti.set(i,DisegnaCarta.disegnaCarta(mano.mano.get(i)));
        for (int i=0;i<mano.mano.size();i++)
            postazione.add(posti.get(i));
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
        Postazione postazione = new Postazione(1);
        Postazione postazionePiatto = new Postazione(1);
        Postazione postazioneColori = new Postazione(1);
        postazione.setBackground(null);
        postazione.setOpaque(false);
        
    
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
        tavolo = new Piatto();

        JLabel foto = new JLabel(avatar1png);
        JLabel foto1 = new JLabel(avatar2png);
        JLabel foto2 = new JLabel(avatar3png);
     
       
        GridBagConstraints gbc10= new GridBagConstraints();
        this.add(tavolo, BorderLayout.CENTER);
        JButton uno= new JButton("UNO!");
        

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
        
        gbc10.anchor=GridBagConstraints.CENTER;
        gbc10.gridx=4;
        gbc10.gridy=5;
        gbc10.weighty=2;
        tavolo.add(postazione,gbc10);
        
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
        gbc10.gridx=4;
        gbc10.gridy=6;
        gbc10.weighty=2;
 ///////tavolo.add(xxxxxx,gbc10);
        
        
        ActionListener avanti = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                repaint();
                System.out.println("turno: "+turno);
                    avanti(gbc10, turno, manoOvest, manoNord, manoEst, tavolo, postazioneOvest, postazioneNord, postazioneEst, mazzo, postazione, mano,postazionePiatto);
     
            }
        };
        Timer t = new Timer(3000, avanti);
        t.start();
        
     
        /**
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


	   /**
	   coloreRosso.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
             cartaScarto.setC(0);
             Eventi.passo(gbc10, mano, 0, null, postazione, tavolo, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, mazzo,postazionePiatto);
             
           }
       });
	   */
	   
	   
	   
	   
      
       
    public static void cliccato(GridBagConstraints gbc10, Mano mano, int indiceCarta, JButton posto, Postazione postazione, Piatto piatto,  Mano manoOvest, Mano manoNord, Mano manoEst, Postazione postazioneOvest, Postazione postazioneNord, Postazione postazioneEst, ArrayList<JButton> posti, Mazzo mazzo, Postazione postazionePiatto) {
    	
    	if (mano.mano.size()>1) Menu.deviGridareUno=false;
    	if (Menu.deviGridareUno==true&&Menu.gridatoUno==false) {
    		System.out.println("Penalità: non hai gridato 1!");
    		mano.mano.add(mazzo.pesca());
             posti.get(mano.mano.size() - 1).setBorder(null);
            mano.mano.add(mazzo.pesca());
           posti.get(mano.mano.size() - 1).setBorder(null);
    	}
    	if ((mano.mano.get(indiceCarta).getC() == cartaScarto.getC() || mano.mano.get(indiceCarta).getV() == cartaScarto.getV() || mano.mano.get(indiceCarta).getC() == 4)&&(turno%4==0)) {
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
                cambiaSenso();
            if (senso == Senso.ORARIO)
                turno = 1;
            if (senso == Senso.ANTIORARIO)
                turno = 3;
            if (cartaScarto.getV() == 10)
                turno = 2;
        }
            if (cartaScarto.getV() == 12) {
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
            if (cartaScarto.getV() == 13) {
                Menu.firstTime = true;
              //  Menu.rosso.setIcon(redLabel);Menu.giallo.setIcon(yellowLabel);Menu.verde.setIcon(greenLabel);Menu.blu.setIcon(blueLabel);
                Menu.rosso.setEnabled(true);Menu.giallo.setEnabled(true);Menu.verde.setEnabled(true);Menu.blu.setEnabled(true);
                Menu.postazioneColori.invalidate();
                Menu.postazioneColori.validate();
            }
            if (cartaScarto.getV() == 14) {
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
    public static void avanti(GridBagConstraints gbc10, int turno, Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, Postazione postazioneOvest, Postazione postazioneNord, Postazione postazioneEst, Mazzo mazzo, Postazione postazione, Mano mano,Postazione postazionePiatto) {
        System.out.println("funzione avanti");
    	switch (turno%4) {
            case 1:
            	//foto.setBorder(new LineBorder(Color.RED, 5));foto1.setBorder(null);foto2.setBorder(null);foto3.setBorder(null);
            	mossaOvest( gbc10,mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);           
                break;
            case 2:
            	//Menu.foto1.setBorder(new LineBorder(Color.RED, 5));Menu.foto.setBorder(null);Menu.foto2.setBorder(null);Menu.foto3.setBorder(null);
                mossaNord(gbc10,mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
                break;
            case 3:
            	//Menu.foto2.setBorder(new LineBorder(Color.RED, 5));Menu.foto1.setBorder(null);Menu.foto.setBorder(null);Menu.foto3.setBorder(null);            	
                mossaEst(gbc10,mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
                break;
            default:
            	//Menu.foto3.setBorder(new LineBorder(Color.RED, 5));Menu.foto1.setBorder(null);Menu.foto2.setBorder(null);Menu.foto.setBorder(null);
            	
                break;
        }
    }
    public static void mossaOvest(GridBagConstraints gbc10,Mano mano, Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, Postazione postazioneOvest, Mazzo mazzo, Postazione postazione, Postazione postazioneNord, Postazione postazioneEst,Postazione postazionePiatto)
    {
        System.out.println("OVEST: " + manoOvest.mano.toString());
        Carta x=cartaUtile(manoOvest);
        if (x!=null)                								        // se il giocatore ha una carta utile
        {
        	

            lanciaCarta(gbc10,piatto,manoOvest,postazioneOvest,x,"./src/immagini/dorso90.png",postazionePiatto);                // lancia la carta
            System.out.println("Ovest ha tirato " + x.toString());
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
            if(x.getV()>=12&&senso==Senso.ORARIO) aggiornaSpeciale(manoNord,postazioneNord,piatto, x,mazzo,"./src/immagini/dorso.png");
            if(x.getV()>=12&&senso==Senso.ANTIORARIO) aggiornaSpecialeUmano(mano,mazzo,x,postazione);
            
            aggiornaVista(piatto, postazioneOvest);
            aggiornaTurno(mano,mazzo); 
        }
        else if (pescato == false)                                   //se il giocatore non ha una carta utile e non ha ancora pescato
        {
            manoOvest.mano.add(mazzo.pesca());                       //pesca
           // aggiornaPostazione(postazioneOvest, manoOvest,"./src/immagini/dorso90.png" );
            pescato = true;
            mossaOvest(gbc10, mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
        }
        else if (x == null && pescato == true) {                       //se il giocatore non ha una carta utile e ma ha gi� pescato
           pescato = false;
           aggiornaTurno(mano,mazzo); 
           System.out.println("OVEST: " + manoOvest.mano.toString());
        }
        if (manoOvest.mano.size()==0) {
            Database db2 = Database.getInstance();
        }
        System.out.println("turno: "+turno);
    }
    public static void mossaNord(GridBagConstraints gbc10, Mano mano, Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, Postazione postazioneOvest, Mazzo mazzo, Postazione postazione, Postazione postazioneNord, Postazione postazioneEst,Postazione postazionePiatto)
    {	
    	
        System.out.println("NORD: " + manoNord.mano.toString());
        Carta x=cartaUtile(manoNord);
        if (x!=null)                								        // se il giocatore ha una carta utile
        {	
      
       
           lanciaCarta(gbc10,piatto,manoNord,postazioneNord,x,"./src/immagini/dorso.png",postazionePiatto);                // lancia la carta
            System.out.println("Nord ha tirato " + x.toString());
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
           
            if(x.getV()>=12&&senso==Senso.ORARIO) aggiornaSpeciale(manoEst,postazioneEst,piatto, x,mazzo,"./src/immagini/dorso90s.png");
            if(x.getV()>=12&&senso==Senso.ANTIORARIO) aggiornaSpeciale(manoOvest,postazioneOvest,piatto, x,mazzo,"./src/immagini/dorso90.png");
            aggiornaVista(piatto, postazioneNord);
            aggiornaTurno(mano,mazzo); 
        }
        else if (pescato == false)                                   //se il giocatore non ha una carta utile e non ha ancora pescato
        {
            manoNord.mano.add(mazzo.pesca());                       //pesca
            //aggiornaPostazione(postazioneNord, manoNord,"./src/immagini/dorso.png" );
            pescato = true;
            mossaNord(gbc10, mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
        }
        else if (x == null && pescato == true) {                       //se il giocatore non ha una carta utile e ma ha gi� pescato
           pescato = false;
           aggiornaTurno(mano,mazzo); 
           System.out.println("NORD: " + manoNord.mano.toString());
        }
        if (manoNord.mano.size()==0) {
            Database db2 = Database.getInstance();
        }
        System.out.println("turno: "+turno);
    }
    public static void mossaEst(GridBagConstraints gbc10, Mano mano, Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, Postazione postazioneOvest, Mazzo mazzo, Postazione postazione, Postazione postazioneNord, Postazione postazioneEst,Postazione postazionePiatto)
    {	
        System.out.println("EST: " + manoEst.mano.toString());
        Carta x=cartaUtile(manoEst);
        if (x!=null)                								        // se il giocatore ha una carta utile
        {
            lanciaCarta(gbc10,piatto,manoEst,postazioneEst,x,"./src/immagini/dorso90s.png",postazionePiatto);                // lancia la carta
            System.out.println("Est ha tirato " + x.toString());
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
           
            if(x.getV()>=12&&Menu.senso==Senso.ORARIO) aggiornaSpecialeUmano(mano,mazzo,x,postazione);
            if(x.getV()>=12&&Menu.senso==Senso.ANTIORARIO) aggiornaSpeciale(manoNord,postazioneNord,piatto, x,mazzo,"./src/immagini/dorso.png");
            aggiornaVista(piatto, postazioneEst);
            aggiornaTurno(mano,mazzo);
        }
        else if (pescato == false)                                   //se il giocatore non ha una carta utile e non ha ancora pescato
        {
            manoEst.mano.add(mazzo.pesca());                       //pesca
            //aggiornaPostazione(postazioneEst, manoEst,"./src/immagini/dorso90s.png" );
            pescato = true;
            mossaEst(gbc10, mano, manoOvest, manoNord, manoEst, piatto, postazioneEst, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
        }
        else if (x == null && pescato == true) {                       //se il giocatore non ha una carta utile e ma ha gi� pescato
           pescato = false;
           if (Menu.senso == Senso.ORARIO) Menu.turno += 1;
           else Menu.turno-=1;
           System.out.println("EST: " + manoEst.mano.toString());
        }
        if (manoEst.mano.size()==0) {
            Database db2 = Database.getInstance();
        }
        
        System.out.println("turno: "+Menu.turno);
    }
    public static Carta cartaUtile(Mano manoGiocatore)
    {
    	for (Carta x : manoGiocatore.mano) 
    		if (x.getV() == cartaScarto.getV() || x.getC() == cartaScarto.getC()||x.getC() ==4)
                return x;
    	return null;
    }
    public static void lanciaCarta(GridBagConstraints gbc10, Piatto piatto, Mano mano, Postazione postazione, Carta carta,String pathDorso,Postazione postazionePiatto) 
    {	
    	postazionePiatto.remove(scartoButton);
    	
    	
        scartoButton = DisegnaCarta.disegnaCarta(carta);
        cartaScarto = carta;
        postazionePiatto.add(scartoButton);
        piatto.repaint();
        mano.mano.remove(carta);

        }
    public static void aggiornaTurno(Mano mano,Mazzo mazzo) 
    {
    	postazione.removeAll();
    
        if (cartaScarto.getV() == 11) {
            cambiaSenso();
            if (senso == Senso.ORARIO) turno += 1;
            else turno -= 1;
        }
        if (cartaScarto.getV() == 10) 
            turno += 2;
        if (senso == Senso.ORARIO&&cartaScarto.getV() != 10&&cartaScarto.getV() != 11)
            turno += 1;
        if (senso == Senso.ANTIORARIO&&cartaScarto.getV() != 10&&cartaScarto.getV() != 11)
            turno -= 1;
        Carta x=cartaUtile(mano);
        //if (Menu.turno%4==0) Menu.evidenzia(0);     
        if (turno%4==0&&x==null) {System.out.println("non hai la carta da giocare");pesca(mazzo, mano);}
        }
    
    public static void aggiornaVista(Piatto piatto, Postazione postazione)
    {
    	piatto.invalidate();
        piatto.validate();
        postazione.invalidate();
        postazione.validate();
    } 
    public static void cambiaSenso() {
        if (senso == Senso.ANTIORARIO) senso = Senso.ORARIO;
        else senso = Senso.ANTIORARIO;
    }
    public static void aggiornaSpeciale(Mano manoVittima, Postazione postazioneVittima, Piatto piatto, Carta x, Mazzo mazzo, String path) 
    {
    	if (x.getV()==12) {
    		
    		manoVittima.mano.add(mazzo.pesca());manoVittima.mano.add(mazzo.pesca());
    		//aggiornaPostazione(postazioneVittima, manoVittima,path );
    	}
    	if (x.getV()==13) {
            cartaScarto.setC((int)(Math.random()*4));
            String filename = "./src/immagini/"+cartaScarto.getC() + ".png";
            ImageIcon img = new ImageIcon(filename);
            JButton colore = new JButton(img);
            postazione.add(colore);
            System.out.println("colore: "+cartaScarto.getC());
        }
    	if (x.getV()==14) {
    		manoVittima.mano.add(mazzo.pesca());
            manoVittima.mano.add(mazzo.pesca());
            manoVittima.mano.add(mazzo.pesca());
            manoVittima.mano.add(mazzo.pesca());
    		cartaScarto.setC((int)(Math.random()*4));
    	    System.out.println("colore: "+cartaScarto.getC());
    	}
    }
    public static void aggiornaSpecialeUmano(Mano mano,Mazzo mazzo,Carta x,Postazione postazione)
    {
    	
    	if (x.getV()==13) {
            cartaScarto.setC((int)(Math.random()*4));
            System.out.println(cartaScarto.getC());
        }
    	if (x.getV()==14) {
            cartaScarto.setC((int)(Math.random()*4));
            System.out.println(cartaScarto.getC());
            System.out.print("la tua mano è: "+mano.mano.toString());
            pesca(mazzo,mano);pesca(mazzo,mano);
            pesca(mazzo,mano);pesca(mazzo,mano);
            System.out.println(" e dopo diventa: "+mano.mano.toString());
     
         
            postazione.repaint();
        }
    }
    public static void pesca(Mazzo mazzo, Mano mano) {
    	
  	  Carta carta=mazzo.pesca();
  	  mano.mano.add(carta);
  	  Icon immagine= new ImageIcon("./src/immagini/" + carta.getV() + carta.getC() + ".png");
        posti.get(mano.mano.size()-1).setIcon(immagine);posti.get(mano.mano.size()-1).setBorder(null);
      	  postazione.add(posti.get(mano.mano.size()-1));
      	  postazione.invalidate();
            postazione.validate();
            tavolo.invalidate();
            tavolo.validate();
           
  
  }
    public static void aggiornaPostazione(Postazione postazione, Mano mano)
    {	postazione.removeAll();
    	int count =0;
    	for (Carta x:mano.mano)
	{
		Icon immagine= new ImageIcon("./src/immagini/" + x.getV() + x.getC() + ".png");
		posti.get(count).setIcon(immagine);posti.get(count).setBorder(null);
		postazione.add(posti.get(count));
		count++;
	}
    postazione.invalidate();
    postazione.validate();
        
    }
    
}
