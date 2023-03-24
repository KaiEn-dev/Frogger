package Frogger.HighScore;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class for InputPopUp
 * PopUp dialog box for user to input name
 * @author leeka
 *
 */
public class InputPopUp {

	/**
	 * Create named instance of InputPopUp
	 * Create dialog box, take input and stores result
	 */
	public InputPopUp() {
		JFrame frame = new JFrame();
		Object result = JOptionPane.showInputDialog(frame, "Enter Your Name:");
		
		RecordScore.name = (String) result; 
	}
	
	
	
}
