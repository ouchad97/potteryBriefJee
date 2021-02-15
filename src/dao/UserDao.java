package dao;

import java.sql.SQLException;

import model.User;


public interface UserDao {
	
	public User Inscription(String nameUser, String lastnameUser, String emailUser, String passwordUser) throws ClassNotFoundException, SQLException;

}
