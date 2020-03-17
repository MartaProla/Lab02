package it.polito.tdp.alien.alienModel;

public class Word {
	private String AlienWord;
	private String translation;
	
	
	public Word(String alienWord, String translation) {
		super();
		AlienWord = alienWord;
		this.translation = translation;
	}
	public String getAlienWord() {
		return AlienWord;
	}
	public void setAlienWord(String alienWord) {
		AlienWord = alienWord;
	}
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AlienWord == null) ? 0 : AlienWord.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (AlienWord == null) {
			if (other.AlienWord != null)
				return false;
		} else if (!AlienWord.equals(other.AlienWord))
			return false;
		return true;
	}
	
	
	

}
