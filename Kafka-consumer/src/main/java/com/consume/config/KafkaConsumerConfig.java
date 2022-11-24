package com.consume.config;

import java.util.HashMap;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.consume.entity.User;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;


@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	//config for straight plain string text
	@Bean
	public ConsumerFactory<String,String>consumerFactory(){
		Map<String,Object> configs=new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG,"groupid-1");
		return new DefaultKafkaConsumerFactory<>(configs);
		
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,String>KafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String,String>factory=new ConcurrentKafkaListenerContainerFactory<String,String>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
		
	}
	@Bean
	
public ConsumerFactory<String,User>userConsumerFactory(){
		Map<String,Object> configs=new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG,"groupid-2");
		return new DefaultKafkaConsumerFactory<>(configs,new StringDeserializer(),new JsonDeserializer<>())
		
	}
	
}
