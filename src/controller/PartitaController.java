package controller;

import view2.PartitaPanel;

public class PartitaController {

	 public PartitaController(PartitaPanel partitaPanel,Eventi eventi) {


		 partitaPanel.funzioneRosso(e -> {
			 System.out.println("rosso");
			 eventi.cartaScarto.setC(0);
			 
		 });
		 partitaPanel.funzioneGiallo(e -> {
			 
			 eventi.cartaScarto.setC(1);
			
		 });
		 partitaPanel.funzioneVerde(e -> {
			 
			 eventi.cartaScarto.setC(3);
		
		 });
		 partitaPanel.funzioneBlu(e -> {
			
			 eventi.cartaScarto.setC(2);
			 
		 });
		 partitaPanel.funzioneUno(e -> {
			if (eventi.getDeviGridareUno() == true)
				eventi.setGridatoUno();
		 });
		 
	 }
}
