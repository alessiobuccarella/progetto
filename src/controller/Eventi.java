package controller;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.*;
import view.Menu;
import view.Piatto;
import view.Postazione;
import static view.Menu.nomeutente;

public class Eventi {
	static Icon redLabel = new ImageIcon("./src/immagini/0.png");
	static Icon yellowLabel = new ImageIcon("./src/immagini/1.png");
	static Icon blueLabel = new ImageIcon("./src/immagini/2.png");
	static Icon greenLabel = new ImageIcon("./src/immagini/3.png");
	public static boolean contrattaccoAttivo;
	private static boolean pescato=false;
    public static void cliccato(GridBagConstraints gbc10, Mano mano, int indiceCarta, JButton posto, Postazione postazione, Piatto piatto, int turno, Mano manoOvest, Mano manoNord, Mano manoEst, Postazione postazioneOvest, Postazione postazioneNord, Postazione postazioneEst, ArrayList<JButton> posti, Mazzo mazzo, Postazione postazionePiatto) {
    	//System.out.println("hai cliccato "+mano.mano.get(indiceCarta).getV()+" "+mano.mano.get(indiceCarta).getC()+" CONTRO "+Menu.cartaScarto.getV());
    	if (mano.mano.size()>1) Menu.deviGridareUno=false;
    	if (Menu.deviGridareUno==true&&Menu.gridatoUno==false) {
    		System.out.println("Penalità: non hai gridato 1!");
    		mano.mano.add(mazzo.pesca());
           // posti.set(mano.mano.size() - 1,new JLabel(new ImageIcon(mano.mano.get(mano.mano.size() - 1).getPath())));
            posti.get(mano.mano.size() - 1).setBorder(null);
            mano.mano.add(mazzo.pesca());
           // posti.set(mano.mano.size() - 1,new JLabel(new ImageIcon(mano.mano.get(mano.mano.size() - 1).getPath())));
            posti.get(mano.mano.size() - 1).setBorder(null);
    	}
    	if ((mano.mano.get(indiceCarta).getC() == Menu.cartaScarto.getC() || mano.mano.get(indiceCarta).getV() == Menu.cartaScarto.getV() || mano.mano.get(indiceCarta).getC() == 4)&&(Menu.turno%4==0)) {
    		
    		Menu.cartaScarto=mano.mano.get(indiceCarta);postazionePiatto.remove(Menu.scartoButton);Menu.scartoButton=DisegnaCarta.disegnaCarta(Menu.cartaScarto);
    	    gbc10.anchor=GridBagConstraints.LINE_END;
            gbc10.weightx=0;
            gbc10.weighty=0;
            gbc10.gridx=7;
            gbc10.gridy=1;
            postazionePiatto.add(Menu.scartoButton);
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
            if (Menu.cartaScarto.getV() == 11)
                cambiaSenso();
            if (Menu.senso == Senso.ORARIO)
                Menu.turno = 1;
            if (Menu.senso == Senso.ANTIORARIO)
                Menu.turno = 3;
            if (Menu.cartaScarto.getV() == 10)
                Menu.turno = 2;
        }
            if (Menu.cartaScarto.getV() == 12) {
                Menu.firstTime = true;
                if (Menu.turno %4== 1) {
                   // for (int i = 0; i < 2; i++)
                     //   manoOvest.mano.add(mazzo.pesca());
                    //postazioneOvest.removeAll();
                    //for (Carta y : manoOvest.mano) {
                     //   postazioneOvest.add(new JLabel(new ImageIcon("./src/immagini/dorso90.png")));
                      //  postazioneOvest.add(Box.createRigidArea(new Dimension(0, 5)));
                    }
                    //postazioneOvest.invalidate();
                    //postazioneOvest.validate();
                } else {
                    //for (int i = 0; i < 2; i++)
                      //  manoEst.mano.add(mazzo.pesca());
                   // postazioneEst.removeAll();
                  //  for (Carta y : manoEst.mano) {
                    //    postazioneEst.add(new JLabel(new ImageIcon("./src/immagini/dorso90s.png")));
                      //  postazioneEst.add(Box.createRigidArea(new Dimension(0, 5)));
                    }
                    //postazioneEst.invalidate();
                    //postazioneEst.validate();
              //  }
         //   }
            if (Menu.cartaScarto.getV() == 13) {
                Menu.firstTime = true;
                Menu.rosso.setIcon(redLabel);Menu.giallo.setIcon(yellowLabel);Menu.verde.setIcon(greenLabel);Menu.blu.setIcon(blueLabel);
                Menu.rosso.setEnabled(true);Menu.giallo.setEnabled(true);Menu.verde.setEnabled(true);Menu.blu.setEnabled(true);
                Menu.postazioneColori.invalidate();
                Menu.postazioneColori.validate();
            }
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
                Menu.rosso.setEnabled(true);Menu.giallo.setEnabled(true);Menu.verde.setEnabled(true);Menu.blu.setEnabled(true);
            }            
            if (mano.mano.size()==0) {
                Database db2 = new Database();
                db2.updateBD2(nomeutente, true);
            }
    }

    public static void avanti(GridBagConstraints gbc10, int turno, Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, Postazione postazioneOvest, Postazione postazioneNord, Postazione postazioneEst, Mazzo mazzo, Postazione postazione, Mano mano,Postazione postazionePiatto) {
        switch (turno%4) {
            case 1:
                mossaOvest( gbc10,mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
                break;
            case 2:
                mossaNord(gbc10,mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
                break;
            case 3:
                mossaEst(gbc10,mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
                break;
            default:
                break;
        }
    }
    //cambia il senso del giro di mano
    public static void cambiaSenso() {
        if (Menu.senso == Senso.ANTIORARIO) Menu.senso = Senso.ORARIO;
        else Menu.senso = Senso.ANTIORARIO;
    }
    // calcola se nella mano di un giocatore c'� una carta lanciabile
    public static Carta cartaUtile(Mano manoGiocatore)
    {
    	for (Carta x : manoGiocatore.mano) 
    		if (x.getV() == Menu.cartaScarto.getV() || x.getC() == Menu.cartaScarto.getC()||x.getC() ==4)
                return x;
    	return null;
    }
    //aggiorna graficamente il campo in seguito alla scelta delal carta di un giocatore
    public static void lanciaCarta(GridBagConstraints gbc10, Piatto piatto, Mano mano, Postazione postazione, Carta carta,String pathDorso,Postazione postazionePiatto) 
    {
    	postazionePiatto.remove(Menu.scartoButton);
        Menu.scartoButton = DisegnaCarta.disegnaCarta(carta);
        Menu.cartaScarto = carta;
        postazionePiatto.add(Menu.scartoButton);
        mano.mano.remove(carta);
       // postazione.removeAll();
       // for (Carta y : mano.mano) {
        //    postazione.add(new JLabel(new ImageIcon(pathDorso)));
         //   postazione.add(Box.createRigidArea(new Dimension(0, 5)));
        }
     //   postazione.invalidate();
      //  postazione.validate();
    //}
    //calcola di quale giocatore sar� il turno successivo
    public static void aggiornaTurno(Mano mano,Mazzo mazzo) 
    {
        if (Menu.cartaScarto.getV() == 11) {
            cambiaSenso();
            if (Menu.senso == Senso.ORARIO) Menu.turno += 1;
            else Menu.turno -= 1;
        }
        if (Menu.cartaScarto.getV() == 10) 
            Menu.turno += 2;
        if (Menu.senso == Senso.ORARIO&&Menu.cartaScarto.getV() != 10&&Menu.cartaScarto.getV() != 11)
            Menu.turno += 1;
        if (Menu.senso == Senso.ANTIORARIO&&Menu.cartaScarto.getV() != 10&&Menu.cartaScarto.getV() != 11)
            Menu.turno -= 1;
        Carta x=cartaUtile(mano);
               
        if (Menu.turno%4==0&&x==null) {System.out.println("non hai la carta da giocare");Menu.pesca(mazzo, mano);}
    }
    //aggiorna le man dei giocatori in caso di una carta speciale

    
    public static void aggiornaSpeciale(Mano manoVittima, Postazione postazioneVittima, Piatto piatto, Carta x, Mazzo mazzo, String path) 
    {
    	if (x.getV()==12) {
    		
    		manoVittima.mano.add(mazzo.pesca());manoVittima.mano.add(mazzo.pesca());
    		//aggiornaPostazione(postazioneVittima, manoVittima,path );
    	}
    	if (x.getV()==13) {
            Menu.cartaScarto.setC((int)(Math.random()*4));
            System.out.println("colore: "+Menu.cartaScarto.getC());
        }
    	if (x.getV()==14) {
    		manoVittima.mano.add(mazzo.pesca());
            manoVittima.mano.add(mazzo.pesca());
            manoVittima.mano.add(mazzo.pesca());
            manoVittima.mano.add(mazzo.pesca());
    		Menu.cartaScarto.setC((int)(Math.random()*4));
    	    System.out.println("colore: "+Menu.cartaScarto.getC());
    	}
    }
    //aggiorna graficamente piatto e postazione in input
    public static void aggiornaVista(Piatto piatto, Postazione postazione)
    {
    	piatto.invalidate();
        piatto.validate();
        postazione.invalidate();
        postazione.validate();
    } 
    // aggiorna graficamente la postazione di un giocatore
    public static void aggiornaPostazione(Postazione postazione, Mano mano,String pathImmagine)
    {/**
    	 postazione.removeAll();
         for (Carta y : mano.mano) {
             postazione.add(new JLabel(new ImageIcon(pathImmagine)));
             postazione.add(Box.createRigidArea(new Dimension(0, 5)));
             postazione.invalidate();
             postazione.validate();
        
         }*/
    }
    public static boolean contrattacco(Mano mano) 
    {
    	for(Carta z:mano.mano)if (z.getV()==12||z.getV()==14)return true;
    	return false;
    }
    public static void aggiornaSpecialeUmano(Mano mano,Mazzo mazzo,Carta x,Postazione postazione)
    {
    	if (x.getV()==12) {
          if (contrattacco(mano)==false)
          {
            Menu.pesca(mazzo, mano);
            Menu.pesca(mazzo, mano);
          }
          else 
          {
        	  contrattaccoAttivo=true;
          }
        }
    	if (x.getV()==13) {
            Menu.cartaScarto.setC((int)(Math.random()*4));
            System.out.println(Menu.cartaScarto.getC());
        }
    	if (x.getV()==14) {
            Menu.cartaScarto.setC((int)(Math.random()*4));
            System.out.println(Menu.cartaScarto.getC());
            System.out.print("considero che la tua mano è: "+mano.mano.toString());
            Menu.pesca(mazzo,mano);Menu.pesca(mazzo,mano);
            Menu.pesca(mazzo,mano);Menu.pesca(mazzo,mano);
            System.out.println(" e dopo diventa: "+mano.mano.toString());
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
            if(x.getV()>=12&&Menu.senso==Senso.ORARIO) aggiornaSpeciale(manoNord,postazioneNord,piatto, x,mazzo,"./src/immagini/dorso.png");
            if(x.getV()>=12&&Menu.senso==Senso.ANTIORARIO) aggiornaSpecialeUmano(mano,mazzo,x,postazione);
            aggiornaVista(piatto, postazioneOvest);
            aggiornaTurno(mano,mazzo); 
        }
        else if (pescato == false)                                   //se il giocatore non ha una carta utile e non ha ancora pescato
        {
            manoOvest.mano.add(mazzo.pesca());                       //pesca
            aggiornaPostazione(postazioneOvest, manoOvest,"./src/immagini/dorso90.png" );
            pescato = true;
            mossaOvest(gbc10, mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
        }
        else if (x == null && pescato == true) {                       //se il giocatore non ha una carta utile e ma ha gi� pescato
           pescato = false;
           aggiornaTurno(mano,mazzo); 
           System.out.println("OVEST: " + manoOvest.mano.toString());
        }
        if (manoOvest.mano.size()==0) {
            Database db2 = new Database();
        }
        System.out.println("turno: "+Menu.turno);
    }
    private static void mossaNord(GridBagConstraints gbc10, Mano mano, Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, Postazione postazioneOvest, Mazzo mazzo, Postazione postazione, Postazione postazioneNord, Postazione postazioneEst,Postazione postazionePiatto)
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
            aggiornaTurno(mano,mazzo);
            if(x.getV()>=12&&Menu.senso==Senso.ORARIO) aggiornaSpeciale(manoEst,postazioneEst,piatto, x,mazzo,"./src/immagini/dorso90s.png");
            if(x.getV()>=12&&Menu.senso==Senso.ANTIORARIO) aggiornaSpeciale(manoOvest,postazioneOvest,piatto, x,mazzo,"./src/immagini/dorso90.png");
            aggiornaVista(piatto, postazioneNord);
        }
        else if (pescato == false)                                   //se il giocatore non ha una carta utile e non ha ancora pescato
        {
            manoNord.mano.add(mazzo.pesca());                       //pesca
            aggiornaPostazione(postazioneNord, manoNord,"./src/immagini/dorso.png" );
            pescato = true;
            mossaNord(gbc10, mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
        }
        else if (x == null && pescato == true) {                       //se il giocatore non ha una carta utile e ma ha gi� pescato
           pescato = false;
           aggiornaTurno(mano,mazzo); 
           System.out.println("NORD: " + manoNord.mano.toString());
        }
        if (manoNord.mano.size()==0) {
            Database db2 = new Database();
        }
        System.out.println("turno: "+Menu.turno);
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
            aggiornaTurno(mano,mazzo);
            if(x.getV()>=12&&Menu.senso==Senso.ORARIO) aggiornaSpecialeUmano(mano,mazzo,x,postazione);
            if(x.getV()>=12&&Menu.senso==Senso.ANTIORARIO) aggiornaSpeciale(manoNord,postazioneNord,piatto, x,mazzo,"./src/immagini/dorso.png");
            aggiornaVista(piatto, postazioneEst);
        }
        else if (pescato == false)                                   //se il giocatore non ha una carta utile e non ha ancora pescato
        {
            manoEst.mano.add(mazzo.pesca());                       //pesca
            aggiornaPostazione(postazioneEst, manoEst,"./src/immagini/dorso90s.png" );
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
            Database db2 = new Database();
        }
        System.out.println("turno: "+Menu.turno);
    }
    public static void passo(GridBagConstraints gbc10,Mano mano, int i, JButton posto0, Postazione postazione, Piatto piatto, int turno, Mano manoOvest, Mano manoNord, Mano manoEst, Postazione postazioneOvest, Postazione postazioneNord, Postazione postazioneEst, Mazzo mazzo, Postazione postazionePiatto) {
        if (Menu.senso == Senso.ANTIORARIO)
            Menu.turno = 3;
        if (Menu.senso == Senso.ORARIO)
            Menu.turno = 1;
        avanti(gbc10, turno, manoOvest, manoNord, manoEst, piatto, postazioneOvest, postazioneNord, postazioneEst, mazzo, postazioneNord, manoEst,postazionePiatto);
    }
}