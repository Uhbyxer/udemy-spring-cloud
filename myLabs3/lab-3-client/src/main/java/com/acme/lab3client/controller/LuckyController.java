package com.acme.lab3client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/lucky-word")
public class LuckyController {
	@Value("${lucky-word}")
	private String luckyWord;

	@GetMapping
	public String getLucky() {
		return "The word is " + luckyWord;
	}
}
