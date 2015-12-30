package gui;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import competition.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import karte.RobotWarmUp;
import robot.Robot;

/**
 * Robots windsurfing competition
 * Ist für die Darstellung der Auswertung zur verfuegung.
 * @author Osarua
 */
public class AuswertungAusgabe implements Observer  {

	private Visio visio;
	
	private Wettkampf simulation;
	
	private Tabelle tabelle;
	
	private AuswahlButtonEventHandler gedruecktEventHandler;
	
	private RobotWarmUp robotWarmUp;
	
	public AuswertungAusgabe(Visio visioPar, Wettkampf simulationPar) {
		visio = visioPar;
		simulation = simulationPar;	
		tabelle = new Tabelle();
		gedruecktEventHandler = new AuswahlButtonEventHandler();
		robotWarmUp = new RobotWarmUp((Observer) this, simulation.getRunde().
				getZeitProRunde(),(ArrayList<Robot>) simulation.getlistRobots(),visio);
	}
	
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
				case "ZUMSTARTMENUE":
					visio.getSzenengraph().getChildren().clear();
					visio.hauptmenueInitialisieren();
					break;
				case "SPEICHERN":
					break;
				case "FORTSETZEN":
					simulation.getRunde().setAktuelleRunde(simulation.getRunde().getAktuelleRunde() +1);		
					visio.getSzenengraph().getChildren().clear();
					robotWarmUp.surf();	
					break;
				}	
			}
		}
	}
	
	/**
	 * Die Mthode gibt die Tabelle aus sowie die Möglichkeit zu speichern
	 * fortzufahren und zurück zum Hauptmenue zu komme.
	 */
	public void auswertungTabelleErstellen() {
		visio.getSzenengraph().getChildren().clear();
		VBox auswertungGui = new VBox();
		auswertungGui.getChildren().add(rundeInformation());
		auswertungGui.setAlignment(Pos.CENTER);
		auswertungGui.getChildren().add(tabelle.erstelleTabelle(
		simulation.getRunde().getAktuelleRunde(),simulation.getlistRobots()));
		auswertungGui.getChildren().add(menueSteuerungAuswertung());
		visio.getSzenengraph().getChildren().add(auswertungGui);
	}
	
	/**
	 * Ezeugt ein Menuesteuerung die es ermöglicht fortzufahren, speichern 
	 * und zurueck ins Startmenue zu kommen.
	 * @return Pane die Steuerrung
	 */
	public synchronized Pane menueSteuerungAuswertung() {
		NavigierButton naviButton = new NavigierButton();
		HBox menue = new HBox();
		Button buttonStartmenue = naviButton.erzeugeAbbrechenButton();
		buttonStartmenue.setText("Zum Startmenü");
		buttonStartmenue.setId("ZUMSTARTMENUE");
		buttonStartmenue.setOnAction(gedruecktEventHandler);
		Button buttonSpeichern = naviButton.erzeugeSpeichern();
		buttonSpeichern.setId("SPEICHERN");
		buttonSpeichern.setOnAction(gedruecktEventHandler);
		menue.getChildren().addAll(buttonStartmenue,buttonSpeichern);
		if(simulation.getRunde().getAnzahlDerRunden()!=simulation.getRunde().getAktuelleRunde()) {
			Button buttonFortsetzen = naviButton.erzeugeFortfahrenButton();
		    buttonFortsetzen.setId("FORTSETZEN");
			buttonFortsetzen.setOnAction(gedruecktEventHandler);
			menue.getChildren().add(buttonFortsetzen);
		}
		menue.setAlignment(Pos.CENTER);
		menue.setPadding(new Insets(10));
		menue.setSpacing(120.0);
		return menue;
	}
	
	public Pane rundeInformation(){
		HBox infoBox = new HBox();
		Label textSimulationsArt = new  Label();
		textSimulationsArt.setText(simulation.toString());
		textSimulationsArt.setFont(new Font("Courier New",14));
		infoBox.getChildren().add(textSimulationsArt);
		infoBox.setAlignment(Pos.CENTER);
		infoBox.setPadding(new Insets(10));
		infoBox.setTranslateY(-20.0);
		return infoBox;
	}
	
	public AuswertungAusgabe getAuswertung(){
		return this;
	}

	@Override
	public void update(Observable o, Object arg) {
		simulation.peng(new AuswertungAusgabe(visio, simulation));	
	}
}
