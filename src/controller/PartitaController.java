package controller;

import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.Mano;
import model.Mazzo;
import view2.PartitaPanel;
import view2.Piatto;
import view2.Postazione;

public class PartitaController {

	 public PartitaController(PartitaPanel partitaPanel,Eventi eventi) {
		 partitaPanel.funzionePasso(e -> {
			 eventi.passo();
			 System.out.println("ciao");
		 });

		 partitaPanel.funzioneRosso(e ->{
			 eventi.passo();
			 partitaPanel.cartaScarto.setC(0);
			 
		 });

		 partitaPanel.funzioneGiallo(e ->{
			 eventi.passo();
			 partitaPanel.cartaScarto.setC(1);
			
		 });

		 partitaPanel.funzioneVerde(e ->{
			 eventi.passo();
			 partitaPanel.cartaScarto.setC(3);
		
		 });

		 partitaPanel.funzioneBlu(e ->{
			 eventi.passo();
			 partitaPanel.cartaScarto.setC(2);
			 
		 });

		 partitaPanel.funzioneUno(e ->{
			if (eventi.getDeviGridareUno()==true)
				eventi.setGridatoUno();
			
		 });
		
	 }
}
