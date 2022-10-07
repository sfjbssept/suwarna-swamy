package com.active.config;


import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;


@Configuration
public class Config {
	@Value("${activemq.broker.url}")
	private String brokerUrl;
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("standalone.queue");
	}
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerUrl);
		//factory.setUserName("admin");
		//factory.setPassword("admin");
		return factory;
	}
	@Bean
	public JmsTemplate template() {
		return new JmsTemplate(activeMQConnectionFactory());
		
	}

}
