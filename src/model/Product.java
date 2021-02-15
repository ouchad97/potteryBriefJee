package model;

public class Product {
	private int idProduct;
	private String titleProduct;
	private double priceProduct;
	private int Quantite;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(int idProduct, String titleProduct, double priceProduct, int quantite) {
		super();
		this.idProduct = idProduct;
		this.titleProduct = titleProduct;
		this.priceProduct = priceProduct;
		this.Quantite = quantite;
	}

	
	public Product(String titleProduct, double priceProduct, int quantite) {
		super();
		this.titleProduct = titleProduct;
		this.priceProduct = priceProduct;
		this.Quantite = quantite;
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

	

}
