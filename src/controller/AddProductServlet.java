package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
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

import javax.servlet.annotation.MultipartConfig;

import dao.ProductDao;
import dao.daoImpl.ProductDaoImpl;
import model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/Ajout")
@MultipartConfig(maxFileSize = 16177215)

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

		HttpSession session = request.getSession();

		if (session.getAttribute("Administrateur") != null) {
			String titleProduct = request.getParameter("titleProduct");
			double priceProduct = Double.parseDouble(request.getParameter("priceProduct"));
			int Quantite = Integer.parseInt(request.getParameter("Quantite"));
			InputStream inputStream = null;
			Part filePart = request.getPart("image");
			if (filePart != null) {
				inputStream = filePart.getInputStream();
			}

			byte[] image = IOUtils.toByteArray(inputStream);
			try {
				product.AddProduct(titleProduct, priceProduct, Quantite, image);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			// test
			response.sendRedirect("Gestion");
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

}
