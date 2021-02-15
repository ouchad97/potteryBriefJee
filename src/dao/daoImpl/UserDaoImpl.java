package dao.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.UserDao;
import database.database;
import model.User;

public class UserDaoImpl implements UserDao{
	Statement statement = null;
	
	//Inscription Role: Client
	public User Inscription(String nameUser, String lastnameUser, String emailUser, String passwordUser)
			throws ClassNotFoundException, SQLException {
		User user = null;
		String requete="INSERT INTO public.\"User\"(\"nameUser\", \"lastnameUser\", \"emailUser\", \"passwordUser\", \"roleUser\") VALUES (?, ?, ?, ?, ?);";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		
		statement.setString(1, nameUser);
		statement.setString(2, lastnameUser);
		statement.setString(3, emailUser);
		statement.setString(4, passwordUser);
		statement.setString(5, "Client");
		statement.executeUpdate();
		
		user = new User(nameUser, lastnameUser, emailUser, passwordUser);
		return user;
	}
}
