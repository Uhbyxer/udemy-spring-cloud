package com.acme.lab4eurekaclientsolution.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController("/sentence")
public class EurekaController {
	private static final Logger logger = LoggerFactory.getLogger(EurekaController.class);
	@Autowired
	private DiscoveryClient client;


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

		List<String> allServs = client.getServices();
		System.out.println("All servs: " + allServs);

		logger.debug("Service name: {} list: {}", service, list);
		System.out.println("Service name: " + service + " list: " + list);

		if (list != null && list.size() > 0 ) {
			URI uri = list.get(0).getUri();
			if (uri !=null ) {

				logger.debug("About to hit the URI: {}", uri);
				System.out.println("About to hit the URI: " + uri);
				return (new RestTemplate()).getForObject(uri,String.class);
			}
		}
		return null;
	}
}
