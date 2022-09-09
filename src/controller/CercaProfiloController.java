package controller;

import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JOptionPane;
import model.Database;
import model.Profilo;
import view.CercaProfiloPanel;
import view.ProfiloPanel;

public class CercaProfiloController {

	AudioButtonManager musicObjectButton = new AudioButtonManager();

	public CercaProfiloController(CercaProfiloPanel cercaProfiloPanel, ProfiloPanel profiloPanel, CardLayout cardLayout, Container parent) {
		cercaProfiloPanel.cercaProfilo(e -> {
			String nickname = cercaProfiloPanel.getNickname();
			if (nickname.equals("") || nickname.equals(null)) {
				musicObjectButton.playButtonMusic("/Users/alessiobuccarella/eclipse-workspace/progetto/src/audio/error_button_audio.wav");
	            JOptionPane.showMessageDialog(null, "Nickname Obbligatorio");
	        } else {
				//funzione di ricerca
				//con il risultato
				Database db = Database.getInstance();
				Profilo profilo = db.cercaProfilo(nickname);
				if (profilo != null) {
					musicObjectButton.playButtonMusic("/Users/alessiobuccarella/eclipse-workspace/progetto/src/audio/success_button_audio.wav");
					profiloPanel.printProfilo(profilo);
					JOptionPane.showMessageDialog(null, "Benvenuto " + nickname);
					cardLayout.show(parent, "inizio2");
				} else {
					musicObjectButton.playButtonMusic("/Users/alessiobuccarella/eclipse-workspace/progetto/src/audio/error_button_audio.wav");
					JOptionPane.showMessageDialog(null, "Nessun profilo trovato per con il nickaname " + nickname);
				}
	        }
		});
	}
}
