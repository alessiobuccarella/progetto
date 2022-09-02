package view2;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.CercaProfiloController;
import controller.NuovoProfiloController;
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
        
        // initialize user controller
        new CercaProfiloController(cercaProfilo, profilo, cardLayout, MainFrame.this.getContentPane());
        new NuovoProfiloController(nuovoProfilo, profilo, cardLayout, MainFrame.this.getContentPane());
        
        // aggiunge i panel al layout
        setLayout(cardLayout);
        add(inzioPanel, "inizio");
        add(cercaProfilo, "cercaProfilo");
        add(nuovoProfilo, "nuovoProfilo");
        add(profilo, "profilo");
        add(inizio2, "inizio2");
        add(configuraPartita, "configuraPartita");

        //azioni inzioPanel
        inzioPanel.caricaProfilo(e -> cardLayout.show(MainFrame.this.getContentPane(), "cercaProfilo")); 
        inzioPanel.nuovoProfilo(e -> cardLayout.show(MainFrame.this.getContentPane(), "nuovoProfilo"));
        inzioPanel.esci(e -> {
        	Database.getInstance().close();
        	System.exit(0);
        });
        
        cercaProfilo.paginaPrec(e -> cardLayout.show(MainFrame.this.getContentPane(), "inizio"));
        nuovoProfilo.paginaPrec(e -> cardLayout.show(MainFrame.this.getContentPane(), "inizio"));
        profilo.paginaPrec(e -> cardLayout.show(MainFrame.this.getContentPane(), "inizio2"));

        inizio2.opzioniProfilo(e -> cardLayout.show(MainFrame.this.getContentPane(), "profilo"));
        inizio2.nuovaPartita(e -> cardLayout.show(MainFrame.this.getContentPane(), "configuraPartita"));
        inizio2.esci(e -> {
            Database.getInstance().close();
            System.exit(0);
        });

        configuraPartita.paginaPrec(e -> cardLayout.show(MainFrame.this.getContentPane(), "inizio2"));
        
    }
}
