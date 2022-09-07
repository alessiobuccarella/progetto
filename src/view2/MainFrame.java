package view2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import controller.*;
import model.Database;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -5535790746189171625L;
	private CardLayout cardLayout;

    public MainFrame() {
        super("JUno");
        setVisible(true);
        setSize(1200, 680);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        cardLayout = new CardLayout();

        //Panel
        InizioPanel inzioPanel = new InizioPanel();
        CercaProfiloPanel cercaProfilo = new CercaProfiloPanel();
        NuovoProfiloPanel nuovoProfilo = new NuovoProfiloPanel();   
        ProfiloPanel profilo = new ProfiloPanel();
        MenuPanel inizio2 = new MenuPanel();
        ConfiguraPanel configuraPartita = new ConfiguraPanel();
        PartitaPanel partitaPanel = new PartitaPanel();

        // initialize user controller
        new CercaProfiloController(cercaProfilo, profilo, cardLayout, MainFrame.this.getContentPane());
        new NuovoProfiloController(nuovoProfilo, profilo, cardLayout, MainFrame.this.getContentPane());
        new PartitaController(partitaPanel);
        
        // aggiunge i panel al layout
        setLayout(cardLayout);
        add(inzioPanel, "inizio");
        add(cercaProfilo, "cercaProfilo");
        add(nuovoProfilo, "nuovoProfilo");
        add(profilo, "profilo");
        add(inizio2, "inizio2");
        add(configuraPartita, "configuraPartita");
        add(partitaPanel, "partitaPanel");

        AudioManager musicObject = AudioManager.getInstance();
        AudioButtonManager musicObjectButton = new AudioButtonManager();
        musicObject.playMusic("./src/audio/background_menu_audio.wav");

        inzioPanel.caricaProfilo(e -> {
            musicObjectButton.playButtonMusic("./src/audio/general_menu_button_audio.wav");
            cardLayout.show(MainFrame.this.getContentPane(), "cercaProfilo");
        });
        inzioPanel.nuovoProfilo(e -> {
            musicObjectButton.playButtonMusic("./src/audio/general_menu_button_audio.wav");
            cardLayout.show(MainFrame.this.getContentPane(), "nuovoProfilo");
        });
        inzioPanel.esci(e -> {
            musicObjectButton.playButtonMusic("./src/audio/general_menu_button_audio.wav");
            Database.getInstance().close();
        	System.exit(0);
        });

        cercaProfilo.paginaPrec(e -> {
            musicObjectButton.playButtonMusic("./src/audio/general_menu_button_audio.wav");
            cardLayout.show(MainFrame.this.getContentPane(), "inizio");
        });
        nuovoProfilo.paginaPrec(e -> {
            musicObjectButton.playButtonMusic("./src/audio/general_menu_button_audio.wav");
            cardLayout.show(MainFrame.this.getContentPane(), "inizio");
        });
        profilo.paginaPrec(e -> {
            musicObjectButton.playButtonMusic("./src/audio/general_menu_button_audio.wav");
            cardLayout.show(MainFrame.this.getContentPane(), "inizio2");
        });

        inizio2.opzioniProfilo(e -> {
            musicObjectButton.playButtonMusic("./src/audio/general_menu_button_audio.wav");
            cardLayout.show(MainFrame.this.getContentPane(), "profilo");
        });
        inizio2.nuovaPartita(e -> {
            musicObjectButton.playButtonMusic("./src/audio/general_menu_button_audio.wav");
            cardLayout.show(MainFrame.this.getContentPane(), "configuraPartita");
        });
        inizio2.esci(e -> {
            musicObjectButton.playButtonMusic("./src/audio/general_menu_button_audio.wav");
            Database.getInstance().close();
            System.exit(0);
        });

        configuraPartita.paginaPrec(e -> {
            musicObjectButton.playButtonMusic("./src/audio/general_menu_button_audio.wav");
            cardLayout.show(MainFrame.this.getContentPane(), "inizio2");
        });
        configuraPartita.classica(e -> {
            musicObjectButton.playButtonMusic("./src/audio/general_menu_button_audio.wav");
            musicObject.playMusic("./src/audio/background_menu_audio.wav");
            musicObject.playMusic("./src/audio/background_game_audio2.wav");
        });
        configuraPartita.classica(e -> {
            musicObjectButton.playButtonMusic("./src/audio/general_menu_button_audio.wav");
            cardLayout.show(MainFrame.this.getContentPane(), "partitaPanel");
        });
    }
}

