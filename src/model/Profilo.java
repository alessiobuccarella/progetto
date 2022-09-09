package model;

public class Profilo {

	private String nickname;
	private String avatarImg;
	private int livello;
	private int partiteGiocate;
	private int partiteVinte;
	private int partitePerse;

	/**
	 * classe che costruisce il profilo utilizzando il builder pattern
	 */
	public Profilo() {}

	/**
	 *builder del profilo
	 */
	public static class ProfiloBuilder {

		/**
		 * stringa che rappresenta il nickname del giocatore
		 */
		private String nickname;
		/**
		 * stringa che rappresenta il percorso dell'immagine di profilo del giocatore
		 */
		private String avatarImg;
		/**
		 * inter oche rappresenta il livello del giocatore
		 */
		private int livello;
		/**
		 * intero che rappresenta il numero di partite giocate
		 */
		private int partiteGiocate;
		/**
		 * intero che rappresenta il numero di partite vinte
		 */
		private int partiteVinte;
		/**
		 * intero che rappresenta il numero di partite perse
		 */
		private int partitePerse;

		/**
		 * metodo che costruisce il profilo
		 * @return il profilo
		 */
		public Profilo build() {
			Profilo profilo = new Profilo();
			profilo.nickname = this.nickname;
			profilo.avatarImg = this.avatarImg;
			profilo.livello = this.livello;
			profilo.partiteGiocate = this.partiteGiocate;
			profilo.partiteVinte = this.partiteVinte;
			profilo.partitePerse = this.partitePerse;
			return profilo;
		}

		/**
		 * setter del nickname del profilo
		 * @param nickname scelto dal giocatore
		 * @return il profilo aggiornato
		 */
		public ProfiloBuilder setNickname(String nickname) {
			this.nickname = nickname;
			return this;
		}

		/**
		 * setter dell'avatar del giocato
		 * @param avatarImg avatar scelto dal giocatore
		 * @return il profilo aggiornato
		 */
		public ProfiloBuilder setAvatarImg(String avatarImg) {
			this.avatarImg = avatarImg;
			return this;
		}

		/**
		 * setter del livello del giocatore
		 * @param livello 
		 * @return il profilo aggiornato
		 */
		public ProfiloBuilder setLivello(int livello) {
			this.livello = livello;
			return this;
		}

		/**
		 * setter del numero di partite giocater
		 * @param partiteGiocate
		 * @return il profilo aggiornato
		 */
		public ProfiloBuilder setPartiteGiocate(int partiteGiocate) {
			this.partiteGiocate = partiteGiocate;
			return this;
		}

		/**
		 * setter delle partite vinte
		 * @param partiteVinte
		 * @return il profilo aggiornato
		 */
		public ProfiloBuilder setPartiteVinte(int partiteVinte) {
			this.partiteVinte = partiteVinte;
			return this;
		}

		/**
		 * setter delle partite perse
		 * @param partitePerse
		 * @return il profilo aggiornato
		 */
		public ProfiloBuilder setPartitePerse(int partitePerse) {
			this.partitePerse = partitePerse;
			return this;
		}
	}

	/**
	 * getter nickname
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * getter dell'avatar
	 * @return avatar del giocatore
	 */
	public String getAvatarImg() {
		return avatarImg;
	}

	/**
	 * getter del livello del giocatore
	 * @return livello del giocatore
	 */
	public int getLivello() {
		return livello;
	}

	/**
	 * getter delle partite giocate
	 * @return il numero delle partite giocate
	 */
	public int getPartiteGiocate() {
		return partiteGiocate;
	}

	/**
	 * getter delle partite vinte
	 * @return il numero di partite vinte
	 */
	public int getPartiteVinte() {
		return partiteVinte;
	}

	/**
	 * getter delle partite perse
	 * @return il numero di partite perse
	 */
	public int getPartitePerse() {
		return partitePerse;
	}
}


