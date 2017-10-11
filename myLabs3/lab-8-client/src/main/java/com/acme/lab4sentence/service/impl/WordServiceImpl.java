package com.acme.lab4sentence.service.impl;

import com.acme.lab4sentence.domain.Word;
import com.acme.lab4sentence.repository.*;
import com.acme.lab4sentence.service.WordService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {
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
	@HystrixCommand(fallbackMethod = "getFallbackSubject")
	public Word getSubject() {
		return subjectClient.getWord();
	}

	@Override
	public Word getVerb() {
		return verbClient.getWord();
	}

	@Override
	public Word getArticle() {
		return articleClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackAdjective")
	public Word getAdjective() {
		return adjectiveClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackNoun")
	public Word getNoun() {
		return nounClient.getWord();
	}

	public Word getFallbackSubject() {
		return new Word("Someone");
	}

	public Word getFallbackAdjective() {
		return new Word("");
	}

	public Word getFallbackNoun() {
		return new Word("Something");
	}
}
