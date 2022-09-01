package controller;

import javax.swing.JOptionPane;

import model.Database;
import model.Profilo;
import view2.CercaProfiloPanel;
import view2.ProfiloPanel;

public class CercaProfileController {
	
	
	public CercaProfileController(CercaProfiloPanel cercaProfiloPanel, ProfiloPanel profiloPanel) {
		
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
				} else {
					JOptionPane.showMessageDialog(null, "Nessun profilo trovato per con il nickaname " + nickname);
				}

	        }

		});

	}
}
