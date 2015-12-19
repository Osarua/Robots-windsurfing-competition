package gui;

import competition.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Robots windsurfing competition
 * Hier kann der gewuenschte Modus gewaehlt werden
 * @author Osarua
 */
public class Auswahl {

	private Visio visio;

	private NavigierButton naviButton;

	private AuswahlButtonEventHandler gedruecktEventHandler;
	
	/**
	 * Die Innere Klasse verarbeitet die Events, 
	 * wenn ein Button gedrueckt wurde.
	 * @author Osarua
	 */
	public class AuswahlButtonEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Object ereignisVerursacher = event.getSource();
			if (ereignisVerursacher instanceof Control) {
				Button knopf = (Button) ereignisVerursacher;
				switch (knopf.getId()) {
				case "SELBSTERSTELLEN":
					visio.neuAuswahl();
					break;
				case "SCHNELLER_WETTKAMPF":
					Wettkampf schneller_Wettkampf = new Schneller_Wettkampf(15, 4, 10000, 0);
					schneller_Wettkampf.erzeugeRobots(15);
					AuswertungAusgabe auswertungA = new AuswertungAusgabe(visio, schneller_Wettkampf);				
					schneller_Wettkampf.peng(auswertungA);
					break;
				case "LANGER_WETTKAMPF":
					break;
				case "TEAMMATCH":;
					break;
				case "LAST_TEAM_STANDING":
					break;
				case "ABBRECHEN":
					visio.getSzenengraph().getChildren().clear();
					visio.hauptmenueInitialisieren();
				}
			}
		}
	}
	
	public Auswahl(Visio visioPar) {
		visio = visioPar;
		naviButton = new NavigierButton();
		gedruecktEventHandler = new AuswahlButtonEventHandler();
	}
	
	/**
	 * Die Methode initialisiert die die Auswahelbaren Buttons.
	 * @return die Auswahl mit den Buttons
	 */
	public Pane auswahlWaehlen() {
		VBox auswahlBox = new VBox(4);
		Button button1 = naviButton.erzeugeAuswahlButton();
		button1.setText("Selbsterstellen");
		button1.setId("SELBSTERSTELLEN");
		button1.setOnAction(gedruecktEventHandler);
		Button button2 = naviButton.erzeugeAuswahlButton();
		button2.setText("Schneller Wettkampf");
		button2.setId("SCHNELLER_WETTKAMPF");
		button2.setOnAction(gedruecktEventHandler);
		Button button3 = naviButton.erzeugeAuswahlButton();
		button3.setText("Langer Wettkampf");
		button3.setId("LANGER_WETTKAMPF");
		button3.setOnAction(gedruecktEventHandler);
		Button button4 = naviButton.erzeugeAuswahlButton();
		button4.setText("Teammatch");
		button4.setId("TEAMMATCH");
		button4.setOnAction(gedruecktEventHandler);
		Button button5 = naviButton.erzeugeAuswahlButton();
		button5.setText("Last Team Standing");
		button5.setId("LAST_TEAM_STANDING");
		button5.setOnAction(gedruecktEventHandler);
		Button button6 = naviButton.erzeugeAbbrechenButton();
		button6.setId("ABBRECHEN");
		button6.setOnAction(gedruecktEventHandler);
		auswahlBox.getChildren().addAll(button1, button2, button3, button4, button5, button6);
		auswahlBox.setAlignment(Pos.CENTER);
		auswahlBox.setSpacing(12);
		return auswahlBox;
	}
}
