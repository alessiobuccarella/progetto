package controller;

import model.Database;
import model.Profilo;
import view2.NuovoProfiloPanel;
import view2.ProfiloPanel;

import javax.swing.*;

public class NuovoProfiloController {
    public NuovoProfiloController(NuovoProfiloPanel nuovoProfiloPanel, ProfiloPanel profiloPanel) {
        nuovoProfiloPanel.nuovoProfilo(e -> {
            String nickname = nuovoProfiloPanel.getNickname();
            if (nickname.equals("") || nickname.equals(null)) {
                JOptionPane.showMessageDialog(null, "Nickname Obbligatorio");
            } else {
                Database db = Database.getInstance();
                //COMPLETARE
            }
        });
    }

}

