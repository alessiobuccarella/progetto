package view2;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import view.BarraAudio;

public class InizioPanel extends JPanel {

	private static final long serialVersionUID = -513177980532526192L;
	private JButton nuovoProfilo;
	private JButton caricaProfiloBtn;
	private JButton esci;
	private BarraAudio audio;

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
        this.audio = new BarraAudio();
        this.add(audio, BorderLayout.PAGE_START);
	}
	
    public void nuovoProfilo(ActionListener actionListener) {
    	nuovoProfilo.addActionListener(actionListener);
    }
    
    public void caricaProfilo(ActionListener actionListener) {
    	caricaProfiloBtn.addActionListener(actionListener);
    }
    
    public void esci(ActionListener actionListener) {
    	esci.addActionListener(actionListener);
    }
}