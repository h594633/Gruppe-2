package no.hvl.dat102.klient;


import java.io.*;
import java.util.Scanner;

import no.hvl.dat102.adt.FilmarkivADT;

public class Fil {



	public static void lesFraFil(String filmfil) {

	final String SEPARATOR = "#";
	final String FILM_FIL = filmfil;


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
				String[] felt = post.split(SEPARATOR);
				// http://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split(java.lang.String, int)

				int filmnr 			= Integer.parseInt(felt[0]);
				String produsent	= felt[1];
				String tittel		= felt[2];
				int aar				= Integer.parseInt(felt[3]);
				String sjanger		= felt[4];
				String filmselskap	= felt[5];

				String f = ("Filmnr: " + filmnr + "\n Produsent: " + produsent + "\n Tittel: " + tittel + "\n Aar: " + aar + "\n Sjanger: " + sjanger + "\n Filmselskap: " + filmselskap + "\n\n");
				System.out.println(f);

				post = innfil.readLine();
			}

			// 4 - Lukk filen
			innfil.close();

		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
		}
	}

	// Lagre et Filmarkiv til tekstfil
	 public static void skrivTilFil(FilmarkivADT filmarkiv, String filnavn){

		Scanner input = new Scanner(System.in);
		 System.out.println("");


		 final String SEPARATOR = "#";                // parameter når vi lager metode
//		 final String filnavn = filnavn;  parameter når vi lager metode (redundant)

//		 Ansatt anne = new Ansatt("Anne", "Dahl", 220, Ansatt.KVINNE);
//		 Ansatt knut = new Ansatt("Knut", "Olsen", 180, Ansatt.MANN);
//		 int antall = 2;

//		 antall, film[]

		 try {
			 // 1 - FileWriter
			 FileWriter ansFil = new FileWriter(filnavn, false);

			 // 2 - PrintWriter
			 PrintWriter utfil = new PrintWriter(filnavn);

			 //3 - Skriver først ut antall ansatt-info-er på den første linjen
//			 utfil.println(antall);
//
//			 // Hvis vi tar imot en tabell av ansatte, ville vi her lage en løkke der
//			 // vi for hver ansatt henter ut feltvariable og skriver de ut på samme linje
//
//			 // 3 - Skriv postene, felt for felt
//			 utfil.print(anne.getFornavn()); utfil.print(SEPARATOR);
//			 utfil.print(anne.getEtternavn()); utfil.print(SEPARATOR);
//			 utfil.print(anne.getTimeloenn()); utfil.print(SEPARATOR);
//			 utfil.print(anne.isKjoenn()); utfil.println();
//
//			 utfil.print(knut.getFornavn()); utfil.print(SEPARATOR);
//			 utfil.print(knut.getEtternavn()); utfil.print(SEPARATOR);
//			 utfil.print(knut.getTimeloenn()); utfil.print(SEPARATOR);
//			 utfil.print(knut.isKjoenn()); utfil.println();

			 // 4 - Lukk filen
			 utfil.close();

		 } catch (IOException e) {
			 System.out.println("Feil ved skriving til fil : " + e);
			 System.exit(3);
		 }
	 }



	 }

