package controller;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import model.*;
import view2.*;

public class Eventi {
    public Eventi eventi;
	public int turno = 0;
	
	public  boolean deviGridareUno=false;
	public  boolean gridatoUno=false;
	public Senso senso = Senso.ORARIO;
	private Carta cartaScarto;
	private  boolean pescato=false;
    private boolean firstTime = true;
    PartitaPanel partitaPanel;
    AudioButtonManager musicObjectBot = new AudioButtonManager();

	public Eventi(PartitaPanel partitaPanel) {
		this.partitaPanel=partitaPanel;
		cartaScarto=partitaPanel.getCartaScarto();
	}

	public boolean getDeviGridareUno() {
		return deviGridareUno;
	}

	public void setGridatoUno() {
		gridatoUno=true;
    }
	
	public void cliccato(GridBagConstraints gbc10, Mano mano, int indiceCarta, JButton posto, Postazione postazione, Piatto piatto,  Mano manoOvest, Mano manoNord, Mano manoEst, Postazione postazioneOvest, Postazione postazioneNord, Postazione postazioneEst, ArrayList<JButton> posti, Mazzo mazzo, Postazione postazionePiatto) {
		
		System.out.println("cartaScarto colore"+cartaScarto.getC()+"cartaScarto numero"+cartaScarto.getV()+"colore"+mano.mano.get(indiceCarta).getC()+"numero"+mano.mano.get(indiceCarta).getV());
		if(senso == Senso.ORARIO) {
            if (turno==0)musicObjectBot.playButtonMusic("./src/audio/Bulbasaur_audio.wav");
            partitaPanel.getFoto().setBorder(new LineBorder(Color.RED, 5));
            partitaPanel.getFoto1().setBorder(null);partitaPanel.getFoto2().setBorder(null);
        } else {
            partitaPanel.getFoto().setBorder(null);
            partitaPanel.getFoto1().setBorder(null);
            if (turno==0)musicObjectBot.playButtonMusic("./src/audio/Squirtle_audio.wav");
            partitaPanel.getFoto2().setBorder(new LineBorder(Color.RED, 5));
        }
        if (mano.mano.size() > 1) {
            deviGridareUno=false;
        } else {
            deviGridareUno = true;
        }
        if (deviGridareUno == true && gridatoUno == false) {
            System.out.println("Penalità: non hai gridato 1!");
            mano.mano.add(mazzo.pesca());
            posti.get(mano.mano.size() - 1).setBorder(null);
            mano.mano.add(mazzo.pesca());
            posti.get(mano.mano.size() - 1).setBorder(null);
        }
        if ((mano.mano.get(indiceCarta).getC() == cartaScarto.getC() || mano.mano.get(indiceCarta).getV() == cartaScarto.getV() || mano.mano.get(indiceCarta).getC() == 4) && (turno % 4 == 0)) {
        	  if (cartaScarto.getV() == 11) musicObjectBot.playButtonMusic("./src/audio/special_card_audio.wav");
        	if(cartaScarto.getV() < 10) {
                musicObjectBot.playButtonMusic("./src/audio/normal_card_audio.wav");
            } 
            System.out.println("ok");
            cartaScarto = mano.mano.get(indiceCarta);
            postazionePiatto.remove(partitaPanel.getScartoButton());
            partitaPanel.setScartoButton(DisegnaCarta.disegnaCarta(cartaScarto));
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
                Icon immagine= new ImageIcon("./src/immagini/" + x.getV() + x.getC() + ".png");
                posti.get(count).setIcon(immagine);
                posti.get(count).setBorder(null);
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
            firstTime = true;
            if (turno % 4 == 1) {
                for (int i = 0; i < 2; i++)
                    manoOvest.mano.add(mazzo.pesca());
                	postazioneOvest.invalidate();
                	postazioneOvest.validate();
            } else {
            	for (int i = 0; i < 2; i++)
            		manoEst.mano.add(mazzo.pesca());
            }    
        }
        
        postazioneEst.invalidate();
        postazioneEst.validate();
        if (cartaScarto.getV() == 13) {
            // Menu.firstTime = true;
        
            partitaPanel.getColoreRosso().setIcon(partitaPanel.getRedLabel());
            partitaPanel.getColoreGiallo().setIcon(partitaPanel.getYellowLabel());
            partitaPanel.getColoreVerde().setIcon(partitaPanel.getGreenLabel());
            partitaPanel.getColoreBlu().setIcon(partitaPanel.getBlueLabel());
            partitaPanel.getColoreRosso().setEnabled(true);
            partitaPanel.getColoreGiallo().setEnabled(true);
            partitaPanel.getColoreVerde().setEnabled(true);
            partitaPanel.getColoreBlu().setEnabled(true);
        
        }
        if (cartaScarto.getV() == 14) {
            //Menu.firstTime = true;
            if (turno == 1) {
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
               // Menu.rosso.setEnabled(true);Menu.giallo.setEnabled(true);Menu.verde.setEnabled(true);Menu.blu.setEnabled(true);
        }
        if (mano.mano.size()==0) {
            musicObjectBot.playButtonMusic("./src/audio/victory_audio.wav");
            Database db2 = Database.getInstance();
        }
    }
    public void avanti(GridBagConstraints gbc10, int turno, Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, Postazione postazioneOvest, Postazione postazioneNord, Postazione postazioneEst, Mazzo mazzo, Postazione postazione, Mano mano,Postazione postazionePiatto) {
        switch (turno % 4) {
            case 1:
                mossaOvest(gbc10,mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
                if (senso == Senso.ORARIO && cartaScarto.getV() != 10 && cartaScarto.getV() != 11) {
                    partitaPanel.getFoto2().setBorder(null);
                    musicObjectBot.playButtonMusic("./src/audio/Charmander_audio.wav");
                    partitaPanel.getFoto1().setBorder(new LineBorder(Color.RED, 5));
                    partitaPanel.getFoto().setBorder(null);
                }
                else if (senso == Senso.ANTIORARIO && cartaScarto.getV() != 10 && cartaScarto.getV() != 11) {
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
                mossaNord(gbc10,mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
                if (senso == Senso.ORARIO && cartaScarto.getV() != 10 && cartaScarto.getV() != 11) {
                    musicObjectBot.playButtonMusic("./src/audio/Squirtle_audio.wav");
                    partitaPanel.getFoto2().setBorder(new LineBorder(Color.RED, 5));
                    partitaPanel.getFoto1().setBorder(null);
                    partitaPanel.getFoto().setBorder(null);
                }
                else if (senso == Senso.ANTIORARIO && cartaScarto.getV() != 10 && cartaScarto.getV() != 11) {
                    partitaPanel.getFoto2().setBorder(null);
                    partitaPanel.getFoto1().setBorder(null);
                    musicObjectBot.playButtonMusic("./src/audio/Bulbasaur_audio.wav");
                    partitaPanel.getFoto().setBorder(new LineBorder(Color.RED, 5));
                }
                else {
                    partitaPanel.getFoto2().setBorder(null);
                    partitaPanel.getFoto1().setBorder(null);
                    partitaPanel.getFoto().setBorder(null);
                }
                break;
            case 3:
                mossaEst(gbc10,mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
                if (senso == Senso.ORARIO && cartaScarto.getV() != 10 && cartaScarto.getV() != 11) {
                     partitaPanel.getFoto2().setBorder(null);
                     partitaPanel.getFoto1().setBorder(null);
                     partitaPanel.getFoto().setBorder(null);}
                else if (senso == Senso.ANTIORARIO && cartaScarto.getV() != 10 && cartaScarto.getV() != 11) {
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

    public void mossaOvest(GridBagConstraints gbc10,Mano mano, Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, Postazione postazioneOvest, Mazzo mazzo, Postazione postazione, Postazione postazioneNord, Postazione postazioneEst,Postazione postazionePiatto) {
    	
    	System.out.println("OVEST: " + manoOvest.mano.toString());
        Carta x = cartaUtile(manoOvest);
        // se il giocatore ha una carta utile
        if (x != null) {
            lanciaCarta(gbc10,piatto,manoOvest,postazioneOvest,x,"./src/immagini/dorso90.png",postazionePiatto);
            if(senso == Senso.ORARIO) {
                partitaPanel.getFoto().setBorder(null);
                musicObjectBot.playButtonMusic("./src/audio/Charmander_audio.wav");
                partitaPanel.getFoto1().setBorder(new LineBorder(Color.RED, 5));
                partitaPanel.getFoto2().setBorder(null);
            }
            else {
                partitaPanel.getFoto().setBorder(null);
                partitaPanel.getFoto1().setBorder(null);
                partitaPanel.getFoto2().setBorder(null);
            }
            // lancia la carta
            System.out.println("turno: " + turno);
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
            if(x.getV() >= 12 && senso == Senso.ORARIO) {
                aggiornaSpeciale(manoNord,postazioneNord,piatto, x,mazzo,"./src/immagini/dorso.png");
            }
            if(x.getV() >= 12 && senso == Senso.ANTIORARIO) {
                aggiornaSpecialeUmano(mano,mazzo,x,postazione);
            }
            aggiornaVista(piatto, postazioneOvest);
            aggiornaTurno(mano,mazzo);
        }
        //se il giocatore non ha una carta utile e non ha ancora pescato
        else if (pescato == false) {
            //pesca
            manoOvest.mano.add(mazzo.pesca());
            //aggiornaPostazione(postazioneOvest, manoOvest,"./src/immagini/dorso90.png" );
            pescato = true;
            mossaOvest(gbc10, mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
        }
        //se il giocatore non ha una carta utile e ma ha già pescato
        else if (x == null && pescato == true) {
           pescato = false;
           aggiornaTurno(mano,mazzo);
           System.out.println("OVEST: " + manoOvest.mano.toString());
        }
        if (manoOvest.mano.size() == 0) {
            musicObjectBot.playButtonMusic("./src/audio/defeat_audio.wav");
            Database db2 = Database.getInstance();
            //HA VINTO
        }
    }

    public void mossaNord(GridBagConstraints gbc10, Mano mano, Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, Postazione postazioneOvest, Mazzo mazzo, Postazione postazione, Postazione postazioneNord, Postazione postazioneEst,Postazione postazionePiatto) {
        System.out.println("NORD: " + manoNord.mano.toString());
        System.out.println("EST: "+mano.mano.toString());
        Carta x = cartaUtile(manoNord);
        // se il giocatore ha una carta utile
        if (x != null) {
            lanciaCarta(gbc10,piatto,manoNord,postazioneNord,x,"./src/immagini/dorso.png",postazionePiatto);
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
            if(x.getV() >= 12 && senso == Senso.ORARIO) {
                aggiornaSpeciale(manoEst,postazioneEst,piatto, x,mazzo,"./src/immagini/dorso90s.png");
            }
            if(x.getV() >= 12 && senso == Senso.ANTIORARIO) {
                aggiornaSpeciale(manoOvest,postazioneOvest,piatto, x,mazzo,"./src/immagini/dorso90.png");
            }
            aggiornaVista(piatto, postazioneNord);
            aggiornaTurno(mano,mazzo);
        }
        //se il giocatore non ha una carta utile e non ha ancora pescato
        else if (pescato == false) {
            //pesca
            manoNord.mano.add(mazzo.pesca());
            //aggiornaPostazione(postazioneNord, manoNord,"./src/immagini/dorso.png" );
            pescato = true;
            mossaNord(gbc10, mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
        }
        //se il giocatore non ha una carta utile e ma ha già pescato
        else if (x == null && pescato == true) {
           pescato = false;
           aggiornaTurno(mano,mazzo);
           System.out.println("NORD: " + manoNord.mano.toString());
        }
        if (manoNord.mano.size() == 0) {
            musicObjectBot.playButtonMusic("./src/audio/defeat_audio.wav");
            Database db2 = Database.getInstance();
            //HA VINTO
        }
        System.out.println("turno: " + turno);
    }
    public void mossaEst(GridBagConstraints gbc10, Mano mano, Mano manoOvest, Mano manoNord, Mano manoEst, Piatto piatto, Postazione postazioneOvest, Mazzo mazzo, Postazione postazione, Postazione postazioneNord, Postazione postazioneEst,Postazione postazionePiatto) {
        System.out.println("EST: " + manoEst.mano.toString());
        Carta x = cartaUtile(manoEst);
        // se il giocatore ha una carta utile
        if (x != null) {
            lanciaCarta(gbc10,piatto,manoEst,postazioneEst,x,"./src/immagini/dorso90s.png",postazionePiatto);
            System.out.println("turno: " + turno);
            if(senso == Senso.ORARIO) {
                partitaPanel.getFoto2().setBorder(null);
                partitaPanel.getFoto1().setBorder(null);
                partitaPanel.getFoto().setBorder(null);
            } else {
                partitaPanel.getFoto2().setBorder(null);
                musicObjectBot.playButtonMusic("./src/audio/Charmander_audio.wav");
                partitaPanel.getFoto1().setBorder(new LineBorder(Color.RED, 5));
                partitaPanel.getFoto().setBorder(null);
            }
            // lancia la carta
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
            if(x.getV() >= 12 && senso == Senso.ORARIO) {
                aggiornaSpecialeUmano(mano, mazzo, x, postazione);
            }
            if(x.getV() >= 12 && senso == Senso.ANTIORARIO) {
                aggiornaSpeciale(manoNord, postazioneNord, piatto, x, mazzo, "./src/immagini/dorso.png");
            }
            aggiornaVista(piatto, postazioneEst);
            aggiornaTurno(mano,mazzo);
        }
        //se il giocatore non ha una carta utile e non ha ancora pescato
        else if (pescato == false) {
            //pesca
           manoEst.mano.add(mazzo.pesca());
            //aggiornaPostazione(postazioneEst, manoEst,"./src/immagini/dorso90s.png" );
            pescato = true;
            mossaEst(gbc10, mano, manoOvest, manoNord, manoEst, piatto, postazioneOvest, mazzo, postazione, postazioneNord, postazioneEst,postazionePiatto);
        }
        //se il giocatore non ha una carta utile e ma ha già pescato
        else if (x == null && pescato == true) {
            pescato = false;
            if (senso == Senso.ORARIO) {
               turno += 1;
            }
            else {
               turno-=1;
            }
            System.out.println("EST: " + manoEst.mano.toString());
        }
        if (manoEst.mano.size() == 0) {
            musicObjectBot.playButtonMusic("./src/audio/defeat_audio.wav");
            Database db2 = Database.getInstance();
        }
}
    public void cambiaSenso() {
        if (senso == Senso.ANTIORARIO) {
            senso = Senso.ORARIO;
        }
        else {
            senso = Senso.ANTIORARIO;
        }
    }
    public Carta cartaUtile(Mano manoGiocatore) {
    	for (Carta x : manoGiocatore.mano) 
    		if (x.getV() == cartaScarto.getV() || x.getC() == cartaScarto.getC() || x.getC() == 4)
                return x;
    	return null;
    }

    public void lanciaCarta(GridBagConstraints gbc10, Piatto piatto, Mano mano, Postazione postazione, Carta carta,String pathDorso,Postazione postazionePiatto) {
    	postazionePiatto.remove(partitaPanel.getScartoButton());
        partitaPanel.setScartoButton(DisegnaCarta.disegnaCarta(carta));
        cartaScarto = carta;
        postazionePiatto.add(partitaPanel.getScartoButton());
        piatto.repaint();
        mano.mano.remove(carta);
    }

    public  void aggiornaSpeciale(Mano manoVittima, Postazione postazioneVittima, Piatto piatto, Carta x, Mazzo mazzo, String path) {
    	if (x.getV() == 12) {
    		manoVittima.mano.add(mazzo.pesca());manoVittima.mano.add(mazzo.pesca());
    		//aggiornaPostazione(postazioneVittima, manoVittima,path);
    	}
    	if (x.getV() == 13) {
            cartaScarto.setC((int)(Math.random() * 4));
            String filename = "./src/immagini/" + cartaScarto.getC() + "+0.png";
            ImageIcon img = new ImageIcon(filename);
            JButton colore = new JButton(img);
            colore.setBorder(null);
            partitaPanel.getScartoButton().add(colore);
            System.out.println("colore: "+cartaScarto.getC());
        }
    	if (x.getV() == 14) {
    		manoVittima.mano.add(mazzo.pesca());
            manoVittima.mano.add(mazzo.pesca());
            manoVittima.mano.add(mazzo.pesca());
            manoVittima.mano.add(mazzo.pesca());
    		cartaScarto.setC((int)(Math.random() * 4));
            String filename = "./src/immagini/" + cartaScarto.getC() + "+4.png";
            ImageIcon img = new ImageIcon(filename);
            JButton colore = new JButton(img);
            colore.setBorder(null);
            partitaPanel.getScartoButton().add(colore);
    	    System.out.println("colore: "+cartaScarto.getC());
    	}
    }

    public  void aggiornaSpecialeUmano(Mano mano,Mazzo mazzo,Carta x,Postazione postazione)
    {
    	if (x.getV()==12) {
            pesca(mazzo,mano);
            pesca(mazzo,mano);
        }
    	if (x.getV()==13) {
            cartaScarto.setC((int)(Math.random() * 4));
            cartaScarto.setC((int)(Math.random() * 4));
            String filename = "./src/immagini/" + cartaScarto.getC() + ".png";
            ImageIcon img = new ImageIcon(filename);
            JButton colore = new JButton(img);
            colore.setBorder(null);
            partitaPanel.getScartoButton().add(colore);
            System.out.println(cartaScarto.getC());
        }
    	if (x.getV() == 14) {
            cartaScarto.setC((int)(Math.random() * 4));
            cartaScarto.setC((int)(Math.random() * 4));
            String filename = "./src/immagini/" + cartaScarto.getC() + "+4.png";
            ImageIcon img = new ImageIcon(filename);
            JButton colore = new JButton(img);
            colore.setBorder(null);
            partitaPanel.getScartoButton().add(colore);
            System.out.println(cartaScarto.getC());
            System.out.print("la tua mano è: " + mano.mano.toString());
            pesca(mazzo,mano);
            pesca(mazzo,mano);
            pesca(mazzo,mano);
            pesca(mazzo,mano);
            System.out.println(" e dopo diventa: " + mano.mano.toString());
            postazione.repaint();
        }
    }

    public  void aggiornaVista(Piatto piatto, Postazione postazione) {
    	piatto.invalidate();
        piatto.validate();
        postazione.invalidate();
        postazione.validate();
    }

    public  void aggiornaTurno(Mano mano,Mazzo mazzo) {
        if (cartaScarto.getV() == 11) {
        	musicObjectBot.playButtonMusic("./src/audio/special_card_audio.wav");
            cambiaSenso();
            if (senso == Senso.ORARIO) {
                turno += 1;
            }
            else {
                turno -= 1;
            }
        }
        if (cartaScarto.getV() == 10) 
            turno += 2;
        if (senso == Senso.ORARIO && cartaScarto.getV() != 10 && cartaScarto.getV() != 11)
            turno += 1;
        if (senso == Senso.ANTIORARIO && cartaScarto.getV() != 10 && cartaScarto.getV() != 11)
            turno -= 1;
        Carta x = cartaUtile(mano);
        //if (Menu.turno % 4 == 0) Menu.evidenzia(0);
        if (turno % 4 == 0 && x == null) {
            System.out.println("non hai la carta da giocare");
            pesca(mazzo, mano);
        }
    }

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

    public  void passo() {
    	
        if (senso == Senso.ANTIORARIO) {
            turno = 3;
            partitaPanel.getFoto2().setBorder(new LineBorder(Color.RED, 5));
            musicObjectBot.playButtonMusic("./src/audio/Squirtle_audio.wav");
        }
        if (senso == Senso.ORARIO) {
            turno = 1;
            partitaPanel.getFoto().setBorder(new LineBorder(Color.RED, 5));
            musicObjectBot.playButtonMusic("./src/audio/Bulbasaur_audio.wav");
       
        }
    }
}
