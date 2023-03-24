package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class for Seagull entity
 * @author leeka
 *
 */
public class Seagull extends Actor {
	
	private double speed;
	
	@Override
	public void act(long now) {
		move(speed, 0);
		
		ResetSeagull();
	}
	
	/**
	 * Create named instance of Seagull
	 * @param imagelink
	 * @param width
	 * @param height
	 * @param xposition
	 * @param yposition
	 * @param movement speed
	 */
	public Seagull(String imagelink, int w, int h, int xpos, int ypos, double s) {
		setImage(new Image(imagelink, w, h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	/**
	 * Reset seagull when out of bound
	 */
	public void ResetSeagull() {
		if (getX()>600 && speed>0)
			setX(-100);
	}
}
