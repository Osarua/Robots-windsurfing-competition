package competition;

import java.util.ArrayList;
import java.util.List;

import robot.Robot;

public class SchnellerWettkampf implements Wettkampf {
	
	/**
	 * Die Anzahl der Teilnehmer dieses Wettkampfs
	 */
	private int anzahlDerTeilnehmer;	

	/**
	 * Die Anzahl der Runden dieses Wettkampfs
	 */
	private final int anzahlDerRunden;
	
	/**
	 * Die dauer einer Runde
	 */
	private final int zeitProRunde;
	
	/**
	 * 
	 */
	private List<Robot> robots;
	
	public SchnellerWettkampf(int anzahlDerTeilnehmerPar, int anzahlDerRundenPar, 
			int zeitProRundePar) {
		anzahlDerTeilnehmer = anzahlDerTeilnehmerPar;
		anzahlDerRunden = anzahlDerRundenPar;
		zeitProRunde = zeitProRundePar;
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

	public int getAnzahlDerRunden() {
		return anzahlDerRunden;
	}

	public int getZeitProRunde() {
		return zeitProRunde;
	}
}
