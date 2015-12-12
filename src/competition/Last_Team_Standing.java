package competition;

import java.util.List;

import robot.Robot;

/**
 * Robots windsurfing competition
 * Die Klasse repraesentiert eine Last Team Standing Simulation
 * @author Osarua
 */
public class Last_Team_Standing implements Wettkampf {

	@Override
	public int wertePunkteAus() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public WettkampfArt getWettkampfArt() {
		return WettkampfArt.LANGER_WETTKAMPF;
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
