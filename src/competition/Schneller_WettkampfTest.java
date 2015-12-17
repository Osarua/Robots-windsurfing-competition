package competition;

import static org.junit.Assert.*;

import org.junit.Test;

import robot.Robot;
/**
 * Robots windsurfing competition
 * Die Klasse testet einen Schnellen Wettkamnpf.
 * @author Osarua
 */
public class Schneller_WettkampfTest {

	/**
	 * Testet die Methode erzeugeRobots.
	 * Insbesondere ob genauso viele Roboter hinzugefügt wurden 
	 * wie als Argument (int anzahl) übergeben.
	 */
	@Test
	public void testErzeugeRobots() {
		Schneller_Wettkampf schnellW = new Schneller_Wettkampf(2, 5, 5, 1);
		schnellW.erzeugeRobots(2);
		assertTrue(schnellW.getlistRobots().get(0) != null);
		assertTrue(schnellW.getlistRobots().get(1) != null);
		assertTrue(schnellW.getlistRobots().get(0) instanceof Robot);
		try {
			assertTrue(schnellW.getlistRobots().get(3) == null);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
		Schneller_Wettkampf schnellW2 = new Schneller_Wettkampf(10, 5, 5, 1);
		schnellW2.erzeugeRobots(10);
		assertTrue(schnellW.getlistRobots().get(0) != null);
		assertTrue(schnellW.getlistRobots().get(1) != null);
		assertTrue(schnellW2.getlistRobots().get(2) != null);
		assertTrue(schnellW2.getlistRobots().get(3) != null);
		assertTrue(schnellW2.getlistRobots().get(4) != null);
		assertTrue(schnellW2.getlistRobots().get(5) != null);
		assertTrue(schnellW2.getlistRobots().get(6) != null);
		assertTrue(schnellW2.getlistRobots().get(7) != null);
		assertTrue(schnellW2.getlistRobots().get(8) != null);
		assertTrue(schnellW2.getlistRobots().get(9) != null);
	}

}
