package com.acme.lab4sentence.service;

import com.acme.lab4sentence.domain.Word;

public interface WordService {
	Word getSubject();
	Word getVerb();
	Word getArticle();
	Word getAdjective();
	Word getNoun();
}
