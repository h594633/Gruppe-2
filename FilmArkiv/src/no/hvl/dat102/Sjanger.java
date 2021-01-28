package no.hvl.dat102;

public enum Sjanger {
	DRAMA, ACTION, DOKUMENTAR, SCIFI, HISTORIE, WESTERN, NORSK, KOMEDIE, ROMANTISK;

	public static Sjanger finnSjanger(String sjInput) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.toString().equals(sjInput.toUpperCase())) {
				sjang = sj;
				return sjang;
			}

		}
		return sjang;

	}// Met

}// Class
