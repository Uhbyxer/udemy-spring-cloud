package com.acme.lab4sentence.domain;

public class Word {
	private String word;

	public Word(String word) {
		this.word = word;
	}

	public Word() {
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getString() {
		return getWord();
	}
}
