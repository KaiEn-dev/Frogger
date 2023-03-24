package Frogger.GameState;

import Frogger.Controllers.StartMenuController;
import Frogger.Controllers.TutorialController;
import Frogger.Entity.End;
import Frogger.Entity.Frog;
import Frogger.Entity.Vehicle;
import Frogger.HUD.BackgroundImage;
import Frogger.HUD.Button;
import Frogger.HUD.MenuCursor;
import Frogger.World.MyStage;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class For Tutorial GameState
 * @author leeka
 *
 */
public class Tutorial extends GameState{
	
	Vehicle car1;
	Vehicle car2;
	Vehicle car3;
	Vehicle truck1;
	End end;
	BackgroundImage tutorialBack;
	Tutorial tutorial;
	
	public static int step=0;
	public static boolean status = false;
	
	/**
	 *Start Tutorial
	 * @param
	 */
	public void start(Stage primaryStage)  {
		status = true;
		background = new MyStage();
	    Scene scene  = new Scene(background,558,780);	    
	    
	    stepOne();
	    
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start();  
	}
	
	/**
	 * Set tutorial variable
	 * @param tutorial
	 */
	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}
	
	/**
	 * set step variable
	 * @param value to be set
	 */
	public static void setStep(int x) {
		step = x;
	}
	
	/**
	 * get value of step variable
	 * @return
	 */
	public static int getStep() {
		return step;
	}
	
	/**
	 * Load Step one of tutorial onto stage
	 */
	public void stepOne() {
		step = 1;
		tutorialBack = new BackgroundImage("file:Resources/Landscape/tuto1.png");
		frog = new Frog("file:Resources/Frog/froggerDown.png", 0);
		TutorialController controls = new TutorialController(frog, tutorial);
		frog.setfrog(frog);		
		background.add(tutorialBack);
		background.add(frog);
	}
	
	/**
	 * Load Step two of tutorial onto stage
	 */
	public void stepTwo() {
		step = 2;
		background.remove(tutorialBack);
		background.remove(frog);
		tutorialBack = new BackgroundImage("file:Resources/Landscape/tuto2.png");
		frog = new Frog("file:Resources/Frog/froggerDown.png", 0);
		TutorialController controls = new TutorialController(frog, tutorial);
		frog.setfrog(frog);		
		background.add(tutorialBack);
		background.add(frog);
		end = new End(270,40);
		background.add(end);
		car1 = new Vehicle("file:Resources/Vehicles/car1Left.png", 250, 290, -1, 90, 90);
		car2 = new Vehicle("file:Resources/Vehicles/car1Left.png", 400, 290, -1, 90, 90);
		car3 = new Vehicle("file:Resources/Vehicles/car1Left.png", 100, 290, -1, 90, 90);
		background.add(car1);
		background.add(car2);
		background.add(car3);
	}
	
	/**
	 * Remove Tutorial State
	 */
	public void removeState() {
		background.remove(frog);
		background.remove(tutorialBack);
		background.remove(end);
		background.remove(car1);
		background.remove(car2);
		background.remove(car3);
		background.stopMusic();
		status = false;
	}
	
}
