package rest.services;

import java.util.List;

import rest.DAO.ProductsDAO;
import rest.model.Product;

public class ProductsService {

	ProductsDAO productsDAO = new ProductsDAO();
	
	public List<Product> getProductByIdAndCategory(int brandId, String category) {
		List<Product> list = productsDAO.getProductByIdAndCategory(brandId, category);
		return list;
	}

	public List<Product> getProductById(int brandId) {
		List<Product> list = productsDAO.getProductById(brandId);
		return list;
	}
}
