package com.gmail.jenya.isa;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

	@KafkaListener(topics = "test", groupId = "groupId")
	public void listener(String data) {
		System.out.println("Listener recieved today: " + data);
	}
}
