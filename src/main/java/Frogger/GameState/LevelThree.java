package Frogger.GameState;

import Frogger.Controllers.LevelController;
import Frogger.Entity.Bird;
import Frogger.Entity.End;
import Frogger.Entity.Frog;
import Frogger.Entity.Helicopter;
import Frogger.Entity.Jet;
import Frogger.Entity.NyanCat;
import Frogger.Entity.Seagull;
import Frogger.Entity.Superman;
import Frogger.Entity.TrafficLight;
import Frogger.HUD.BackgroundImage;
import Frogger.World.MyStage;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class for LevelThree GameState
 * @author leeka
 *
 */
public class LevelThree extends GameState {

	public static boolean status = false;
	
	BackgroundImage froggerback;
	TrafficLight light1;
	TrafficLight light2;
	Superman superman;
	Helicopter heli1;
	Bird bird1;
	Bird bird2;
	Bird bird3;
	Seagull gull1;
	Seagull gull2;
	Seagull gull3;
	Jet jet1;
	NyanCat nyan;
	End end1;
	End end2;
	End end3;
	
	/**
	 * Create named instance of LevelThree and initialize all actors
	 */
	public LevelThree() {
		froggerback = new BackgroundImage("file:Resources/Landscape/LevelThreeBck.png");
		light1 = new TrafficLight("file:Resources/Light/lightright.png", 500, 500, 300, 570);
		light2 = new TrafficLight("file:Resources/Light/lightleft.png", 500, 500, -400, 570);
		bird1 = new Bird(50, 50, 300, 530, -2);
		bird2 = new Bird(50, 50, 350, 530, -2);
		bird3 = new Bird(50, 50, 600, 530, -2);
		gull1 = new Seagull("file:Resources/Bird/gull1.png", 60, 60, 300, 450, 2);
		gull2 = new Seagull("file:Resources/Bird/gull1.png", 60, 60, 100, 450, 2);
		gull3 = new Seagull("file:Resources/Bird/gull2.png", 60, 60, 500, 450, 2);
		nyan = new NyanCat(50, 50, 300, 380, -2);
		heli1 = new Helicopter(90, 90, 100, 360, -2);
		jet1 = new Jet(130, 130, 300, 280, -4);
		superman = new Superman(80, 80, 500, 280, -4);
		frog = new Frog("file:Resources/Frog/BalloonDown.png", 3);
		end1 = new End(50,45);
		end2 = new End(245,45);
		end3 = new End(435,45);
		status = true;
	}
	
	/**
	 * Start Gamestate and add all actors into stage
	 * @param Stage
	 */
	public void start(Stage primaryStage)  {
		background = new MyStage();
	    Scene scene  = new Scene(background,558,780);	    
		background.add(froggerback);
		LevelController controls = new LevelController(frog, true);
		frog.setfrog(frog);	
		//background.add();
		background.add(bird1);
		background.add(bird2);
		background.add(bird3);
		background.add(gull1);
		background.add(gull2);
		background.add(gull3);
		background.add(nyan);
		background.add(heli1);
		background.add(superman);
		background.add(jet1);
		background.add(light1);
		background.add(light2);
		background.add(end1);
		background.add(end2);
		background.add(end3);
		
		background.add(frog);
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start();  
	}
	
	/**
	 * Remove Gamestate
	 */
	public void removeState() {
		background.remove(frog);
		background.remove(froggerback);
		status = false;
		background.stopMusic();
	}
}
