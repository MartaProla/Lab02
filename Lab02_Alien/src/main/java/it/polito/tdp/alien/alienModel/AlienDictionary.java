package it.polito.tdp.alien.alienModel;

import java.util.LinkedList;
import java.util.List;


public class AlienDictionary {
	private List<WordEnhaced>elenco;
	public AlienDictionary() {
		elenco=new LinkedList<WordEnhaced>();
	}

	public void addWord(String alienWord, String translation) {
		WordEnhaced w1=null;
		boolean trovato=false;
		for(WordEnhaced w: elenco) {
			if(w.getAlienWord().compareTo(alienWord)==0) {
				trovato=true;
				w1=w;
			}
		}
		if(trovato==true) {
			w1.aggiungiTraduzione(translation);
			w1.setTrad(translation);
			
		}
		else {
			w1=new WordEnhaced(alienWord);
			elenco.add(w1);
			w1.aggiungiTraduzione(translation);
			w1.setTrad(translation);
		}
		
	}
	
	public String translateWord(String alienWord) {
		List<WordEnhaced>elencoLungAdatta= new LinkedList<WordEnhaced>();
		String result="";
		for(int i=0;i<elenco.size();i++) {
			WordEnhaced w=elenco.get(i);
			if(w.getAlienWord().length()==alienWord.length()) {
				elencoLungAdatta.add(w);
			}
		}
		LinkedList<WordEnhaced>elencoRimuovi=new LinkedList<WordEnhaced>();
		for(WordEnhaced s : elencoLungAdatta) {
			for(int i=0;i<s.getAlienWord().length();i++) {
				char x= s.getAlienWord().charAt(i);
				char y=alienWord.charAt(i);
				if(x!=y && y!='?') {
					elencoRimuovi.add(s);
				}
					
			}
		}
		elencoLungAdatta.removeAll(elencoRimuovi);
		if(elencoLungAdatta.size()>=1) {
			for(int i=0;i<elencoLungAdatta.size();i++)
				result+=elencoLungAdatta.get(i).getTrad()+"\n";
		}
		return result;
		
	}
	
	 
	

}
