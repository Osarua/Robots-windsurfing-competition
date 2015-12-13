package competition;

import java.util.List;

import robot.Robot;

/**
 * Robots windsurfing competition
 * Die Schnittstellen die jede "Wettkampf" Klasse benoetigt.
 * @author Osarua
 */
public interface Wettkampf {
 	
	public int wertePunkteAus();
	
	public String toString();
	
	public WettkampfArt getWettkampfArt();
	
	public int getAnzahlDerTeilnehmer();
	
	/**
	 * Fuegt einen Roboter zu der Liste
	 * der teilnehmenden Roboter
	 * @param robotPar Der hinzuzufuegende Roboter
	 */
	public void addRobot(Robot robotPar);
	
	public List<Robot> getlistRobots();
	
	public Runde getRunde();
}
