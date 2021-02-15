package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import dao.UserDao;
import dao.daoImpl.UserDaoImpl;

/**
 * Servlet implementation class InscritServlet
 */
@WebServlet("/Inscription")
public class InscritServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InscritServlet() {
        super();
    }

    private UserDao user;

	public void init() throws ServletException {

		user = new UserDaoImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nameUser = request.getParameter("nameUser");
		String lastnameUser = request.getParameter("lastnameUser");
		String emailUser = request.getParameter("emailUser");
		String passwordUser = request.getParameter("passwordUser");
		try {
			user.Inscription(nameUser, lastnameUser, emailUser, passwordUser);
			
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
		response.sendRedirect("login");

	}
}