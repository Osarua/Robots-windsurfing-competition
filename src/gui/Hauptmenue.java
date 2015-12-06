package gui;
import java.awt.Desktop;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Robots windsurfing competition
 * Das Hauptmenue der "Simulation"
 * @author Osarua
 */
public class Hauptmenue {
	
	private Visio visioMenue;
	
	private HauptmenueButtonEventHandler eventHandler;
	
	public class HauptmenueButtonEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Object ereignisVerursacher = event.getSource();
			if(ereignisVerursacher instanceof Control) {
				ToggleButton knopf = (ToggleButton) ereignisVerursacher;
			switch(knopf.getId()){
			case "NEU":
				System.out.println("Neu wurde gedrückt");
				break;
			case "LADEN":
				System.out.println("Laden wurde gedrueckt");
				break;
			case "HILFE":
				System.out.println("Hilfe wurde gedrückt");
				// oeffne die Wiki Seite auf GitHub
			    try {
			        Desktop.getDesktop().browse(new URL("https://github.com/Osarua/Robots-"
			        		+ "windsurfing-competition/wiki").toURI());
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
				break;
			case "BEENDEN":
				System.out.println("Beenden wurde gedrückt");
				visioMenue.schliessen();
				}
			}
			}
		}
	
	public Hauptmenue(Visio visioMenuePar) {
		eventHandler = new HauptmenueButtonEventHandler();
		visioMenue=visioMenuePar;
	}
	
	public Pane hauptmenueErzeugen() {
		BorderPane pane = new BorderPane();
		ToggleButton btn = new ToggleButton();
		btn.setText("Neu");
		btn.setId("NEU");
		btn.setOnAction(eventHandler);
		ToggleButton btn2 = new ToggleButton();
		btn2.setText("Laden");
		btn2.setId("LADEN");
		btn2.setOnAction(eventHandler);
		ToggleButton btn3 = new ToggleButton();
		btn3.setText("Hilfe");
		btn3.setId("HILFE");
		btn3.setOnAction(eventHandler);
		ToggleButton btn4 = new ToggleButton();
		btn4.setText("Beenden");
		btn4.setId("BEENDEN");
		btn4.setOnAction(eventHandler);
		VBox topPane = new VBox(1);
		topPane.getChildren().add(schriftZug());
		topPane.setAlignment(Pos.BOTTOM_CENTER);
		topPane.setPadding(new Insets(30));
		VBox buttonPane = new VBox(4);
		buttonPane.getChildren().add(btn);
		buttonPane.getChildren().add(btn2);
		buttonPane.getChildren().add(btn3);
		buttonPane.getChildren().add(btn4);
		buttonPane.setAlignment(Pos.TOP_CENTER);
        buttonPane.setPadding(new Insets(2));
        buttonPane.setSpacing(4);
        VBox pc = new VBox(topPane, buttonPane);
        pc.setAlignment(Pos.CENTER);
        pane.setCenter(pc);
        pane.setTranslateY(-60.0);
		return pane;
	}
	
	public Label schriftZug() {
		Label bla = new Label();
		bla.setText("ROBOTS WINDSURFING COMPETITION");
		return bla;
	}
}
