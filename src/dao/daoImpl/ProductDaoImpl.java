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
			Double priceProduct = resultat.getDouble(3);
			int Quantite = resultat.getInt(4);
			byte[] image = resultat.getBytes(5);

			// Creer l'objet Article
			Product A = new Product(idProduct, titleProduct, priceProduct, Quantite, image);
			product.add(A);
		}

		return product;
	}

	@Override
	public Product AddProduct(String titleProduct, Double priceProduct, int Quantite, byte[] image)
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

}
