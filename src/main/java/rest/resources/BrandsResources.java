package rest.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import rest.model.Brand;
import rest.model.Link;
import rest.services.BrandsService;


@Path("/devices/brands")
public class BrandsResources {

	BrandsService service = new BrandsService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Brand> getBrands(){
		List<Brand> list = service.getBrands();
		return list;
	}
	
	@GET
	@Path("/{brandId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Brand getBrandById(@PathParam("brandId") int brandId, @Context UriInfo uri) {
		
		Link self = new Link(uri.getAbsolutePath().toString(), "self");
		
		String productsUri = uri.getBaseUriBuilder()
				.path(ProductsResources.class)
				.path(ProductsResources.class, "getProductById")
				.resolveTemplate("brandId", brandId).toString();
		
		Link products = new Link(productsUri, "products");
		Brand brand = service.getBrandById(brandId);				
		List<Link> links = new ArrayList<>();
		links.add(self);
		links.add(products);
		brand.setLinks(links);
		return brand;
	}
	
	@Path("/{brandId}/products")
	public ProductsResources productsDelegation() {
		return new ProductsResources();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postBrands(Brand brand, @Context UriInfo uri) {
		service.addBrand(brand);
		URI location = uri.getAbsolutePathBuilder().path(Integer.toString(brand.getBrandId())).build(); 
		return Response.created(location).entity(brand).build();
	}
	
	@PUT
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putBrand(@PathParam("brandId")  int brandId, Brand updatedBrand) {
		updatedBrand.setBrandId(brandId);
		service.updateBrand(updatedBrand);
	}
	
	@DELETE
	@Path("/{brandId}")
	public void deleteBrand(@PathParam("brandId") int brandId){
		service.deleteBrand(brandId);
	}
}
