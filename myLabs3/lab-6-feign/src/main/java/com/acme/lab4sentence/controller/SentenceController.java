package com.acme.lab4sentence.controller;

import com.acme.lab4sentence.domain.Word;
import com.acme.lab4sentence.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentenceController {

	@Autowired
	private SentenceService sentenceService;

	@Value("${words}") private String words;

	@GetMapping("/")
	public Word getWord() {
		String[] wordArray = words.split(",");

		//wordArray = "icicle,refrigerator,blizzard,snowball".spAutowiredlit(",");

		int i = (int) Math.round(Math.random() * (wordArray.length - 1));
		return new Word(wordArray[i]);
	}

	@GetMapping("/sentence")
	public String getSentence() {
		return sentenceService.buildSentence();
	}

}
