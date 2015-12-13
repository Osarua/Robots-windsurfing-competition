package DatenIO;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import competition.*;
import robot.Robot;
import robot.Team;

/**
 * Robots windsurfing competition
 * Die Klasse liest ("Laed") XML Dokumente in das Program.
 * @author Osarua
 */
public class DateiLesen {
   
	public Wettkampf readCompetitionXml(String fileName) throws ParserConfigurationException {
		File competitionXml = new File(fileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = null;
		try {
			doc = dBuilder.parse(competitionXml);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		String wettkampfArt = "";
		String anzahlDerTeilnehmer = "";
		String anzahlDerRunden = "";
		String zeitProRunde = "";	
		String aktuelleRunde = "";						
		NodeList nList = doc.getElementsByTagName("simulationsArt");
		Node nNode =  nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			wettkampfArt = eElement.getAttribute("wettkampfArt");
			 anzahlDerTeilnehmer = eElement.getElementsByTagName("simulationTeilnehmer").item(0).getTextContent();
			 NamedNodeMap anzahlDerRundenN = eElement.getElementsByTagName("runde").item(0).getAttributes();
			 anzahlDerRunden = anzahlDerRundenN.getNamedItem("anzahlDerRunden").getTextContent();
			 zeitProRunde = anzahlDerRundenN.getNamedItem("zeitProRunde").getTextContent();
			 aktuelleRunde = eElement.getElementsByTagName("runde").item(0).getTextContent();
			}
		Wettkampf wettkampf = null;
		switch(wettkampfArt) {
		case "LANGER_WETTKAMPF":
			wettkampf = new Langer_Wettkampf(new Integer(anzahlDerTeilnehmer),
					new Integer(anzahlDerRunden), new Integer(zeitProRunde), new Integer(aktuelleRunde));
			break;
		case "LAST_TEAM_STANDING":
		wettkampf = new Last_Team_Standing(new Integer(anzahlDerTeilnehmer),
				new Integer(anzahlDerRunden), new Integer(zeitProRunde), new Integer(aktuelleRunde));
		break;
		case "SCHNELLER_WETTKAMPF":
			wettkampf = new Schneller_Wettkampf(new Integer(anzahlDerTeilnehmer),
					new Integer(anzahlDerRunden), new Integer(zeitProRunde), new Integer(aktuelleRunde));
			break;
		case "SELBSTERSTELLEN":
			wettkampf = new Selbsterstellen(new Integer(anzahlDerTeilnehmer),
					new Integer(anzahlDerRunden), new Integer(zeitProRunde), new Integer(aktuelleRunde));
			break;
		case "TEAMMATCH":
			wettkampf = new Teammatch(new Integer(anzahlDerTeilnehmer),
					new Integer(anzahlDerRunden), new Integer(zeitProRunde), new Integer(aktuelleRunde));
			break;
	}
	
		String name, seed, punkte, team, gesamtpunkte;
		nList = doc.getElementsByTagName("robot");
		for (int i=0; i < nList.getLength(); i++) {
			nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				name = eElement.getAttribute("name");
				seed = eElement.getElementsByTagName("verhalten").item(0).getTextContent();
				punkte = eElement.getElementsByTagName("punkte").item(0).getTextContent();
				team = eElement.getElementsByTagName("team").item(0).getTextContent();
				gesamtpunkte = eElement.getElementsByTagName("gesamtpunkte").item(0).getTextContent();
				Team inTeam = null;
				switch(team) {
				case "ALPHA":
					inTeam=Team.ALPHA;
				break;
				case "ZE2P":
					inTeam=Team.ZE2P;
				break;
				case "OSARUA":
					inTeam=Team.OSARUA;
				break;
				case "GANGOFROBOTS":
					inTeam=Team.GANGOFROBOTS;
				break;
				case "EVOLUTION77":
					inTeam=Team.EVOLUTION77;
				break;
				case "DOGO":
					inTeam=Team.DOGO;
				break;
				case "JSRUN":
					inTeam=Team.JSRUN;
				break;
				case "VARRA":
					inTeam=Team.VARRA;
				break;
				case "PRADISE42":
					inTeam=Team.PRADISE42;
				break;
				}
				Robot robot = new Robot(name, seed, new Integer(punkte),inTeam,new Integer(gesamtpunkte));
				wettkampf.addRobot(robot);
			}
		}
		return wettkampf;
	}
}
