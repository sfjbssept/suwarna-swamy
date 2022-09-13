package com.Product.Service;

import java.util.List;
import java.util.Optional;

import com.Product.Entity.Product;

public interface IproductService {
	
	public Integer addProduct(Product product);
	public List<Product> getAllProducts();
	Optional<Product> getProduct(Integer Id);
	Product updateProduct(Product product ,Integer id);
	public void delete(Integer id);
	public void deleteAll();

}
