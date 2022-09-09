package view2;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Profilo;

public class ProfiloPanel extends JPanel {

	private static final long serialVersionUID = 3960043400919881397L;

    private JLabel nickname;
	private JLabel myavatar;
	private JLabel livello;
	private JLabel partiteGiocate;
	private JLabel partiteVinte;
	private JLabel partitePerse;
	private JButton indietroButton;
    public static String nome;
    public static String immagine;
	public ProfiloPanel() {
        JPanel oa = new JPanel();
        JPanel oa2 = new JPanel();
        JPanel oa3 = new JPanel();
        JPanel indietro = new JPanel();
        indietro.setBackground(Color.black);
        oa.setBackground(Color.red);
        oa2.setBackground(Color.red);
        oa3.setBackground(Color.red);
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridwidth = GridBagConstraints.REMAINDER;
        gbc7.fill = GridBagConstraints.HORIZONTAL;
        GridBagConstraints gbc8 = new GridBagConstraints();
        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridwidth = GridBagConstraints.REMAINDER;
        gbc9.fill = GridBagConstraints.HORIZONTAL;
        myavatar = new JLabel();
        nickname = new JLabel();
        nickname.setFont(new Font("Dialog", Font.PLAIN, 20));
        livello = new JLabel();
        livello.setFont(new Font("Dialog", Font.PLAIN, 20));
        partiteGiocate = new JLabel();
        partiteGiocate.setFont(new Font("Dialog", Font.PLAIN, 15));
        partiteVinte = new JLabel();
        partiteVinte.setFont(new Font("Dialog", Font.PLAIN, 15));
        partitePerse = new JLabel();
        partitePerse.setFont(new Font("Dialog", Font.PLAIN, 15));
        indietroButton = new JButton("<");
        setLayout(new BorderLayout());
        oa.setLayout(new GridBagLayout());
        oa2.setLayout(new GridBagLayout());
        oa3.setLayout(new GridBagLayout());
        indietro.setLayout(new FlowLayout(FlowLayout.LEFT));
        oa2.add(myavatar, gbc8);
        oa2.add(Box.createRigidArea(new Dimension(4, 0)));
        oa3.add(nickname, gbc9);
        oa3.add(livello, gbc9);
        oa2.add(oa3, gbc8);
        oa.add(oa2, gbc7);
        oa.add(partiteGiocate, gbc7);
        oa.add(partiteVinte, gbc7);
        oa.add(partitePerse, gbc7);
        indietro.add(indietroButton);
        this.add(oa, BorderLayout.CENTER);
        this.add(indietro, BorderLayout.PAGE_END);
	}

    public void printProfilo(Profilo profilo) {
		this.nickname.setText("NICKNAME: " + profilo.getNickname());
        nome = profilo.getNickname();
		ImageIcon avatar4png = new ImageIcon(profilo.getAvatarImg());
        Image image4 = avatar4png.getImage();
        Image newimg4 = image4.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        avatar4png = new ImageIcon(newimg4);
        this.myavatar.setIcon(avatar4png);
        immagine = profilo.getAvatarImg();
        this.livello.setText("LIVELLO: " + profilo.getLivello());
        this.partiteGiocate.setText("PARTITE GIOCATE: " + profilo.getPartiteGiocate());
        this.partitePerse.setText("PARTITE PERSE: " + profilo.getPartitePerse());
        this.partiteVinte.setText("PARTITE VINTE: " + profilo.getPartiteVinte());
	}

    public void paginaPrec(ActionListener actionListener) {
    	indietroButton.addActionListener(actionListener);
    }
}

