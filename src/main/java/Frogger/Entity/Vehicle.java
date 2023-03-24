package Frogger.Entity;

import Frogger.GameState.Tutorial;
import javafx.scene.image.Image;

/**
 * Class for Vehicle entity
 * @author leeka
 *
 */
public class Vehicle extends Actor {
	private int speed;
	
	@Override
	public void act(long now) {
		move(speed , 0);
		
		ResetVehicle();
	}
	
	/**
	 * Create named instance for VEHICLE
	 * @param imageLink
	 * @param xpos
	 * @param ypos
	 * @param s
	 * @param w
	 * @param h
	 */
	public Vehicle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	/**
	 * reset vehicle if out of bound
	 */
	public void ResetVehicle() {
		if(Tutorial.status == true) {
			if (getX() < 50 && speed<0)
				//respawn car after out of bound left
				setX(450);
		}
		else {
			if (getX() > 600 && speed>0)
				//respawn car after out of bound right
				setX(-200);
			if (getX() < -50 && speed<0)
				//respawn car after out of bound left
				setX(600);
		}
		
	}

}
