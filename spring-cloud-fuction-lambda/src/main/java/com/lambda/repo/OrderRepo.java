package com.lambda.repo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.lambda.entity.Order;

@Repository
public class OrderRepo {
	
	public List<Order> buildOrders(){
		return Stream.of(
				new Order(101,"LG",100000,1),
				new Order(102,"Samsung",200000,1),
				new Order(103,"Philips",300000,1),
				new Order(104,"Toshiba",400000,1)).collect(Collectors.toList());
		
	}

}
