package view2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import view.BarraAudio;

public class MenuPanel extends JPanel {
	
	private static final long serialVersionUID = -6284533655497930757L;
	
	private JButton nuovaPartita;
	private JButton opzioniProfilo;
	private JButton esci;
	private BarraAudio audio;

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
        audio = new BarraAudio();
        this.add(audio, BorderLayout.PAGE_START);

	}
	
    public void nuovaPartita(ActionListener actionListener) {
    	nuovaPartita.addActionListener(actionListener);
    }
    
    public void opzioniProfilo(ActionListener actionListener) {
    	opzioniProfilo.addActionListener(actionListener);
    }
    
    public void esci(ActionListener actionListener) {
    	esci.addActionListener(actionListener);
    }
}
