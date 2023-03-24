package Frogger.HighScore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class for ReadFile
 * Read contents of file
 * @author leeka
 *
 */
public class ReadFile {

	/**
	 * Create instance of ReadFile and establish Scanner to read file
	 * @throws FileNotFoundException
	 */
	public ReadFile() throws FileNotFoundException{
		FileInputStream fis = new FileInputStream("HighScoreName.txt");
		Scanner in = new Scanner(fis);
		
		while(in.hasNext()) {
			System.out.println(in.nextLine());
		}
	}
	
}
