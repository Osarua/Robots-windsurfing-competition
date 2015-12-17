package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import robot.*;

/**
 * Robots windsurfing competition
 * Die Klasse kann den Stand einer Simulation
 * als Tabelle darstellen.
 * @author Osarua
 */
public class Tabelle {
	
	public Pane erstelleTabelle(int aktuelleRundePar, List<Robot> robotsPar) {
		VBox boxTabelle = new VBox();
		List<Robot> robots = new ArrayList<Robot>(robotsPar);
        final ObservableList<Robot> data = FXCollections.observableArrayList(robots);
        
        TableColumn<Robot, Integer> positionCol = new TableColumn<>("Position");   
        positionCol.setCellValueFactory(new PropertyValueFactory<Robot, Integer>("position"));

        TableColumn<Robot, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<Robot, String>("name"));

        TableColumn<Robot, String> seedCol = new TableColumn<>("Seed");
        seedCol.setCellValueFactory(new PropertyValueFactory<Robot, String>("seed"));

        TableColumn<Robot, Integer> punkteCol = new TableColumn<>("Punkte");
        punkteCol.setCellValueFactory(new PropertyValueFactory<Robot, Integer>("punkte"));
        
        TableColumn<Robot, String> teameCol = new TableColumn<>("Team");
        teameCol.setCellValueFactory(new PropertyValueFactory<Robot, String>("team"));
        
        TableColumn<Robot, Integer> gesamtpunkteCol = new TableColumn<>("Gesamtpunkte");
        gesamtpunkteCol.setCellValueFactory(new PropertyValueFactory<Robot, Integer>("Gesamtpunkte"));

         TableView<Robot> tableView = new TableView<>();
        tableView.setItems(data);
        tableView.getColumns().add(positionCol);
        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(seedCol);
        tableView.getColumns().add(punkteCol);
        tableView.getColumns().add(teameCol);
        tableView.getColumns().add(gesamtpunkteCol);
        boxTabelle.getChildren().add(tableView);
		return boxTabelle;
	}
}
