package no.hvl.dat102.klient;

import no.hvl.dat102.adt.FilmarkivADT;


public class Meny {

    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filma;

    public Meny(FilmarkivADT filma){
        tekstgr = new Tekstgrensesnitt();
        this.filma = filma;
    }
    public void start(){


    }

}

