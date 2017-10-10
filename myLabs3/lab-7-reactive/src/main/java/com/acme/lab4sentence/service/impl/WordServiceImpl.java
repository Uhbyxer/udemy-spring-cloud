package com.acme.lab4sentence.service.impl;

import com.acme.lab4sentence.domain.Word;
import com.acme.lab4sentence.repository.*;
import com.acme.lab4sentence.service.WordService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.Executor;

import static com.acme.lab4sentence.domain.Word.Role.*;

@Service
public class WordServiceImpl implements WordService {

	@Autowired VerbClient verbClient;
	@Autowired SubjectClient subjectClient;
	@Autowired ArticleClient articleClient;
	@Autowired AdjectiveClient adjectiveClient;
	@Autowired NounClient nounClient;
	@Autowired Executor executor;	//	Source of threads


	@Override
	@HystrixCommand(fallbackMethod="getFallbackSubject")
	public Observable<Word> getSubject() {
		//	This 'reactive' observable is backed by a regular Java Callable, which can run in a different thread:
		return Observable.fromCallable(
				() ->  new Word (subjectClient.getWord().getWord(), SUBJECT)
		).subscribeOn(Schedulers.from(executor));
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackVerb")
	public Observable<Word> getVerb() {
		return Observable.fromCallable(
				() ->  new Word (verbClient.getWord().getWord(), VERB)
		).subscribeOn(Schedulers.from(executor));
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackArticle")
	public Observable<Word> getArticle() {
		return Observable.fromCallable(
				() ->  new Word (articleClient.getWord().getWord(), ARTICLE)
		).subscribeOn(Schedulers.from(executor));
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackAdjective")
	public Observable<Word> getAdjective() {
		return Observable.fromCallable(
				() ->  new Word (adjectiveClient.getWord().getWord(), ADJECTIVE)
		).subscribeOn(Schedulers.from(executor));
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackNoun")
	public Observable<Word> getNoun() {
		return Observable.fromCallable(
				() ->  new Word (nounClient.getWord().getWord(), NOUN)
		).subscribeOn(Schedulers.from(executor));
	}



	public Word getFallbackSubject() {
		return new Word("Someone", SUBJECT);
	}

	public Word getFallbackVerb() {
		return new Word("does", VERB);
	}

	public Word getFallbackArticle() {
		return new Word("", ARTICLE);
	}

	public Word getFallbackAdjective() {
		return new Word("", ADJECTIVE);
	}

	public Word getFallbackNoun() {
		return new Word("something", NOUN);
	}
}
