package no.hvl.dat102;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv implements no.hvl.data102.adt.FilmarkivADT {
//	instans variable
	private Film[] filmTabell;
	private int antall;
	//konstruktører og andre metoder
	
	public Filmarkiv(Film[] filmTabell) {
		this.filmTabell = filmTabell;
		antall = 0;
	}
	
//	Operasjoner:
//		• Legge inn en ny film. Det er frivillig om du vil teste på om den ligger der fra før.
	

	void LeggTilFilm(Film nyFilm) {
		
	}

//		• Slette en film
//		• Søker og henter filmer med en gitt delstreng i tittelen
//		• Søke og hente en produsent med en gitt delstreng i tittelen
//		• Henter antall filmer

	
	
	//	fyll ut
	
	// testing av film konstruktør
	public static void main(String[] args) {
		Film lotr = new Film (01, "Jackson", "Fellowship", 2001, "DokUmEntar", "New Line Cinema");
	
		System.out.println(lotr.toString());
		
	
	}
	
	
}