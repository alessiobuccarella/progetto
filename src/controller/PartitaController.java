package controller;

import view2.PartitaPanel;

public class PartitaController {

	 public PartitaController(PartitaPanel partitaPanel,Eventi eventi) {


		 partitaPanel.funzioneRosso(e -> {
			 eventi.passo();
			 partitaPanel.getCartaScarto().setC(0);
			 
		 });
		 partitaPanel.funzioneGiallo(e -> {
			 eventi.passo();
			 partitaPanel.getCartaScarto().setC(1);
			
		 });
		 partitaPanel.funzioneVerde(e -> {
			 eventi.passo();
			 partitaPanel.getCartaScarto().setC(3);
		
		 });
		 partitaPanel.funzioneBlu(e -> {
			 eventi.passo();
			 partitaPanel.getCartaScarto().setC(2);
			 
		 });
		 partitaPanel.funzioneUno(e -> {
			if (eventi.getDeviGridareUno() == true)
				eventi.setGridatoUno();
		 });
		 
	 }
}
