package controller;

import model.Senso;
import view2.PartitaPanel;

public class PartitaController {
	
	
	
	 public PartitaController(PartitaPanel partitaPanel) {
		 partitaPanel.funzionePasso(e ->{
	        System.out.println("ciao");
	        
		 	if (PartitaPanel.senso == Senso.ANTIORARIO)
	            PartitaPanel.turno = 3;
	        if (PartitaPanel.senso == Senso.ORARIO)
	            PartitaPanel.turno = 1;
	       	 });

		 partitaPanel.funzioneRosso(e ->{
			 PartitaPanel.cartaScarto.setC(0);
		 });
		 partitaPanel.funzioneGiallo(e ->{
			 PartitaPanel.cartaScarto.setC(1);
		 });
		 partitaPanel.funzioneVerde(e ->{
			 PartitaPanel.cartaScarto.setC(3);
		 });
		 partitaPanel.funzioneBlu(e ->{
			 PartitaPanel.cartaScarto.setC(2);
		 });
	 
	 
	 
	 
	 
	       // avanti(gbc10, turno, manoOvest, manoNord, manoEst, piatto, postazioneOvest, postazioneNord, postazioneEst, mazzo, postazioneNord, manoEst,postazionePiatto);
	    
}
}
