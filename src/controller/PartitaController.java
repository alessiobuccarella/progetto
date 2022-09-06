package controller;

import view2.PartitaPanel;

public class PartitaController {

	 public PartitaController(PartitaPanel partitaPanel) {
		 partitaPanel.funzionePasso(e -> {
			 PartitaPanel.passo();
			 System.out.println("ciao");
		 });

		 partitaPanel.funzioneRosso(e ->{
			 PartitaPanel.passo();
			 PartitaPanel.cartaScarto.setC(0);
		 });

		 partitaPanel.funzioneGiallo(e ->{
			 PartitaPanel.passo();
			 PartitaPanel.cartaScarto.setC(1);
		 });

		 partitaPanel.funzioneVerde(e ->{
			 PartitaPanel.passo();
			 PartitaPanel.cartaScarto.setC(3);
		 });

		 partitaPanel.funzioneBlu(e ->{
			 PartitaPanel.passo();
			 PartitaPanel.cartaScarto.setC(2);
		 });

		 partitaPanel.funzioneUno(e ->{
			if (PartitaPanel.getDeviGridareUno()==true)
				PartitaPanel.setGridatoUno();
		 });
	 }
}
