package com.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbit.config.MessagingConfig;
import com.rabbit.entity.EmployeeStatus;

@Component
public class User {
	@RabbitListener(queues = MessagingConfig.QUEUENAME)
	public void consumeMessageFromQueue(EmployeeStatus employeeStatus) {
		System.out.println("Message Recived"+employeeStatus);
	}
}
