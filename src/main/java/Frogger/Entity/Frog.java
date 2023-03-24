package Frogger.Entity;

import java.util.ArrayList;

import Frogger.Controllers.LevelController;
import Frogger.Manager.BoundManager;
import Frogger.Manager.DeathManager;
import Frogger.Manager.IntersectionManager;
import Frogger.Manager.MovementManager;
import Frogger.Manager.ScoreManager;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Class for Frog entity
 * @author leeka
 *
 */
public class Frog extends Actor {

	Frog frog;
	int level;
	int end = 0;
	double w = 800;
	double movement = MovementManager.getMovement();
	double movementX = MovementManager.getMovementX();
	boolean stop = false;
	int carD = 0;
	private boolean reachEnd = false;
	public static int imgSize = 40;
	ArrayList<End> inter = new ArrayList<End>();
	
	/**
	 * Create named instance of Frog
	 * @param imageLink
	 * @param level the frog is on
	 */
	public Frog(String imageLink, int level) {
		// set frog entity 
		if(level == 3) {
			imgSize = 80;
		}
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		if(level == 0) {
			resetTutorialFrog();
		}
		else {
			resetFrog();	
		}
		this.level = level;
	}
	
	@Override
	public void act(long now) {
		BoundManager bound = new BoundManager(frog, level);
		bound.handleBound();
		DeathManager death = new DeathManager(now, frog);
		death.handleDeath();
		IntersectionManager intersect = new IntersectionManager(frog, level);
		intersect.handleIntersection();
	}
	
	/**
	 * Set w value
	 * @param new w value
	 */
	public void setW(double x) {
		w = x;
	}
	
	/**
	 * Get w value
	 * @return w value
	 */
	public double getW() {
		return w;
	}
	
	/**
	 * set frog variable
	 * @param frog
	 */
	public void setfrog(Frog frog) {
		this.frog = frog;
	}
	
	/**
	 * reset frog to original position in tutorial
	 */
	public void resetTutorialFrog(){
		setX(280);
		setY(400);
	}
	
	/**
	 * reset frog to original position
	 */
	public void resetFrog() {
		setX(250);
		setY(679.8+movement);
	}
	
	/**
	 * Update status to indicate frog has reached the end
	 */
	public void FrogReachEnd() {
		reachEnd = true;
	}
	
	/**
	 * get whether frog reached end
	 * @return status whether frog reached end
	 */
	public boolean getReachEnd() {
		return reachEnd;
	}
	
	/**
	 * reset frog reach end status
	 */
	public void resetReachEnd() {
		reachEnd = false;
	}
	
	/**
	 * add number to end variable
	 * @param number to be added
	 */
	public void setEnd(int x) {
		end+=x;
	}
	
	/**
	 * get value of level variable that indicates what level is the frog in
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * set value of level variable that indicates what level is the frog in
	 * @param value to be set
	 */
	public void setLevel(int x) {
		level = x;
	}
	
	/**
	 * Check whether all frogs reached the end in a level
	 * @return status whether frogs completed level
	 */
	//all five frog success
	public boolean getStop() {
		return end==3;
	}

}
