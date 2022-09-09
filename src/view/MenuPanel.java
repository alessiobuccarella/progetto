package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Questa classe crea il pannello con il menu principale del gioco
 */
public class MenuPanel extends JPanel {

    /**
     * button per iniziare una nuova partita
     */
	private JButton nuovaPartita;
    /**
     * button per visualizzare i propri dati del profilo
     */
	private JButton opzioniProfilo;
    /**
     * button per uscire dall'applicazione
     */
	private JButton esci;

    /**
     * costruttore che costruisce il design del pannello con il menu principale del gioco
     */
	public MenuPanel() {
        JPanel noe = new JPanel();
        noe.setBackground(Color.red);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridwidth = GridBagConstraints.REMAINDER;
        gbc5.fill = GridBagConstraints.HORIZONTAL;
        nuovaPartita = new JButton("NUOVA PARTITA");
        opzioniProfilo = new JButton("OPZIONI PROFILO");
        esci = new JButton("ESCI");
        nuovaPartita.setPreferredSize(new Dimension(150, 50));
        opzioniProfilo.setPreferredSize(new Dimension(150, 50));
        esci.setPreferredSize(new Dimension(150, 50));
        this.setLayout(new BorderLayout());
        noe.setLayout(new GridBagLayout());
        noe.add(nuovaPartita, gbc5);
        noe.add(Box.createRigidArea(new Dimension(0, 70)));
        noe.add(opzioniProfilo, gbc5);
        noe.add(Box.createRigidArea(new Dimension(0, 40)));
        noe.add(esci, gbc5);
        this.add(noe, BorderLayout.CENTER);
	}

    /**
     * actionlistener sul button nuovaPartita
     * @param actionListener
     */
    public void nuovaPartita(ActionListener actionListener) {
    	nuovaPartita.addActionListener(actionListener);
    }

    /**
     * actionlistener sul button opzioniProfilo
     * @param actionListener
     */
    public void opzioniProfilo(ActionListener actionListener) {
    	opzioniProfilo.addActionListener(actionListener);
    }

    /**
     * actionlistener sul button esci
     * @param actionListener
     */
    public void esci(ActionListener actionListener) {
    	esci.addActionListener(actionListener);
    }
}
