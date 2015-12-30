package competition;

/**
 * Robots windsurfing competition
 * Die Klasse repraesentiert eine Runde.
 * Eine Runde haelt informationen ueber die Runden
 * von einem Wettkampf.
 * @author Osarua
 */
public class Runde {
	
	/**
	 * Die Anzahl der Runden dieses Wettkampfs
	 */
	private final int anzahlDerRunden;
	
	/**
	 * Die dauer einer Runde
	 */
	private final long zeitProRunde;
	
	/**
	 * Aktuelle Runde 
	 */
	private int aktuelleRunde;
	
	public Runde(int anzahlDerRundenPar, long zeitProRundePar, int aktuelleRundePar) {
		try {
			if((anzahlDerRundenPar<1)) {
				throw new IllegalArgumentException("anzahlDerRundenPar "
						+ "darf nicht kleiner als eins sein");
			}
			else if((zeitProRundePar<1)) {
				throw new IllegalArgumentException("zeitProRundePar "
						+ "darf nicht kleiner als eins sein");
			}
			else if((aktuelleRundePar<0)) {
				throw new IllegalArgumentException("aktuelleRundePar "
						+ "darf nicht kleiner als eins sein");
			}
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		anzahlDerRunden = anzahlDerRundenPar;
		zeitProRunde = zeitProRundePar;
		aktuelleRunde = aktuelleRundePar;
	}

	public int getAnzahlDerRunden() {
		return anzahlDerRunden;
	}

	public long getZeitProRunde() {
		return zeitProRunde;
	}

	public int getAktuelleRunde() {
		return aktuelleRunde;
	}
	
	public void setAktuelleRunde(int akutelleRundePar) {
		aktuelleRunde = akutelleRundePar;
	}

	public String toString() {
		return "Runde: anzahl der Runden: " + anzahlDerRunden + "/n zeit pro Runde: " + zeitProRunde
				+ "/n aktuelle Runde: " + aktuelleRunde;
	}
	
}
