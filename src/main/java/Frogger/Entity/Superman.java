package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class for superman entity
 * @author leeka
 *
 */
public class Superman extends Actor {

private double speed;
	
	@Override
	public void act(long now) {
		move(speed, 0);
		
		ResetSuperman();
	}
	
	/**
	 * Create named instance for superman
	 * @param width
	 * @param height
	 * @param xposition
	 * @param yposition
	 * @param movement speed
	 */
	public Superman(int w, int h, int xpos, int ypos, double s) {
		setImage(new Image("file:Resources/FlyStuff/SUPERMAN.png", w, h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	/**
	 * reset superman when out of bound
	 */
	public void ResetSuperman() {
		if (getX()<-100 && speed<0)
			setX(700);
	}
}
