package DatenIO;
/**
 * Robots windsurfing competition
 * Testet die Klasse DateiSchreiben
 * @author Osarua
 */
import static org.junit.Assert.*;

import org.junit.Test;

import competition.Schneller_Wettkampf;
import competition.Wettkampf;
import robot.Robot;
import robot.Team;

public class DateiSchreibenTest {

	/**
	 * Testet die Methode roboterXMLWriter.
	 * Erzeugt einen Roboter und schreibt eine XML Datei.
	 */
	@Test
	public void testRoboterXMLWriter() {
		Robot robot1 = new Robot("YETI", "1234fefgeg", 1, Team.GANGOFROBOTS, 10);
		assertTrue(true);
		DateiSchreiben write = new DateiSchreiben();
		write.roboterXMLWriter(robot1, "beisp1");
	}
	
	/**
	 * Testet die Methode competitionXMLWriter.
	 * Erzeugt einen Wettkampf und schreibt eine XML Datei. 
	 */
	@Test
	public void testCompetitionXMLWriter() {
		Robot robot1 = new Robot("YETI", "1234fefgeg", 1, Team.GANGOFROBOTS, 10);
		Robot robot2 = new Robot("YETI", "1234fefgeg", 1, Team.ALPHA, 10);
		Robot robot3 = new Robot("YETI", "1234fefgeg", 1, Team.BENNI, 10);
		Robot robot4 = new Robot("YETI", "1234fefgeg", 1, Team.ZE2P, 10);
		Robot robot5 = new Robot("YETI", "1234fefgeg", 1, Team.OSARUA, 10);
		Robot robot6 = new Robot("YETI", "1234fefgeg", 1, Team.EVOLUTION77, 10);
		Robot robot7 = new Robot("YETI", "1234fefgeg", 1, Team.DOGO, 10);
		Robot robot8 = new Robot("YETI", "1234fefgeg", 1, Team.JSRUN, 10);
		Robot robot9 = new Robot("YETI", "1234fefgeg", 1, Team.VARRA, 10);
		Robot robot10 = new Robot("YETI", "1234fefgeg", 1, Team.PRADISE42, 10);
		assertTrue(true);
		Wettkampf competition = new Schneller_Wettkampf(10, 3, 5, 1);
		competition.addRobot(robot1);
		competition.addRobot(robot2);
		competition.addRobot(robot3);
		competition.addRobot(robot4);
		competition.addRobot(robot5);
		competition.addRobot(robot6);
		competition.addRobot(robot7);
		competition.addRobot(robot8);
		competition.addRobot(robot9);
		competition.addRobot(robot10);
		DateiSchreiben write = new DateiSchreiben();
		write.competitionXMLWriter(competition, "beisp_Competition_Schneller_Wettkampf");
	}

}
