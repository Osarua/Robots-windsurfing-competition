package competition;

import java.util.ArrayList;
import java.util.List;

import gui.AuswertungAusgabe;
import robot.Robot;
import robot.RobotErzeuger;

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
	public void peng(AuswertungAusgabe auswertungAusgabePar) {
		// TODO Auto-generated method stub

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
	
	@Override
	public void erzeugeRobots(int anzahl) {
		try {
			if (anzahl < 1) {
				new IllegalArgumentException("Die anzahl sollte Größer als 0 sein");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		} 
		RobotErzeuger robotErzeuger = new RobotErzeuger();
		Robot robot = null;
		while(anzahl>0){
			robot = robotErzeuger.erzeugeRobotRandom();
			addRobot(robot);
			anzahl--;
		}
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
