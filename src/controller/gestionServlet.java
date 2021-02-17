package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.daoImpl.ProductDaoImpl;
import model.Product;

/**
 * Servlet implementation class gestionServlet
 */
@WebServlet("/Gestion")
public class gestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao product;

	public void init() throws ServletException {

		product = new ProductDaoImpl();
	}

	public gestionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Product> listProduct = product.getAll();
			request.setAttribute("listProduct", listProduct);
			
			List<String> listImage = new ArrayList<String>();
			for (Product product : listProduct) {
				byte[] imageBytes = product.getImage();
				listImage.add(Base64.getEncoder().encodeToString(imageBytes));
			}
			request.setAttribute("images", listImage);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("GestionProduct.jsp").forward(request, response);
		//this.getServletContext().getRequestDispatcher("productvote.jsp").forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}
}

