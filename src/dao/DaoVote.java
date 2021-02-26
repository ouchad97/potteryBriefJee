package dao;

import java.sql.SQLException;

import model.Vote;

public interface DaoVote {
	public Vote AddVote(int idUser, int idProduct) throws ClassNotFoundException, SQLException;

	
}
