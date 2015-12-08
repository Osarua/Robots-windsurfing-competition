package gui;

import gui.Hauptmenue.HauptmenueButtonEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 * Robots windsurfing competition
 * Hier kann der gewuenschte Modus gewaehlt werden
 * @author Osarua
 */
public class Auswahl {

	private Visio visio;
	
	public Auswahl(Visio visioPar) {
		visio=visioPar;
	}
	public Pane auswahlWaehlen(){
		VBox auswahlBox = new VBox(4);
	        Button button1 = new Button();
	        button1.setText("SELBSTERSTELLEN");
	        Button button2 = new Button();
	        button2.setText("SCHNELLER WETTKAMPF");
	        Button button3 = new Button();
	        button3.setText("LANGER WETTKAMPF");
	        Button button4 = new Button();
	        button4.setText("TEAMMATCH");
	        Button button5 = new Button();
	        button5.setText("LAST TEAM STANDING");
	        Button button6 = new Button();
	        button6.setText("ABBRECHEN");
	        button6.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent arg0) {
					visio.getSzenengraph().getChildren().clear();
					visio.hauptmenueInitialisieren();
				}      	
	        });
	        auswahlBox.getChildren().addAll(button1,button2,button3,
	        		button4,button5,button6);
	        auswahlBox.setAlignment(Pos.CENTER);
	        auswahlBox.setSpacing(12);
	            return auswahlBox;
	}
}
