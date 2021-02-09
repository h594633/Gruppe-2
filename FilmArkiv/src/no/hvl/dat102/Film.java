package no.hvl.dat102;

public class Film  {

	private int filmnr;
	private String produsent;
	private String tittel;
	private int aar;
	private Sjanger sjanger;
	private String filmselskap;
	
	//test
	public Film() {
	}

	public Film(int filmnr, String produsent, String tittel, int aar, String sjanger, String filmselskap) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.aar = aar;
		this.sjanger = Sjanger.getSjanger(sjanger);
		if (this.sjanger == null) {
			System.out.println("Filmnr: " + filmnr + " mangler sjanger. innput: " + sjanger);
		}
		this.filmselskap = filmselskap;
	}

	
	@Override
	public String toString() {
		return "Film Nr: " + filmnr + ", Producer: " + produsent + ", Title: " + tittel + ", Year: " + aar
				+ ", Genre: " + sjanger + ", Company: " + filmselskap + " ]";
		
	}
	
	public String getTittel() {
		return tittel;
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}
	public Sjanger getSjanger() {
		return sjanger;
	}
	public int getAar() { return  aar; }
	public String getFilmselskap() {return filmselskap; }

}