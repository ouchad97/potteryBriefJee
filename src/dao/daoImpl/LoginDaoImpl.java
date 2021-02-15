package dao.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import dao.DaoLogin;
import database.database;
import model.User;

public class LoginDaoImpl implements DaoLogin {
	Statement statement = null;
	public static int id_Session = 0;

	public User login(String emailUser, String passwordUser) throws ClassNotFoundException, SQLException {
		User user = null;
		
		try {
			String query = "SELECT * FROM public.\"User\" where \"emailUser\"=? and \"passwordUser\"=?";
			Connection con = database.getMyConnexion();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, emailUser);
			ps.setString(2, passwordUser);
			ResultSet rs = ps.executeQuery();
			
			
			
			if (rs.next()) {
				if (rs.getString(6).equals("Administrateur")) {
					user = new User(rs.getString(2), rs.getString(3), emailUser, passwordUser, rs.getString(6));
					id_Session = (rs.getInt(1));
				} else {
					if (rs.getString(6).equals("Client")) {
						user = new User(rs.getString(2), rs.getString(3), emailUser, passwordUser, rs.getString(6));
						id_Session = (rs.getInt(1));
					}
				}
				
				user.setIdUser((rs.getInt(1)));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}