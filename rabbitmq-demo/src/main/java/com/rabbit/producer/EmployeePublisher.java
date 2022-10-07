package com.rabbit.producer;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.config.MessagingConfig;
import com.rabbit.entity.Employee;
import com.rabbit.entity.EmployeeStatus;

@RestController
//@RequestMapping("/Employee")
@RequestMapping
public class EmployeePublisher {

	@Autowired
	private RabbitTemplate template;

	@PostMapping("/employee")
	public String saveMessage(@RequestBody Employee employee) {
		employee.setEmpId(UUID.randomUUID().toString());

		EmployeeStatus empStatus = new EmployeeStatus(employee, "Joinded",
				"Employee has recently joined and is going through training");
		template.convertAndSend(MessagingConfig.EXHANGENAME, MessagingConfig.ROUTING_KEY, empStatus);

		return "success";

	}

}
