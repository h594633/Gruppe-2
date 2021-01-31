package no.hvl.dat102.klient;


import no.hvl.dat102.Film;
import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.adt.FilmarkivADT;

public class KlientFilmarkiv {

	
	public static void main(String[] args) {
		
		
		Film lotr = new Film(01, "Jackson", "Fellowship", 2001, "DokUmEntar", "New Line Cinema");
		Film film2 = new Film(01, "Erik", "filmen", 2001, "komedie", "Lie Production");
		Film film3;
		
		
		
		System.out.println(lotr.getProdusent());
		System.out.println(lotr.toString());
		
//		FilmarkivADT filmarkiv = new Filmarkiv();

		
		
	}
	
}
