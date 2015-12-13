package DatenIO;

import static org.junit.Assert.*;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Test;
import competition.*;
import robot.Robot;
import robot.Team;

/**
 * Robots windsurfing competition
 * Die Klasse Testet die Klasse DateiLesen
 * @author Osarua
 */
public class DateiLesenTest {
	
	/**
	 * Testet die Methode readCompetitionXml. Siehe zum Vergleich
	 * der Tesstfaelle Klasse DateiSchreibenTest.
	 */
	@Test
	public void testReadCompetitionXml() {
		assertTrue(true);
		DateiLesen reader = new DateiLesen();
		Wettkampf wettkampf=null; 
		try {
			wettkampf = reader.readCompetitionXml("beisp_Competition_Schneller_Wettkampf");
		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		ArrayList<Robot> robots =  new ArrayList<>(wettkampf.getlistRobots());
		assertEquals("Sollte gleich sein",robots.get(0).getTeam(),Team.GANGOFROBOTS);
		assertEquals("Sollte gleich sein",robots.get(0).getName(),"YETI");
		assertEquals("Sollte gleich sein",robots.get(0).getSeed(),"1234fefgeg");
		assertEquals("Sollte gleich sein",robots.get(0).getPunkte(),1);
		assertEquals("Sollte gleich sein",robots.get(0).getGesamtpunkte(),10);
		assertEquals("Sollte gleich sein",wettkampf.getAnzahlDerTeilnehmer(),10);
		assertEquals("Sollte gleich sein",wettkampf.getRunde().getAktuelleRunde(),1);
		assertEquals("Sollte gleich sein",wettkampf.getRunde().getAnzahlDerRunden(),3);
		assertEquals("Sollte gleich sein",wettkampf.getRunde().getZeitProRunde(),5);
	}

}
