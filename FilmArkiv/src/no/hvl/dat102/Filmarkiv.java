package no.hvl.dat102;

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
				if (nyFilm.getFilmnr() == (filmTabell[i].getFilmnr())) {
				}
			}
			filmTabell[antall] = nyFilm;
		}

	}

	@Override
	public boolean slettFilm(int filmnr) {
		int i = 0;
		boolean funnet = false;
		while (i < antall) {
			if (filmTabell[i].getFilmnr() == (filmnr)) {
				funnet = true;
				filmTabell[i] = filmTabell[antall];
			}
			this.filmTabell = trimTab(filmTabell, antall-1);

		}
		return funnet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] resultat = new Film[filmTabell.length];
		int funn = 0;
		
		for (int i = 0; i < filmTabell.length; i++) {
			
			if (filmTabell[i].getTittel().contains(delstreng)) {
				resultat[i] = filmTabell[i];
				funn++;
			}
			
		}
		resultat = trimTab(resultat, funn);
		if (funn == 0) {System.out.println("Her var det tomt gitt");}
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
		return antall;
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

	private Film[] trimTab(Film[] gammelTab, int antallfilmer) {
		Film[] nyTab = new Film[antallfilmer];
		for (int i = 0; i < antallfilmer; i++) {
			nyTab[i] = gammelTab[i];

		}
		return nyTab;
	}

}