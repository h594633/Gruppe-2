package no.hvl.dat102;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv implements no.hvl.data102.adt.FilmarkivADT {
//	instans variable
	private Film[] filmTabell;
	private int antall;
	//konstrukt�rer og andre metoder
	
	public Filmarkiv(Film[] filmTabell) {
		this.filmTabell = filmTabell;
		antall = 0;
	}
	
//	Operasjoner:
//		� Legge inn en ny film. Det er frivillig om du vil teste p� om den ligger der fra f�r.
	

	void LeggTilFilm(Film nyFilm) {
		
	}

//		� Slette en film
//		� S�ker og henter filmer med en gitt delstreng i tittelen
//		� S�ke og hente en produsent med en gitt delstreng i tittelen
//		� Henter antall filmer

	
	
	//	fyll ut
	
	// testing av film konstrukt�r
	public static void main(String[] args) {
		Film lotr = new Film (01, "Jackson", "Fellowship", 2001, "DokUmEntar", "New Line Cinema");
	
		System.out.println(lotr.toString());
		
	
	}
	
	
}