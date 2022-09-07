package model;

public class Profilo {

	private String nickname;
	private String avatarImg;
	private int livello;
	private int partiteGiocate;
	private int partiteVinte;
	private int partitePerse;

	private Profilo() {}

	public static class ProfiloBuilder {

		private String nickname;
		private String avatarImg;
		private int livello;
		private int partiteGiocate;
		private int partiteVinte;
		private int partitePerse;

		public Profilo build() {
			Profilo profilo = new Profilo();
			profilo.nickname = this.nickname;
			profilo.avatarImg = this.avatarImg;
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


