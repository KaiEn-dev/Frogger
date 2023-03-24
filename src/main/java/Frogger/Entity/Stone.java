package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class for Stone entity
 * @author leeka
 *
 */
public class Stone extends Actor {

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Create named instance of Stone
	 * @param width
	 * @param height
	 * @param xposition
	 * @param yposition
	 */
	public Stone(int w, int h, int xpos, int ypos) {
		setImage(new Image("file:Resources/WaterStuff/Stone.png", w, h, true, true));
		setX(xpos);
		setY(ypos);
	}

}
