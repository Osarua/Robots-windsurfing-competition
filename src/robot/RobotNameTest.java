package robot;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Robots windsurfing competition
 * @author Osarua
 */
public class RobotNameTest {

	/**
	 * Testet die Methode erzeugeName().
	 */
	@Test
	public void testErzeugeName() {
		RobotName name = new RobotName();
		String nameResult = name.erzeugeName();
		assertFalse(nameResult.isEmpty());
	}

}
