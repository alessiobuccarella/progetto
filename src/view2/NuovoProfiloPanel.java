package view2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import view.BarraAudio;

public class NuovoProfiloPanel extends JPanel {

    private JTextField textnickname2;
    private JButton inviaButton2;
    private JButton indietroButton2;
    private BarraAudio audio;

    public NuovoProfiloPanel(){
        JPanel nickname2 = new JPanel();
        JPanel image = new JPanel();
        JPanel indietro2 = new JPanel();
        indietro2.setBackground(Color.black);
        nickname2.setBackground(Color.red);
        image.setBackground(Color.red);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridwidth = GridBagConstraints.REMAINDER;
        JLabel nick2 = new JLabel("Nickname:");
        textnickname2  = new JTextField(10);
        nick2.setFont(new Font("Dialog", Font.PLAIN, 15));
        JLabel avatar = new JLabel("Avatar:");
        avatar.setFont(new Font("Dialog", Font.PLAIN, 15));
        inviaButton2 = new JButton("INVIA");
        indietroButton2 = new JButton("<");
        ButtonGroup avatari = new ButtonGroup();
        ImageIcon avatar1png = new ImageIcon("./src/immagini/avatar1.png");
        Image image1 = avatar1png.getImage();
        Image newimg1 = image1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar1png = new ImageIcon(newimg1);
        JToggleButton radio1 = new JToggleButton(avatar1png);
        radio1.setName("Avatar1");
        ImageIcon avatar2png = new ImageIcon("./src/immagini/avatar2.png");
        Image image2 = avatar2png.getImage();
        Image newimg2 = image2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar2png = new ImageIcon(newimg2);
        JToggleButton radio2 = new JToggleButton(avatar2png);
        radio2.setName("Avatar2");
        ImageIcon avatar3png = new ImageIcon("./src/immagini/avatar3.png");
        Image image3 = avatar3png.getImage();
        Image newimg3 = image3.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar3png = new ImageIcon(newimg3);
        JToggleButton radio3 = new JToggleButton(avatar3png);
        radio2.setName("Avatar3");
        avatari.add(radio1);
        avatari.add(radio2);
        avatari.add(radio3);
        this.setLayout(new BorderLayout());
        nickname2.setLayout(new GridBagLayout());
        image.setLayout(new GridBagLayout());
        indietro2.setLayout(new FlowLayout(FlowLayout.LEFT));
        nickname2.add(nick2, gbc3);
        nickname2.add(Box.createRigidArea(new Dimension(0, 35)));
        nickname2.add(textnickname2, gbc3);
        nickname2.add(Box.createRigidArea(new Dimension(0, 35)));
        nickname2.add(avatar, gbc3);
        image.add(radio1);
        image.add(Box.createRigidArea(new Dimension(5, 0)));
        image.add(radio2);
        image.add(Box.createRigidArea(new Dimension(5, 0)));
        image.add(radio3);
        nickname2.add(image, gbc3);
        nickname2.add(Box.createRigidArea(new Dimension(0, 70)));
        nickname2.add(inviaButton2, gbc3);
        indietro2.add(indietroButton2);
        this.add(nickname2, BorderLayout.CENTER);
        this.audio = new BarraAudio();
        this.add(audio, BorderLayout.PAGE_START);
        this.add(indietro2, BorderLayout.PAGE_END);
    }

    public String getNickname() {
        return this.textnickname2.getText();
    }

    public void nuovoProfilo(ActionListener actionListener) {
        inviaButton2.addActionListener(actionListener);
    }

    public void paginaPrec(ActionListener actionListener) {
        indietroButton2.addActionListener(actionListener);
    }
}
