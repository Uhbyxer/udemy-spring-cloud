package com.acme.lab4sentence.service.impl;

import com.acme.lab4sentence.repository.*;
import com.acme.lab4sentence.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {
	@Autowired
	private VerbClient verbClient;
	@Autowired
	private SubjectClient subjectClient;
	@Autowired
	private ArticleClient articleClient;
	@Autowired
	private AdjectiveClient adjectiveClient;
	@Autowired
	private NounClient nounClient;

	@Override
	public String buildSentence() {
		try {
			return String.format("%s %s %s %s %s",
					subjectClient.getWord().getString(),
					verbClient.getWord().getString(),
					articleClient.getWord().getString(),
					adjectiveClient.getWord().getString(),
					nounClient.getWord().getString()
			);
		} catch (Exception e) {
			e.printStackTrace();
			return "Oops!!!! We have some problems...";
		}
	}
}
