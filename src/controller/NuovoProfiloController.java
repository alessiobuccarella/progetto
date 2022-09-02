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
            if (nickname.equals("") || nickname.equals(null)) {
                JOptionPane.showMessageDialog(null, "Nickname Obbligatorio");
                return;
            }
            String avatarImg = nuovoProfiloPanel.getVatarImg();
            if (avatarImg.equals("") || avatarImg.equals(null)) {
                JOptionPane.showMessageDialog(null, "Avatar Obbligatorio");
                return;
            }
            
            Database db = Database.getInstance();
            Profilo profilo = db.creaProfilo(nickname, avatarImg);
            if ( profilo != null ) {
            	profiloPanel.printProfilo(profilo);
            	cardLayout.show(parent, "nuovoProfilo");
            	
            } else {
            	JOptionPane.showMessageDialog(null, "Errore nella creazione del profilo");
            }
            
            
        });
    }

}

