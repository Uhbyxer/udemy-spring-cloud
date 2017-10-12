package com.acme.lab4sentence.service.impl;

import com.acme.lab4sentence.repository.*;
import com.acme.lab4sentence.service.SentenceService;
import com.acme.lab4sentence.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {

	@Autowired
	private WordService wordService;

	@Override
	public String buildSentence() {
		try {
			return String.format("%s %s %s %s %s",
					wordService.getSubject().getString(),
					wordService.getVerb().getString(),
					wordService.getArticle().getString(),
					wordService.getAdjective().getString(),
					wordService.getNoun().getString()
			);
		} catch (Exception e) {
			e.printStackTrace();
			return "Oops!!!! We have some problems...";
		}
	}
}
