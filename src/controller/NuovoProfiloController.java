package controller;

import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JOptionPane;

import model.Database;
import model.Profilo;
import view2.NuovoProfiloPanel;
import view2.ProfiloPanel;

public class NuovoProfiloController {
    public NuovoProfiloController(NuovoProfiloPanel nuovoProfiloPanel, ProfiloPanel profiloPanel, CardLayout cardLayout, Container parent) {
        nuovoProfiloPanel.creaProfilo(e -> {
            String nickname = nuovoProfiloPanel.getNickname();
            if (nickname == null || nickname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nickname Obbligatorio");
                return;
            }
            String avatarImg = nuovoProfiloPanel.getAvatar();
            if (avatarImg == null || avatarImg.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Avatar Obbligatorio");
                return;
            }
            Database db = Database.getInstance();
            Profilo profilo = db.creaProfilo(nickname, avatarImg);
            if ( profilo != null ) {
            	profiloPanel.printProfilo(profilo);
                JOptionPane.showMessageDialog(null, "Benvenuto " + nickname);
            	cardLayout.show(parent, "inizio2");
            } else {
            	JOptionPane.showMessageDialog(null, "Errore nella creazione del profilo");
            }
        });
    }
}

