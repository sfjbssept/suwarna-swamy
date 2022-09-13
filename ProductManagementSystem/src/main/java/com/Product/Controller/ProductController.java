package com.Product.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Product.Entity.Product;
import com.Product.Service.IproductService;

@RestController
public class ProductController {
	@Autowired
	
	IproductService iProductService;
	
	@PostMapping("/addproduct")
	Integer addProduct(@RequestBody Product product) {
		Integer id= iProductService.addProduct(product);
		System.out.println(id);
		return id;
	}
	
	@GetMapping("//allproducts")
	public List getAllProducts() {
		return iProductService.getAllProducts(); 
		
	}
	@GetMapping("/product/{id}")
	public Optional<Product> getProduct(@PathVariable Integer id) {
		Optional<Product> product=iProductService.getProduct(id);
		return (product);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id,@RequestBody Product product){
		return new ResponseEntity<Product>(iProductService.updateProduct(product, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> DeleteProduct(@PathVariable Integer id){
		System.out.println(id);
		ResponseEntity<Product> responseEntity=new ResponseEntity<>(HttpStatus.OK);
		try {
			iProductService.delete(id);
		}
		catch(Exception e){
			e.printStackTrace();
			responseEntity=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		
	}
	
	@DeleteMapping("//deleteAll")
	public void deleteAllProducts() {
		iProductService.deleteAll();
	}

}
