package no.hvl.dat102;


public class Film {
	public enum Sjanger {
		DRAMA, ACTION, DOKUMENTAR, SCIFI, HISTORIE, WESTERN, NORSK, KOMEDIE, ROMANTISK;
	}

	private int filmnr;
	private String produsent;
	private String tittel;
	private int aar;
	private Sjanger sjanger;
	private String filmselskap;
	
	
	
	//test

	public Film() {
		
	}

	public Film(int filmnr, String produsent, String tittel, int aar, String sjanger, String filmselskap ) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.aar = aar;
		this.sjanger = getSjanger(sjanger);
		if (this.sjanger == null) {
			System.out.println("Filmnr: " + filmnr + " mangler sjanger. innput: " + sjanger);
		}
		this.filmselskap = filmselskap;
	}
	
	

	@Override
	public String toString() {
		return "Film [filmnr=" + filmnr + ", produsent=" + produsent + ", tittel=" + tittel + ", aar=" + aar
				+ ", sjanger=" + sjanger + ", filmselskap=" + filmselskap + "]";
	}
	
	
	public static Sjanger getSjanger(String sjInput) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.toString().equals(sjInput.toUpperCase())) {
				sjang = sj;
				return sjang;
			}

		}
		return sjang;

	}// Met
}