package rest.resources;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import rest.model.Product;
import rest.services.ProductsService;

@Path("/devices/brands")
public class ProductsResources {

	ProductsService productsService = new ProductsService();

	@GET
	@Path("/{brandId}/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductById(@PathParam("brandId") int brandId,
			@QueryParam("category") String category) {

		List<Product> productList;
		
		if (category != null) {
			productList = productsService.getProductByIdAndCategory(brandId, category);
		} else {
			productList = productsService.getProductById(brandId);	
		}

		return productList;
	}
}