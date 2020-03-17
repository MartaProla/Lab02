package it.polito.tdp.alien.alienModel;

import java.util.LinkedList;
import java.util.List;

public class WordEnhaced {
	private String alienWord;
	private List<String>possibiliTraduzioni;
	private String trad;
	public WordEnhaced(String alienWord) {
		super();
		this.alienWord = alienWord;
		possibiliTraduzioni=new LinkedList<String>();
	}
	public String getAlienWord() {
		return alienWord;
	}
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	public List<String> getPossibiliTraduzioni() {
		return possibiliTraduzioni;
	}
	public void aggiungiTraduzione(String trad) {
		if(!possibiliTraduzioni.contains(trad))
			possibiliTraduzioni.add(trad);
	}
	public String getTrad() {
		return trad;
	}
	public void setTrad(String trad) {
		this.trad = trad;
	}
	
	

}
