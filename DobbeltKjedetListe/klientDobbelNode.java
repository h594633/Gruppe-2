public class klientDobbelNode {
    public static void main(String[] args) {

        int[] tall = {1,2,3,4,5,6,7,8,9,10};
        DobbelKjedetListeS<Integer> liste = new DobbelKjedetListeS<>(0,11);

        for (int i = 0; i < tall.length; i++){
            liste.leggTil(tall[i]);
        }
        liste.visListe();
    }
}
