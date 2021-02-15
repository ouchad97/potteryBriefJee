package dao;

import java.sql.SQLException;

import model.User;

public interface DaoLogin {

	public  User login(String emailUser, String passwordUser)throws ClassNotFoundException, SQLException;
	
}
