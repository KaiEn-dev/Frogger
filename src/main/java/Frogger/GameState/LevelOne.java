package Frogger.GameState;

import Frogger.Controllers.LevelController;
import Frogger.Entity.End;
import Frogger.Entity.Frog;
import Frogger.Entity.Log;
import Frogger.Entity.Turtle;
import Frogger.Entity.Vehicle;
import Frogger.Entity.WetTurtle;
import Frogger.HUD.BackgroundImage;
import Frogger.HUD.Digit;
import Frogger.World.MyStage;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class for LevelOne Gamestate
 * @author leeka
 *
 */
public class LevelOne extends GameState {
	
	BackgroundImage froggerback;
	Log log1_1, log1_2, log1_3;
	Log log2_1, log2_2;
	Log log3_1, log3_2, log3_3;
	Turtle turtle1, turtle2;
	WetTurtle wetTurtle1, wetTurtle2, wetTurtle3, wetTurtle4;
	End end1, end2, end3;
	Vehicle truck1_1, truck1_2, truck1_3;
	Vehicle truck2_1, truck2_2;
	Vehicle car1, car2, car3, car4, car5;
	Digit digit;
	
	/**
	 * Create named instance for LevelOne and initialize all Actors
	 */
	public LevelOne() {
		froggerback = new BackgroundImage("file:Resources/Landscape/LevelOneBck.png");
		log1_1 = new Log("file:Resources/Log/log3.png", 150, 0, 166, 0.75);
		log1_2 = new Log("file:Resources/Log/log3.png", 150, 220, 166, 0.75);
		log1_3 = new Log("file:Resources/Log/log3.png", 150, 440, 166, 0.75);
		log2_1 = new Log("file:Resources/Log/logs.png", 300, 0, 276, -2);
		log2_2 = new Log("file:Resources/Log/logs.png", 300, 400, 276, -2);
		log3_1 = new Log("file:Resources/Log/log3.png", 150, 50, 329, 0.75);
		log3_2 = new Log("file:Resources/Log/log3.png", 150, 270, 329, 0.75);
		log3_3 = new Log("file:Resources/Log/log3.png", 150, 490, 329, 0.75);
		turtle1 = new Turtle(500, 376, -1, 130, 130);
		turtle2 = new Turtle(300, 376, -1, 130, 130);
		wetTurtle1 = new WetTurtle(700, 376, -1, 130, 130);
		wetTurtle2 = new WetTurtle(600, 217, -1, 130, 130);
		wetTurtle3 = new WetTurtle(400, 217, -1, 130, 130);
		wetTurtle4 = new WetTurtle(200, 217, -1, 130, 130);
		end1 = new End(50,96);
		end2 = new End(260,96);
		end3 = new End(450,96);
		truck1_1 = new Vehicle("file:Resources/Vehicles/truck1Right.png", 0, 639, 1, 90, 90);
		truck1_2 = new Vehicle("file:Resources/Vehicles/truck1Right.png", 300, 639, 1, 90, 90);
		truck1_3 = new Vehicle("file:Resources/Vehicles/truck1Right.png", 600, 639, 1, 90, 90);
		truck2_1 = new Vehicle("file:Resources/Vehicles/truck2Right.png", 0, 520, 1, 140, 140);
		truck2_2 = new Vehicle("file:Resources/Vehicles/truck2Right.png", 500, 520, 1, 140, 140);
		car1 = new Vehicle("file:Resources/Vehicles/car1Left.png", 100, 597, -1, 80, 80);
		car2 = new Vehicle("file:Resources/Vehicles/car2Left.png", 250, 597, -1, 80, 80);
		car3 = new Vehicle("file:Resources/Vehicles/car1Left.png", 400, 597, -1, 80, 80);
		car4 = new Vehicle("file:Resources/Vehicles/car1Left.png", 550, 597, -1, 80, 80);
		car5 = new Vehicle("file:Resources/Vehicles/car2Left.png", 500, 480, -5, 80, 80);
		digit = new Digit(0, 30, 520, 25);
		frog = new Frog("file:Resources/Frog/froggerDown.png", 1);
	}
	
	/**
	 * Start Gamestate and add all actors into Stage
	 * @param Stage
	 */
	public void start(Stage primaryStage)  {
		background = new MyStage();
	    Scene scene  = new Scene(background,558,780);	    
		background.add(froggerback);		
		background.add(log1_1);
		background.add(log1_2);
		background.add(log1_3);
		background.add(log2_1);
		background.add(log2_2);
		background.add(log3_1);
		background.add(log3_2);
		background.add(log3_3);		
		background.add(turtle1);
		background.add(turtle2);		
		background.add(wetTurtle1);
		background.add(wetTurtle2);
		background.add(wetTurtle3);
		background.add(wetTurtle4);
		background.add(end1);
		background.add(end2);
		background.add(end3);
		LevelController controls = new LevelController(frog);
		frog.setfrog(frog);		
		background.add(frog);
		background.add(truck1_1);
		background.add(truck1_2);
		background.add(truck1_3);
		background.add(car1);
		background.add(car2);
		background.add(car3);
		background.add(car4);
		background.add(car5);		
		background.add(truck2_1);
		background.add(truck2_2);
		background.add(digit);
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
		background.remove(log1_1);
		background.remove(log1_2);
		background.remove(log1_3);
		background.remove(log2_1);
		background.remove(log2_2);
		background.remove(log3_1);
		background.remove(log3_2);
		background.remove(log3_3);
		background.remove(turtle1);
		background.remove(turtle2);
		background.remove(wetTurtle1);
		background.remove(wetTurtle2);
		background.remove(wetTurtle3);
		background.remove(wetTurtle4);
		background.remove(end1);
		background.remove(end2);
		background.remove(end3);
		background.remove(truck1_1);
		background.remove(truck1_2);
		background.remove(truck1_3);
		background.remove(truck2_1);
		background.remove(truck2_2);
		background.remove(car1);
		background.remove(car2);
		background.remove(car3);
		background.remove(car4);
		background.remove(car5);
		background.remove(digit);
		background.stopMusic();
	}
	
}
