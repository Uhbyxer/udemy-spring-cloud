package com.acme.lab4sentence.service;

import com.acme.lab4sentence.domain.Word;

import rx.Observable;

public interface WordService {
	Observable<Word> getSubject();
	Observable<Word> getVerb();
	Observable<Word> getArticle();
	Observable<Word> getAdjective();
	Observable<Word> getNoun();
}
