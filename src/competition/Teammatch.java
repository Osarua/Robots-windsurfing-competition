package competition;

import java.util.List;

import robot.Robot;

/**
 * Robots windsurfing competition
 * Die Klasse repraesentiert ein Teammatch
 * @author Osarua
 */
public class Teammatch implements Wettkampf {

	@Override
	public int wertePunkteAus() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WettkampfArt getWettkampfArt() {
		return WettkampfArt.TEAMMATCH;
	}

	@Override
	public int getAnzahlDerTeilnehmer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAnzahlDerRunden() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getZeitProRunde() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addRobot(Robot robotPar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Robot> getlistRobots() {
		// TODO Auto-generated method stub
		return null;
	}

}
