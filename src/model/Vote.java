package model;

public class Vote {
	
	private int idVote;
	private int idUser;
	private int idProduct;
	public Vote(int idVote, int idUser, int idProduct) {
		super();
		this.idVote = idVote;
		this.idUser = idUser;
		this.idProduct = idProduct;
	}
	
	
	public Vote(int idUser, int idProduct) {
		super();
		this.idUser = idUser;
		this.idProduct = idProduct;
	}
	public Vote() {
		super();
		
	}
	
	public int getIdVote() {
		return idVote;
	}
	public void setIdVote(int idVote) {
		this.idVote = idVote;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	
	
	
}
