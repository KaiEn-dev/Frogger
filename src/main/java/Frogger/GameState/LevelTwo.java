package Frogger.GameState;

import Frogger.Controllers.LevelController;
import Frogger.Entity.End;
import Frogger.Entity.Frog;
import Frogger.Entity.Lotus;
import Frogger.Entity.Raft;
import Frogger.Entity.Stone;
import Frogger.Entity.Train;
import Frogger.Entity.TrainButton;
import Frogger.HUD.BackgroundImage;
import Frogger.HUD.Digit;
import Frogger.World.MyStage;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class for LevelTwo GameState
 * @author leeka
 *
 */
public class LevelTwo extends GameState {

	BackgroundImage froggerback;
	Train train1;
	Train train2;
	Train train3;
	Train train4;
	Train train5;
	Stone stone1;
	Stone stone2;
	Raft raft1;
	Raft raft2;
	Raft raft3;
	Raft raft4;
	Raft raft5;
	Lotus lotus;
	TrainButton button;
	End end1;
	End end2;
	End end3;
	Digit digit;
	
	
	/**
	 * Create named instance for LevelTwo and initialize all actors
	 */
	public LevelTwo() {
		froggerback = new BackgroundImage("file:Resources/Landscape/LevelTwoBck.png");
		frog = new Frog("file:Resources/Frog/froggerUp.png", 2);
		stone1 = new Stone(100, 80, 100, 595);
		stone2 = new Stone(100, 80, 430, 595);
		raft1 = new Raft(80, 80, 50, 640, 2);
		raft2 = new Raft(80, 80, 200, 640, 2);
		raft3 = new Raft(80, 80, 500, 640, 2);
		raft4 = new Raft(70, 60, 200, 540, -4);
		raft5 = new Raft(70, 60, 550, 540, -4);
		lotus = new Lotus(70, 70, 150, 500);
		train1 = new Train("file:Resources/Train/TrainLong.png", 600, 600, -20, 320, 0);
		train2 = new Train("file:Resources/Train/Train.png", 450, 450, 0, 250, 2);
		train3 = new Train("file:Resources/Train/Train.png", 450, 450, 600, 250, 2);
		train4 = new Train("file:Resources/Train/Train.png", 450, 450, 50, 185, 3);
		train5 = new Train("file:Resources/Train/Train.png", 450, 450, 700, 185, 3);
		end1 = new End(50,36);
		end2 = new End(260,36);
		end3 = new End(450,36);
		button = new TrainButton(40, 40, 460, 720, train1);
		digit = new Digit(0, 30, 520, 25);
	}
	
	/**
	 * Start gamestate and add all actors into stage
	 */
	public void start(Stage primaryStage)  {
		background = new MyStage();
	    Scene scene  = new Scene(background,558,780);
	    background.add(froggerback);
	    LevelController controls = new LevelController(frog);
		frog.setfrog(frog);	
		background.add(stone1);
		background.add(stone2);
		background.add(raft1);
		background.add(raft2);
		background.add(raft3);
		background.add(raft4);
		background.add(raft5);
		background.add(lotus);
		background.add(train1);
		background.add(train2);
		background.add(train3);
		background.add(train4);
		background.add(train5);
		background.add(end1);
		background.add(end2);
		background.add(end3);
		background.add(button);
		background.add(frog);
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start();  
	}
	
	/**
	 * Remove gamestate
	 */
	public void removeState() {
		background.remove(froggerback);
		background.remove(stone1);
		background.remove(stone2);
		background.remove(raft1);
		background.remove(raft2);
		background.remove(raft3);
		background.remove(raft4);
		background.remove(raft5);
		background.remove(lotus);
		background.remove(train1);
		background.remove(train2);
		background.remove(train3);
		background.remove(train4);
		background.remove(train5);
		background.remove(end1);
		background.remove(end2);
		background.remove(end3);
		background.remove(button);
		background.remove(frog);
		background.stopMusic();
	}
	
	}
