package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class for Jet entity
 * @author leeka
 *
 */
public class Jet extends Actor {

	private double speed;
	
	@Override
	public void act(long now) {
		move(speed, 0);
		ResetJet();
	}
	
	/**
	 * Create named instance of Jet
	 * @param width
	 * @param height
	 * @param x position
	 * @param y position
	 * @param movement speed
	 */
	public Jet(int w, int h, int xpos, int ypos, double s) {
		setImage(new Image("file:Resources/FlyStuff/JET.png", w, h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	/**
	 * Reset Jet to original position after out of bound
	 */
	public void ResetJet() {
		if (getX()<-100 && speed<0)
			setX(700);
	}
	
}
