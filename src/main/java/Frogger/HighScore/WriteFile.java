package Frogger.HighScore;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import Frogger.Manager.ScoreManager;

/**
 * Class for WriteFile
 * Write contents into given file
 * @author leeka
 *
 */
public class WriteFile {

	/**
	 * Create instance of WriteFile
	 * Establish and close output stream to Write to file
	 * @throws FileNotFoundException
	 */
	public WriteFile() throws FileNotFoundException{
		
		FileOutputStream fos1 = new FileOutputStream("HighScoreName.txt", true);
		PrintWriter pw1 = new PrintWriter(fos1);
		
		FileOutputStream fos2 = new FileOutputStream("HighScore.txt", true);
		PrintWriter pw2 = new PrintWriter(fos2);
		
		pw1.println(RecordScore.name);
		pw2.println(ScoreManager.getPoints());
		pw1.close();
		pw2.close();
		
	}
	
}
