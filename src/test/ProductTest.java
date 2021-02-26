package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.daoImpl.ProductDaoImpl;
import model.Product;

class ProductTest {

	private static final ProductDaoImpl product_service = new ProductDaoImpl();

	

	
	
	@Test
	public void testupdateProducts() throws Exception{
	
		Product product = product_service.getProductbyID(20);
		
		if (product != null) {
			
			System.out.println(product.toString());
			
//			product.setTitleProduct("Housni ouchad");
//			product.setPriceProduct(126.12);
//			product.setQuantite(4);
//			product.setImage(null);
//			
//			product_service.UpdateProduct(product);
		}
		

	
	}
	
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
