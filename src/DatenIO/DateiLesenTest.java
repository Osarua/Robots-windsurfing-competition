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
		assertEquals(robots.get(0).getName(),"YETI");
		assertEquals(robots.get(0).getSeed(),"1234fefgeg");
		assertEquals(robots.get(0).getPunkte(),1);
		assertEquals(robots.get(0).getGesamtpunkte(),10);
		assertEquals(wettkampf.getAnzahlDerTeilnehmer(),10);
		assertEquals(wettkampf.getRunde().getAktuelleRunde(),1);
		assertEquals(wettkampf.getRunde().getAnzahlDerRunden(),3);
		assertEquals(wettkampf.getRunde().getZeitProRunde(),5);		
	}
	
	/**
	 * Testet die Methode readRobotXML an beisp1.
	 */
	@Test
	public void testReadRobotXML(){
		Robot robot1 = null;
		DateiLesen reader = new DateiLesen();
		robot1 = reader.readRobotXML("beisp1");
		assertEquals("Sollt gleich sein",robot1.getName(),"YETI");	
		assertEquals(robot1.getSeed(),"1234fefgeg");		
		assertEquals(robot1.getPunkte(),0);		
		assertEquals(robot1.getGesamtpunkte(),10);	
		assertEquals(robot1.getTeam(),Team.GANGOFROBOTS);
	}
	
	/**
	 * Testet die Methode readRobotXML an beisp2.
	 */
	@Test
	public void testReadRobotXMLBeisp2(){
		Robot robot2 = null;
		DateiLesen reader = new DateiLesen();
		robot2 = reader.readRobotXML("beisp2");
		assertEquals("Sollt gleich sein",robot2.getName(),"Fooh");	
		assertEquals(robot2.getSeed(),"ZZ2faasA34fefgeR");		
	    assertEquals(robot2.getPunkte(),0);		
		assertEquals(robot2.getGesamtpunkte(),22222);	
		assertEquals(robot2.getTeam(), Team.DOGO);
	}

}
