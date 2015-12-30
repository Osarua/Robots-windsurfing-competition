package karte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Robots windsurfing competition
 * Der Wind bestest aus der Windrichtung und stärke.
 * @author Osarua
 */
public class Wind {

	/**
	 * Liste aller Windrichtungen.
	 */
	private List<Windrichtungen> windrichtungen;
	
	/**
	 * Die Windrichtung aus welcher der Wind kommt 
	 */
	private WindrichtungI aktuelleWindrichtung;
	
	/**
	 * Die Windstärke
	 */
	private  List<Windstaerken> windstaerken;
	
	private int aktuelleWindstaerke;
	
	private int Windaenderung;
	
	public Wind(){
		windrichtungen = new ArrayList<>(Arrays.asList(Windrichtungen.NORD, Windrichtungen.NORDOST, Windrichtungen.OST, 
				Windrichtungen.OSTSUED, Windrichtungen.SUED, Windrichtungen.SUEDWEST, 
				Windrichtungen.WEST, Windrichtungen.WESTNORD));
		aktuelleWindrichtungBestimmen(); 
	}
	
	public void aktuelleWindrichtungBestimmen() {
		Windrichtungen windrichtung= windrichtungen.get((int)(Math.random() * windrichtungen.size()));
		switch(windrichtung) {
		case NORD:
			
			break;
		case NORDOST:
			
			break;
		case OST:
			
			break;
		case OSTSUED:
			
			break;
		case SUED:
			
			break;
		case SUEDWEST:
			
			break;
		case WEST:
			
			break;
		case WESTNORD:
			
			break;
		}
	}
}
