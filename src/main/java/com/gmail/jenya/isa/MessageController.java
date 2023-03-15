package com.gmail.jenya.isa;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/messages")
public class MessageController {

	private KafkaTemplate<String, String> kafkaTemplate;

	public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@PostMapping
	public void publish(@RequestBody String text) {
		try {
			new JSONObject(text);
		} catch (JSONException exception) {
			exception.printStackTrace();
			return;
		}

		kafkaTemplate.send("test", text);
	}
}
