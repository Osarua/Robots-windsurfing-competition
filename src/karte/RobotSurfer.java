package karte;

import java.util.Observable;
import java.util.Observer;

import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.util.Duration;

public class RobotSurfer extends Observable implements Runnable{	

	private int zeitProRuunde;

	private long startZeit;
	
	private long rennDauer;
	
	private int koordinateX;

	private int koordinateY;
	
	private int[][] koordinaten;
	
	private PathTransition pathTransition;

	public RobotSurfer(int zeitProRundePar, int[][] koordinatenXyPar, 
			Observer observerPar, PathTransition pathTransitionThreadPar) {
		zeitProRuunde = zeitProRundePar;
		koordinaten = koordinatenXyPar;
		addObserver(observerPar);
		pathTransition= pathTransitionThreadPar;
	}

	  private Path machWasAnderes(double x, double y) {
	    	ArcTo arcTo = new ArcTo();
	    	arcTo.setX(x-50*((Math.random()*2))+1);
	    	arcTo.setY(y-50*((Math.random()*2))+1);
	    	arcTo.setRadiusX(1.0);
	    	arcTo.setRadiusY(1.0);
	    	arcTo.setSweepFlag(true);
	    	  	    	 Path path = PathBuilder.create()
		                .elements(
		                    new MoveTo(x,y),
		                    arcTo
		                )
		                .build();
	    	    path.setStroke(Color.DODGERBLUE);
		        path.getStrokeDashArray().setAll(5d,5d);
		    	pathTransition.setDuration(Duration.seconds(3*((int)(Math.random()*4)+1)));
	    	 return path;
	    }
	    private Path machWas(double x, double y) {
	    	ArcTo arcTo = new ArcTo();
	    	arcTo.setX(x+50*((Math.random()*2))+1);
	    	arcTo.setY(y+50*((Math.random()*2))+1);
	    	arcTo.setRadiusX(1.0);
	    	arcTo.setRadiusY(1.0);
	    	arcTo.setSweepFlag(true);
	    	  	    	 Path path = PathBuilder.create()
		                .elements(
		                    new MoveTo(x,y),
		                    arcTo
		                )
		                .build();
	    	 pathTransition.setDuration(Duration.seconds(3*((int)(Math.random()*4)+1)));
	    	 return path;
	    }
	    
	    private boolean pathCheck(double xPar, double yPar) {
			boolean result = false;
			if( (xPar<540&&0<xPar)&&(yPar<540&&0<yPar)) {
				result =true;
			}
	    	return result;			
		}

	private Path zurueckSetzen(double x, double y) {
		Path path = PathBuilder.create()
				.elements(new MoveTo(x, y),
						new LineTo(x - 10.0 * ((Math.random() * 10) + 1), y - 10.0 * ((Math.random() * 10)) + 1))
				.build();
		pathTransition.setDuration(Duration.seconds(3 * ((int) (Math.random() * 4) + 1)));
		return path;
	}

	private Path geradeAus(double x, double y) {
		Path path = PathBuilder.create()
				.elements(new MoveTo(x, y),
						new LineTo(x + 10.0 * ((Math.random() * 10) + 1), y + 10.0 * ((Math.random() * 10)) + 1))
				.build();
		pathTransition.setDuration(Duration.seconds(3 * ((int) (Math.random() * 4) + 1)));
		return path;
	}
	    
	    public PathTransition getPathT(){
	    	return pathTransition;
	    }
	    
		@Override
		public void run() {
			pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					double x, y;
					x =pathTransition.getNode().getTranslateX();
					y= pathTransition.getNode().getTranslateY();
				//	stop();
					if(!pathCheck(x,y)) {
						if(x<20||y<20){
						pathTransition.setPath(geradeAus(x+4, y+4));
						} else {
							
						pathTransition.setPath(zurueckSetzen(x+4, y+4));
						}	
					}
					else if(Math.random()<0.2) {
					pathTransition.setPath(geradeAus(x+4, y+4));
					}
					else if(Math.random()<0.2) {
					pathTransition.setPath(zurueckSetzen(x+4, y+4));
					}
					else if(Math.random()<0.5) {
						pathTransition.setPath(machWas(x+4, y+4));

					} else {
						pathTransition.setPath(machWasAnderes(x+6, y+6));

					}
				      setChanged();
				      notifyObservers();			
				}
		    });
}

		public void play() {
			pathTransition.play();
			
		}
	 
	        }


