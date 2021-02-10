package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

    private int antall;
    private LinearNode<Film> start;


    @Override
    public Film[] hentFilmTabell() {

        LinearNode<Film> aktuell = start;

        Film[] midTab = new Film[antall];

        for (int i = 0; i < antall; i++) {

            midTab[i] = aktuell.getElement();

            aktuell = aktuell.getNeste();
        }


        return midTab;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {

        LinearNode<Film>nynode = new LinearNode<Film>(nyFilm);

        if (antall == null) {
            start = nynode;
            antall = 0;

        } else {
            nynode.setNeste(start);
            start = nynode;
            antall++;
        }
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film>aktuell = start;
        boolean funnet = false;

        if (aktuell.getElement().getFilmnr() == filmnr) {
            start = aktuell.getNeste();
            return true;
        }

        while (!funnet && aktuell.getNeste()!=null) {
            if (aktuell.getNeste().getElement().getFilmnr() == filmnr) {
                aktuell.setNeste(aktuell.getNeste().getNeste());
                return true;
            }

            if (aktuell.getNeste().getNeste() == null) {
                if (aktuell.getNeste().getElement().getFilmnr()==filmnr) {
                    aktuell.getNeste().setNeste(null);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {

        LinearNode<Film> aktuell = start;

        Film[] midTab = new Film[antall];

        int funnet = 0;

        for (int i = 0; i < antall; i++) {

            //begynne på første node

            if (aktuell.getElement().getTittel().toUpperCase().contains(delstreng.toUpperCase())) {
            //sjekk om delstreng matcher toString
            //hvis desltreng matcher toString, putt element i tabell, fortsett å gå gjennom noder
                midTab[funnet] = aktuell.getElement();
                funnet ++;
            //hvis finner nytt element med delstreng som matcher toString, øk antall in med +1 på midTab og putt element i tab
                aktuell = aktuell.getNeste();
            //repeter ^ til det ikke er flere noder.
            //løkke over, return midTab;
            }
        }



        return trimTab(midTab, funnet);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {

        LinearNode<Film> aktuell = start;

        Film[] midTab = new Film[antall];

        int funnet = 0;

        for (int i = 0; i < antall; i++) {

            //begynne på første node

            if (aktuell.getElement().getProdusent().toUpperCase().contains(delstreng.toUpperCase())) {
                //sjekk om delstreng matcher toString
                //hvis desltreng matcher toString, putt element i tabell, fortsett å gå gjennom noder
                midTab[funnet] = aktuell.getElement();
                funnet ++;
                //hvis finner nytt element med delstreng som matcher toString, øk antall in med +1 på midTab og putt element i tab
                aktuell = aktuell.getNeste();
                //repeter ^ til det ikke er flere noder.
                //løkke over, return midTab;
            }
        }

        return trimTab(midTab, funnet);

    }

    @Override
    public int antall(Sjanger sjanger) {

        LinearNode<Film> aktuell = start;

        int sjangerantall = 0;

        for (int i = 0; i < antall; i++) {

            if (aktuell.getElement().getSjanger().equals(sjanger)) {
                sjangerantall++;
            }

            aktuell = aktuell.getNeste();
        }

        return sjangerantall;

    }

    @Override
    public int antall() {

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
