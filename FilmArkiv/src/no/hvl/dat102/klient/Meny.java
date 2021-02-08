package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

import java.util.Scanner;


public class Meny {

    private Tekstgrensesnitt tekstgr;
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

        String fNavn, antallNy;

        while (run1) {
            switch (input){
                case "N":
                    Film[] nyFilm = new Film[filma.antall()];
                    filma = new Filmarkiv(nyFilm);
                    run1 = false;
                    break;
                case "E":
                    System.out.println("Oppgi eksisterende arkiv:");
                    fNavn = scan.nextLine();
                        if (Fil.lesFraFil(fNavn)) run1 = false;

                    break;
                default:
                    System.out.println("Feil i input");
                    System.out.println("Ny input");
                    input = scan.nextLine().toUpperCase();
                    break;

            }
        }
        /*
        System.out.println("L for innlegg av film\n");
        System.out.println("S for sleeting\n");
        System.out.println("F for  henting av film, gitt tittel\n");
        System.out.println("P for  henting av film, gitt produsent\n");
        System.out.println("T for arkiv statistikk\n");
        System.out.println("W for lagring\n");
        System.out.println("Q for QUIT");
        */
        String run2meny = "L for innlegg av film\n" +
                "S for sleeting\n" +
                "F for  henting av film, gitt tittel\n" +
                "P for  henting av film, gitt produsent\n" +
                "T for arkiv statistikk\n" +
                "W for lagring\n" +
                "Q for QUIT";

        System.out.println(run2meny);

        input = scan.nextLine().toUpperCase();

        String slett, delstreng, size, navnF, eNavn, fStudio, fProdusent, fSjanger;
        int aar, filmnr;
        boolean run2 = true;

        while (run2) {


            System.out.println(" ");
            switch (input) {
                case "L":
                    filmnr = filma.antall()+1;
                    System.out.println("Skriv inn tittel");
                    eNavn = scan.nextLine();

                    System.out.println("Produsent");
                    fProdusent = scan.nextLine();

                    System.out.println("Aar");
                    aar = Integer.parseInt(scan.nextLine());

                    System.out.println("Filmstudio");
                    fStudio = scan.nextLine();

                    System.out.println("Sjanger");
                    fSjanger = scan.nextLine();

                    Film f = new Film(filmnr,fProdusent, eNavn, aar, fSjanger, fStudio);
                    filma.leggTilFilm(f);
                    System.out.println(eNavn + " lagt til med film-nr: " + filmnr);

                    break;

                case "S":
                    System.out.println("Skriv inn filmnummer for film som skal slettes");
                    slett = scan.nextLine();
                    int fnr = Integer.parseInt(slett);
                    if(filma.slettFilm(fnr)) {
                        System.out.println("Filmen er slettet");
                }   else {
                        System.out.println("Fant ikke filmen");
                    }
                    break;
                case "F":
                    System.out.println("Skriv inn tittel");
                    delstreng = scan.nextLine();
                    tekstgr.skrivUtFilmDelstrengITittel(filma, delstreng);
                    break;
                case "P":
                    System.out.println("Skriv inn produsent");
                    delstreng = scan.nextLine();
                    tekstgr.skrivUtFilmProdusent(filma, delstreng);
                    break;
                case "T":
                    tekstgr.skrivUtStatistikk(filma);
                    break;
                case "W":
                    System.out.println("filnavn for lagring...");
                    navnF = scan.nextLine();
                    Fil.skrivTilFil(filma, navnF);
                    System.out.println(navnF + " er opprettet");
                    break;
                case "Q":
                    System.out.println("Meny avsluttet");
                    run2 = false;
                    break;
                default:
                    System.out.println("Feil i input");
            }
            System.out.println("******");
            input = scan.nextLine();

        }

        scan.close();
        System.out.println("");

    }

}

