package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import dao.DaoVote;
import dao.ProductDao;
import dao.daoImpl.ProductDaoImpl;
import dao.daoImpl.voteDaoImpl;
import model.Product;

/**
 * Servlet implementation class gestionServlet
 */
@WebServlet("/")
public class gestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoVote vote;

	private ProductDao product;

	public void init() throws ServletException {
		vote = new voteDaoImpl();

		product = new ProductDaoImpl();
	}

	public gestionServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
		
			case "/delete":
				deleteProduct(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateProduct(request, response);
				break;
			case "/Gestion":
				listProduct(request, response);
				break;
			case "/vote":
				voteProduct(request, response);
				break;
			case "/listClient":
				listClient(request, response);
				break;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ServletException(ex);
		}
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {

		HttpSession session = request.getSession();
		if (session.getAttribute("Administrateur") != null) {

			try {
				List<Product> listProduct = product.getAll();
				request.setAttribute("listProduct", listProduct);
				List<String> listImage = new ArrayList<String>();
				for (Product product : listProduct) {
					byte[] imageBytes = product.getImage();
					listImage.add(Base64.getEncoder().encodeToString(imageBytes));
				}
				request.setAttribute("images", listImage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("GestionProduct.jsp");
				dispatcher.forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("login");
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("Administrateur") != null) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("Ajout.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}


	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, ClassNotFoundException {

		HttpSession session = request.getSession();
		if (session.getAttribute("Administrateur") != null) {
			int idProduct = Integer.parseInt(request.getParameter("idProduct"));
			Product existingProduct = product.getProductbyID(idProduct);
			request.setAttribute("product", existingProduct);

			RequestDispatcher dispatcher = request.getRequestDispatcher("Modif.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}


	private void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {

		HttpSession session = request.getSession();
		if (session.getAttribute("Administrateur") != null) {

			try {
				// int idProduct = Integer.parseInt(request.getParameter("idProduct"));

				String titleProduct = request.getParameter("titleProduct");
				double priceProduct = Double.parseDouble(request.getParameter("priceProduct"));
				int Quantite = Integer.parseInt(request.getParameter("Quantite"));
				String data = request.getParameter("image");
				byte[] image = data.getBytes();

				Product prod = new Product(titleProduct, priceProduct, Quantite, image);
				product.UpdateProduct(prod);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("login");
		}
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {

		HttpSession session = request.getSession();
		if (session.getAttribute("Administrateur") != null) {
			int idProduct = Integer.parseInt(request.getParameter("idProduct"));
			product.deleteProduct(idProduct);
			response.sendRedirect("Gestion");

		} else {
			response.sendRedirect("login");
		}
	}
	
	
	private void listClient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {

		HttpSession session = request.getSession();
		if (session.getAttribute("Client") != null) {

			try {
				List<Product> listProduct = product.getAll();
				request.setAttribute("listProduct", listProduct);
				List<String> listImage = new ArrayList<String>();
				for (Product product : listProduct) {
					byte[] imageBytes = product.getImage();
					listImage.add(Base64.getEncoder().encodeToString(imageBytes));
				}
				request.setAttribute("images", listImage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("productvote.jsp");
				dispatcher.forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("login");
		}
	}
	private void voteProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException, ServletException {
	
		HttpSession session = request.getSession();
		if (session.getAttribute("Client") != null) {
			
			try {
				int idUser = Integer.parseInt(request.getParameter("idUser"));
				int idProduct = Integer.parseInt(request.getParameter("idProduct"));
				response.sendRedirect("listClient");

				vote.AddVote(idUser, idProduct);
			} catch (ClassNotFoundException | SQLException | NumberFormatException e) {
				e.printStackTrace();
			}
			
			
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}
}
