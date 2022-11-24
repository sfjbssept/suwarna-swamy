package com.lambda;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lambda.entity.Order;
import com.lambda.repo.OrderRepo;

@SpringBootApplication
public class SpringCloudFuctionLambdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFuctionLambdaApplication.class, args);
	}
	@Autowired
	OrderRepo orderRepo;
	@Bean
	public Supplier<List<Order>> orders(){
		return() ->orderRepo.buildOrders();
		
	}
	@Bean
	public Function<String,List<Order>> findByOrderName(){
		return(input) -> orderRepo.buildOrders().stream().filter(order -> order.getName().equals(input)).collect(Collectors.toList());
	}
	
}
