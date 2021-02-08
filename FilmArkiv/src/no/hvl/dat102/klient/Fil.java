package no.hvl.dat102.klient;


import java.io.*;
import java.util.Scanner;

import no.hvl.dat102.adt.FilmarkivADT;

public class Fil {

	public static boolean lesFraFil(String filmfil) {

	final String SEPARATOR = "#";
	final String FILM_FIL = filmfil;


		FileReader filmFil = null;
		BufferedReader innfil = null;

		try{
			filmFil = new FileReader(FILM_FIL);
		}catch(FileNotFoundException unntak){
			System.out.println("Finner ikke filen " + FILM_FIL);
//			System.exit(1);
			return false;

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

		return true;
	}


	 public static void skrivTilFil(FilmarkivADT filmarkiv, String filnavn){

		Scanner input = new Scanner(System.in);
		 System.out.println("");


		 final String SEPARATOR = "#";                // parameter når vi lager metode
		 try {
			 // 1 - FileWriter
			 FileWriter ansFil = new FileWriter(filnavn, false);

			 // 2 - PrintWriter
			 PrintWriter utfil = new PrintWriter(filnavn);

			 utfil.close();

		 } catch (IOException e) {
			 System.out.println("Feil ved skriving til fil : " + e);
			 System.exit(3);
		 }
	 }



	 }

