package view2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NuovoProfiloPanel extends JPanel {

	private static final long serialVersionUID = -4924450993476714670L;
	private JTextField textnickname;
    private JButton inviaButton;
    private JButton indietroButton;
    private JToggleButton radio1;
    private JToggleButton radio2;
    private JToggleButton radio3;
    private JToggleButton radio4;
    private JToggleButton radio5;

    public NuovoProfiloPanel(){
        JPanel nickname = new JPanel();
        JPanel image = new JPanel();
        JPanel indietro = new JPanel();
        indietro.setBackground(Color.black);
        nickname.setBackground(Color.red);
        image.setBackground(Color.red);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridwidth = GridBagConstraints.REMAINDER;
        JLabel nick2 = new JLabel("Nickname:");
        textnickname  = new JTextField(10);
        nick2.setFont(new Font("Dialog", Font.PLAIN, 15));
        JLabel avatar = new JLabel("Avatar:");
        avatar.setFont(new Font("Dialog", Font.PLAIN, 15));
        inviaButton = new JButton("INVIA");
        indietroButton = new JButton("<");
        ButtonGroup avatari = new ButtonGroup();
        ImageIcon avatar1png = new ImageIcon("./src/immagini/Pikachu.png");
        Image image1 = avatar1png.getImage();
        Image newimg1 = image1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar1png = new ImageIcon(newimg1);
        radio1 = new JToggleButton(avatar1png);
        radio1.setName("Avatar1");
        ImageIcon avatar2png = new ImageIcon("./src/immagini/Entei.png");
        Image image2 = avatar2png.getImage();
        Image newimg2 = image2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar2png = new ImageIcon(newimg2);
        radio2 = new JToggleButton(avatar2png);
        radio2.setName("Avatar2");
        ImageIcon avatar3png = new ImageIcon("./src/immagini/Rayquaza.png");
        Image image3 = avatar3png.getImage();
        Image newimg3 = image3.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar3png = new ImageIcon(newimg3);
        radio3 = new JToggleButton(avatar3png);
        radio3.setName("Avatar3");
        ImageIcon avatar4png = new ImageIcon("./src/immagini/Articuno.png");
        Image image4 = avatar4png.getImage();
        Image newimg4 = image4.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar4png = new ImageIcon(newimg4);
        radio4 = new JToggleButton(avatar4png);
        radio4.setName("Avatar4");
        ImageIcon avatar5png = new ImageIcon("./src/immagini/Mew.png");
        Image image5 = avatar5png.getImage();
        Image newimg5 = image5.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar5png = new ImageIcon(newimg5);
        radio5 = new JToggleButton(avatar5png);
        radio5.setName("Avatar5");
        avatari.add(radio1);
        avatari.add(radio2);
        avatari.add(radio3);
        avatari.add(radio4);
        avatari.add(radio5);
        this.setLayout(new BorderLayout());
        nickname.setLayout(new GridBagLayout());
        image.setLayout(new GridBagLayout());
        indietro.setLayout(new FlowLayout(FlowLayout.LEFT));
        nickname.add(nick2, gbc3);
        nickname.add(Box.createRigidArea(new Dimension(0, 35)));
        nickname.add(textnickname, gbc3);
        nickname.add(Box.createRigidArea(new Dimension(0, 35)));
        nickname.add(avatar, gbc3);
        image.add(radio1);
        image.add(Box.createRigidArea(new Dimension(5, 0)));
        image.add(radio2);
        image.add(Box.createRigidArea(new Dimension(5, 0)));
        image.add(radio3);
        image.add(Box.createRigidArea(new Dimension(5, 0)));
        image.add(radio4);
        image.add(Box.createRigidArea(new Dimension(5, 0)));
        image.add(radio5);
        nickname.add(image, gbc3);
        nickname.add(Box.createRigidArea(new Dimension(0, 70)));
        nickname.add(inviaButton, gbc3);
        indietro.add(indietroButton);
        this.add(nickname, BorderLayout.CENTER);
        this.add(indietro, BorderLayout.PAGE_END);
    }

    public String getNickname() {
        return this.textnickname.getText();
    }
    
    public String getAvatar() {
    	String img = null;
        if(radio1.isSelected()){
            img = "./src/immagini/Pikachu.png";
        }
        if (radio2.isSelected()){
            img = "./src/immagini/Entei.png";
        }
        if (radio3.isSelected()){
            img = "./src/immagini/Rayquaza.png";
        }
        if (radio4.isSelected()){
            img = "./src/immagini/Articuno.png";
        }
        if (radio5.isSelected()){
            img = "./src/immagini/Mew.png";
        }
        return img;
    }

    public void creaProfilo(ActionListener actionListener) {
        inviaButton.addActionListener(actionListener);
    }

    public void paginaPrec(ActionListener actionListener) {
        indietroButton.addActionListener(actionListener);
    }
}
