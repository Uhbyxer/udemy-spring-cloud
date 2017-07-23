package com.acme.lab4sentence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController public class SentenceController {
	@Autowired private LoadBalancerClient loadBalancer;

	@Value("${words}") private String words;

	@GetMapping("/") public String getWord() {
		String[] wordArray = words.split(",");

		//wordArray = "icicle,refrigerator,blizzard,snowball".split(",");

		int i = (int) Math.round(Math.random() * (wordArray.length - 1));
		return wordArray[i];
	}

	@GetMapping("/sentence") public String getSentence() {
		return "<h3>Some Sentences</h3><br/>" + buildSentence() + "<br/><br/>" + buildSentence() + "<br/><br/>"
				+ buildSentence() + "<br/><br/>" + buildSentence() + "<br/><br/>" + buildSentence() + "<br/><br/>";
	}

	private String buildSentence() {
		try {
			return String.format("%s %s %s %s %s.", getWordFromInstance("SUBJECT"), getWordFromInstance("VERB"), getWordFromInstance("ARTICLE"),
					getWordFromInstance("ADJECTIVE"), getWordFromInstance("NOUN"));
		} catch (Exception e) {
			e.printStackTrace();
			return "Sorry, Michael...";
		}
	}

	private String getWordFromInstance(String service) {
		ServiceInstance instance = loadBalancer.choose("LAB-4-"+ service);
		System.out.println("Ribbon's choice is: " + instance.getUri());
		return new RestTemplate().getForObject(instance.getUri(), String.class);
	}
}
