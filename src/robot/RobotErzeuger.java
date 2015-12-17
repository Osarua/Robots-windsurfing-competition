package robot;

/**
 * Robots windsurfing competition
 * Die Klasse erzeugt Roboter dabei werden weitere Objekte benutzt, um 
 * die moeglichkeit zu bieten "zufallige" Roboter zu erzeugen.
 * @author Osarua
 */
public class RobotErzeuger {
 
	/**
	 * Die Methode erzeugt einen neuen Roboter.
	 * Mit der Hilfe von Klassen mit denen ein Roboter "zufällig" 
	 * (Algortihmen) definierbar ist.
	 * @return Robot der erzeugte Roboter
	 */
	public Robot erzeugeRobotRandom() {
		String name = null, seed = null;
		RobotName nameErzeugen = new RobotName();
		name = nameErzeugen.erzeugeName();
		
		RobotSeed seedErzeugen = new RobotSeed();
		seed = seedErzeugen.erzeugeRobotSeed();
		
		RobotTeam teamWaehlen = new RobotTeam();
		Team team = teamWaehlen.gibTeamFuerEinenRobot();
		return new Robot(name, seed, 0, team, 0);
	}
}
