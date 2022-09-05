package controller;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

import model.Database;
import model.Profilo;
import view2.CercaProfiloPanel;
import view2.ProfiloPanel;

public class CercaProfiloController {
	public CercaProfiloController(CercaProfiloPanel cercaProfiloPanel, ProfiloPanel profiloPanel, CardLayout cardLayout, Container parent) {
		cercaProfiloPanel.cercaProfilo(e -> {
			String nickname = cercaProfiloPanel.getNickname();
			if (nickname.equals("") || nickname.equals(null)) {
	            JOptionPane.showMessageDialog(null, "Nickname Obbligatorio");
	        } else {
				//funzione di ricerca
				//con il risultato
				Database db = Database.getInstance();
				Profilo profilo = db.cercaProfilo(nickname);
				if ( profilo != null ) {
					profiloPanel.printProfilo(profilo);
					JOptionPane.showMessageDialog(null, "Benvenuto " + nickname);
					cardLayout.show(parent, "inizio2");
				} else {
					JOptionPane.showMessageDialog(null, "Nessun profilo trovato per con il nickaname " + nickname);
				}
	        }
		});
	}
}
