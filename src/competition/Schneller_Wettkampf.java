package competition;

import java.util.ArrayList;
import java.util.List;

import gui.AuswertungAusgabe;
import javafx.application.Platform;
import robot.*;
/**
 * Robots windsurfing competition
 * Die Klasse repraesentiert einen Schnellen Wettkamnpf.
 * @author Osarua
 */
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
	public void peng(AuswertungAusgabe auswertungAusgabePar) {
	 if(getRunde().getAktuelleRunde()<=getRunde().getAnzahlDerRunden()) {
			// Aktuelle Tabelle ausgeben
			auswertungAusgabePar.auswertungTabelleErstellen();
			// Gehe in die nächste Runde...
		} 	

	}

	public List<Robot> getlistRobots() {
		return robots;
	}
	
	/**
	 * Fuegt einen Roboter zu der Liste
	 * der teilnehmenden Roboter
	 * @param robotPar Der hinzuzufuegende Roboter
	 */
	public void addRobot(Robot robotPar) {
		try {
			if (robotPar == null) {
				new NullPointerException("robotPar darf nicht null sein");
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
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
	
	@Override
	public String toString() {
		return "Schneller Wettkampf: \n" +
	"Anzahl der Teilnehmer: "+ anzahlDerTeilnehmer + "\nRunde:" + runden.getAktuelleRunde() +
	"\nRunden: " + runden.getAnzahlDerRunden() + ", Zeit Pro Runde: " + runden.getZeitProRunde();
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
