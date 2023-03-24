package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * class for Log entity
 * @author leeka
 *
 */
public class Log extends Actor {

	private double speed;
	
	@Override
	public void act(long now) {
		move(speed , 0);
		ResetLog();
	}
	
	/**
	 * Create named instance for Log
	 * @param imageLink
	 * @param size
	 * @param x position
	 * @param y position
	 * @param movement speed
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	/**
	 * Reset log to original position after being out of bound
	 */
	public void ResetLog() {
		if (getX()>600 && speed>0)
			//respawn log after out of bound right
			setX(-100);
		if (getX()<-300 && speed<0)
			//respawn log after out of bound left
			setX(700);
	}
	
	/**
	 * to know whether log is moving towards the left
	 * @return status on whether log is moving towards left
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
