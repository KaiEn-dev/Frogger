package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class of Helicopter Entity
 * @author leeka
 *
 */
public class Helicopter extends Actor {

	private double speed;
	
	@Override
	public void act(long now) {
		move(speed, 0);
		
		ResetHelicopter();
	}
	
	/**
	 * Create named instance of Helicopter
	 * @param width
	 * @param height
	 * @param x position
	 * @param y position
	 * @param movement speed
	 */
	public Helicopter(int w, int h, int xpos, int ypos, double s) {
		setImage(new Image("file:Resources/FlyStuff/HELI.png", w, h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	/**
	 * Reset helicopter to original position when out of bound
	 */
	public void ResetHelicopter() {
		if (getX()<-100 && speed<0)
			setX(550);
	}
	
}
