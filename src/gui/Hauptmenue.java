package gui;
import java.awt.Desktop;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Robots windsurfing competition
 * Das Hauptmenue der "Simulation"
 * @author Osarua
 */
public class Hauptmenue {
	
	 private static final Image wellenTest = new Image
			 (Hauptmenue.class.getResourceAsStream("wellenTest.png"));
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
				ToggleButton knopf = (ToggleButton) ereignisVerursacher;
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
				}
			}
		}
	}
	
	public Hauptmenue(Visio visioMenuePar) {
		eventHandler = new HauptmenueButtonEventHandler();
		visioMenue = visioMenuePar;
	}
	
	public Pane hauptmenueErzeugen() {
		BorderPane pane = new BorderPane();
		ToggleButton btn = new ToggleButton();
		btn.setText("Neu");
		btn.setId("NEU");
		btn.setOnAction(eventHandler);
		btn.setStyle("-fx-base: rgb(134,241,247);");
		ToggleButton btn2 = new ToggleButton();
		btn2.setText("Laden");
		btn2.setId("LADEN");
		btn2.setOnAction(eventHandler);
		btn2.setStyle("-fx-base: rgb(134,241,247);");
		ToggleButton btn3 = new ToggleButton();
		btn3.setText("Hilfe");
		btn3.setId("HILFE");
		btn3.setOnAction(eventHandler);
		btn3.setStyle("-fx-base: rgb(134,241,247);");
		ToggleButton btn4 = new ToggleButton();
		btn4.setText("Beenden");
		btn4.setId("BEENDEN");
		btn4.setOnAction(eventHandler);
		btn4.setStyle("-fx-base: rgb(134,241,247);");
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
		pane.setCenter(pc);
		pane.setTranslateY(-60.0);
		return pane;
	}

	/**
	 * Erzeugt ein Label
	 * @return Label 
	 */
	public Label schriftZug() {
		ImageView sample = new ImageView(wellenTest);
		Label bla = new Label("ROBOTS WINDSURFING COMPETITION", sample);
		bla.setContentDisplay(ContentDisplay.TOP);
		return bla;
	}
}
