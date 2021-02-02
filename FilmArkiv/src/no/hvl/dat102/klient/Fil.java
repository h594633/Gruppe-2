package no.hvl.dat102.klient;


import no.hvl.dat102.Film;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import no.hvl.dat102.adt.FilmarkivADT;

public class Fil {



	public static void main(String[] args) {

	final String SKILLE = "#";
	final String FILM_FIL = "film.txt";


		FileReader filmFil = null;
		BufferedReader innfil = null;

		try{
			// // 1 - FileReader
			filmFil = new FileReader(FILM_FIL);
		}catch(FileNotFoundException unntak){
			System.out.println("Finner ikke filen " + FILM_FIL);
			System.exit(1);
			// Vi kan lage script som kjører programmet fra kommandolinjen
			// og fanger opp returkoden ved System.exit
			//
		}

		try {
			// 2 - BufferedReader
			innfil = new BufferedReader(filmFil);

			// 3 - Leser den første posten som er antall info-poster
			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);

			// 4 - Les postene, en hel post om gangen
			String post = innfil.readLine();
			for (int i = 0; i < n; i++) {
				String[] felt = post.split(SKILLE);
				// http://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split(java.lang.String, int)

				int filmnr 			= Integer.parseInt(felt[0]);
				String produsent	= felt[1];
				String tittel		= felt[2];
				int aar				= Integer.parseInt(felt[3]);
				String sjanger		= felt[4];
				String filmselskap	= felt[5];

				Film f = new Film(filmnr, produsent, tittel, aar, sjanger, filmselskap);
				System.out.println(f);

				post = innfil.readLine();
			}

			// 4 - Lukk filen
			innfil.close();

		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
		}
//	
//	 // Lese et Filmarkiv fra tekstfil
//	 public static void lesFraFil(FilmarkivADT filmarkiv, String filnavn) {
//		 
//	 }
//	
//	 Alt: public static FilmarkivADT lesFraFil(String filnavn) {
//	 FILMarkivADT filma = null;
//	 
//	 
//	 filma = new Filmarkiv(n);
//	 
//	 return filma
//	}
//	 
//	// Lagre et Filmarkiv til tekstfil
//	 public static void skrivTilFil(FilmarkivADT filmarkiv, String filnav){�} 


	}
}
