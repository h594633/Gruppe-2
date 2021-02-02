package no.hvl.dat102.klient;


import no.hvl.dat102.Film;
import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.adt.FilmarkivADT;

public class KlientFilmarkiv {

	
	public static void main(String[] args) {
		
		FilmarkivADT filma = new Filmarkiv(null);
		
		
		Film film1 = new Film(1, "Jackson", "Fellowship", 2001, "DokUmEntar", "New Line Cinema");
		Film film2 = new Film(2, "Erik", "filmen", 2002, "komedie", "Lie Production");
		Film film3 = new Film(3, "Erik", "filmen 2", 2003, "komedie", "Lie Production");
		Film film4 = new Film(4, "Jorgen", "filmen 4", 2005, "action", "Pro Production");

//		System.out.println(lotr.toString());
//		System.out.println(film2.toString());
		
		filma.leggTilFilm(film1);
		filma.leggTilFilm(film2);
		filma.leggTilFilm(film3);
		filma.leggTilFilm(film4);

		

		filma.soekTittel("iLm");
// for (Film film : filma.soekTittel("iLm")) {
// 	System.out.println(film);
// }
// FilmarkivADT filmarkiv = new Filmarkiv();


	}
	
}
