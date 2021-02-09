package no.hvl.dat102.klient;

import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.adt.FilmarkivADT;

public class KlientFilmarkiv {


	public static void main(String[] args) {

		FilmarkivADT filma = new Filmarkiv(null);

		Meny meny = new Meny(filma);
		meny.start();

	}


}
