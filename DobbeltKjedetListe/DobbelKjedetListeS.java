public class DobbelKjedetListeS<T extends Comparable<T>> {

    private DobbeltNode<T> foerste;
    private DobbeltNode<T> siste;
    private int antall;

    public DobbelKjedetListeS (T minVerdi, T maksVerdi) {

        foerste = new DobbeltNode<T>(minVerdi);
        siste = new DobbeltNode<T>(maksVerdi);
        antall = 0;

        /*Konstruktør må lage struktur som på fig.*/
    }
    public void leggTil (T ny) {

        DobbeltNode<T> f = null;
        boolean ltil = false;
        if ((ny.compareTo(foerste.getElement()) <= 0) || ny.compareTo(siste.getElement()) >= 0) {
            // Ugyldige verdier
            System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());
        } else {
            f = foerste.getNeste();
            while (ltil = false) {
                if (!(f == null)) {
                    f = f.getNeste();
                } else {
                    ny = f.getElement();
                    ltil = true;
                    antall++;
                }
            }


        }

    }
    public T fjern (T x) {
        DobbeltNode<T> s = null;

        if ((x.compareTo(foerste.getElement()) <= 0) || x.compareTo(siste.getElement()) >= 0) {
            // Ugyldige verdier
            System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());
        } else {
            s = foerste.getNeste();
        }   while (x.compareTo(s.getElement()) > 0){
            s = s.getNeste();
        } if (x.compareTo(s.getElement()) == 0) {
           s.getForrige().setNeste(s.getNeste());
           s.getNeste().setForrige(s.getForrige());
           antall--;
        }
        return x;
    }
    public boolean fins (T x) {

        DobbeltNode<T> f = null;
        boolean funnet = false;
    if ((x.compareTo(foerste.getElement()) <= 0) || x.compareTo(siste.getElement()) >= 0) {
        // Ugyldige verdier
        System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());
    } else {

        f = foerste.getNeste();
        }
        while (x.compareTo(f.getElement()) > 0) {
            f = f.getNeste();
        }
        if (x.compareTo(f.getElement()) == 0) {
            funnet = true;
        }
        return funnet;
    }

    public void visListe() {

        DobbeltNode<T> l = foerste;

        while(l.getNeste() != null) {
            System.out.println(l.getElement() + " ");
            l = l.getNeste();
        }

    }
}
