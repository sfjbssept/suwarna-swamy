package com.active.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	@JmsListener(destination="standalone.queue")
	public void consume(String msg) {
		System.out.println("This Message has been published is consumed " +msg);
		
	}

}
