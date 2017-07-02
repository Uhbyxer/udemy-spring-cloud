package com.acme.lab4eurekaclientsolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController("/sentence")
public class EurekaController {
	@Autowired DiscoveryClient client;

	@RequestMapping
	public String getSentence() {
		return
				getWord("LAB-4-SUBJECT") + " "
						+ getWord("LAB-4-VERB") + " "
						+ getWord("LAB-4-ARTICLE") + " "
						+ getWord("LAB-4-ADJECTIVE") + " "
						+ getWord("LAB-4-NOUN") + "."
				;
	}

	private String getWord(String service) {
		List<ServiceInstance> list = client.getInstances(service);
		if (list != null && list.size() > 0 ) {
			URI uri = list.get(0).getUri();
			if (uri !=null ) {
				return (new RestTemplate()).getForObject(uri,String.class);
			}
		}
		return null;
	}
}
