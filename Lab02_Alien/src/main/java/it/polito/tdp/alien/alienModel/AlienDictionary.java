package it.polito.tdp.alien.alienModel;

import java.util.LinkedList;
import java.util.List;


public class AlienDictionary {
	private List<WordEnhaced>elenco;
	private List<String>elencoT;
	public AlienDictionary() {
		elenco=new LinkedList<WordEnhaced>();
		elencoT=new LinkedList<String>();
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
			elencoT.add(translation);
		}
		else {
			w1=new WordEnhaced(alienWord);
			elenco.add(w1);
			elencoT.add(translation);
			w1.aggiungiTraduzione(translation);
		}
		
	}
	
	public String translateWord(String alienWord) {
		String result="";
		for(int i=0;i<elenco.size();i++) {
			WordEnhaced w=elenco.get(i);
			if(w.getAlienWord().compareTo(alienWord)==0) {
				for(int j=0;j<w.getPossibiliTraduzioni().size();j++)
					result+=w.getPossibiliTraduzioni().get(j)+"\n";
			}
		}
		return result;
		
	}
	

}
