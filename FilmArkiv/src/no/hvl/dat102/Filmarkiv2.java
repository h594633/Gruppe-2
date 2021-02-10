package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

    private int antall;
    private LinearNode<Film> start;


    @Override
    public Film[] hentFilmTabell() {
        Film[] returTabell = new Film[antall];
        LinearNode<Film>aktuell = start;

        for (int i = 0; i < returTabell.length; i++) {
            returTabell[i] = aktuell.getElement();
            aktuell = aktuell.getNeste();
        }
        return returTabell;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
    // hvis første element sett neste null, start = nyfilm
        LinearNode<Film>nynode = new LinearNode<>(nyFilm);

        if (antall != 0) {
            nynode.setNeste(start);
        }
        start = nynode;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film>aktuell = start;


        if (aktuell.getElement().getFilmnr() == filmnr){
            start = aktuell.getNeste();
            antall--;
            return true;
        }

        while (aktuell.getNeste()!=null) {
            if (aktuell.getNeste().getElement().getFilmnr() == filmnr) {
                aktuell.setNeste(aktuell.getNeste().getNeste());
                antall--;
                return true;
            }
            if (aktuell.getNeste().getNeste() == null) {
                if (aktuell.getNeste().getElement().getFilmnr()==filmnr){
                    aktuell.getNeste().setNeste(null);
                    antall--;
                    return true;
                }
            }
            aktuell = aktuell.getNeste();
        }
    return false;

    }

    @Override
    public Film[] soekTittel(String delstreng) {

        Film[] returTabell = new Film[antall];
        int funn = 0;
        LinearNode<Film>aktuell = start;

        for (int i = 0; i < returTabell.length; i++) {
            if (aktuell.getElement().getTittel().contains(delstreng)) {
                returTabell[funn] = aktuell.getElement();
                funn++;
            }
            aktuell = aktuell.getNeste();
        }

        return trimTab(returTabell, funn);


    }

    @Override
    public Film[] soekProdusent(String delstreng) {

        Film[] returTabell = new Film[antall];
        int funn = 0;
        LinearNode<Film>aktuell = start;

        for (int i = 0; i < returTabell.length; i++) {
            if (aktuell.getElement().getProdusent().contains(delstreng)) {
                returTabell[funn] = aktuell.getElement();
                funn++;
            }
            aktuell = aktuell.getNeste();
        }
        return trimTab(returTabell, funn);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int antall = 0;
        LinearNode<Film>aktuell = start;

        while (aktuell.getNeste() != null) {
            if (aktuell.getNeste().getElement().getSjanger().equals(sjanger)) {
                antall++;
            }
            aktuell = aktuell.getNeste();
        }
        return antall;
    }

    @Override
    public int antall() {
        int antall = 0;
        LinearNode<Film>aktuell = start;
        while (aktuell.getNeste() != null) {
            antall++;
            aktuell = aktuell.getNeste();
        }
        return antall;
    }

    private Film[] trimTab(Film[] gammelTab, int antallfilmer) {

        Film[] nyTab = new Film[antallfilmer];

        for (int i = 0; i < nyTab.length; i++) {
            nyTab[i] = gammelTab[i];

        }
        return nyTab;
    }
}