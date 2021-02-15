package dao;

import java.sql.SQLException;
import java.util.List;

import model.Product;



public interface ProductDao {
	public List<Product> getAll() throws ClassNotFoundException, SQLException;
//	public Product getProductbyID(int idProduct) throws ClassNotFoundException, SQLException;
	public Product AddProduct(String titleProduct, Double priceProduct, int Quantite, byte[] image) throws ClassNotFoundException, SQLException;
//	public int  UpdateProduct(int idProduct, String titleProduct, Double priceProduct, int Quantite) throws ClassNotFoundException, SQLException;
//	public int deleteProduct(int idProduct) throws ClassNotFoundException, SQLException;
}
