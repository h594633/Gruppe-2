package no.hvl.dat102;

import java.util.PrimitiveIterator.OfDouble;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements no.hvl.dat102.adt.FilmarkivADT {

	
	private Film[] filmTabell;
	private int antall;


	public Filmarkiv(Film[] filmTabell) {
		this.filmTabell = filmTabell;
		antall = 0;
	}

	@Override
	public Film[] hentFilmTabell() {
		return filmTabell;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall < filmTabell.length) {
			
			for (int i = 0; i < filmTabell.length; i++) {
				if (nyFilm.getFilmnr() == (filmTabell[i].getFilmnr())) {}
			}
			filmTabell[antall] = nyFilm;
		}

		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i].getFilmnr() == (filmnr)) {
				filmTabell[i] = filmTabell[antall];
			}
			this.filmTabell = trimTab(filmTabell, antall);
			return true;
		}
	}
	

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] resultat = new Film[filmTabell.length];
		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i].getTittel().contains(delstreng)) {
				resultat[i] = filmTabell[i];		
			}
		}
		return resultat;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] resultat = new Film[filmTabell.length];
		for (int i = 0; i < filmTabell.length; i++) {
			
			if (filmTabell[i].getProdusent().contains(delstreng)) {
				resultat[i] = filmTabell[i];		
			}
		}
		return resultat;
	}

	@Override
	public int antall(Sjanger sjanger) {
		for (int i = 0; i < filmTabell.length; i++) {
			if (sjanger == filmTabell[i].getSjanger()) {
				
			}
		}
	}

	@Override
	public int antall() {
		int antall = 0;
		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i] != null) {
				antall++;
			}
		}
		return antall;
	}
	
	private Film[] trimTab(Film[] gammelTab, int antallfilmer ) {
		Film[] nyTab = new Film[antallfilmer];
		for (int i = 0; i < antallfilmer; i++) {
			nyTab[i] = gammelTab[i];
			
		}
		return nyTab;
	}

	/**
	 *  testing av film konstruktør
	 */
	public void main(String[] args) {
		Film lotr = new Film (01, "Jackson", "Fellowship", 2001, "DokUmEntar", "New Line Cinema");
	
		
	
	}
	
	
}