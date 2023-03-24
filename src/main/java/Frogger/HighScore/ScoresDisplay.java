package Frogger.HighScore;

import java.io.FileNotFoundException;

/**
 * Class for ScoreDisplay
 * Runs the whole operation of getting user name, write file and read file
 * @author leeka
 *
 */
public class ScoresDisplay {

	/**
	 * Create instance of ScoreDisplay and runs each step
	 * @throws FileNotFoundException
	 */
	public ScoresDisplay() throws FileNotFoundException {
		InputPopUp pop = new InputPopUp();
		WriteFile write = new WriteFile();
		ScoreList list = new ScoreList();
	}
	
}
