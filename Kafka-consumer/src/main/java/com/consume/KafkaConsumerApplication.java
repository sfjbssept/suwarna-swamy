package com.consume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;

import com.consume.entity.User;

@SpringBootApplication
public class KafkaConsumerApplication {
	List<String> messages= new ArrayList();
	User userFromTopic=null;
	@GetMapping("/consumerString")
	public List <String> consumeMessages(){
		return messages;
		
	}
	@KafkaListener(groupId="group-1",topics="spring-kafka1",containerFactory="kafkaContainerFactory")
	public List String getMessageFromTopic(String Data) {
		messages.add(Data);
		return messages;
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

}
