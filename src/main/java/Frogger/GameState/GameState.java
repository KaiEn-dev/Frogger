package Frogger.GameState;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import Frogger.Entity.Frog;
import Frogger.Controllers.LevelController;
import Frogger.Entity.End;
import Frogger.Entity.Log;
import Frogger.Entity.Vehicle;
import Frogger.Entity.Turtle;
import Frogger.Entity.WetTurtle;
import Frogger.HUD.BackgroundImage;
import Frogger.HUD.Digit;
import Frogger.HighScore.ScoresDisplay;
import Frogger.Manager.GameStateManager;
import Frogger.Manager.ScoreManager;
import Frogger.World.MyStage;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Base class for all game states
 * @author leeka
 *
 */
public abstract class GameState extends Application{
	AnimationTimer timer;
	MyStage background;
	Frog frog;
	Stage stage;
	
	public void start(Stage primaryStage){ 
	}
	
	/**
	 * Create Animation timer and handle runtime functionalities
	 * switch levels when level is completed
	 * show highscore list when game is completed
	 */
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	setNumber(ScoreManager.getPoints());
            	if(frog != null) {
            		if (frog.getStop() && frog.getLevel() == 1) {
            			frog.setLevel(0);
            			removeState();
            			GameStateManager.MainManager.launchLevelTwo();
            		}
            		else if (frog.getStop() && frog.getLevel() == 2) {
            			frog.setLevel(0);
            			removeState();
            			GameStateManager.MainManager.launchLevelThree();
            		}
            		else if (frog.getStop() && frog.getLevel() == 3) {
                		System.out.print("STOPP:");
                		background.stopMusic();
                		stop();
                		background.stop();
                		
                		try {
							ScoresDisplay display = new ScoresDisplay();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                	}
            	}
            }
        };
    }
	
	/**
	 * Start animationtimer, music and gamestate
	 */
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }
	
	/**
	 * Stop animation timer 
	 */
	public void stop() {
        timer.stop();
    }
	
	/**
	 * Update displayed score
	 * @param current score
	 */
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 520 - shift, 25));
    		  shift+=30;
    		}
    }
    
    /**
     * abstract method to remove each state
     */
    public abstract void removeState();
}




