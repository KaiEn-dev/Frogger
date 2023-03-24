package Frogger.HighScore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Frogger.Manager.ScoreManager;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Class for ScoreList
 * List out HighScoreList
 * @author leeka
 *
 */
public class ScoreList {
	
	int[] scores = new int[100];
	String[] names = new String[100];
	int length = 0;
	int i;
	String display;
	String temp;
	
	/**
	 * Create instance of ScoreList
	 * Arrange and display Highscore list
	 * @throws FileNotFoundException
	 */
	public ScoreList() throws FileNotFoundException {
		
		FileInputStream x = new FileInputStream("HighScore.txt");
		Scanner one = new Scanner(x);
		
		FileInputStream y = new FileInputStream("HighScoreName.txt");
		Scanner two = new Scanner(y);
		
		i = 0;
		while(one.hasNext()) {
			scores[i] = one.nextInt();
			i++;
		}
		
		i = 0;
		while(two.hasNext()) {
			names[i] = two.nextLine();
			i++;
		}
		

		for(i=0;i<scores.length;i++) {
			if(scores[i] == 0)
				break;
			length++;
		}
		
		sort(scores, names);
		
		showHighScore();
		
	}
	
	/**
	 * Sort the list from High to Low
	 * @param scores
	 * @param names
	 */
	public void sort(int arr1[], String arr2[]) {
		
		int n = length;
		
		// One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int max_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr1[j] > arr1[max_idx]) 
                    max_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr1[max_idx]; 
            String tempS = arr2[max_idx];
            arr1[max_idx] = arr1[i]; 
            arr1[i] = temp; 
            arr2[max_idx] = arr2[i]; 
            arr2[i] = tempS; 
        } 
		
		
	}
	
	/**
	 * Display HighscoreList
	 */
	public void showHighScore() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("You Have Won The Game!");
		alert.setHeaderText("Your High Score: "+ScoreManager.getPoints()+"!");
		display = "----High Scores----\n";
		
		
		for(i=0;i<length;i++) {
			display = display + names[i] + ":  " + scores[i] + "\n";
		}
		alert.setContentText(display);
		alert.show();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
