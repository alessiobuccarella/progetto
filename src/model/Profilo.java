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

		public ProfiloBuilder setNickname(String nickname) {
			this.nickname = nickname;
			return this;
		}

		public ProfiloBuilder setAvatarImg(String avatarImg) {
			this.avatarImg = avatarImg;
			return this;
		}

		public ProfiloBuilder setLivello(int livello) {
			this.livello = livello;
			return this;
		}

		public ProfiloBuilder setPartiteGiocate(int partiteGiocate) {
			this.partiteGiocate = partiteGiocate;
			return this;
		}

		public ProfiloBuilder setPartiteVinte(int partiteVinte) {
			this.partiteVinte = partiteVinte;
			return this;
		}

		public ProfiloBuilder setPartitePerse(int partitePerse) {
			this.partitePerse = partitePerse;
			return this;
		}
	}

	public String getNickname() {
		return nickname;
	}

	public String getAvatarImg() {
		return avatarImg;
	}

	public int getLivello() {
		return livello;
	}

	public int getPartiteGiocate() {
		return partiteGiocate;
	}

	public int getPartiteVinte() {
		return partiteVinte;
	}

	public int getPartitePerse() {
		return partitePerse;
	}
}


