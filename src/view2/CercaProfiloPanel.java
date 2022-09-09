package view2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class CercaProfiloPanel extends JPanel {
	
	private static final long serialVersionUID = 4831030812782264284L;
	private JTextField textnickname;
	private JButton inviaButton;
	private JButton indietroButton;
	
	public CercaProfiloPanel() {
        JPanel nickname = new JPanel();
        JPanel indietro = new JPanel();
        indietro.setBackground(Color.black);
        nickname.setBackground(Color.red);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridwidth = GridBagConstraints.REMAINDER;
        JLabel nick = new JLabel("Nickname:");
        nick.setFont(new Font("Dialog", Font.PLAIN, 15));
        textnickname = new JTextField(10);
        inviaButton = new JButton("INVIA");
        indietroButton = new JButton("<");
        this.setLayout(new BorderLayout());
        nickname.setLayout(new GridBagLayout());
        indietro.setLayout(new FlowLayout(FlowLayout.LEFT));
        nickname.add(nick, gbc2);
        nickname.add(Box.createRigidArea(new Dimension(0, 35)));
        nickname.add(textnickname, gbc2);
        nickname.add(Box.createRigidArea(new Dimension(0, 50)));
        nickname.add(inviaButton, gbc2);
        indietro.add(indietroButton);
        this.add(nickname, BorderLayout.CENTER);
        this.add(indietro, BorderLayout.PAGE_END);
	}
	
	public String getNickname() {
		return this.textnickname.getText();
	}

    public void cercaProfilo(ActionListener actionListener) {
		 inviaButton.addActionListener(actionListener);
    }

    public void paginaPrec(ActionListener actionListener) {
        indietroButton.addActionListener(actionListener);
    }
}
