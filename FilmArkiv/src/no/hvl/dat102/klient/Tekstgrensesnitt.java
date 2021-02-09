package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

import java.util.Scanner;

public class Tekstgrensesnitt {

    // lese opplysningene om en FILM fra tastatur
    public Film lesFilm(){
        int filmnr = scanInt("Filmnr");
        String produsent = scanString("Produsent");
        String tittel = scanString("Tittel");
        int aar = scanInt("År");
        String sjanger = scanString("Sjanger");
        String filmselskap = scanString("Filmselskap");
        return new Film (filmnr, produsent, tittel, aar, sjanger, filmselskap);
    }
    // vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void visFilm(Film film){
        System.out.println(film.toString());
    }
    // Skrive ut alle Filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng){


        Film[] tempTab = filma.soekTittel(delstreng);
        try {
            for (Film f:tempTab) {
                System.out.println(f.toString());
            }
        }
        catch (NullPointerException e) {
            System.out.println("ingen resultater for \"" + delstreng + "\"");
        }


    }
    // Skriver ut alle Filmer av en produsent / en gruppe
    public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {


        Film[] tempTab = filma.soekProdusent(delstreng);
        try {
            for (Film f:tempTab) {
                System.out.println(f.toString());
            }
        }
        catch (NullPointerException e) {
            System.out.println("ingen resultater for \"" + delstreng + "\"");
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
                case DRAMA -> {
                    drama++;
                    i++;
                }
                case ACTION -> {
                    action++;
                    i++;
                }
                case DOKUMENTAR -> {
                    dokumentar++;
                    i++;
                }
                case SCIFI -> {
                    scifi++;
                    i++;
                }
                case NORSK -> {
                    norsk++;
                    i++;
                }
                case KOMEDIE -> {
                    komedie++;
                    i++;
                }
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
                System.out.println("legg inn " + input + "... ");


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
                System.out.println("legg inn " + input + "... ");


                outputStr = in.nextLine();

                // hvis sjangerinput ikke er riktig throw new exception ("ikke gyldig sjanger")
                if (input.equals("Sjanger")) {

                    for (Sjanger sj : Sjanger.values()) {
                        if (sj.toString().equals(outputStr.toUpperCase())) {
                        return outputStr;
                        }



                    }throw new IllegalArgumentException("\"" + outputStr + "\" er ikke en gyldig sjanger\n");
                }





                    godkjent = true;
                } catch(Exception e) {
                System.out.println("ikke godkjent input.");
            }
        }
        return outputStr;
    }

}//class