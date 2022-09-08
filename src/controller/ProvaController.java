package controller;

import view2.*;

public class ProvaController {

    public ProvaController(ConfiguraPanel configuraPanel, PartitaPanel partitaPanel, ProfiloPanel profiloPanel) {
        configuraPanel.classica(e -> {

            //partitaPanel.printProfiloPartita(profiloPanel.getName(), profiloPanel.getImmagine());

        });
    }

}
