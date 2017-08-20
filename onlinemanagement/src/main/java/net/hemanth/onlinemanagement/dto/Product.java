package net.hemanth.onlinemanagement.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
@Entity
public class Product {

	/*
	 * Private fields
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;
	
	@Column(name = "product_name")
	@NotBlank(message="Please enter product Name")
	@Length(min=2,message="Product Name should be atleast 2 characters")
	private String name;
	
	@Column(name = "product_description")
	@NotBlank(message="Please enter Description")
	@Length(max=30,message="Product Description should not exceed 30 characters")
	// @JsonIgnore This annotation will ignore this field in JSON Response while making REST call
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description +"]";
	}
}
