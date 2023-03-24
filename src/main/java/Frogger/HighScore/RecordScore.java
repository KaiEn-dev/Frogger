package Frogger.HighScore;

import java.io.FileNotFoundException;

/**
 * Class for Record Store
 * Placeholder for the username and scores of user for each game
 * @author leeka
 *
 */
public class RecordScore {
	
	public static int score = 1000;
	public static String name;

	public RecordScore() throws FileNotFoundException {
		
		InputPopUp x = new InputPopUp();
		WriteFile y = new WriteFile();
		ReadFile z = new ReadFile();
	}
	
	
	
}
