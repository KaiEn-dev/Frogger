package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class for lotus entity
 * @author leeka
 *
 */
public class Lotus extends Actor {

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Create named instance for lotus
	 * @param width
	 * @param height
	 * @param x position
	 * @param y position
	 */
	public Lotus(int w, int h, int xpos, int ypos) {
		setImage(new Image("file:Resources/WaterStuff/Lotus.png", w, h, true, true));
		setX(xpos);
		setY(ypos);
	}

	
}
