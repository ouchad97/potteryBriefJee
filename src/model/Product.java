package model;

public class Product {
	private int idProduct;
	private String titleProduct;
	private double priceProduct;
	private int Quantite;
	byte[] image;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(int idProduct, String titleProduct, double priceProduct, int quantite, byte[] image) {
		super();
		this.idProduct = idProduct;
		this.titleProduct = titleProduct;
		this.priceProduct = priceProduct;
		this.Quantite = quantite;
		this.image = image;

		

	}

	
	public Product(String titleProduct, double priceProduct, int quantite, byte[] image) {
		super();
		this.titleProduct = titleProduct;
		this.priceProduct = priceProduct;
		this.Quantite = quantite;
		this.image = image;

	}

	public int getIdProduct() {
		return idProduct;
	}


	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}


	public String getTitleProduct() {
		return titleProduct;
	}


	public void setTitleProduct(String titleProduct) {
		this.titleProduct = titleProduct;
	}


	public double getPriceProduct() {
		return priceProduct;
	}


	public void setPriceProduct(double priceProduct) {
		this.priceProduct = priceProduct;
	}


	public int getQuantite() {
		return Quantite;
	}


	public void setQuantite(int quantite) {
		this.Quantite = quantite;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}

	

}
