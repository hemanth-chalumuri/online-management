package net.hemanth.onlinemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.hemanth.onlinemanagement.dao.ProductDAO;
import net.hemanth.onlinemanagement.dto.Product;
/*
 * Author : Hemanth Chalumuri
 * @Controller+@ResponseBody=@RestController annotation in Spring 4
 * For testing with PostMan call using http://localhost:8080/onlinemanagement/json/data/all/products (OR) http://localhost:8080/onlinemanagement/json/data/14/products 
 * 
 */

@RestController
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDao;
	
	
	@RequestMapping(value = { "/all/products" })
	//@ResponseBody
	public List<Product> getAllProducts() {
		return productDao.getProducts();
	}
	
	@RequestMapping("{id}/products")
	//@ResponseBody
	public Product getProductsById(@PathVariable int id) {
		return productDao.getProductByid(id);
	}
	
	
}
