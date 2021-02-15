package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.daoImpl.ProductDaoImpl;
import model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/Ajout")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDao product;

	public void init() throws ServletException {

		product = new ProductDaoImpl();
	}

	public AddProductServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("Ajout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titleProduct = request.getParameter("titleProduct");
		double priceProduct = Double.parseDouble(request.getParameter("priceProduct"));
		int Quantite = Integer.parseInt(request.getParameter("Quantite"));
		try {
			product.AddProduct(titleProduct, priceProduct, Quantite);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		// test
		response.sendRedirect("vote");

	}

}
