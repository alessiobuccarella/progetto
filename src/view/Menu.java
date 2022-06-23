package view;

import javax.swing.*;

import controller.DisegnaCarta;
import controller.Eventi;
import model.Carta;
import model.Mano;
import model.Mazzo;
import model.Senso;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    public static int coloreSpeciale = 4;
    private JButton nuovoProfilo, caricaProfilo, esci, nuovaPartita, opzioniProfilo, esci2, classica, mod2, mod3, esci3;
    private JButton indietroButton, indietroButton2, indietroButton3, indietroButton4, inviaButton, inviaButton2;
    private JLabel label1, label2, label3;
    public static JPanel menu;

    private PostazioneGiocatore postazione;
    private PostazioneGiocatore postazioneNord;
    private static PostazioneLaterale postazioneOvest;
    private PostazioneLaterale postazioneEst;
    private static Piatto piatto;
    public static Senso senso = Senso.ORARIO;
    private Color colore = new Color(128, 128, 128);

    public static JButton posto0;
    public static JButton posto1;
    public static JButton posto2;
    public static JButton posto3;
    public static JButton posto4;
    public static JButton posto5;
    public static JButton posto6;
    public static JButton posto7;
    public static JButton posto8;
    public static JButton posto9;
    public static JButton posto10;
    public static JButton posto11;
    public static JButton posto12;
    public static JButton posto13;
    public static JButton posto14;
    public static JButton posto15;
    public static JButton posto16;
    public static JButton posto17;
    public static JButton posto18;
    public static JButton posto19;
    public static JButton posto20;
    public static JButton rosso;
    public static JButton giallo;
    public static JButton blu;
    public static JButton verde;
    public static JButton[] listaBottoni = new JButton[20];
    public static JButton scartoButton = new JButton();
    public static JButton passo = new JButton("PASSO");
    public static Carta cartaScarto = new Carta(0, 0);
    public static Mano mano;
    public Mano manoOvest;
    public static Mano manoNord;
    public static Mano manoEst;
    public static int turno;
    public static boolean firstTime = true;
    public static boolean pronto = false;
    public static int pescato = 0;

    public Menu() {
        super("JUno");
        setVisible(true);
        setSize(1000, 600);
        setLayout(new BorderLayout());
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

        posto0 = DisegnaCarta.disegnaCarta(mano.mano.get(0));
        posto1 = DisegnaCarta.disegnaCarta(mano.mano.get(1));
        posto2 = DisegnaCarta.disegnaCarta(mano.mano.get(2));
        posto3 = DisegnaCarta.disegnaCarta(mano.mano.get(3));
        posto4 = DisegnaCarta.disegnaCarta(mano.mano.get(4));
        posto5 = DisegnaCarta.disegnaCarta(mano.mano.get(5));
        posto6 = DisegnaCarta.disegnaCarta(mano.mano.get(6));
        posto7 = new JButton();
        posto8 = new JButton();
        posto8 = new JButton();
        posto9 = new JButton();
        posto10 = new JButton();
        posto11 = new JButton();
        posto12 = new JButton();
        posto13 = new JButton();
        posto14 = new JButton();
        posto15 = new JButton();
        posto16 = new JButton();
        posto17 = new JButton();
        posto18 = new JButton();
        posto19 = new JButton();
        posto20 = new JButton();
        cartaScarto = mazzo.pesca();
        scartoButton = DisegnaCarta.disegnaCarta(cartaScarto);


        menu = new JPanel();
        CardLayout cl = new CardLayout();
        menu.setLayout(cl);

        Audio audio = new Audio();
        Audio audio2 = new Audio();
        Audio audio3 = new Audio();
        Audio audio4 = new Audio();
        Audio audio5 = new Audio();
        Audio audio6 = new Audio();

        //PAGE INIZIALE
        JPanel inizio = new JPanel();
        JPanel nce = new JPanel();
        nce.setBackground(Color.red);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.anchor = GridBagConstraints.CENTER;
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
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc3.gridwidth = GridBagConstraints.REMAINDER;
        JLabel nick2 = new JLabel("Nickname:");
        JTextField textnickname2 = new JTextField(10);
        nick2.setFont(new Font("Dialog", Font.PLAIN, 15));
        JLabel avatar = new JLabel("Avatar:");
        avatar.setFont(new Font("Dialog", Font.PLAIN, 15));
        inviaButton2 = new JButton("INVIA");
        indietroButton2 = new JButton("<");
        ImageIcon avatar1png = new ImageIcon("./src/immagini/avatar1.png");
        Image image1 = avatar1png.getImage();
        Image newimg1 = image1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar1png = new ImageIcon(newimg1);
        //label1 = new JLabel(avatar1png);
        JButton radio1 = new JButton(avatar1png);
        radio1.setName("Avatar1");
        ImageIcon avatar2png = new ImageIcon("./src/immagini/avatar2.png");
        Image image2 = avatar2png.getImage();
        avatar2png = new ImageIcon(image2);
        Image newimg2 = image2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar2png = new ImageIcon(newimg2);
        JButton radio2 = new JButton(avatar2png);
        label2 = new JLabel(avatar2png);
        //radio2 = new JRadioButton("");
        radio2.setName("Avatar2");
        ImageIcon avatar3png = new ImageIcon("./src/immagini/avatar3.png");

        Image image3 = avatar3png.getImage();
        Image newimg3 = image3.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar3png = new ImageIcon(newimg3);
        label3 = new JLabel(avatar3png);
        //radio3 = new JRadioButton("");
        JButton radio3 = new JButton(avatar3png);
        //radio3.setName("Avatar3");
        ButtonGroup group = new ButtonGroup();
        //group.add(radio1);
        //group.add(radio2);
        //group.add(radio3);
        nuovoProfilo.setLayout(new BorderLayout());
        nickname2.setLayout(new GridBagLayout());
        image.setLayout(new GridBagLayout());
        indietro2.setLayout(new FlowLayout(FlowLayout.LEFT));
        nickname2.add(nick2, gbc3);
        nickname2.add(Box.createRigidArea(new Dimension(0, 35)));
        nickname2.add(textnickname2, gbc3);
        nickname2.add(Box.createRigidArea(new Dimension(0, 35)));
        nickname2.add(avatar, gbc3);
        radio1.setBorder(null);
        radio2.setBorder(null);
        radio3.setBorder(null);
        image.add(radio1, gbc4);
        image.add(Box.createRigidArea(new Dimension(5, 0)));
        image.add(radio2, gbc4);
        image.add(Box.createRigidArea(new Dimension(5, 0)));
        image.add(radio3, gbc4);

        //image.add(label1, gbc4);
        //image.add(radio2, gbc4);
        //image.add(label2, gbc4);
        //image.add(radio3, gbc4);
        //image.add(label3, gbc4);

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
        //gbc.anchor = GridBagConstraints.CENTER;
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
        listaBottoni[0] = posto0;
        listaBottoni[1] = posto1;
        listaBottoni[2] = posto2;
        listaBottoni[3] = posto3;
        listaBottoni[4] = posto4;
        listaBottoni[5] = posto5;
        listaBottoni[6] = posto6;
        listaBottoni[7] = posto7;
        listaBottoni[8] = posto8;
        listaBottoni[9] = posto9;
        listaBottoni[10] = posto10;
        listaBottoni[11] = posto11;
        listaBottoni[12] = posto12;
        listaBottoni[13] = posto13;
        listaBottoni[14] = posto14;
        listaBottoni[15] = posto15;
        listaBottoni[16] = posto16;
        listaBottoni[17] = posto17;
        listaBottoni[18] = posto18;
        listaBottoni[19] = posto19;

        Campo campo = new Campo();
        postazione = new PostazioneGiocatore();

        campo.add(postazione, BorderLayout.PAGE_END);

        postazione.setBackground(colore);


        postazione.add(posto0);
        postazione.add(posto1);
        postazione.add(posto2);
        postazione.add(posto3);
        postazione.add(posto4);
        postazione.add(posto5);
        postazione.add(posto6);


        postazioneOvest = new PostazioneLaterale();
        campo.add(postazioneOvest, BorderLayout.WEST);
        for (int i = 0; i < 7; i++) {
            postazioneOvest.add(new JLabel(new ImageIcon("./src/immagini/dorso90.png")));
            postazioneOvest.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        ;
        postazioneOvest.setBackground(colore);

        postazioneNord = new PostazioneGiocatore();
        campo.add(postazioneNord, BorderLayout.PAGE_START);
        for (int i = 0; i < 7; i++) postazioneNord.add(new JLabel(new ImageIcon("./src/immagini/dorso180.png")));
        postazioneNord.setBackground(colore);


        piatto = new Piatto();
        campo.add(piatto, BorderLayout.CENTER);
        piatto.setBackground(colore);
        //piatto.add(fatto);
        deckButton.setBorder(null);
        piatto.add(passo);
        piatto.add(deckButton);
        piatto.add(scartoButton);


        postazioneEst = new PostazioneLaterale();
        campo.add(postazioneEst, BorderLayout.EAST);
        for (int i = 0; i < 7; i++) {
            postazioneEst.add(new JLabel(new ImageIcon("./src/immagini/dorso90s.png")));
            postazioneEst.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        ;
        postazioneEst.setBackground(colore);
        menu.add(campo, "7");
        ActionListener avanti = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                invalidate();
                validate();
                repaint();
                if (firstTime == false)
                    Eventi.avanti(turno, manoOvest, manoNord, manoEst, piatto, postazioneOvest, postazioneNord, postazioneEst, mazzo, postazione, manoEst);
                else {
                    firstTime = false;
                }

            }
        };
        Timer t = new Timer(2000, avanti);


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

        inviaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(menu, "4");
            }
        });

        inviaButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(menu, "4");
            }
        });

        classica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(menu, "7");


            }
        });


        deckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mano.mano.add(mazzo.pesca());

                listaBottoni[mano.mano.size() - 1].add(new JLabel(new ImageIcon(mano.mano.get(mano.mano.size() - 1).getPath())));
                listaBottoni[mano.mano.size() - 1].setBorder(null);
                postazione.add(listaBottoni[mano.mano.size() - 1]);

                postazione.invalidate();
                postazione.validate();


            }
        });

        passo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.passo(mano, 0, posto0, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, mazzo);
            }
        });

        posto0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto0), posto0, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
                t.start();
            }
        });

        posto1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto1), posto1, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto2), posto2, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto3), posto3, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto4), posto4, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto5), posto5, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto6), posto6, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto7), posto7, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto8), posto8, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto9), posto9, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto10), posto10, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto11), posto11, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto12), posto12, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto13), posto13, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto14), posto14, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto15), posto15, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
            }
        });
        posto16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto16), posto16, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
                t.start();
            }
        });
        posto17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto17), posto17, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
                t.start();
            }
        });
        posto18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto18), posto18, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
                t.start();
            }
        });
        posto19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                repaint();
                t.start();
                Eventi.cliccato(mano, postazione.getComponentZOrder(posto19), posto19, postazione, piatto, turno, manoOvest, manoNord, manoEst, postazioneOvest, postazioneNord, postazioneEst, listaBottoni, mazzo);
                t.start();
            }
        });
        rosso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coloreSpeciale = 0;
                piatto.remove(rosso);
                piatto.remove(giallo);
                piatto.remove(verde);
                piatto.remove(blu);
                Menu.cartaScarto.setC(0);
                repaint();
                t.start();
            }
        });

        giallo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coloreSpeciale = 1;
                piatto.remove(rosso);
                piatto.remove(giallo);
                piatto.remove(verde);
                piatto.remove(blu);
                Menu.cartaScarto.setC(1);
                repaint();
                t.start();
            }
        });
        blu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coloreSpeciale = 2;
                piatto.remove(rosso);
                piatto.remove(giallo);
                piatto.remove(verde);
                piatto.remove(blu);
                Menu.cartaScarto.setC(2);
                repaint();
                t.start();
            }
        });
        verde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coloreSpeciale = 3;
                piatto.remove(rosso);
                piatto.remove(giallo);
                piatto.remove(verde);
                piatto.remove(blu);
                Menu.cartaScarto.setC(3);
                repaint();
                t.start();
            }
        });

    }
}
		


		
        
        
        
    
    


