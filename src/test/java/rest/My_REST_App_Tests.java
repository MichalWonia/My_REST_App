package rest;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import rest.DAO.BrandsDAO;
import rest.DAO.ProductsDAO;
import rest.model.Brand;
import rest.model.Product;

public class My_REST_App_Tests {

	private BrandsDAO brandsDAO;
	private ProductsDAO productsDAO;
	
	@BeforeEach
	void init() {
		brandsDAO = new BrandsDAO();
		productsDAO = new ProductsDAO();
	}
	
	@Test
	@Disabled // remove it to run this test
	public void getAllBrandsTest() {
		Iterable<Brand> brandsList = brandsDAO.getBrands();
		Assertions.assertNotNull(brandsList);
		brandsList.forEach(System.out::println);
	}
	
	@Test
	@Disabled
	public void getBrandByIdTest() {
		int brandId = 3;
		Brand selectedBrand = brandsDAO.getBrandById(brandId);
		Assertions.assertNotNull(selectedBrand);
		System.out.println(selectedBrand);
	}
	
	@Test
	@Disabled
	public void addNewBrandTest() {
		Brand newBrand = new Brand();
		newBrand.setBrandName("Motorola");
		brandsDAO.addBrand(newBrand);
		List<Brand> brandsList = brandsDAO.getBrands();
		Assertions.assertNotNull(brandsList.contains(newBrand));
	}
	
	@Test
	@Disabled
	public void updateBrandTest() {
		int updateBrandId = 6;
		String newBrandName = "newBrand";
		Brand newBrand = new Brand();
		newBrand.setBrandId(updateBrandId);
		newBrand.setBrandName(newBrandName);
		brandsDAO.updateBrand(newBrand);
		
		List<Brand> brandsList = brandsDAO.getBrands();
		Assertions.assertNotNull(brandsList.contains(newBrand));	
	}
	
	@Test
	@Disabled
	public void deleteBrandById() {
		int deleteBrandId = 7;
		brandsDAO.deleteBrand(deleteBrandId);
		List<Brand> brandsList = brandsDAO.getBrands();
		boolean isDeletedBrandPresent = brandsList.stream().anyMatch(brand -> brand.getBrandId() == deleteBrandId);
		Assertions.assertEquals(isDeletedBrandPresent, false);
	}
	
	@Test
	@Disabled
	public void getProductByIdAndCategoryTest() {
		int brandId = 1;
		String category = "smartphone";
		List<Product> productsList = productsDAO.getProductByIdAndCategory(brandId, category);
		System.out.println(productsList);
		Assertions.assertNotNull(productsList);
	}
	
	@Test
	@Disabled
	public void getProductByIdTest() {
		int brandId = 1;
		List<Product> productsList = productsDAO.getProductById(brandId);
		System.out.println(productsList);
		Assertions.assertNotNull(productsList);
	}
}
