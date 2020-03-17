package it.polito.tdp.alien.alienModel;

import java.util.LinkedList;
import java.util.List;


public class AlienDictionary {
	private List<Word>parole;
	
	public AlienDictionary() {
		parole=new LinkedList<Word>();
	}

	public void addWord(String alienWord, String translation) {
		boolean trovato=false;
		String s="";
		Word w=null;
		for(Word w1:parole) {
			if(w1.getAlienWord().compareTo(alienWord)==0) {
				trovato=true;
				w=w1;
				s=translation;
			}
				
		}
		if(trovato==true) {
			w.setTranslation(s);
			
		}else {
			Word w1=new Word(alienWord,translation);
			parole.add(w1);
		}
		
	}
	
	public String translateWord(String alienWord) {
		String result=null;
		for(Word w: parole) {
			if(w.getAlienWord().compareTo(alienWord)==0)
				result=w.getTranslation();
		}
		return result;
		
	}

}
