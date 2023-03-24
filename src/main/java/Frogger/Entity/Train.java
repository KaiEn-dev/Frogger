package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class for Train Entity
 * @author leeka
 *
 */
public class Train extends Actor {

	private double speed;
	
	@Override
	public void act(long now) {
		move(speed , 0);
		
		ResetTrain();
		
	}
	
	/**
	 * Create named instance of Train
	 * @param imagelink
	 * @param width
	 * @param height
	 * @param xposition
	 * @param yposition
	 * @param movement speed
	 */
	public Train(String imagelink, int w, int h, int xpos, int ypos, double s) {
		setImage(new Image(imagelink, w, h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	/**
	 * move Train
	 */
	public void moveTrain() {
		speed = 4;
	}
	
	/**
	 * Reset Train when out of bound
	 */
	public void ResetTrain() {
		if(getX()>700 && speed == 4) {
			setX(-580);
		}
		
		if (getX()>800 && speed<4) {
			setX(-600);
		}
		
			
	}
}
