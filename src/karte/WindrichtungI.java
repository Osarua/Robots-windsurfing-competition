package karte;

import javafx.scene.shape.Path;

/**
 * Robots windsurfing competition
 * Interface für die Windrichtung.
 * danach Orientiert sich der neue Path.
 * @author Osarua
 */
public interface WindrichtungI {

	public Path anfahren(double x, double y);
	
	public Path wende(double x, double y);
	
	public Path halse(double x, double y);
	
	public Path vorwindkurs(double x, double y);

	public Path raumwindkurs(double x, double y);
	
	public Path halbwindkurs(double x, double y);
	
	public Path amwindkurs(double x, double y);

}
