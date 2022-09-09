package view2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Questa classe crea il pannello per la selezione della modalià di gioco della partita
 */
public class ConfiguraPanel extends JPanel {

    /**
     * buttons corrispettivi alla modalià di gioco
     */
    private JButton classica, mod2, mod3;
    /**
     * button che torna indietro al precedente pannello
     */
    private JButton indietroButton;

    /**
     * costruttore che costruisce il design del pannello per scegliere la modalità di gioco della partita
     */
     public ConfiguraPanel() {
         JPanel cmm = new JPanel();
         JPanel indietro3 = new JPanel();
         indietro3.setBackground(Color.black);
         cmm.setBackground(Color.red);
         GridBagConstraints gbc6 = new GridBagConstraints();
         gbc6.gridwidth = GridBagConstraints.REMAINDER;
         gbc6.fill = GridBagConstraints.HORIZONTAL;
         classica = new JButton("CLASSICA");
         mod2 = new JButton("1 VS 1");
         mod3 = new JButton("LAMPO");
         classica.setPreferredSize(new Dimension(150, 50));
         mod2.setPreferredSize(new Dimension(150, 50));
         mod3.setPreferredSize(new Dimension(150, 50));
         indietroButton = new JButton("<");
         this.setLayout(new BorderLayout());
         cmm.setLayout(new GridBagLayout());
         indietro3.setLayout(new FlowLayout(FlowLayout.LEFT));
         cmm.add(classica, gbc6);
         cmm.add(Box.createRigidArea(new Dimension(0, 70)));
         cmm.add(mod2, gbc6);
         cmm.add(Box.createRigidArea(new Dimension(0, 40)));
         cmm.add(mod3, gbc6);
         indietro3.add(indietroButton);
         this.add(cmm, BorderLayout.CENTER);
         this.add(indietro3, BorderLayout.PAGE_END);
     }

    /**
     * actionlistener sul button paginaPrec
     */
    public void paginaPrec(ActionListener actionListener) {
        indietroButton.addActionListener(actionListener);
    }

    /**
     * actionlistener sul button classica
     */
    public void classica(ActionListener actionListener) {
    	classica.addActionListener(actionListener);
    }

    /**
     * actionlistener sul button mod2
     */
    public void mod2(ActionListener actionListener) {
        mod2.addActionListener(actionListener);
    }

    /**
     * actionlistener sul button mod3
     */
    public void mod3(ActionListener actionListener) {
        mod3.addActionListener(actionListener);
    }
}
