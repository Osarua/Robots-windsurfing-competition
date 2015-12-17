package robot;

/**
 * Robots windsurfing competition
 * @author Osarua
 */
public class RobotName {

	/**
	 * Erzeugt einen String der als Name
	 * für einen Roboter steht.
	 * @return String der erzeugte Name
	 */
	public String erzeugeName(){
		String result = "";
		String stringAlphabet = "aAbBcCdDeEfFgGhHiIjJ"
				+ "kKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		String zeichen = "$&#*~@%:_;";
		char c = 0;
		for(int i=0;i<10;i++) {
			// "50% Wahrscheinlichkeit"
			if(Math.random()<0.5) {
				c = stringAlphabet.charAt((int)(Math.random() * stringAlphabet.length()));
				result += Character.toString(c);
			} else if(Math.random()<0.3) {
				c = zeichen.charAt((int)(Math.random() * zeichen.length()));
				result += Character.toString(c);
			} else if(Math.random()<0.2) {
				result +=berechneZahl();
			}
			else {
				if(i>8&&result.length()<2) {
					i=7;
				}
			}
			
		}
		return result;
	}
	
	/**
	 * Git eine Ziffer zwischen 0-9 zurück.
	 * @return String die berechnete Ziffer als String
	 */
	private String berechneZahl() {
	int r = (int) (Math.random() * 9 );
	return Integer.toString(r);
	}
}
