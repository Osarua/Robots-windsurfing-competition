package robot;

/**
 * Robots windsurfing competition
 * Die Klasse haelt die Daten für einen Roboter.
 * @author Osarua
 */
public class Robot {


	/**
	 * Name des Roboters.
	 */
	private final String name;
	
	/**
	 * Seed des Roboters worauf sein Verhalten aufbaut
	 */
	private final String seed;
	
	/**
	 * Bisherige Punkte. 
	 */
	private int punkte;
	
	/**
	 * Team in dem der Roboter faehrt
	 */
	private Team team;
	
	/**
	 * Die bisherígen Gesamtpunkte des Roboters
	 */
	private int gesamtpunkte;
	
	public Robot(String namePar, String seedPar, int punktePar, Team teamPar, int gesamtpunktePar) {
		name = namePar;
		seed = seedPar;
		punkte = punktePar;
		team = teamPar;
		gesamtpunkte = gesamtpunktePar;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getGesamtpunkte() {
		return gesamtpunkte;
	}

	public void setGesamtpunkte(int gesamtpunkte) {
		this.gesamtpunkte = gesamtpunkte;
	}

	public String getName() {
		return name;
	}

	public String getSeed() {
		return seed;
	}
}
