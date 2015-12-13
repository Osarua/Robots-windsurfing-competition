package competition;

import java.util.ArrayList;
import java.util.List;

import robot.Robot;

/**
 * Robots windsurfing competition
 * Die Klasse repraesentiert ein Teammatch
 * @author Osarua
 */
public class Teammatch implements Wettkampf {

	/**
	 * Die Anzahl der Teilnehmer dieses Wettkampfs
	 */
	private int anzahlDerTeilnehmer;	

	/**
	 * Haelt informationen ueber die Runden
	 */
	private Runde runden;
	
	/**
	 * Liste von teilnehmenden Robotern
	 */
	private List<Robot> robots;
	
	public Teammatch(int anzahlDerTeilnehmerPar, int anzahlDerRundenPar, 
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

	@Override
	public WettkampfArt getWettkampfArt() {
		return WettkampfArt.TEAMMATCH;
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
