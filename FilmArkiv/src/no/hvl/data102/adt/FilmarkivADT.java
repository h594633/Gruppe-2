package no.hvl.data102.adt;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public interface FilmarkivADT {
	
	Film[] hentFilmTabell();
	
	void LeggTilFilm(Film nyFilm);
	
	boolean slettFilm(int filmnr);
	
	Film[] soekTittel(String delstreng);
	
	Film[] soekProdusent(String delstreng);
	
	int antall (Sjanger sjanger);
	

    int antall();
}
