package com.Product.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Product.Entity.Product;

public interface IProductRepo extends JpaRepository<Product,Integer>{

}
