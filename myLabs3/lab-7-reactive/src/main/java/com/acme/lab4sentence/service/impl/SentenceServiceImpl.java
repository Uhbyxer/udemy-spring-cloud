package com.acme.lab4sentence.service.impl;

import com.acme.lab4sentence.domain.Sentence;
import com.acme.lab4sentence.domain.Word;
import com.acme.lab4sentence.service.SentenceService;
import com.acme.lab4sentence.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
public class SentenceServiceImpl implements SentenceService {

	@Autowired
	private WordService wordService;

	@Override
	public String buildSentence() {
		Sentence sentence = new Sentence();
		List<Observable<Word>> observables = createObservables();

		CountDownLatch latch = new CountDownLatch(observables.size());

		Observable.merge(observables).subscribe((word -> {
			sentence.add(word);
			latch.countDown();
		}));

		waitForAll(latch);
		return sentence.toString();
	}

	private List<Observable<Word>> createObservables() {
		List<Observable<Word>> observables = new ArrayList<>();
		observables.add(wordService.getSubject());
		observables.add(wordService.getVerb());
		observables.add(wordService.getArticle());
		observables.add(wordService.getAdjective());
		observables.add(wordService.getNoun());
		return observables;
	}

	private void waitForAll(CountDownLatch latch) {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
