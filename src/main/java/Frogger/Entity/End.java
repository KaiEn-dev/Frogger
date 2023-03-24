package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class for Ending Slot
 * @author leeka
 *
 */
public class End extends Actor{
	boolean activated = false;
	int x;
	int y;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	/**
	 * Create named instance of End
	 * @param x position
	 * @param y position
	 */
	//set not occupied image
	public End(int x, int y) {
		this.x = x;
		this.y = y;
		setX(x);
		setY(y);
		setImage(new Image("file:Resources/Landscape/End.png", 70, 70, true, true));
	}
	
	/**
	 * set end image and occupancy when frog reaches
	 */
	public void setEnd() {
		setX(x-15);
		setY(y-12);
		setImage(new Image("file:Resources/Landscape/FrogEnd.png", 100, 100, true, true));
		activated = true;
	}
	
	/**
	 * track whether end slot occupied
	 * @return occupancy status
	 */
	public boolean isActivated() {
		return activated;
	}
	

}
