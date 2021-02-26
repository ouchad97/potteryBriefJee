package dao.daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DaoVote;
import database.database;
import model.Vote;

public class voteDaoImpl implements DaoVote{

	@Override
	public Vote AddVote(int idUser, int idProduct) throws ClassNotFoundException, SQLException {
		Vote vote = null;
		String requete = "INSERT INTO public.\"Vote\"( \"idUser\", \"idProduct\") VALUES (?, ?;";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete,
				Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, idUser);
		statement.setInt(2, idProduct);
		statement.executeUpdate();
		vote = new Vote (idUser, idProduct);
		return vote;
	}

}
