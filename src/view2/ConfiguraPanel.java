package view2;

import view.BarraAudio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConfiguraPanel extends JPanel {

    private JButton classica, mod2, mod3;
    private JButton indietroButton;
    private BarraAudio audio;

     public ConfiguraPanel() {
         JPanel cmm = new JPanel();
         JPanel indietro3 = new JPanel();
         indietro3.setBackground(Color.black);
         cmm.setBackground(Color.red);
         GridBagConstraints gbc6 = new GridBagConstraints();
         gbc6.gridwidth = GridBagConstraints.REMAINDER;
         gbc6.fill = GridBagConstraints.HORIZONTAL;
         classica = new JButton("CLASSICA");
         mod2 = new JButton("MOD2");
         mod3 = new JButton("MOD3");
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
         this.audio = new BarraAudio();
         this.add(audio, BorderLayout.PAGE_START);
         this.add(indietro3, BorderLayout.PAGE_END);
     }

    public void paginaPrec(ActionListener actionListener) {
        indietroButton.addActionListener(actionListener);
    }
    public void classica(ActionListener actionListener) {
    	classica.addActionListener(actionListener);
    }
}
