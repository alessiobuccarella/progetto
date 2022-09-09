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

import static view2.ProfiloPanel.immagine;

public class PartitaPanel extends JPanel {

	Mazzo mazzo = new Mazzo();
	private PostazionePanel postazioneNord;
	private PostazionePanel postazioneOvest;
	private PostazionePanel postazioneEst;
	private PostazionePanel postazionePiatto;
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
	private PiattoPanel tavolo;
	private PostazionePanel postazione;
	private Carta cartaScarto;
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
    PartitaPanel partitaPanel;
    private int mod;
	
	public PartitaPanel(int x) {
    	setLayout(new BorderLayout());
    	do
            setCartaScarto(mazzo.next());
        while (getCartaScarto().getV() > 12);
    	manoOvest = new Mano(mazzo);
    	manoNord = new Mano(mazzo);
    	manoEst = new Mano(mazzo);
    	mano = new Mano(mazzo);
    	partitaPanel=this;
    	tavolo=new PiattoPanel();
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
        passo= new JButton("PASSO");
        setPostazione(new PostazionePanel(1));
        mod=x;
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
        tavolo.add(getFoto1(),gbc10);
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
        gbc10.anchor = GridBagConstraints.LINE_END;
        gbc10.gridx = 4;
        gbc10.gridy = 7;
        gbc10.weightx = 0;
        gbc10.weighty = 0;
        gbc10.gridwidth = 1;
        tavolo.add(passo,gbc10);
        gbc10.anchor = GridBagConstraints.LINE_END;
        gbc10.gridx = 5;
        gbc10.gridy = 7;
        gbc10.weightx = 0;
        gbc10.weighty = 0;
        gbc10.gridwidth = 1;
        //tavolo.add(nomegiocatore,gbc10);
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
        if (x==1) gbc10.gridx = 4;
        else gbc10.gridx = 3;
        gbc10.gridy = 5;
        
        gbc10.weighty = 4;
        tavolo.add(getPostazione(),gbc10);
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
        	tavolo.add(getFoto(),gbc10);
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
        	tavolo.add(getFoto2(),gbc10);
        }
        gbc10.anchor = GridBagConstraints.PAGE_START;
        gbc10.gridx = 4;
        gbc10.gridy = 6;
        gbc10.weighty = 2;
        //tavolo.add(xxxxxx,gbc10);
     
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
                    	
						eventi.cliccato(gbc10, mano, getPostazione().getComponentZOrder(posto), posto, getPostazione(), getTavolo(), manoOvest, manoNord,
								manoEst, postazioneOvest, postazioneNord, postazioneEst, getPosti(), mazzo, postazionePiatto);
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
                    System.out.println("timer");
                   eventi.avanti(gbc10, eventi.turno, manoOvest, manoNord, manoEst, tavolo, postazioneOvest, postazioneNord, postazioneEst, mazzo, getPostazione(), mano,postazionePiatto);
                }
            };
            t = new Timer(6000, avanti);
          
        }
    }

    public JLabel getFoto(int foto) {
        switch(foto) {
            case 1:
                return getFoto1();
            case 2:
                return getFoto2();
            case 3:
                return foto3;
            default:
                return this.foto;
        }
    }

    public  void aggiornaPostazione(Mano mano) {
        getPostazione().removeAll();
        for (int i = 0; i < mano.mano.size(); i++)
            getPosti().set(i, DisegnaCarta.disegnaCarta(mano.mano.get(i)));
        for (int i = 0; i < mano.mano.size(); i++)
            getPostazione().add(getPosti().get(i));
        getPostazione().invalidate();
        getPostazione().validate();
        getPostazione().repaint();
    }

    public void funzioneUno(ActionListener actionListener) {
        uno.addActionListener(actionListener);
    }


    public int getMod() {
    	return mod;
    }

	public JLabel getFoto() {
		return foto;
	}

	public void setFoto(JLabel foto) {
		this.foto = foto;
	}

	public JLabel getFoto1() {
		return foto1;
	}

	public void setFoto1(JLabel foto1) {
		this.foto1 = foto1;
	}

	public JLabel getFoto2() {
		return foto2;
	}

	public void setFoto2(JLabel foto2) {
		this.foto2 = foto2;
	}

    public JLabel getFoto3() {
        return foto3;
    }

    public void setFoto3(JLabel foto3) {
        this.foto3 = foto3;
    }

	public JButton getScartoButton() {
		return scartoButton;
	}

	public void setScartoButton(JButton scartoButton) {
		this.scartoButton = scartoButton;
	}

	public JButton getColoreRosso() {
		return coloreRosso;
	}

	public void setColoreRosso(JButton coloreRosso) {
		this.coloreRosso = coloreRosso;
	}

	public JButton getColoreGiallo() {
		return coloreGiallo;
	}

	public void setColoreGiallo(JButton coloreGiallo) {
		this.coloreGiallo = coloreGiallo;
	}

	public JButton getColoreVerde() {
		return coloreVerde;
	}

	public void setColoreVerde(JButton coloreVerde) {
		this.coloreVerde = coloreVerde;
	}

	public JButton getColoreBlu() {
		return coloreBlu;
	}

	public void setColoreBlu(JButton coloreBlu) {
		this.coloreBlu = coloreBlu;
	}

	public Icon getRedLabel() {
		return redLabel;
	}

	public void setRedLabel(Icon redLabel) {
		this.redLabel = redLabel;
	}

	public Icon getGreenLabel() {
		return greenLabel;
	}

	public void setGreenLabel(Icon greenLabel) {
		this.greenLabel = greenLabel;
	}

	public Icon getYellowLabel() {
		return yellowLabel;
	}

	public void setYellowLabel(Icon yellowLabel) {
		this.yellowLabel = yellowLabel;
	}

	public Icon getBlueLabel() {
		return blueLabel;
	}

	public void setBlueLabel(Icon blueLabel) {
		this.blueLabel = blueLabel;
	}

	public ArrayList<JButton> getPosti() {
		return posti;
	}

	public void setPosti(ArrayList<JButton> posti) {
		this.posti = posti;
	}

	public PostazionePanel getPostazione() {
		return postazione;
	}

	public void setPostazione(PostazionePanel postazione) {
		this.postazione = postazione;
	}

	public PiattoPanel getTavolo() {
		return tavolo;
	}

	public void setTavolo(PiattoPanel tavolo) {
		this.tavolo = tavolo;
	}

	public Carta getCartaScarto() {
		return cartaScarto;
	}

	public void setCartaScarto(Carta cartaScarto) {
		this.cartaScarto = cartaScarto;
	}
}
