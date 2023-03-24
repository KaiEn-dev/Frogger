package Frogger.Manager;

import java.util.ArrayList;

import Frogger.Entity.Bird;
import Frogger.Entity.End;
import Frogger.Entity.Frog;
import Frogger.Entity.Log;
import Frogger.Entity.Lotus;
import Frogger.Entity.NyanCat;
import Frogger.Entity.Train;
import Frogger.Entity.TrainButton;
import Frogger.Entity.Raft;
import Frogger.Entity.Seagull;
import Frogger.Entity.Stone;
import Frogger.Entity.TrafficLight;
import Frogger.Entity.Turtle;
import Frogger.Entity.Vehicle;
import Frogger.Entity.WetTurtle;
import Frogger.Entity.Helicopter;
import Frogger.Entity.Superman;
import Frogger.Entity.Jet;

/**
 * Class for intersection manager
 * indicate intersections and handle actions when it happens
 * @author leeka
 *
 */
public class IntersectionManager {

	Frog frog;
	ArrayList<End> inter = new ArrayList<End>();
	int level;
	
	/**
	 * Create named instance of Intersection Manager
	 * @param frog to check on
	 * @param level the frog is on
	 */
	public IntersectionManager(Frog frog, int level) {
		this.frog = frog;
		this.level = level;
	}
	
	/**
	 * Handle all intersections based on which game state the frog is on
	 */
	public void handleIntersection() {
		if(level == 0) {
			handleTutorial();
		}
		if(level == 1) {
			handleLevelOne();
		}
		if(level == 2) {
			handleLevelTwo();
		}
		if(level == 3) {
			handleLevelThree();
		}
	}
	
	/**
	 * indicate and handle intersections in tutorial
	 */
	public void handleTutorial() {
		if (frog.getIntersectingObjects(Vehicle.class).size() >= 1) {
			DeathManager.setCarDeath(true);
		}
		if (frog.getIntersectingObjects(End.class).size() >= 1) {
			frog.getIntersectingObjects(End.class).get(0).setEnd(); 
			frog.resetTutorialFrog();
		}
	}
	
	/**
	 * indicate and handle intersections in levelOne
	 */
	public void handleLevelOne() {
		
		if (frog.getIntersectingObjects(Vehicle.class).size() >= 1) {
			DeathManager.setCarDeath(true);
		}
		
		
		//if collide log
		if (frog.getIntersectingObjects(Log.class).size() >= 1 && !MovementManager.getNoMove()) {
			if(frog.getIntersectingObjects(Log.class).get(0).getLeft())
				//frog follow wood to left
				frog.move(-2,0);
			else
				//frog follow wood to right
				frog.move (.75,0);
		}
		else if (frog.getIntersectingObjects(Turtle.class).size() >= 1 && !MovementManager.getNoMove()) {
			//frog follow turtle
			frog.move(-1,0);
		}
		else if (frog.getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (frog.getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				//if turtle sunk frog die
				DeathManager.setWaterDeath(true);
			} else {
				//turtle not sunk frog follow turtle
				frog.move(-1,0);
			}
		}
		else if (frog.getIntersectingObjects(End.class).size() >= 1) {
			//frog reach end
			inter = (ArrayList<End>) frog.getIntersectingObjects(End.class);
			if (frog.getIntersectingObjects(End.class).get(0).isActivated()) {
				//if end slot occupied
				frog.setEnd(-1);
				ScoreManager.addPoints(-50);
			}
			//add points reset frog
			ScoreManager.endScore();
			frog.setW(800);
			frog.getIntersectingObjects(End.class).get(0).setEnd(); //set success frog image
			frog.setEnd(1);
			frog.resetFrog();
		}
		else if (frog.getY()<413){
			//between end slots there's water
			DeathManager.setWaterDeath(true);
		}
		
	}
	
	/**
	 * indicate and handle intersections in levelTwo
	 */
	public void handleLevelTwo() {
		
		//train
		if (frog.getIntersectingObjects(Train.class).size() >= 1) {
			DeathManager.setCarDeath(true);
		}
		
		if (frog.getIntersectingObjects(TrainButton.class).size() >= 1) {
			TrainButton.setStatus();
		}
		
		if (frog.getIntersectingObjects(End.class).size() >= 1) {
			//frog reach end
			frog.FrogReachEnd();
			inter = (ArrayList<End>) frog.getIntersectingObjects(End.class);
			if (frog.getIntersectingObjects(End.class).get(0).isActivated()) {
				//if end slot occupied
				frog.setEnd(-1);
				ScoreManager.addPoints(-50);
			}
			//add points reset frog
			ScoreManager.endScore();
			frog.setW(800);
			frog.getIntersectingObjects(End.class).get(0).setEnd(); //set success frog image
			frog.setEnd(1);
			frog.resetFrog();
		}
		
		
		//raft
		if (frog.getIntersectingObjects(Raft.class).size() >= 1 && !MovementManager.getNoMove()) {
			if(frog.getIntersectingObjects(Raft.class).get(0).getLeft())
				//frog follow wood to left
				frog.move(-4,0);
			else
				//frog follow wood to right
				frog.move (2,0);
		}
		else if(frog.getIntersectingObjects(Stone.class).size() >= 1){}
		else if(frog.getIntersectingObjects(Lotus.class).size() >= 1) {}
		else if(frog.getY()>440){
			if(frog.getY() > 706) {
				if(frog.getX()>180 && frog.getX()<320) {
					
				}
				else if(frog.getX()>435 && frog.getX()<485) {
					
				}
				else {
					DeathManager.setWaterDeath(true);
				}
				}
			else {
				DeathManager.setWaterDeath(true);
			}
		}
	}
	
	/**
	 * indicate and handle intersections in levelThree
	 */
	public void handleLevelThree() {
		
		if (frog.getIntersectingObjects(TrafficLight.class).size() >= 1) {
			DeathManager.setCarDeath(true);
		}
		if (frog.getIntersectingObjects(Bird.class).size() >= 1) {
			DeathManager.setCarDeath(true);
		}
		if (frog.getIntersectingObjects(Seagull.class).size() >= 1) {
			DeathManager.setCarDeath(true);
		}
		if (frog.getIntersectingObjects(NyanCat.class).size() >= 1) {
			DeathManager.setCarDeath(true);
		}
		if (frog.getIntersectingObjects(Helicopter.class).size() >= 1) {
			DeathManager.setCarDeath(true);
		}
		if (frog.getIntersectingObjects(Superman.class).size() >= 1) {
			DeathManager.setCarDeath(true);
		}
		if (frog.getIntersectingObjects(Jet.class).size() >= 1) {
			DeathManager.setCarDeath(true);
		}
		
		if (frog.getIntersectingObjects(End.class).size() >= 1) {
			//frog reach end
			frog.FrogReachEnd();
			inter = (ArrayList<End>) frog.getIntersectingObjects(End.class);
			if (frog.getIntersectingObjects(End.class).get(0).isActivated()) {
				//if end slot occupied
				frog.setEnd(-1);
				ScoreManager.addPoints(-50);
			}
			//add points reset frog
			ScoreManager.endScore();
			frog.setW(800);
			frog.getIntersectingObjects(End.class).get(0).setEnd(); //set success frog image
			frog.setEnd(1);
			frog.resetFrog();
		}
	}
}
