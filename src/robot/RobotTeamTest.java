package robot;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Robots windsurfing competition
 * @author Osarua
 */
public class RobotTeamTest {

	/**
	 * Testet die Methode gibTeamFuerEinenRobot().
	 * Es soll ein korrekter Index berechnet werden d.h 
	 * ein enum von Typ Team soll zurück gegeben werden..
	 */
	@Test
	public void testGibTeamFuerEinenRoboter() {
		RobotTeam teamR = new RobotTeam();
		Team team = null;
		for(int i=0; i<10;i++) {
		team = teamR.gibTeamFuerEinenRobot();
		assertTrue(team instanceof Team);
		}
	}

}
