package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class for NyanCat entity
 * @author leeka
 *
 */
public class NyanCat extends Actor {

	private double speed;
	
	@Override
	public void act(long now) {
		move(speed, 0);
		
		ResetNyan();
	}
	
	/**
	 * Create named instance of NyanCat
	 * @param width
	 * @param height
	 * @param x position
	 * @param y position
	 * @param movement speed
	 */
	public NyanCat(int w, int h, int xpos, int ypos, double s) {
		setImage(new Image("file:Resources/FlyStuff/NYAN.png", w, h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	/**
	 * Reset NyanCat to original position when out of bound
	 */
	public void ResetNyan() {
		if (getX()<-100 && speed<0)
			setX(550);
	}

}
