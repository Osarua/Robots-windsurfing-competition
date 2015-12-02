package gui;

import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * Robots windsurfing competition
 * Das Hauptmenue der "Simulation"
 * @author Osarua
 */
public class Hauptmenue {
	 
	public Pane hauptmenueErzeugen() {
		GridPane pane = new GridPane();
		pane.centerShapeProperty();
		pane.setPadding(new Insets(5));
		pane.setHgap(5);
		pane.setVgap(5);
		ToggleButton btn = new ToggleButton();
		btn.setText("Neu");
		ToggleButton btn2 = new ToggleButton();
		btn2.setText("Laden");
		ToggleButton btn3 = new ToggleButton();
		btn3.setText("Hilfe");
		ToggleButton btn4 = new ToggleButton();
		btn4.setText("Beenden");
		pane.add(btn, 60, 60);
		pane.add(btn2, 60, 62);
		pane.add(btn3, 60, 64);
		pane.add(btn4, 60, 66);
		return pane;
	}
}
