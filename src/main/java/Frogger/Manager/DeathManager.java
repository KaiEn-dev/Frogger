package Frogger.Manager;

import Frogger.Entity.Frog;
import Frogger.GameState.LevelThree;
import Frogger.GameState.Tutorial;
import javafx.scene.image.Image;

/**
 * Class for DeathManager
 * To indicate when and act when Frog dies
 * @author leeka
 *
 */
public class DeathManager {

	public static boolean carDeath = false;
	public static boolean waterDeath = false;
	public static int D = 0;
	int imgSize = 40;
	long now;
	Frog frog;
	
	/**
	 * Create named instance of DeathManager
	 * @param animation time
	 * @param frog to be checked
	 */
	public DeathManager(long now, Frog frog) {
		this.now = now;
		this.frog = frog;
	}
	
	/**
	 * handle actions and indicate when Death happens
	 */
	public void handleDeath() {
		CarDeath();
		WaterDeath();
	}
	
	/**
	 * Indicate when and handle actions when Death happens due to collision with other actors
	 */
	public void CarDeath() {
		if(carDeath) {
			MovementManager.setNoMove(true);
			//car death animation
			if ((now)% 11 ==0) {
				D++;
			}
			if (D==1) {
				frog.setImage(new Image("file:Resources/VFX/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (D==2) {
				frog.setImage(new Image("file:Resources/VFX/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (D==3) {
				frog.setImage(new Image("file:Resources/VFX/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (D == 4) { //reset frog
				if(Tutorial.status == true && Tutorial.getStep() == 2) {
					frog.resetTutorialFrog();
					carDeath = false;
					D = 0;
					frog.setImage(new Image("file:Resources/Frog/froggerUp.png", imgSize, imgSize, true, true));
					MovementManager.setNoMove(false);
				}
				else {
				frog.resetFrog();
				carDeath = false;
				D = 0;
				if(LevelThree.status) {
					frog.setImage(new Image("file:Resources/Frog/BalloonDown.png", 80, 80, true, true));
				}
				else {
					frog.setImage(new Image("file:Resources/Frog/froggerUp.png", imgSize, imgSize, true, true));		
				}
				MovementManager.setNoMove(false);
				ScoreManager.collideScore();
				}
			}		
		}	
	}
		
	
	/**
	 * Indicate when and handle actions when Frog drops in water and dies
	 */
	public void WaterDeath() {
		if(waterDeath) {
			MovementManager.setNoMove(true);
			//water death animation
			if ((now)% 11 ==0) {
				D++;
			}
			if (D==1) {
				frog.setImage(new Image("file:Resources/VFX/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (D==2) {
				frog.setImage(new Image("file:Resources/VFX/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (D==3) {
				frog.setImage(new Image("file:Resources/VFX/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (D == 4) {
				frog.setImage(new Image("file:Resources/VFX/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (D == 5) { //reset frog
				frog.resetFrog();
				waterDeath = false;
				D = 0;
				frog.setImage(new Image("file:Resources/Frog/froggerUp.png", imgSize, imgSize, true, true));
				MovementManager.setNoMove(false);
				ScoreManager.collideScore();
			}		
		}
	}

	/**
	 * Get status whether CarDeath happened
	 * @return carDeath boolean
	 */
	public static boolean getCarDeath() {
		return carDeath;
	}

	/**
	 * Set whether carDeath happened
	 * @param carDeath boolean
	 */
	public static void setCarDeath(boolean carDeath) {
		DeathManager.carDeath = carDeath;
	}

	/**
	 * Get status whether WaterDeath happened
	 * @return waterDeath boolean
	 */
	public static boolean getWaterDeath() {
		return waterDeath;
	}

	/**
	 * Set whether waterDeath happened
	 * @param waterDeath boolean
	 */
	public static void setWaterDeath(boolean waterDeath) {
		DeathManager.waterDeath = waterDeath;
	}
	
	public void setNow(long now) {
		this.now = now;
	}
	
	
}
