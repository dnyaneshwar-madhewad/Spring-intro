package com.cdac.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("txtEdtr")
public class TextEditor {

	@Autowired //DI
	private SpellChecker sp;
	
	public void loadDocument(String doc) {
		System.out.println("Document " + doc + " loaded successfully..");
		//from here i want to call checkSpellingMistakes function of SpellChecker class
		//SpellChecker sp = new SpellChecker(); --> we will not do this as Spring is meant for this purpose
		sp.checkSpellingMistakes(doc);
	}
}
