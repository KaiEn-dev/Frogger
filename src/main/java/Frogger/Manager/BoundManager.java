package Frogger.Manager;

import Frogger.Entity.Frog;


/**
 * Class for BoundManager
 * Handle actions when Frog goes out of bound in the game
 * @author leeka
 *
 */
public class BoundManager {
	
	int level;
	Frog frog;
	double movement = MovementManager.getMovement();
	double movementX = MovementManager.getMovementX();
	
	/**
	 * Create named instance of BoundManager
	 * @param frog to be checked
	 * @param level the frog is on
	 */
	public BoundManager(Frog frog, int level) {
		this.frog = frog;
		this.level = level;
	}
	
	/**
	 * Handle Frog when it goes out of bound based on which game state the frog is on
	 */
	public void handleBound() {
		if(level == 0) {
			handleTutorial();
		}
		else {
			handleLevel();
		}
	}
	
	/**
	 * Handle Frog in Level Stages
	 */
	public void handleLevel() {
		if (frog.getY()<-50 || frog.getY()>734) {
			frog.resetFrog();
		}	
		//Out of bound X left side
		if (frog.getX()<0) {
			frog.move(movement*2, 0);
		}
		
		//out of bound X right side
		if (frog.getX()>558) {
			frog.move(-movement*2, 0);
		}
	}
	
	/**
	 * Handle Frog in Tutorial
	 */
	public void handleTutorial() {
		if (frog.getY()<30 ) {
			frog.move(0, movement*2);
		}	
		if(frog.getY()>580) {
			frog.move(0, -movement*2);
		}	
		//Out of bound X left side
		if (frog.getX()<40) {
			frog.move(movement*2, 0);
		}
		
		//out of bound X right side
		if (frog.getX()>493) {
			frog.move(-movement*2, 0);
		}
		
	}
}
