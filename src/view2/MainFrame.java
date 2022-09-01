package view2;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;

import controller.CercaProfileController;

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
        
        InizioPanel inzioPanel = new InizioPanel();
        CercaProfiloPanel caricaProfilo = new CercaProfiloPanel();
        ProfiloPanel profilo = new ProfiloPanel();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize user controller
        new CercaProfileController(caricaProfilo, profilo);

        // adds view to card layout with unique constraints
        add(inzioPanel, "inizio");
        add(caricaProfilo, "caricaProfilo");
        add(profilo, "profilo");
        // switch view according to its constraints on click

        inzioPanel.caricaProfilo(e -> cardLayout.show(MainFrame.this.getContentPane(), "caricaProfilo")); 
        inzioPanel.nuovoProfilo(e -> cardLayout.show(MainFrame.this.getContentPane(), "caricaProfilo"));
        inzioPanel.esci(e -> {
        	//chiudere conn db
        	System.exit(0);
        });
    }
}

