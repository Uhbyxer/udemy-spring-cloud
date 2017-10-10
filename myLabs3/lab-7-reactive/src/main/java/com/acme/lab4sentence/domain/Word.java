package com.acme.lab4sentence.domain;

public class Word {

	private String word;
	private Role role;

	public Word(String word, Role role) {
		this(word);
		this.role = role;
	}

	public Word(String word ) {
		this();
		this.word = word;
	}

	public Word() {
		super();
	}


	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getString() {
		return getWord();
	}

	public static enum Role {
		SUBJECT, VERB, ARTICLE, ADJECTIVE, NOUN,
	}
}
