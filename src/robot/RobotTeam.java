package robot;

import java.util.ArrayList;
import java.util.List;

/**
 * Robots windsurfing competition
 * Gibt ein "zufälliges" Team zurück.
 * @author Osarua
 */
public class RobotTeam {
	
	private List<Team> teams;
	
	public RobotTeam(){
		teams = new ArrayList<>();
		// Fuege alle Teams zur Liste
		teams.add(Team.ALPHA);
		teams.add(Team.BENNI);
		teams.add(Team.DOGO);
		teams.add(Team.EVOLUTION77);
		teams.add(Team.GANGOFROBOTS);
		teams.add(Team.JSRUN);
		teams.add(Team.OSARUA);
		teams.add(Team.PRADISE42);
		teams.add(Team.VARRA);
		teams.add(Team.ZE2P);
	}
	
	/**
	 * Die Methode gibt ein Team zurück
	 * @return Team das "berechnete" Team
	 */
	public Team gibTeamFuerEinenRobot() {
		int i = (int) (Math.random() * teams.size());
		return teams.get(i);
	}
}
