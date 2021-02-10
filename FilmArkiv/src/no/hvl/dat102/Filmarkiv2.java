package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

    private int antall;
    private LinearNode<Film> start;


    @Override
    public Film[] hentFilmTabell() {
        return new Film[0];
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
    public boolean soekTittel(String delstreng) {

        LinearNode<Film>aktuell = start;
        boolean funnet = false;

        if (aktuell.getElement().getTittel().toUpperCase().contains(delstreng.toUpperCase() == delstreng.toUpperCase()) {
            //start = aktuell.getNeste();
            return true;
        }

        while (!funnet && aktuell.getNeste()!=null) {
            if (aktuell.getNeste().getElement().getTittel().toUpperCase().contains(delstreng.toUpperCase() == delstreng.toUpperCase()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        return new Film[0];
    }

    @Override
    public int antall(Sjanger sjanger) {
        return 0;
    }

    @Override
    public int antall() {
        return 0;
    }
}
