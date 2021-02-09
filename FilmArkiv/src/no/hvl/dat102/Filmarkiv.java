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

/*
		// sjekker om tabell er tom
		if (filmTabell == null) {
			this.filmTabell = new Film[1];
			this.filmTabell[0] = nyFilm;
			antall++;
		} else {
			// ser etter film med identisk nr først
			for (int i = 0; i < filmTabell.length; i++) {
				if (filmTabell[i].getFilmnr() == nyFilm.getFilmnr()) {
					System.out.println("filmNr i bruk");
					return;
				}
			}

			Film[] tempTab = new Film[filmTabell.length + 1];
			// kopierer over filmer fra gammel tabell til tempTab
			for (int i = 0; i < filmTabell.length; i++) {
				tempTab[i] = filmTabell[i];
			}
			// øker antall filmer i arkivet med 1, legger inn ny film, og peker til tempTab
			tempTab[tempTab.length-1] = nyFilm;
			antall++;
			this.filmTabell = tempTab;

		}
NY ITERASJON
*/

		if (filmTabell != null) {
			// ser etter film med identisk nr først
			for (int i = 0; i < filmTabell.length; i++) {
				if (filmTabell[i].getFilmnr() == nyFilm.getFilmnr()) {
					System.out.println("filmNr i bruk");
					return;
				}
			}//filmnr søk

			// kopierer over filmer fra gammel tabell til tempTab
			Film[] tempTab = new Film[filmTabell.length + 1];
			for (int i = 0; i < filmTabell.length; i++) {
				tempTab[i] = filmTabell[i];
			}
			// øker antall filmer i arkivet med 1, legger inn ny film, og peker til tempTab
			tempTab[tempTab.length-1] = nyFilm;
			antall++;
			this.filmTabell = tempTab;
		}//ikke tom tabell

		// for tomt arkiv:
		else {
			this.filmTabell = new Film[1];
			this.filmTabell[0] = nyFilm;
			antall++;
		}






	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean funnet = false;

		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i].getFilmnr() == (filmnr)) {
				funnet = true;
				filmTabell[i] = filmTabell[antall-1];
				break;
			}
		}

		if (funnet) {
			antall--;
			this.filmTabell = trimTab(filmTabell, antall);
		}

		return funnet;

	}

	@Override
	public Film[] soekTittel(String delstreng) {
		
		//antall funnede filmer
		int funn = 0;
		
		
		Film[] resultatTabell = new Film[filmTabell.length];
		
		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i].getTittel().toUpperCase().contains(delstreng.toUpperCase())) {
				resultatTabell[funn] = filmTabell[i];
				funn++;
			}
		}
		if (funn == 0) {return null;}
		return trimTab(resultatTabell, funn);
		
		
		
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		
		//antall funnede filmer
		int funn = 0;
		
		
		Film[] resultatTabell = new Film[filmTabell.length];
		
		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i].getProdusent().toUpperCase().contains(delstreng.toUpperCase())) {
				resultatTabell[funn] = filmTabell[i];
				funn++;
			}
		}
		if (funn == 0) {return null;}
		return trimTab(resultatTabell, funn);
		
		
		
	}

	@Override
	public int antall(Sjanger sjanger) {
		int sjangerantall = 0;
		for (int i = 0; i < filmTabell.length; i++) {
			if (sjanger == filmTabell[i].getSjanger()) {
			sjangerantall++;
			}
		}
		return sjangerantall;
	}

	@Override
	public int antall() {
//		int antall = 0;
//		for (int i = 0; i < filmTabell.length; i++) {
//			if (filmTabell[i] != null) {
//				antall++;
//			}
//		}
		return antall;
	}

	private Film[] trimTab(Film[] gammelTab, int antallfilmer) {
		
		Film[] nyTab = new Film[antallfilmer];
		
		for (int i = 0; i < nyTab.length; i++) {
			nyTab[i] = gammelTab[i];

		}
		return nyTab;
	}

}