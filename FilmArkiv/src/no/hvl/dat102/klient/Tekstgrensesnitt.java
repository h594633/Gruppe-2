package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

import java.util.Scanner;

public class Tekstgrensesnitt {
    // lese opplysningene om en FILM fra tastatur
    public Film lesFilm(){
        int filmnr = scanInt("filmnr");
        String produsent = scanString("produsent");
        String tittel = scanString("tittel");
        int aar = scanInt("år");
        Sjanger sjang = scanSjanger("sjanger");
        String filmselskap = scanString("filmselskap");

        Film film = new Film (filmnr, produsent, tittel, aar, sjang, filmselskap);

    }
    // vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void visFilm(Film film){

        System.out.println(film.toString());
    }
    // Skrive ut alle Filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng){

        for (Film f:filma.soekTittel(delstreng)) {
            System.out.println(f.toString());
        }


    }
    // Skriver ut alle Filmer av en produsent / en gruppe
    public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {

        for (Film f:filma.soekProdusent(delstreng)) {
            System.out.println(f.toString());
        }

    }
    // Skrive ut en enkel statistikk som inneholder antall Filmer totalt
// og hvor mange det er i hver sjanger
    public void skrivUtStatistikk(FilmarkivADT filma){

        int i = 0;

        int drama = 0;
        int action = 0;
        int dokumentar = 0;
        int scifi = 0;
        int norsk = 0;
        int komedie = 0;



        while (filma.hentFilmTabell().length > i) {

        switch (filma.hentFilmTabell()[i].getSjanger()) {
            case DRAMA:
                drama++;
                i++;
                break;
            case ACTION:
                action++;
                i++;
                break;
            case DOKUMENTAR:
                dokumentar++;
                i++;
                break;
            case SCIFI:
                scifi++;
                i++;
                break;
            case NORSK:
                norsk++;
                i++;
                break;
            case KOMEDIE:
                komedie++;
                i++;
                break;
        }
    }

        System.out.println("Antall filmer: " + filma.antall() + "\nDrama "+ drama + "\naction "+ action + "\ndokumentar "+ dokumentar + "\nSciFi "+ scifi +
                "\nnorsk "+ norsk + "\nkomedie "+ komedie);


    }


    // scan int
    private int scanInt(String input) {
        boolean godkjent = false;

        int integer = 0;

        while(!godkjent) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("legg inn " + input);


                integer = in.nextInt();
                godkjent = true;
            } catch(Exception e) {
                System.out.println("ikke godkjent input.");
            }
        }
        return integer;
    }


    // scan string
    private String scanString(String input) {
        boolean godkjent = false;

        String outputStr = "";

        while(!godkjent) {
            try {
                Scanner in = new Scanner(System.in);


                outputStr = in.nextLine();
                godkjent = true;
            } catch(Exception e) {
                System.out.println("ikke godkjent input.");
            }
        }
        return outputStr;
    }
    // scan sjanger
    private Sjanger scanSjanger(String input) {
        boolean godkjent = false;

        String stringIn = "";
        Sjanger output = null;

        while(!godkjent) {
            try {
                Scanner in = new Scanner(System.in);


                 stringIn = in.nextLine();

                for (Sjanger sj : Sjanger.values()) {
                    if (sj.toString().equals(stringIn.toUpperCase())) {
                        godkjent = true;
                        output = sj;

                    }
                }

            } catch(Exception e) {
                System.out.println("ikke godkjent input.");
            }
        }
        return output;

    }

}//class