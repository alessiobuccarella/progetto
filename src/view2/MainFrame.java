package view2;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;

import controller.CercaProfiloController;
import controller.NuovoProfiloController;

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
        MenuPanel menuPanel = new MenuPanel();
        
        // initialize user controller
        new CercaProfiloController(cercaProfilo, profilo, cardLayout, MainFrame.this.getContentPane());
        new NuovoProfiloController(nuovoProfilo, profilo, cardLayout, MainFrame.this.getContentPane());
        
        // aggiunge i panel al layout
        setLayout(cardLayout);
        add(inzioPanel, "inizio");
        add(cercaProfilo, "cercaProfilo");
        add(nuovoProfilo, "nuovoProfilo");
        add(profilo, "profilo");
        add(menuPanel, "menu");

        //azioni inzioPanel
        inzioPanel.caricaProfilo(e -> cardLayout.show(MainFrame.this.getContentPane(), "cercaProfilo")); 
        inzioPanel.nuovoProfilo(e -> cardLayout.show(MainFrame.this.getContentPane(), "nuovoProfilo"));
        inzioPanel.esci(e -> {
        	//chiudere conn db
        	System.exit(0);
        });
        
        cercaProfilo.paginaPrec(e -> cardLayout.show(MainFrame.this.getContentPane(), "inizio"));
        
        profilo.indietro(e -> cardLayout.show(MainFrame.this.getContentPane(), "menu"));
        
        
    }
}

