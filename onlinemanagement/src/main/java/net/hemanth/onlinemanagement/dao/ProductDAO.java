package net.hemanth.onlinemanagement.dao;

import java.util.List;

import net.hemanth.onlinemanagement.dto.Product;

public interface ProductDAO {

	List<Product> getProducts();
	Product getProductByid(Integer id);
	boolean saveProduct(Product p);
	void deleteProductByid(Integer id);
}
