package rest.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import rest.model.Brand;
import rest.model.Product;

public class ProductsDAO {

	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Product.class)
			.addAnnotatedClass(Brand.class) 
			.buildSessionFactory();
	
	public List<Product> getProductByIdAndCategory(int brandId, String category) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Product> productList;
		String HiberQuery = "from products where brandId = '" + brandId + "' and category = '" + category + "'";
		productList = session.createQuery(HiberQuery).getResultList();
		return productList;
	}

	public List<Product> getProductById(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Product> productList;
		String HiberQuery = "from products where brandId = '" + brandId + "'";
		productList = session.createQuery(HiberQuery).getResultList();
		return productList;
	}
}
