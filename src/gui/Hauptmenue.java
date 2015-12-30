package gui;
import java.awt.Desktop;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Robots windsurfing competition
 * Das Hauptmenue der "Simulation"
 * @author Osarua
 */
public class Hauptmenue {
	
//	 private static final Image wellenTest = new Image
//			 (Hauptmenue.class.getResourceAsStream("wellenTest.png"));
	private Visio visioMenue;
	
	private HauptmenueButtonEventHandler eventHandler;
	
	/**
	 * Die Innere Klasse verarbeitet die Events, 
	 * wenn ein Button gedrueckt wurde.
	 * @author Osarua
	 */
	public class HauptmenueButtonEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Object ereignisVerursacher = event.getSource();
			if (ereignisVerursacher instanceof Control) {
				Button knopf = (Button) ereignisVerursacher;
				switch (knopf.getId()) {
				case "NEU":
					visioMenue.neuAuswahl();
					break;
				case "LADEN":
					break;
				case "HILFE":
					// oeffne die Wiki Seite auf GitHub
					try {
						Desktop.getDesktop().browse(
								new URL("https://github.com/Osarua/Robots-" + "windsurfing-competition/wiki").toURI());
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case "BEENDEN":
					visioMenue.schliessen();
					break;
				}
			}
		}
	}
	
	public Hauptmenue(Visio visioMenuePar) {
		eventHandler = new HauptmenueButtonEventHandler();
		visioMenue = visioMenuePar;
	}
	
	public Pane hauptmenueErzeugen() {	
		NavigierButton naviButton = new NavigierButton();
		Button btn = naviButton.erzeugeAuswahlButton();
		btn.setText("Neu");
		btn.setId("NEU");
		btn.setOnAction(eventHandler);
		Button btn2 = naviButton.erzeugeAuswahlButton();
		btn2.setText("Laden");
		btn2.setId("LADEN");
		btn2.setOnAction(eventHandler);
		Button btn3 = naviButton.erzeugeAuswahlButton();
		btn3.setText("Hilfe");
		btn3.setId("HILFE");
		btn3.setOnAction(eventHandler);
		Button btn4 = naviButton.erzeugeAbbrechenButton();
		btn4.setText("Beenden");
		btn4.setId("BEENDEN");
		btn4.setOnAction(eventHandler);
		VBox topPane = new VBox(1);
		topPane.getChildren().add(schriftZug());
		topPane.setAlignment(Pos.BOTTOM_CENTER);
		topPane.setPadding(new Insets(10));
		VBox buttonPane = new VBox(4);
		buttonPane.getChildren().add(btn);
		buttonPane.getChildren().add(btn2);
		buttonPane.getChildren().add(btn3);
		buttonPane.getChildren().add(btn4);
		buttonPane.setAlignment(Pos.TOP_CENTER);
		buttonPane.setPadding(new Insets(20));
		buttonPane.setSpacing(12);
		VBox pc = new VBox(topPane, buttonPane);
		pc.setAlignment(Pos.CENTER);
		pc.setTranslateY(-60.0);
		return pc;
	}

	/**
	 * Erzeugt ein Label
	 * @return Label 
	 */
	public Label schriftZug() {
		//ImageView sample = new ImageView(wellenTest);
		Label bla = new Label("ROBOTS WINDSURFING COMPETITION");
		bla.setContentDisplay(ContentDisplay.TOP);
		return bla;
	}
}
