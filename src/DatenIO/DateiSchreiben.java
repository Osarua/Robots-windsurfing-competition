package DatenIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import competition.Wettkampf;
import robot.Robot;
/**
 * Robots windsurfing competition
 * Mit dieser Klasse können XML Dateien geschrieben werden.
 * Eine XML Datei ist hier ein kompletter Simulationsstand oder ein Roboter.
 * @author Osarua
 */
public class DateiSchreiben {
	
	/**
	 * Schreibt einen Roboter als XML Datei
	 * @param roboterPar Der zu schreibende Roboter 
	 * @param fileNamePar Der Dateiname
	 */
	public void roboterXMLWriter(Robot roboterPar, String fileNamePar) {
		try {
			XMLOutputFactory xof = XMLOutputFactory.newInstance();
			XMLStreamWriter xRobotW = null;
			if (fileNamePar == null) {
				throw new NullPointerException("Der Dateiname ist null");
			}
			xRobotW = xof.createXMLStreamWriter(new FileOutputStream(fileNamePar), "utf-8");
			xRobotW.writeStartDocument("utf-8", "1.0");
			xRobotW.writeDTD("<!DOCTYPE robot SYSTEM \"Robot_Definition.dtd\">");
			xRobotW.writeComment("Robots windsurfing competition: Die XML Datei stellt einen Roboter da.");
			xRobotW.writeStartElement("robot");
			if (roboterPar.getName() == null) {
				throw new NullPointerException("Der Name des Roboters ist null");
			}
			xRobotW.writeAttribute("name", roboterPar.getName());
			xRobotW.writeStartElement("verhalten");
			if (roboterPar.getSeed() == null) {
				throw new NullPointerException("Der Seed des Roboters ist null");
			}
			xRobotW.writeCharacters(roboterPar.getSeed());
			xRobotW.writeEndElement();
			xRobotW.writeStartElement("team");
			xRobotW.writeCharacters(roboterPar.getTeam().toString());
			xRobotW.writeEndElement();
			xRobotW.writeStartElement("gesamtpunkte");
			if (Integer.toString(roboterPar.getGesamtpunkte()) == null) {
				throw new NullPointerException("Die Gesamtpunkte des Roboters sind null");
			}
			xRobotW.writeCharacters(Integer.toString(roboterPar.getGesamtpunkte()));
			xRobotW.writeEndElement();
			xRobotW.writeEndElement();
			xRobotW.writeEndDocument();
			xRobotW.flush();
			xRobotW.close();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			e.printStackTrace();
		} catch (XMLStreamException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Schreibt einen kompletten Wettbewerb als XML Datei
	 * @param wettkampfPar Der zu schreibende Wettkapmf
	 * @param fileNamePar Der Dateiname
	 */
	public void competitionXMLWriter(Wettkampf wettkampfPar, String fileNamePar) {
		try {
			XMLOutputFactory xof = XMLOutputFactory.newInstance();
			XMLStreamWriter xCompW = null;
			if (fileNamePar == null) {
				throw new NullPointerException("Der Dateiname ist null");
			}
			xCompW = xof.createXMLStreamWriter(new FileOutputStream(fileNamePar), "utf-8");
			xCompW.writeStartDocument("utf-8", "1.0");
			xCompW.writeDTD("<!DOCTYPE simulationsArt SYSTEM \"Competition_Definition.dtd\">");
			xCompW.writeComment("Robots windsurfing competition: Die XML Datei stellt einen Wettkampf da.");
			xCompW.writeStartElement("simulationsArt");
			xCompW.writeAttribute("wettkampfArt", wettkampfPar.getWettkampfArt().toString());
			xCompW.writeStartElement("simulationTeilnehmer");
			xCompW.writeCharacters(Integer.toString(wettkampfPar.getAnzahlDerTeilnehmer()));
			xCompW.writeEndElement();
			xCompW.writeStartElement("runde");
			xCompW.writeAttribute("anzahlDerRunden", Integer.toString(wettkampfPar.getRunde().getAnzahlDerRunden()));
			xCompW.writeAttribute("zeitProRunde",  Long.toString(wettkampfPar.getRunde().getZeitProRunde()));
			xCompW.writeCharacters(Integer.toString(wettkampfPar.getRunde().getAktuelleRunde()));
			xCompW.writeEndElement();
			ArrayList<Robot> robots = new ArrayList<>(wettkampfPar.getlistRobots());
			for(int i=0;i<robots.size();i++){
				Robot robot = robots.get(i);
			xCompW.writeStartElement("robot");
			if (robot.getName() == null) {
				throw new NullPointerException("Der Name des Roboters ist null");
			}
			xCompW.writeAttribute("name", robot.getName());
			xCompW.writeStartElement("verhalten");
			if (robot.getSeed() == null) {
				throw new NullPointerException("Der Seed des Roboters ist null");
			}
			xCompW.writeCharacters(robot.getSeed());
			xCompW.writeEndElement();
			xCompW.writeStartElement("punkte");
			if (Integer.toString(robot.getPunkte()) == null) {
				throw new NullPointerException("Die Gesamtpunkte des Roboters sind null");
			}
			xCompW.writeCharacters(Integer.toString(robot.getPunkte()));
			xCompW.writeEndElement();
			xCompW.writeStartElement("team");
			xCompW.writeCharacters(robot.getTeam().toString());
			xCompW.writeEndElement();
			xCompW.writeStartElement("gesamtpunkte");
			if (Integer.toString(robot.getGesamtpunkte()) == null) {
				throw new NullPointerException("Die Gesamtpunkte des Roboters sind null");
			}
			xCompW.writeCharacters(Integer.toString(robot.getGesamtpunkte()));
			xCompW.writeEndElement();
			xCompW.writeEndElement();
			}
			xCompW.writeEndElement();
			xCompW.writeEndDocument();
			xCompW.flush();
			xCompW.close();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			e.printStackTrace();
		} catch (XMLStreamException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
