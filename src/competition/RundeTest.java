package competition;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Robots windsurfing competition
 * Testet die Klasse Runde.
 * @author Osarua
 */
public class RundeTest {

	@Test
	public void testKonstruktor() {
		Runde runde = new Runde(10, 5, 2);
		assertEquals("Sollte gleich sein",runde.getAktuelleRunde(),2);
		assertEquals(runde.getAnzahlDerRunden(),10);
		assertEquals(runde.getZeitProRunde(),5);
		Runde runde2 = new Runde(20, 7, 5);
		assertEquals("Sollte gleich sein",runde2.getAktuelleRunde(),5);
		assertEquals(runde2.getAnzahlDerRunden(),20);
		assertEquals(runde2.getZeitProRunde(),7);
	}
	
	@Test
	public void testToString() {
		Runde runde = new Runde(10, 5, 2);
		assertEquals("Sollte gleich sein",runde.toString(),
				"Runde: anzahl der Runden: " + 10 + "/n zeit pro Runde: " + 5
			+ "/n aktuelle Runde: " + 2);
	}
	
	
}
