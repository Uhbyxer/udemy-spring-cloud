package com.acme.lab4sentence.controller;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@ConfigurationProperties(prefix = "wordConfig")
public class LuckyWordController {
//	@Value("${wordConfig.lucky-word}")
//	private String luckyWord;
//	@Value("${wordConfig.preamble}")
//	private String preamble;

		private String luckyWord;
		private String preamble;

	@GetMapping("/lucky-word")
	public String showLucky() {
		return preamble + ": " + luckyWord;
	}

	public String getLuckyWord() {
		return luckyWord;
	}

	public void setLuckyWord(String luckyWord) {
		this.luckyWord = luckyWord;
		System.out.println("lucky: " + luckyWord);
	}

	public String getPreamble() {
		return preamble;
	}

	public void setPreamble(String preamble) {
		this.preamble = preamble;
	}
}
