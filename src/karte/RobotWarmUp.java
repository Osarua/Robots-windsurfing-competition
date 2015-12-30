package karte;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import gui.Visio;
import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.Animation.Status;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import robot.Robot;
import robot.Team;

public class RobotWarmUp extends Observable implements Observer {

	private List<RobotSurfer> surfer;
	
	private long zeitProRunde;
	
	private ArrayList<Robot> robots;
	
	private Visio visio;
	
	private int[][] koordinaten;
	
	private int koordinateX;
	
	private int koordinateY;
	
	private Pane root; 
	
	private  List<PathTransition> pathTransitions;
	
	private long startZeit;
	
	private long rennDauer;
	
	private Wind wind;
	
	public RobotWarmUp(Observer observerPar, long zeitProRundePar,ArrayList<Robot> robtsPar, Visio visioPar){
		zeitProRunde = zeitProRundePar;
		robots = robtsPar;
		visio = visioPar;
		koordinaten = new int[600][600];
		koordinateX =0;
		koordinateY =0;
		root = new Pane();
		root.setStyle("-fx-background-color: skyblue;");
		pathTransitions = new ArrayList<PathTransition>();
		addObserver(observerPar);
		startZeit = 0;
		rennDauer = 0;	
	}
	
	public void surf() {
		visio.getSzenengraph().getChildren().add(root);
		surfer = new ArrayList<RobotSurfer>();
		for (int i = 0; i < robots.size(); i++) {
			if (i < 5) {
				koordinateX += 100;
				koordinateY = 100;
			} else if (i < 10) {
				if (i == 5) {
					koordinateX = 0;
				}
				koordinateX += 100;
				koordinateY = 300;
			} else if (i < 15) {
				if (i == 10) {
					koordinateX = 0;
				}
				koordinateX += 100;
				koordinateY = 400;
			} else if (i <= 20) {
				if (i == 15) {
				koordinateX = 0;
				}
				koordinateX += 100;
				koordinateY = 500;
			} else {
				koordinateX = 300;
				koordinateY = 325;
			}
			pathTransitions.add(anfahren(robots.get(i), koordinateX, koordinateY));
			surfer.add(new RobotSurfer(zeitProRunde, koordinaten, (Observer) this, pathTransitions.get(i)));
		}
		for (int i = 0; i < pathTransitions.size(); i++) {
			pathTransitions.get(i).play();
			surfer.get(i).getThread().start();
		}
		startZeit = System.currentTimeMillis();
		rennDauer = System.currentTimeMillis() - startZeit;
	}
	
    private PathTransition anfahren(Robot robot, double kX, double kY) {
		PathTransition pathTransition;
		Rectangle rect = new Rectangle(0, 0, 12, 4);
		rect.setArcHeight(80);
		rect.setArcWidth(50);
		Team team = robot.getTeam();
		switch (team) {
		case OSARUA:
			rect.setFill(Color.VIOLET);
			break;
		case ALPHA:
			rect.setFill(Color.BLACK);
			break;
		case BENNI:
			rect.setFill(Color.GOLD);
			break;
		case ZE2P:
			rect.setFill(Color.LIME);
			break;
		case GANGOFROBOTS:
			rect.setFill(Color.YELLOW);
			break;
		case EVOLUTION77:
			rect.setFill(Color.ORANGE);
			break;
		case DOGO:
			rect.setFill(Color.MEDIUMVIOLETRED);
			break;
		case JSRUN:
			rect.setFill(Color.RED);
			break;
		case VARRA:
			rect.setFill(Color.MINTCREAM);
			break;
		case PRADISE42:
			rect.setFill(Color.DARKBLUE);
			break;		
		}
		root.getChildren().add(rect);
        Path path = PathBuilder.create()
                .elements(
                    new MoveTo(kX,kY),
                    new LineTo(kX+10.0*((Math.random()*2)+1), kY+10.0*((Math.random()*2))+1)
                )
                .build();
        pathTransition = PathTransitionBuilder.create()
                .duration(Duration.seconds(3*((int)(Math.random()*4)+1)))
                .path(path)
                .node(rect)
                .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
                .autoReverse(false)
                .build();
        return pathTransition;
    }

    
    
	@Override
	public void update(Observable arg0, Object arg1) {
		if (rennDauer < zeitProRunde) {
			rennDauer = System.currentTimeMillis() - startZeit;
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < pathTransitions.size(); i++) {
						if (pathTransitions.get(i).getStatus() == Status.STOPPED) {
							pathTransitions.get(i).play();
						}
					}
				}
			});
		} else {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < pathTransitions.size(); i++) {
				
					pathTransitions.get(i).stop();
			}
			setChanged();
			notifyObservers();
		
	}
	}
	}
