package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.adt.FilmarkivADT;

import java.util.Scanner;


public class Meny {

    private final Tekstgrensesnitt tekstgr;
    private FilmarkivADT filma;

    public Meny(FilmarkivADT filma){
        tekstgr = new Tekstgrensesnitt();
        this.filma = filma;
    }
    public void start(){

        System.out.println("Meny\n************\nOpprette nytt arkiv: N\nSe etter arkiv: E");
        boolean run1 = true;
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toUpperCase();

        String fNavn;

        while (run1) {
            switch (input) {
                case "N" -> {
                    Film[] nyFilm = new Film[filma.antall()];
                    filma = new Filmarkiv(nyFilm);
                    run1 = false;
                }
                case "E" -> {
                    System.out.println("Oppgi eksisterende arkiv:");
                    fNavn = scan.nextLine();
                    if (Fil.lesFraFil(fNavn, filma)) run1 = false;
                }
                default -> {
                    System.out.println("Feil i input");
                    System.out.println("Ny input");
                    input = scan.nextLine().toUpperCase();
                }
            }
        }
        String run2meny = "L for innlegg av film\n" +
                "S for sleeting\n" +
                "F for  henting av film(er), gitt tittel\n" +
                "P for  henting av film(er), gitt produsent\n" +
                "T for arkiv statistikk\n" +
                "W for lagring\n" +
                "Q for QUIT";

        System.out.println(run2meny);

        input = scan.nextLine().toUpperCase();

        String slett, delstreng,navnF;
        boolean run2 = true;

        while (run2) {


            System.out.println(" ");
            switch (input) {
                case "L" -> {
                    filma.leggTilFilm(tekstgr.lesFilm());
                    System.out.println("Ny film: \n" + filma.hentFilmTabell()[filma.antall() - 1] + "\n");
                }
                case "S" -> {
                    System.out.println("Skriv inn filmnummer for film som skal slettes");
                    slett = scan.nextLine();
                    int fnr = Integer.parseInt(slett);
                    if (filma.slettFilm(fnr)) {
                        System.out.println("Filmen er slettet");
                    } else {
                        System.out.println("Fant ikke filmen");
                    }
                }
                case "F" -> {
                    System.out.println("Skriv inn tittel");
                    delstreng = scan.nextLine();
                    tekstgr.skrivUtFilmDelstrengITittel(filma, delstreng);
                }
                case "P" -> {
                    System.out.println("Skriv inn produsent");
                    delstreng = scan.nextLine();
                    tekstgr.skrivUtFilmProdusent(filma, delstreng);
                }
                case "T" -> tekstgr.skrivUtStatistikk(filma);
                case "W" -> {
                    System.out.println("filnavn for lagring...");
                    navnF = scan.nextLine();
                    Fil.skrivTilFil(filma, navnF);
                    System.out.println(navnF + " er opprettet");
                }
                case "Q" -> {
                    System.out.println("Meny avsluttet");
                    run2 = false;
                }
                default -> System.out.println("Feil i input");
            }
            System.out.println("******");
            input = scan.nextLine().toUpperCase();

        }

        scan.close();
        System.out.println("Scan closed");

    }

}

