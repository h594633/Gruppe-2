package no.hvl.dat102;

public enum Sjanger {
	DRAMA, ACTION, DOKUMENTAR, SCIFI, NORSK, KOMEDIE, ;

	public static Sjanger getSjanger(String sjInput) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.toString().equals(sjInput.toUpperCase())) {
				sjang = sj;
				return sjang;
			}

		}
		System.out.println("Sjanger ikke funnet");
		return null;

	}// Met

}// Class
