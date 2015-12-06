package gui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;

/**
 * Robots windsurfing competition
 * Das Menue der Application
 * @author Osarua
 */
public class Menue {

	public Pane menueErzeugen(){
	Pane root = new Pane();
	MenuBar menueBar = new MenuBar();
	root.getChildren().add(menueBar);
	Menu menu = new Menu("Datei");
	menueBar.getMenus().add(menu);
	return root;
	}
}
