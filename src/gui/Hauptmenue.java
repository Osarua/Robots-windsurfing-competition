package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
	 
	public Pane hauptmenueErzeugen() {
		BorderPane pane = new BorderPane();
		ToggleButton btn = new ToggleButton();
		btn.setText("Neu");
		ToggleButton btn2 = new ToggleButton();
		btn2.setText("Laden");
		ToggleButton btn3 = new ToggleButton();
		btn3.setText("Hilfe");
		ToggleButton btn4 = new ToggleButton();
		btn4.setText("Beenden");
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
        buttonPane.setSpacing(6);
        VBox pc = new VBox(topPane, buttonPane);
        pc.setAlignment(Pos.CENTER);
        pane.setCenter(pc);
		return pane;
	}
	
	public Label schriftZug() {
		Label bla = new Label();
		bla.setText("ROBOTS WINDSURFING COMPETITION");
		return bla;
	}
}
