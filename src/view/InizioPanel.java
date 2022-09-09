package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Questa classe crea il pannello iniziale
 */
public class InizioPanel extends JPanel {
    /**
     * button per creare un nuovo profilo
     */
	private JButton nuovoProfilo;
    /**
     * button per caricare un profilo
     */
	private JButton caricaProfiloBtn;
    /**
     * button per uscire dall'applicazione
     */
	private JButton esci;

    /**
     * costruttore che costruisce il design del pannello iniziale
     */
	public InizioPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nuovoProfilo = new JButton("NUOVO PROFILO");
        caricaProfiloBtn = new JButton("CARICA PROFILO");
        esci = new JButton("ESCI");
        nuovoProfilo.setPreferredSize(new Dimension(150, 50));
        caricaProfiloBtn.setPreferredSize(new Dimension(150, 50));
        esci.setPreferredSize(new Dimension(150, 50));
        this.setLayout(new BorderLayout());
        JPanel nce = new JPanel();
        nce.setBackground(Color.red);
        nce.setLayout(new GridBagLayout());
        nce.add(nuovoProfilo, gbc);
        nce.add(Box.createRigidArea(new Dimension(0, 70)));
        nce.add(caricaProfiloBtn, gbc);
        nce.add(Box.createRigidArea(new Dimension(0, 40)));
        nce.add(esci, gbc);
        this.add(nce, BorderLayout.CENTER);
	}
    /**
     * actionlistener sul button nuovoProfilo
     * @param actionListener actionlistener
     */
    public void nuovoProfilo(ActionListener actionListener) {
    	nuovoProfilo.addActionListener(actionListener);
    }
    /**
     * actionlistener sul button caricaProfiloBtn
     * @param actionListener actionlistener
     */
    public void caricaProfilo(ActionListener actionListener) {
    	caricaProfiloBtn.addActionListener(actionListener);
    }
    /**
     * actionlistener sul button esci
     * @param actionListener actionlistener
     */
    public void esci(ActionListener actionListener) {
    	esci.addActionListener(actionListener);
    }
}