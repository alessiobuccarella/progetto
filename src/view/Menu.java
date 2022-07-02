package view;

import javax.swing.*;
import java.awt.*;
import controller.DisegnaCarta;
import controller.Eventi;
import model.Carta;
import model.Database;


import model.Mano;
import model.Mazzo;
import model.Senso;
import java.awt.event.*;
import java.util.ArrayList;

import static model.Database.*;

public class Menu extends JFrame {
	public static boolean finito=false;
	public static boolean gridatoUno=false;
	public static boolean deviGridareUno=false;
    public static int coloreSpeciale = 4;
    private JButton nuovoProfilo, caricaProfilo, esci, nuovaPartita, opzioniProfilo, esci2, classica, mod2, mod3, esci3;
    private JButton indietroButton, indietroButton2, indietroButton3, indietroButton4, inviaButton, inviaButton2;
    public static JPanel menu;
    private static Postazione postazione;
    private Postazione postazioneNord;
    private static Postazione postazioneOvest;
    private Postazione postazioneEst;
    private  Piatto piatto;
    public static Senso senso = Senso.ORARIO;
    private Color colore = new Color(255, 0, 0);
    public static JButton uno;
    public static JButton rosso;
    public static JButton giallo;
    public static JButton blu;
    public static JButton verde;
    public static JTextField textnickname, textnickname2 ;
    public static ImageIcon avatar1png, avatar2png, avatar3png;
    public static JButton scartoButton = new JButton();
    public static JButton passo = new JButton("PASSO");
    public static Carta cartaScarto = new Carta(0, 0);
    public static int turno;
    public static boolean firstTime = true;
    public static ArrayList<JButton> posti = new ArrayList<>();
    public Menu() {
        super("JUno");
        setVisible(true);
        setSize(1000, 700);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int i=0;i<30;i++)posti.add(new JButton());
        scartoButton = new JButton();
        Mazzo mazzo = new Mazzo();
        Mano mano = new Mano(mazzo);
        Mano manoOvest = new Mano(mazzo);
        Mano manoNord = new Mano(mazzo);
        Mano manoEst = new Mano(mazzo);
        rosso = new JButton("");
        rosso.setBackground(Color.red);
        giallo = new JButton("");
        giallo.setBackground(Color.yellow);
        blu = new JButton("");
        blu.setBackground(Color.blue);
        verde = new JButton("");
        verde.setBackground(Color.green);
        uno= new JButton("1!");
        ArrayList<JButton> colori = new ArrayList<>();
        colori.add(rosso);
        colori.add(giallo);
        colori.add(blu);
        colori.add(verde);
        do cartaScarto=mazzo.next(); while(cartaScarto.getV()>12);
        scartoButton = DisegnaCarta.disegnaCarta(cartaScarto);
        menu = new JPanel();
        CardLayout cl = new CardLayout();
        menu.setLayout(cl);
        BarraAudio audio = new BarraAudio();
        BarraAudio audio2 = new BarraAudio();
        BarraAudio audio3 = new BarraAudio();
        BarraAudio audio4 = new BarraAudio();
        BarraAudio audio5 = new BarraAudio();
        BarraAudio audio6 = new BarraAudio();
        //PAGE INIZIALE
        JPanel inizio = new JPanel();
        JPanel nce = new JPanel();
        nce.setBackground(Color.red);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nuovoProfilo = new JButton("NUOVO PROFILO");
        caricaProfilo = new JButton("CARICA PROFILO");
        esci = new JButton("ESCI");
        nuovoProfilo.setPreferredSize(new Dimension(150, 50));
        caricaProfilo.setPreferredSize(new Dimension(150, 50));
        esci.setPreferredSize(new Dimension(150, 50));
        inizio.setLayout(new BorderLayout());
        nce.setLayout(new GridBagLayout());
        nce.add(nuovoProfilo, gbc);
        nce.add(Box.createRigidArea(new Dimension(0, 70)));
        nce.add(caricaProfilo, gbc);
        nce.add(Box.createRigidArea(new Dimension(0, 40)));
        nce.add(esci, gbc);
        inizio.add(nce, BorderLayout.CENTER);
        inizio.add(audio, BorderLayout.PAGE_START);
        add(menu);
        menu.add(inizio, "1");
        //PAGE CARICAPROFILO
        JPanel caricaProfilo = new JPanel();
        JPanel nickname = new JPanel();
        JPanel indietro = new JPanel();
        indietro.setBackground(Color.black);
        nickname.setBackground(Color.red);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridwidth = GridBagConstraints.REMAINDER;
        JLabel nick = new JLabel("Nickname:");
        nick.setFont(new Font("Dialog", Font.PLAIN, 15));
        JTextField textnickname = new JTextField(10);
        inviaButton = new JButton("INVIA");
        indietroButton = new JButton("<");
        caricaProfilo.setLayout(new BorderLayout());
        nickname.setLayout(new GridBagLayout());
        indietro.setLayout(new FlowLayout(FlowLayout.LEFT));
        nickname.add(nick, gbc2);
        nickname.add(Box.createRigidArea(new Dimension(0, 35)));
        nickname.add(textnickname, gbc2);
        nickname.add(Box.createRigidArea(new Dimension(0, 50)));
        nickname.add(inviaButton, gbc2);
        indietro.add(indietroButton);
        caricaProfilo.add(nickname, BorderLayout.CENTER);
        caricaProfilo.add(audio2, BorderLayout.PAGE_START);
        caricaProfilo.add(indietro, BorderLayout.PAGE_END);
        menu.add(caricaProfilo, "2");
        //PAGE NUOVOPROFILO
        JPanel nuovoProfilo = new JPanel();
        JPanel nickname2 = new JPanel();
        JPanel image = new JPanel();
        JPanel indietro2 = new JPanel();
        indietro2.setBackground(Color.black);
        nickname2.setBackground(Color.red);
        image.setBackground(Color.red);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridwidth = GridBagConstraints.REMAINDER;
        JLabel nick2 = new JLabel("Nickname:");
        textnickname2  = new JTextField(10);
        nick2.setFont(new Font("Dialog", Font.PLAIN, 15));
        JLabel avatar = new JLabel("Avatar:");
        avatar.setFont(new Font("Dialog", Font.PLAIN, 15));
        inviaButton2 = new JButton("INVIA");
        indietroButton2 = new JButton("<");
        ButtonGroup avatari = new ButtonGroup();
        avatar1png = new ImageIcon("./src/immagini/avatar1.png");
        Image image1 = avatar1png.getImage();
        Image newimg1 = image1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar1png = new ImageIcon(newimg1);
        JToggleButton radio1 = new JToggleButton(avatar1png);
        radio1.setName("Avatar1");
        avatar2png = new ImageIcon("./src/immagini/avatar2.png");
        Image image2 = avatar2png.getImage();
        Image newimg2 = image2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar2png = new ImageIcon(newimg2);
        JToggleButton radio2 = new JToggleButton(avatar2png);
        radio2.setName("Avatar2");
        avatar3png = new ImageIcon("./src/immagini/avatar3.png");
        Image image3 = avatar3png.getImage();
        Image newimg3 = image3.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar3png = new ImageIcon(newimg3);
        JToggleButton radio3 = new JToggleButton(avatar3png);
        radio2.setName("Avatar3");
        avatari.add(radio1);
        avatari.add(radio2);
        avatari.add(radio3);
        nuovoProfilo.setLayout(new BorderLayout());
        nickname2.setLayout(new GridBagLayout());
        image.setLayout(new GridBagLayout());
        indietro2.setLayout(new FlowLayout(FlowLayout.LEFT));
        nickname2.add(nick2, gbc3);
        nickname2.add(Box.createRigidArea(new Dimension(0, 35)));
        nickname2.add(textnickname2, gbc3);
        nickname2.add(Box.createRigidArea(new Dimension(0, 35)));
        nickname2.add(avatar, gbc3);
        image.add(radio1);
        image.add(Box.createRigidArea(new Dimension(5, 0)));
        image.add(radio2);
        image.add(Box.createRigidArea(new Dimension(5, 0)));
        image.add(radio3);
        nickname2.add(image, gbc3);
        nickname2.add(Box.createRigidArea(new Dimension(0, 70)));
        nickname2.add(inviaButton2, gbc3);
        indietro2.add(indietroButton2);
        nuovoProfilo.add(nickname2, BorderLayout.CENTER);
        nuovoProfilo.add(audio3, BorderLayout.PAGE_START);
        nuovoProfilo.add(indietro2, BorderLayout.PAGE_END);
        menu.add(nuovoProfilo, "3");
        //PAGE INIZIALE2
        JPanel inizio2 = new JPanel();
        JPanel noe = new JPanel();
        noe.setBackground(Color.red);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridwidth = GridBagConstraints.REMAINDER;
        gbc5.fill = GridBagConstraints.HORIZONTAL;
        nuovaPartita = new JButton("NUOVA PARTITA");
        opzioniProfilo = new JButton("OPZIONI PROFILO");
        esci2 = new JButton("ESCI");
        nuovaPartita.setPreferredSize(new Dimension(150, 50));
        opzioniProfilo.setPreferredSize(new Dimension(150, 50));
        esci2.setPreferredSize(new Dimension(150, 50));
        inizio2.setLayout(new BorderLayout());
        noe.setLayout(new GridBagLayout());
        noe.add(nuovaPartita, gbc5);
        noe.add(Box.createRigidArea(new Dimension(0, 70)));
        noe.add(opzioniProfilo, gbc5);
        noe.add(Box.createRigidArea(new Dimension(0, 40)));
        noe.add(esci2, gbc5);
        inizio2.add(noe, BorderLayout.CENTER);
        inizio2.add(audio4, BorderLayout.PAGE_START);
        menu.add(inizio2, "4");
        //PAGE MODALITA'
        JPanel modalita = new JPanel();
        JPanel cmm = new JPanel();
        JPanel indietro3 = new JPanel();
        indietro3.setBackground(Color.black);
        cmm.setBackground(Color.red);
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridwidth = GridBagConstraints.REMAINDER;
        gbc6.fill = GridBagConstraints.HORIZONTAL;
        classica = new JButton("CLASSICA");
        mod2 = new JButton("MOD2");
        mod3 = new JButton("MOD3");
        esci3 = new JButton("ESCI");
        classica.setPreferredSize(new Dimension(150, 50));
        mod2.setPreferredSize(new Dimension(150, 50));
        mod3.setPreferredSize(new Dimension(150, 50));
        esci3.setPreferredSize(new Dimension(150, 50));
        indietroButton3 = new JButton("<");
        modalita.setLayout(new BorderLayout());
        cmm.setLayout(new GridBagLayout());
        indietro3.setLayout(new FlowLayout(FlowLayout.LEFT));
        cmm.add(classica, gbc6);
        cmm.add(Box.createRigidArea(new Dimension(0, 70)));
        cmm.add(mod2, gbc6);
        cmm.add(Box.createRigidArea(new Dimension(0, 40)));
        cmm.add(mod3, gbc6);
        cmm.add(Box.createRigidArea(new Dimension(0, 70)));
        cmm.add(esci3, gbc6);
        indietro3.add(indietroButton3);
        modalita.add(cmm, BorderLayout.CENTER);
        modalita.add(audio5, BorderLayout.PAGE_START);
        modalita.add(indietro3, BorderLayout.PAGE_END);
        menu.add(modalita, "5");
        //PAGE ACCOUNT
        JPanel account = new JPanel();
        JPanel oa = new JPanel();
        JPanel oa2 = new JPanel();
        JPanel oa3 = new JPanel();
        JPanel indietro4 = new JPanel();
        indietro4.setBackground(Color.black);
        oa.setBackground(Color.red);
        oa2.setBackground(Color.red);
        oa3.setBackground(Color.red);
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridwidth = GridBagConstraints.REMAINDER;
        gbc7.fill = GridBagConstraints.HORIZONTAL;
        GridBagConstraints gbc8 = new GridBagConstraints();
        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridwidth = GridBagConstraints.REMAINDER;
        gbc9.fill = GridBagConstraints.HORIZONTAL;
        JLabel nick3 = new JLabel("NICKNAME: Alessio");
        nick3.setFont(new Font("Dialog", Font.PLAIN, 20));
        ImageIcon avatar4png = new ImageIcon("./src/immagini/avatar3.png");
        Image image4 = avatar4png.getImage();
        Image newimg4 = image4.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar4png = new ImageIcon(newimg4);
        JLabel myavatar = new JLabel(avatar4png);
        JLabel livello = new JLabel("LIVELLO: 23");
        livello.setFont(new Font("Dialog", Font.PLAIN, 20));
        JLabel partiteGiocate = new JLabel("PARTITE GIOCATE: 55");
        partiteGiocate.setFont(new Font("Dialog", Font.PLAIN, 15));
        JLabel partiteVinte = new JLabel("PARTITE VINTE: 40");
        partiteVinte.setFont(new Font("Dialog", Font.PLAIN, 15));
        JLabel partitePerse = new JLabel("PARTITE PERSE: 15");
        partitePerse.setFont(new Font("Dialog", Font.PLAIN, 15));
        indietroButton4 = new JButton("<");
        account.setLayout(new BorderLayout());
        oa.setLayout(new GridBagLayout());
        oa2.setLayout(new GridBagLayout());
        oa3.setLayout(new GridBagLayout());
        indietro4.setLayout(new FlowLayout(FlowLayout.LEFT));
        oa2.add(myavatar, gbc8);
        oa2.add(Box.createRigidArea(new Dimension(4, 0)));
        oa3.add(nick3, gbc9);
        oa3.add(livello, gbc9);
        oa2.add(oa3, gbc8);
        oa.add(oa2, gbc7);
        oa.add(partiteGiocate, gbc7);
        oa.add(partiteVinte, gbc7);
        oa.add(partitePerse, gbc7);
        indietro4.add(indietroButton4);
        account.add(oa, BorderLayout.CENTER);
        account.add(audio6, BorderLayout.PAGE_START);
        account.add(indietro4, BorderLayout.PAGE_END);
        menu.add(account, "6");
        //PAGE PARTITA
        JLabel deckLabel = new JLabel(new ImageIcon("./src/immagini/dorso.png"));
        JButton deckButton = new JButton();
        deckButton.setHorizontalTextPosition(SwingConstants.CENTER);
        deckButton.add(deckLabel);
        Campo campo = new Campo();
        postazione = new Postazione(1);
        campo.add(postazione, BorderLayout.PAGE_END);
        postazione.setBackground(colore);
        for (int i=0;i<mano.mano.size();i++)posti.set(i,DisegnaCarta.disegnaCarta(mano.mano.get(i)));
        for (int i=0;i<mano.mano.size();i++)postazione.add(posti.get(i));
        postazioneOvest = new Postazione(0);
        campo.add(postazioneOvest, BorderLayout.WEST);
        for (int i = 0; i < 7; i++) {
            postazioneOvest.add(new JLabel(new ImageIcon("./src/immagini/dorso90.png")));
            postazioneOvest.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        postazioneOvest.setBackground(colore);
        postazioneNord = new Postazione(1);
        campo.add(postazioneNord, BorderLayout.PAGE_START);
        for (int i = 0; i < 7; i++) postazioneNord.add(new JLabel(new ImageIcon("./src/immagini/dorso180.png")));
        postazioneNord.setBackground(colore);
        piatto = new Piatto();
        piatto.setBackground(colore);
        //ImageIcon avatar1png = new ImageIcon("./src/immagini/avatar1.png");JLabel nick = new JLabel("Nickname:");
        JLabel foto = new JLabel(avatar1png);
        JLabel foto1 = new JLabel(avatar1png);
        JLabel foto2 = new JLabel(avatar1png);
        JLabel foto3 = new JLabel(avatar1png);
        GridBagConstraints gbc10= new GridBagConstraints();
        campo.add(piatto, BorderLayout.CENTER);
        
        gbc10.anchor=GridBagConstraints.FIRST_LINE_END;
        gbc10.gridx=4;
        gbc10.gridy=1;
        gbc10.weightx=0.0;
        gbc10.weighty=0;
        piatto.add(new JLabel("Heap"),gbc10);
        gbc10.anchor=GridBagConstraints.PAGE_START;
        gbc10.gridx=4;
        gbc10.gridy=0;
        gbc10.weightx=0.0;
        gbc10.weighty=0;
        piatto.add(foto1,gbc10);
        
        gbc10.anchor=GridBagConstraints.PAGE_END;
        gbc10.gridx=0;
        gbc10.gridy=1;
        gbc10.weightx=0.0;
        gbc10.weighty=0;
        piatto.add(foto,gbc10);
        gbc10.anchor=GridBagConstraints.PAGE_START;
        gbc10.gridx=0;
        gbc10.gridy=2;
        gbc10.weightx=0;
        gbc10.weighty=0;
        piatto.add(new JLabel("Stack"),gbc10);

        gbc10.anchor=GridBagConstraints.LAST_LINE_END;
        gbc10.gridx=6;
        gbc10.gridy=1;
        gbc10.weightx=1;
        gbc10.weighty=1;
        piatto.add(foto2,gbc10);
        gbc10.anchor=GridBagConstraints.FIRST_LINE_END;
        gbc10.gridx=6;
        gbc10.gridy=2;
        gbc10.weightx=1;
        gbc10.weighty=1;
        piatto.add(new JLabel("MetaSpace"),gbc10);
        
        gbc10.anchor=GridBagConstraints.LAST_LINE_END;
        gbc10.gridx=3;
        gbc10.gridy=4;
        gbc10.weightx=0.5;
        gbc10.weighty=0;

        piatto.add(new JLabel("Alessietto"),gbc10);

        gbc10.gridx=3;
        gbc10.gridy=3;
        gbc10.weightx=0.0;
        gbc10.weighty=0;
        piatto.add(foto3,gbc10);
        
        gbc10.anchor=GridBagConstraints.LINE_END;
        gbc10.gridx=5;
        gbc10.gridy=3;
        gbc10.weightx=0.0;
        gbc10.weighty=0;
        piatto.add(uno,gbc10);
        gbc10.anchor=GridBagConstraints.LINE_START;
        deckButton.setBorder(null);
        gbc10.gridx=6;
        gbc10.gridy=3;
        gbc10.weightx=0;
        gbc10.weighty=0;
        piatto.add(passo,gbc10);       
  
        gbc10.anchor=GridBagConstraints.LINE_START;
        gbc10.weightx=0;
        gbc10.weighty=0;
        gbc10.gridx=4;
        gbc10.gridy=1;
        piatto.add(deckButton,gbc10);
        gbc10.anchor=GridBagConstraints.LINE_START;
        gbc10.weightx=0;
        gbc10.weighty=0;
        gbc10.gridx=5;
        gbc10.gridy=1;
        piatto.add(scartoButton,gbc10);
        postazioneEst = new Postazione(0);
        campo.add(postazioneEst, BorderLayout.EAST);
        for (int i = 0; i < 7; i++) {
            postazioneEst.add(new JLabel(new ImageIcon("./src/immagini/dorso90s.png")));
            postazioneEst.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        postazioneEst.setBackground(colore);
        menu.add(campo, "7");
        ActionListener avanti = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
                if (firstTime == false)
                    Eventi.avanti(gbc10, turno, manoOvest, manoNord, manoEst, piatto, postazioneOvest, postazioneNord, postazioneEst, mazzo, postazione, mano);
                else {
                    firstTime = false;
                }
            }
        };
        this.nuovoProfilo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(menu, "3");
            }
        });
        this.caricaProfilo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(menu, "2");
            }
        });
        nuovaPartita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(menu, "5");
            }
        });
        opzioniProfilo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(menu, "6");
            }
        });
        esci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        esci2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        esci3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(menu, "1");
            }
        });
        indietroButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(menu, "1");
            }
        });
        indietroButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(menu, "4");
            }
        });
        indietroButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(menu, "4");
            }
        });
        Database db = new Database();
        inviaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nickname = textnickname.getText();
                db.updateDB2(nickname);
                if(valido3 == true) {
                    JOptionPane.showMessageDialog(null, "Benvenuto " + nickname + "!");
                    cl.show(menu, "4");
                } else {
                    JOptionPane.showMessageDialog(null, "Nickname inesistente");
                }
            }
        });
        inviaButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nickname2 = textnickname2.getText();
                String img = "";
                if(radio1.isSelected()){
                    String image1 = "./src/immagini/avatar1.png";
                    img = image1;
                    db.updateDB(nickname2, img);
                }
                if (radio2.isSelected()){
                    String image2 = "./src/immagini/avatar2.png";
                    img = image2;
                    db.updateDB(nickname2, img);
                }
                if (radio3.isSelected()){
                    String image3 = "./src/immagini/avatar3.png";
                    img = image3;
                    db.updateDB(nickname2, img);
                }
                if(!radio1.isSelected() && !radio2.isSelected() && !radio3.isSelected()){
                    JOptionPane.showMessageDialog(null, "Seleziona un avatar");
                }
                if(valido == true && valido2 == true) {
                    JOptionPane.showMessageDialog(null, "Profilo creato con successo!");
                    cl.show(menu, "4");
                }
            }
        });
        classica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(menu, "7");
            }
        });
        uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (deviGridareUno==true) 
            		{gridatoUno=true;
            		 System.out.println("hai urlato 1!");
            		}
            }
        });
        deckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              pesca(mazzo,mano);
            }
        });
        Timer t = new Timer(1000, avanti);
        passo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.passo(gbc10, mano, 0, null, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, mazzo);
            }
        });
        for (JButton posto : posti){
            posto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println();
                    repaint();
                    	t.start();
                    	Eventi.cliccato(gbc10, mano, postazione.getComponentZOrder(posto), posto, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, posti, mazzo);
                    	if (cartaScarto.getC()==4) t.stop();
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
        for(int colore = 0; colore < colori.size(); colore++){
            int finalColore = colore;
            colori.get(colore).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    coloreSpeciale = finalColore;
                    postazione.remove(rosso);
                    postazione.remove(giallo);
                    postazione.remove(verde);
                    postazione.remove(blu);
                    Menu.cartaScarto.setC(finalColore);
                    repaint();
                    t.start();
                }
            });
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
    	  }
    }

        
    
    


