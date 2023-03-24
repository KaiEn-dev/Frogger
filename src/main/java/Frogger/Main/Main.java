package Frogger.Main;

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
import Frogger.GameState.GameState;
import Frogger.GameState.LevelOne;
import Frogger.HUD.BackgroundImage;
import Frogger.HUD.Digit;
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
 * Class for Main
 * @author leeka
 *
 */
public class Main extends Application {
	
	AnimationTimer timer;
	
	/**
	 * Main Method
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException{
		launch(args);
	}

	/**
	 * Start the application and establish GameStateManager
	 * @param Stage
	 */
	@Override
	public void start(Stage primaryStage) {
	   GameStateManager manager = new GameStateManager(primaryStage);
	   manager.managerOnline(manager);
	   start();
	}
	
	/**
	 * Create Animation Timer
	 */
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {         	 
                GameStateManager.MainManager.CheckStatus();
            }
        };
    }
	
	/**
	 * Start animation timer
	 */
	public void start() {
		createTimer();
		timer.start();
	}

}