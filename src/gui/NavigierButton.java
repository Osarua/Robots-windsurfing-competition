package gui;


import javafx.scene.control.Button;

/**
 * Robots windsurfing competition
 * Die Klasse erzeugt "besondere" Navigier Buttons
 * @author Osarua
 */
public class NavigierButton {
	
	/**
	 * Erzeugt einen abbrechen Button.
	 * @return Der abbrechen Button
	 */
	public Button erzeugeAbbrechenButton(){
		Button buttonAbbrechen = new Button();
		buttonAbbrechen.setStyle("-fx-base: rgb(223,32,32);");  
		buttonAbbrechen.setText("Abbrechen");
        return buttonAbbrechen;
	}
	
	/**
	 * Erzeugt einen Auswahl Button.
	 * @return Auswahl Button
	 */
	public Button erzeugeAuswahlButton(){
		Button buttonAuswahl = new Button();
		buttonAuswahl.setStyle("-fx-base: rgb(134,241,247);");  
        return buttonAuswahl;
	}
	
	/**
	 * Erzeugt einen fortfahren Button.
	 * @return Fortfahren Button
	 */
	public Button erzeugeFortfahrenButton() {
		Button buttonFortfahren = new Button();
		buttonFortfahren.setStyle("-fx-base: rgb(238,244,108);");  
		buttonFortfahren.setText("FORTFAHREN");
        return buttonFortfahren;
	}
	
	/**
	 * Erzeugt einen speichern und fortfahren Button.
	 * @return Speichern und fortfahren Button
	 */
	public Button erzeugeSpeichernUndFortfahrenButton() {
		Button buttonSpeichernUndFortfahren = new Button();
		buttonSpeichernUndFortfahren.setStyle("-fx-base: rgb(13,255,0);");  
		buttonSpeichernUndFortfahren.setText("SPEICHERN & FORTFAHREN");
        return buttonSpeichernUndFortfahren;
	}
}
