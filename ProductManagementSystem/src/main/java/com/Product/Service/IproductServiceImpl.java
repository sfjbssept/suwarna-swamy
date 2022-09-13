package com.Product.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Product.Entity.Product;
import com.Product.Exception.ResourceNotFound;
import com.Product.Repo.IProductRepo;

@Service
public class IproductServiceImpl implements IproductService {
@Autowired
 IProductRepo iProductRepo;
	@Override
	public Integer addProduct(Product product) {
		Product addProduct= iProductRepo.save(product);
		return addProduct.getId();
	}
	@Override
	public List<Product> getAllProducts() {
		List <Product> list=iProductRepo.findAll();
		
		return list;
	
	
	}
	@Override
	public Optional<Product> getProduct(Integer Id) {
		return iProductRepo.findById(Id);
	}
	@Override
	public Product updateProduct(Product product, Integer id) {
		Product existingProduct=iProductRepo.findById(id).orElseThrow(()-> new ResourceNotFound("Product","id",id));
		//existingProduct.setId(product.getId());
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductCategory(product.getProductCategory());
		existingProduct.setProductBrand(product.getProductBrand());
		existingProduct.setProductPrice(product.getProductPrice());
		iProductRepo.save(existingProduct);
		return existingProduct;
	}
	@Override
	public void delete(Integer id) {
		iProductRepo.deleteById(id);
	}
	@Override
	public void deleteAll() {
		iProductRepo.deleteAll();
		
	}

}
