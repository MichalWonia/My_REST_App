package rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "products")
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	int productId;
	
	@ManyToOne(targetEntity = Brand.class) 
	@JoinColumn(name = "brandId")
	Brand brandEntity;
	
	@Column(name = "productName")
	String productName;
	
	@Column(name = "category")
	String category;
	
	@Column(name = "cost")
	String cost;

	public Product() {
		
	}

	public Product(int productId, Brand brandEntity, String productName, String category, String cost) {
		this.productId = productId;
		this.brandEntity = brandEntity;
		this.productName = productName;
		this.category = category;
		this.cost = cost;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Brand getBrandEntity() {
		return brandEntity;
	}

	public void setBrandEntity(Brand brandEntity) {
		this.brandEntity = brandEntity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", brandEntity=" + brandEntity + ", productName=" + productName
				+ ", category=" + category + ", cost=" + cost + "]";
	}
}
