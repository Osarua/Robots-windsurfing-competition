package competition;

import java.util.List;

import gui.AuswertungAusgabe;
import robot.Robot;

/**
 * Robots windsurfing competition
 * Die Schnittstellen die jede "Wettkampf" Klasse benoetigt.
 * @author Osarua
 */
public interface Wettkampf {
 	
	/**
	 * Startet die Simulation.
	 */
	public void peng(AuswertungAusgabe auswertungAusgabePar);
	
	/**
	 * Getter.
	 * @return WettkampfArt welches die Klasse definiert.
	 */
	public WettkampfArt getWettkampfArt();
	
	/**
	 * Getter.
	 * @return int Anzahl der Teilnehmer
	 */
	public int getAnzahlDerTeilnehmer();
	
	/**
	 * Fuegt einen Roboter zu der Liste
	 * der teilnehmenden Roboter
	 * @param robotPar Der hinzuzufuegende Roboter
	 */
	public void addRobot(Robot robotPar);
	
	/**
	 * Erzeugt Roboter mit Hilfe der Klasse RobotErzeuger.
	 * Die erzeugten Robots werden der Liste der Teilnehmer hinzugefügt.
	 * @param anzahl Die Anzahl der zu erzeugenden Robots
	 */
	public void erzeugeRobots(int anzahl);
		
	/**
	 * Getter.
	 * @return Liste der Roboter.
	 */
	public List<Robot> getlistRobots();
	
	/**
	 * Diese Methode gibt ein Runde Objekt zurueck.
	 * Es haelt informaionen ueber die Runden Einstellungen.
	 * @return Runde Objekt.
	 */
	public Runde getRunde();
	
	public String toString();
}
