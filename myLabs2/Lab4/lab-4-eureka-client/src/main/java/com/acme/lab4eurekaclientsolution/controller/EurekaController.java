package com.acme.lab4eurekaclientsolution.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController {
	@Value("${words}")
	private String words;

	@RequestMapping("/")
	public String getWord() {
		String[] wordsArray = words.split(",");
		return wordsArray[(int) Math.round(Math.random() * (wordsArray.length - 1)) ];
	}
}
