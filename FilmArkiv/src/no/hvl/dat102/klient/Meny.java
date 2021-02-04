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

        System.out.println("Meny");
        System.out.println("************");
        System.out.println("Opprette nytt arkiv, tast N");
        System.out.println("Søke i eksisterende arkiv, tast E");
        boolean run1 = true;
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toUpperCase();

        String fNavn, antallNy;

        while (run1) {
            switch (input){
                case "N":
                    System.out.println("Antall filmer i nytt arkiv?");
                    antallNy = scan.nextLine();
                    int antall = Integer.parseInt(antallNy);
                    Film[] nyFilm = new Film[antall];

                    filma = new Filmarkiv(nyFilm);

                    run1 = false;
                    break;
                case "E":
                    System.out.println("Navn på eksisterende arkiv");
                    fNavn = scan.nextLine();
                    Fil.lesFraFil(fNavn);
                    run1 = false;
                    break;
                default:
                    System.out.println("Feil i input");
                    break;

            }
        }
        System.out.println("L for å legge inn film");
        System.out.println("S for å slette");
        System.out.println("F for å søke og hente filmer med en gitt delstreng av tittel");
        System.out.println("P for å søke å hente filmer med en gitt delstreng av produsent");
        System.out.println("T for å skrive ut statistikk av arkiv");
        System.out.println("W for å skrive arkiv til fil");
        System.out.println("Q for å avslutte programmet");

        input = scan.nextLine();

        String slett, delstreng, size, navnF, eNavn, fStudio, fProdusent, fSjanger;
        int aar, filmnr;
        boolean run2 = true;

        while (run2) {
            System.out.println(" ");
            switch (input) {
                case "L":
                    filmnr = filma.antall();
                    System.out.println("Skriv inn tittel");
                    eNavn = scan.nextLine();

                    System.out.println("Produsent");
                    fProdusent = scan.nextLine();

                    System.out.println("År");
                    aar = Integer.parseInt(scan.nextLine());

                    System.out.println("Filmstudio");
                    fStudio = scan.nextLine();

                    System.out.println("Sjanger");
                    fSjanger = scan.nextLine();

                    Film f = new Film(filmnr,fProdusent, eNavn, aar, fSjanger, fStudio);
                    filma.leggTilFilm(f);
                    System.out.println(eNavn + " legt til med filmnummer " + filmnr);
                    break;

                case "S":
                    System.out.println("Skriv inn filmnummer du ønsker å slette");
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
                    System.out.println("Navn på fil");
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
//            input = scan.nextLine();

        }

        scan.close();
        System.out.println("");

    }

}

