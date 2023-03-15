package com.gmail.jenya.isa;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

	@KafkaListener(topics = "test", groupId = "groupId")
	public void listener(String text) {
		try {
			new JSONObject(text);
		} catch (JSONException exception) {
			exception.printStackTrace();
			return;
		}
		System.out.println("Listener recieved today: " + text);
	}
}
