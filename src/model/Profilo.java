package model;

//FIXME: fare il pattern builder
public class Profilo {
	private String nickname;
	private String avatarImg;
	private int livello;
	private int partiteGiocate;
	private int partiteVinte;
	private int partitePerse;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatarImg() {
		return avatarImg;
	}
	public void setAvatarImg(String avatarImg) {
		this.avatarImg = avatarImg;
	}
	public int getLivello() {
		return livello;
	}
	public void setLivello(int livello) {
		this.livello = livello;
	}
	public int getPartiteGiocate() {
		return partiteGiocate;
	}
	public void setPartiteGiocate(int partiteGiocate) {
		this.partiteGiocate = partiteGiocate;
	}
	public int getPartiteVinte() {
		return partiteVinte;
	}
	public void setPartiteVinte(int partiteVinte) {
		this.partiteVinte = partiteVinte;
	}
	public int getPartitePerse() {
		return partitePerse;
	}
	public void setPartitePerse(int partitePerse) {
		this.partitePerse = partitePerse;
	}
}
