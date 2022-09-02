package view2;

import controller.DisegnaCarta;
import model.Mano;
import model.Mazzo;
import view.Campo;
import view.Piatto;
import view.Postazione;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PartitaPanel extends JPanel {
    public PartitaPanel(){
        JLabel redLabel = new JLabel(new ImageIcon("./src/immagini/0.png"));
        JLabel yellowLabel = new JLabel(new ImageIcon("./src/immagini/1.png"));
        JLabel blueLabel = new JLabel(new ImageIcon("./src/immagini/2.png"));
        JLabel greenLabel = new JLabel(new ImageIcon("./src/immagini/3.png"));
        JLabel deckLabel = new JLabel(new ImageIcon("./src/immagini/mazzo.png"));
        JButton coloreRosso = new JButton();
        coloreRosso.add(redLabel);
        coloreRosso.setBorder(null);
        JButton coloreGiallo = new JButton();
        coloreGiallo.add(yellowLabel);
        coloreGiallo.setBorder(null);
        JButton coloreBlu = new JButton();
        coloreBlu.add(blueLabel);
        coloreBlu.setBorder(null);
        JButton coloreVerde = new JButton();
        coloreVerde.add(greenLabel);
        coloreVerde.setBorder(null);
        JButton deckButton = new JButton();
        deckButton.setBorder(null);
        deckButton.setHorizontalTextPosition(SwingConstants.CENTER);
        deckButton.add(deckLabel);
        Campo campo = new Campo();
        Postazione postazione = new Postazione(1);
        Postazione postazionePiatto = new Postazione(1);
        Postazione postazioneColori = new Postazione(1);
        postazione.setBackground(null);
        postazione.setOpaque(false);
        Mazzo mazzo = new Mazzo();
        Mano mano = new Mano(mazzo);
        Mano manoOvest = new Mano(mazzo);
        Mano manoNord = new Mano(mazzo);
        Mano manoEst = new Mano(mazzo);
        ArrayList<JButton> posti = new ArrayList<>();
        for (int i=0;i<30;i++)posti.add(new JButton());
        ImageIcon avatar1png = new ImageIcon("./src/immagini/avatar1.png");
        ImageIcon avatar2png = new ImageIcon("./src/immagini/avatar1.png");
        ImageIcon avatar3png = new ImageIcon("./src/immagini/avatar1.png");
        JButton scartoButton = new JButton();
        
        for (int i=0;i<mano.mano.size();i++)
            posti.set(i, DisegnaCarta.disegnaCarta(mano.mano.get(i)));
        for (int i=0;i<mano.mano.size();i++)
            postazione.add(posti.get(i));
        Postazione postazioneOvest = new Postazione(0);
        Postazione postazioneEst = new Postazione(0);
        //campo.add(postazioneOvest, BorderLayout.WEST);
        for (int i = 0; i < 7; i++) {
            // postazioneOvest.add(new JLabel(new ImageIcon("./src/immagini/dorso90.png")));
            // postazioneOvest.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        postazioneEst.setBackground(null);
        postazioneEst.setOpaque(false);
        postazioneOvest.setBackground(null);
        postazioneOvest.setOpaque(false);
        Postazione postazioneNord = new Postazione(1);
        postazioneNord.add(new JLabel(new ImageIcon("./src/immagini/dorsonord7.png")));
        postazioneNord.setOpaque(false);
        Piatto tavolo = new Piatto();

        JLabel foto = new JLabel(avatar1png);
        JLabel foto1 = new JLabel(avatar2png);
        JLabel foto2 = new JLabel(avatar3png);

        GridBagConstraints gbc10= new GridBagConstraints();
        campo.add(tavolo, BorderLayout.CENTER);
        JButton uno= new JButton("UNO!");
        JButton passo = new JButton("PASSO");

        gbc10.anchor=GridBagConstraints.PAGE_START;
        gbc10.gridx=5;
        gbc10.gridy=0;
        gbc10.weightx=0.0;
        gbc10.weighty=0;
        gbc10.gridwidth=3;
        tavolo.add(foto1,gbc10);
        gbc10.gridx=5;
        gbc10.gridy=2;
        gbc10.weightx=0.0;
        gbc10.weighty=0;
        gbc10.gridwidth=3;
        tavolo.add(postazioneNord,gbc10);
        gbc10.anchor=GridBagConstraints.LINE_END;
        gbc10.gridx=2;
        gbc10.gridy=7;
        gbc10.weightx=0.0;
        gbc10.weighty=1;
        gbc10.gridwidth=1;
        tavolo.add(uno,gbc10);
        gbc10.anchor=GridBagConstraints.LINE_START;
        gbc10.gridx=4;
        gbc10.gridy=7;
        gbc10.weightx=0;
        gbc10.weighty=0;
        gbc10.gridwidth=1;
        tavolo.add(passo,gbc10);
        gbc10.anchor=GridBagConstraints.CENTER;
        gbc10.gridx=0;
        gbc10.gridy=0;
        gbc10.weighty=1;
        gbc10.weightx=0;
        gbc10.gridwidth=3;
        gbc10.gridheight=1;
        postazioneColori.setBackground(null);
        postazioneColori.setOpaque(false);
        postazioneColori.add(coloreRosso);
        postazioneColori.add((coloreGiallo));
        postazioneColori.add((coloreVerde));
        postazioneColori.add((coloreBlu));
        gbc10.anchor=GridBagConstraints.LINE_START;tavolo.add(postazioneColori,gbc10);
        postazionePiatto.add(deckLabel);
        postazionePiatto.add(scartoButton);
        postazionePiatto.setOpaque(false);
        deckButton.setBorder(null);
        gbc10.gridx=5;
        gbc10.gridy=4;
        gbc10.weighty=1;
        gbc10.weightx=0;
        gbc10.gridwidth=1;
        tavolo.add(postazionePiatto,gbc10);
        //////////////////////////////////////////////////// sinistra
        gbc10.gridx=0;
        gbc10.gridy=4;
        gbc10.weighty=0;
        gbc10.weightx=0;
        tavolo.add(foto,gbc10);
        gbc10.gridx=2;
        gbc10.gridy=4;
        gbc10.weighty=1;
        gbc10.weightx=1;
        gbc10.gridwidth=3;
        tavolo.add(postazioneOvest,gbc10);
        postazioneOvest.add((new JLabel(new ImageIcon("./src/immagini/dorsosx7.png"))),gbc10);
        ///////////////////////////////////////////////////////destra
        gbc10.gridx=6;
        gbc10.gridy=4;
        gbc10.weighty=1;
        gbc10.weightx=1;
        gbc10.gridwidth=3;
        tavolo.add(postazioneEst,gbc10);
        postazioneEst.add((new JLabel(new ImageIcon("./src/immagini/dorsodx7.png"))),gbc10);
        gbc10.gridx=9;
        gbc10.gridy=4;
        gbc10.weighty=1;
        gbc10.weightx=0;
        gbc10.gridwidth=1;
        tavolo.add(foto2,gbc10);
        gbc10.anchor=GridBagConstraints.PAGE_START;
        gbc10.gridx=5;
        gbc10.gridy=5;
        gbc10.weighty=2;
        tavolo.add(postazione,gbc10);
    }
}
