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
	private final int zeitProRunde;
	
	/**
	 * Aktuelle Runde 
	 */
	private int aktuelleRunde;
	
	public Runde(int anzahlDerRundenPar, int zeitProRundePar, 
			int aktuelleRundePar){
		anzahlDerRunden=anzahlDerRundenPar;
		zeitProRunde=zeitProRundePar;
		aktuelleRunde=aktuelleRundePar;
	}
	
	public int getAnzahlDerRunden(){
		return anzahlDerRunden;
	}
	
	public int getZeitProRunde(){
		return zeitProRunde;
	}
	
	public int getAktuelleRunde(){
		return aktuelleRunde;
	}
	
	public String toString(){
		return "Runde: anzahl der Runden: " + anzahlDerRunden +
				"/n zeit pro Runde: " + zeitProRunde + "/n aktuelle Runde: "
				+ aktuelleRunde ;
	}
	
}
