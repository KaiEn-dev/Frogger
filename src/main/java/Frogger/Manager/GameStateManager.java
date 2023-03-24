package Frogger.Manager;

import java.io.File;
import java.util.List;

import Frogger.Entity.Frog;
import Frogger.Entity.End;
import Frogger.Entity.Log;
import Frogger.Entity.Vehicle;
import Frogger.Entity.Turtle;
import Frogger.Entity.WetTurtle;
import Frogger.GameState.GameState;
import Frogger.GameState.Tutorial;
import Frogger.GameState.LevelOne;
import Frogger.GameState.LevelThree;
import Frogger.GameState.LevelTwo;
import Frogger.GameState.StartMenu;
import Frogger.HUD.BackgroundImage;
import Frogger.HUD.Digit;
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
 * Class for GameStateManager
 * Handle activation of each Game State
 * @author leeka
 *
 */
public class GameStateManager {
	
	public static Stage stage;
	public static GameStateManager MainManager;
	public static boolean startMenu = true;
	public static boolean tutorial = false;
	public static boolean levelOne = false;
	public static boolean levelTwo = false;
	public static boolean levelThree = false;

	/**
	 * Create named instance of GameStateManager
	 * @param stage
	 */
	public GameStateManager(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * Set static variable MainManager
	 * @param MainManager
	 */
	public void managerOnline(GameStateManager MainManager) {
		this.MainManager = MainManager;
	}
	
	/**
	 * Check what State to launch at the start of the game
	 * So that developer can manually decide which state to be launched during development
	 */
	public void CheckStatus() {
		if(startMenu) {
			launchStartMenu();
			startMenu = false;
		}
		
		if(tutorial) {
			launchTutorial();
			tutorial = false;
		}
		
		if(levelOne) {
			launchLevelOne();
			levelOne = false;
		}
		
		if(levelTwo) {
			launchLevelTwo();
			levelTwo = false;
		}
		
		if(levelThree) {
			launchLevelThree();
			levelThree = false;
		}
		
	}
	
	/**
	 * launch StartMenu
	 */
	public void launchStartMenu() {
		StartMenu startmenu = new StartMenu();
		startmenu.start(stage, startmenu);
	}
	
	/**
	 * launch LevelOne
	 */
	public void launchLevelOne() {
		LevelOne lvl1 = new LevelOne();
		lvl1.start(stage);
		
	}	
	
	/**
	 * launch LevelTwo
	 */
	public void launchLevelTwo() {
		LevelTwo lvl2 = new LevelTwo();
		lvl2.start(stage);
	}
	
	/**
	 * launchLevelThree
	 */
	public void launchLevelThree() {
		LevelThree lvl3 = new LevelThree();
		lvl3.start(stage);
		
	}
	
	/**
	 * launch Tutorial
	 */
	public void launchTutorial() {
		Tutorial tutorial = new Tutorial();
		tutorial.setTutorial(tutorial);
		tutorial.start(stage);
	}

	/**
	 * get StartMenu variable
	 * @return StartMenu
	 */
	public static boolean getStartMenu() {
		return startMenu;
	}

	/**
	 * setStartMenu variable
	 * @param startMenu
	 */
	public static void setStartMenu(boolean startMenu) {
		GameStateManager.startMenu = startMenu;
	}

	/**
	 * get Tutorial variable
	 * @return tutorial
	 */
	public static boolean getTutorial() {
		return tutorial;
	}

	/**
	 * set tutorial variable
	 * @param tutorial
	 */
	public static void setTutorial(boolean tutorial) {
		GameStateManager.tutorial = tutorial;
	}
	
	/**
	 * get levelone variable
	 * @return levelone
	 */
	public static boolean getLevelOne() {
		return levelOne;
	}

	/**
	 * set level one variable
	 * @param levelOne
	 */
	public static void setLevelOne(boolean levelOne) {
		GameStateManager.levelOne = levelOne;
	}
	
	/**
	 * get leveltwo variable
	 * @return level two
	 */
	public static boolean getLevelTwo() {
		return levelTwo;
	}

	/**
	 * set leveltwo variable
	 * @param levelTwo
	 */
	public static void setLevelTwo(boolean levelTwo) {
		levelTwo = levelTwo;
	}
	
	/**
	 * get levelthree variable
	 * @return levelthree
	 */
	public static boolean getLevelThree() {
		return levelThree;
	}

	/**
	 * set levelthree variable
	 * @param levelThree 
	 */
	public static void setLevelThree(boolean levelThree) {
		GameStateManager.levelThree = levelThree;
	}

}