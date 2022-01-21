package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("splChckr")
public class SpellChecker {

	public void checkSpellingMistakes(String doc) {
		System.out.println("Spelling check done for " + doc +" document..");
	}
}
