package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.LinearNode;

public class Filmarkiv2 implements FilmarkivADT {

    private int antall;
    private LinearNode<Film> start;


    @Override
    public Film[] hentFilmTabell() {
        return new Film[0];
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
    // hvis første element sett neste null, start = nyfilm
        LinearNode<Film>nynode = new LinearNode<>(nyFilm);

        if (antall == null) {
            start = nynode;
            antall = 0;
        } else {
            nynode.setNeste(start);
            start = nynode;
            antall++;
        }
        //hvis film allerede ligger i arkiv   nyfilm.setneste = start
        //start = nyfilm

    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film>aktuell = start;
        boolean funnet = false;

        if (aktuell.getElement().getFilmnr() == filmnr){
            start = aktuell.getNeste();
            return true;
        }

        while (aktuell.getNeste()!=null) {
            if (aktuell.getNeste().getElement().getFilmnr() == filmnr) {
                aktuell.setNeste(aktuell.getNeste().getNeste());
                return true;
            }
            if (aktuell.getNeste().getNeste() == null) {
                if (aktuell.getNeste().getElement().getFilmnr()==filmnr){
                    aktuell.getNeste().setNeste(null);
                    return true;
                }
            }
        }
    return false;

    }

    @Override
    public Film[] soekTittel(String delstreng) {
/*        LinearNode<Film>aktuell = start;
        aktuell.getElement().getTittel()*/
    }

    @Override
    public Film[] soekProdusent(String delstreng) {

    }

    @Override
    public int antall(Sjanger sjanger) {
        return 0;
    }

    @Override
    public int antall() {
        return antall;
    }
}
