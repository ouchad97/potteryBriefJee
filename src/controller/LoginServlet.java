package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoLogin;
import dao.daoImpl.LoginDaoImpl;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoLogin user;

	public void init() throws ServletException {

		user = new LoginDaoImpl();
	}

	String emailId = "";
	String password = "";

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailUser = request.getParameter("emailUser");
		String passwordUser = request.getParameter("passwordUser");

		try {
			User us = user.login(emailUser, passwordUser);
			if (us != null) {

				if (us.getRoleUser().equals("Client")) {
					HttpSession session = request.getSession(true); // Creating a session
					session.setAttribute("Client", emailUser); // setting session attribute
					request.setAttribute("emailUser", emailUser); 
                    session.setAttribute("CURRENT_USER", us);
					

					response.sendRedirect("listClient");
				}

				else {
					if (us.getRoleUser().equals("Administrateur")) {

						response.sendRedirect("Gestion");

						System.out.println("Admin's Home");

						HttpSession session = request.getSession(); // Creating a session
						session.setAttribute("Administrateur", emailUser); // setting session attribute
						request.setAttribute("emailUser", emailUser);

					}
				}
			} else {
				System.out.print("Erreur null");
				response.sendRedirect("login");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("Login.jsp").forward(request, response);

	}

}
