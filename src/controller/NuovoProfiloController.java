package controller;

import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JOptionPane;
import model.Database;
import model.Profilo;
import view2.NuovoProfiloPanel;
import view2.ProfiloPanel;

public class NuovoProfiloController {

    AudioButtonManager musicObjectButton = new AudioButtonManager();

    public NuovoProfiloController(NuovoProfiloPanel nuovoProfiloPanel, ProfiloPanel profiloPanel, CardLayout cardLayout, Container parent) {
        nuovoProfiloPanel.creaProfilo(e -> {
            String nickname = nuovoProfiloPanel.getNickname();
            if (nickname == null || nickname.isEmpty()) {
                musicObjectButton.playButtonMusic("/Users/alessiobuccarella/eclipse-workspace/progetto/src/audio/error_button_audio.wav");
                JOptionPane.showMessageDialog(null, "Nickname Obbligatorio");
                return;
            }
            String avatarImg = nuovoProfiloPanel.getAvatar();
            if (avatarImg == null || avatarImg.isEmpty()) {
                musicObjectButton.playButtonMusic("/Users/alessiobuccarella/eclipse-workspace/progetto/src/audio/error_button_audio.wav");
                JOptionPane.showMessageDialog(null, "Avatar Obbligatorio");
                return;
            }
            Database db = Database.getInstance();
            Profilo profilo = db.creaProfilo(nickname, avatarImg);
            if (profilo != null) {
                musicObjectButton.playButtonMusic("/Users/alessiobuccarella/eclipse-workspace/progetto/src/audio/success_button_audio.wav");
            	profiloPanel.printProfilo(profilo);
                profiloPanel.getName(profilo);
                profiloPanel.getImmagine(profilo);
                JOptionPane.showMessageDialog(null, "Benvenuto " + nickname);
            	cardLayout.show(parent, "inizio2");
            }
        });
    }
}

