package rest.services;

import java.util.List;

import rest.DAO.BrandsDAO;
import rest.model.Brand;

public class BrandsService {

	BrandsDAO brandsDAO = new BrandsDAO();
	
	public List<Brand> getBrands() {
		List<Brand> list = brandsDAO.getBrands();
		return list;
	}

	public Brand getBrandById(int brandId) {
		Brand brand = brandsDAO.getBrandById(brandId);
		return brand;
	}

	public void addBrand(Brand brand) {
		brandsDAO.addBrand(brand);
	}

	public void updateBrand(Brand updatedBrand) {
		brandsDAO.updateBrand(updatedBrand);
	}

	public void deleteBrand(int brandId) {
		brandsDAO.deleteBrand(brandId);
	}
}
