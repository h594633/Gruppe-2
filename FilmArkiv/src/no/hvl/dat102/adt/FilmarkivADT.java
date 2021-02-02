package no.hvl.dat102.adt;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public interface FilmarkivADT {
	
	/**
	 * 
	 * @return
	 */
	Film[] hentFilmTabell();
	
	/**
	 * 
	 * @param nyFilm
	 */
	void leggTilFilm(Film nyFilm);
	
	/**
	 * 
	 * @param filmnr
	 * @return 	false om filmnr ikke blir funnet, else true
	 */
	
	/**
	 * 
	 * @param filmnr
	 * @return	false om filmnr ikke blir funnet, else true
	 */			
	boolean slettFilm(int filmnr);

	
	/**
	 * 
	 * @param delstreng som del av tittel
	 * @return	
	 */
	Film[] soekTittel(String delstreng);
	
	/**
	 * 
	 * @param delstreng
	 * @return
	 */
	Film[] soekProdusent(String delstreng);
	
	/**
	 * 
	 * @param sjanger
	 * @return hvor mange filmer det er av gitt sjanger
	 */
	int antall (Sjanger sjanger);
	
	/**
	 * 
	 * @return antall filmer som er fort inn i film-tabbellen
	 */
    int antall();
}
