package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * class for TrafficLight entity
 * @author leeka
 *
 */
public class TrafficLight extends Actor {

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Create named instance
	 * @param imagelink
	 * @param width
	 * @param height
	 * @param xposition
	 * @param yposition
	 */
	public TrafficLight(String imagelink, int w, int h, int xpos, int ypos) {
		setImage(new Image(imagelink, w, h, true, true));
		setX(xpos);
		setY(ypos);
	}

}
