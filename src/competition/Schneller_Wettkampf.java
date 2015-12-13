package competition;

import java.util.ArrayList;
import java.util.List;

import robot.Robot;

public class Schneller_Wettkampf implements Wettkampf {
	
	/**
	 * Die Anzahl der Teilnehmer dieses Wettkampfs
	 */
	private int anzahlDerTeilnehmer;	
	
	/**
	 * Haelt informationen ueber die Runden
	 */
	private Runde runden;
	
	/**
	 * Liste der teilnehmenden Roboter
	 */
	private List<Robot> robots;
	
	public Schneller_Wettkampf(int anzahlDerTeilnehmerPar, int anzahlDerRundenPar, 
			int zeitProRundePar, int aktuelleRundePar) {
		anzahlDerTeilnehmer = anzahlDerTeilnehmerPar;
		runden = new Runde(anzahlDerRundenPar, zeitProRundePar, aktuelleRundePar);
		robots = new ArrayList<>(anzahlDerTeilnehmer);
	}
	
	@Override
	public int wertePunkteAus() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Robot> getlistRobots() {
		return robots;
	}
	
	/**
	 * Fuegt einen Roboter zu der Liste
	 * der teilnehmenden Roboter
	 * @param robotPar Der hinzuzufuegende Roboter
	 */
	public void addRobot(Robot robotPar){
		robots.add(robotPar);
	}
	
	@Override
	public WettkampfArt getWettkampfArt() {
		return WettkampfArt.SCHNELLER_WETTKAMPF;
	}

	public int getAnzahlDerTeilnehmer() {
		return anzahlDerTeilnehmer;
	}

	public void setAnzahlDerTeilnehmer(int anzahlDerTeilnehmer) {
		this.anzahlDerTeilnehmer = anzahlDerTeilnehmer;
	}

	public Runde getRunde() {
		return runden;
	}
}
