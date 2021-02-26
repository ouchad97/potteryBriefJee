package dao.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import database.database;
import model.Product;

public class ProductDaoImpl implements ProductDao {

	Statement statement = null;

	public List<Product> getAll() throws ClassNotFoundException, SQLException {

		List<Product> product = new ArrayList<Product>();
		statement = database.getMyConnexion().createStatement();

		// - selectionner la table
		ResultSet resultat;
		String requete = "SELECT * FROM public.\"Product\"";

		resultat = statement.executeQuery(requete);

		while (resultat.next()) {
			int idProduct = resultat.getInt(1);
			String titleProduct = resultat.getString(2);
			double priceProduct = resultat.getDouble(3);
			int Quantite = resultat.getInt(4);
			byte[] image = resultat.getBytes(5);

			// Creer l'objet Product
			Product A = new Product(idProduct, titleProduct, priceProduct, Quantite, image);
			product.add(A);
		}

		return product;
	}

	// Ajout
	@Override
	public Product AddProduct(String titleProduct, double priceProduct, int Quantite, byte[] image)
			throws ClassNotFoundException, SQLException {
		Product product = null;
		String requete = "INSERT INTO public.\"Product\"(\"titleProduct\", \"priceProduct\", \"Quantite\", \"image\") VALUES (?, ?, ?, ?);";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete,
				Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, titleProduct);
		statement.setDouble(2, priceProduct);
		statement.setInt(3, Quantite);
		statement.setBytes(4, image);
		statement.executeUpdate();

		product = new Product(titleProduct, priceProduct, Quantite, image);

		return product;
	}

//	// Modif
//	@Override
//	public int UpdateProduct(int idProduct, String titleProduct, int priceProduct, int Quantite, byte[] image)
//			throws ClassNotFoundException, SQLException {
//
//		String requette = "UPDATE public.\"Product\" SET \"titleProduct\"="+titleProduct+",\"priceProduct\"="+priceProduct+", \"Quantite\"="+Quantite+", image="+image+" WHERE \"idProduct\"="+idProduct+";";
//		PreparedStatement statement = database.getMyConnexion().prepareStatement(requette,
//				Statement.RETURN_GENERATED_KEYS);
//		
//		return statement.executeUpdate();
//	}

	// Supp
	@Override
	public int deleteProduct(int idProduct) throws ClassNotFoundException, SQLException {

		String requete = "DELETE FROM public.\"Product\" WHERE \"idProduct\"=?;";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete,
				Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, idProduct);
		return statement.executeUpdate();
	}

	// get by id
	@Override
	public Product getProductbyID(int id) throws ClassNotFoundException, SQLException {
		Product product = null;
		String requete = "SELECT * FROM \"Product\" WHERE \"idProduct\" = ?";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete);

		statement.setLong(1, id);
		ResultSet resultat = statement.executeQuery();

		if (resultat.next()) {
			int idProduct = resultat.getInt("idProduct");
			String titleProduct = resultat.getString("titleProduct");
			int priceProduct = resultat.getInt("priceProduct");
			int Quantite = resultat.getInt("Quantite");
			byte[] image = resultat.getBytes("image");

			product = new Product(idProduct, titleProduct, priceProduct, Quantite, image);
		}

		return product;
	}

	@Override
	public int UpdateProduct(Product prod) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String requette = "UPDATE  \"Product\" set  \"titleProduct\"='?, \"priceProduct\"=?, \"Quantite\"=?, \"image\"=? WHERE \"idProduct\"=?";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requette,
				Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, prod.getTitleProduct());
		statement.setDouble(2, prod.getPriceProduct());
		statement.setInt(3, prod.getQuantite());
		statement.setBytes(4, prod.getImage());
		statement.setInt(5, prod.getIdProduct());
		
		return statement.executeUpdate();
	}

}
