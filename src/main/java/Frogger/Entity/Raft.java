package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class for raft entity
 * @author leeka
 *
 */
public class Raft extends Actor {

	private double speed;
	
	@Override
	public void act(long now) {
		
		move(speed , 0);
		
		ResetRaft();
		
	}
	
	/**
	 * Create named instance of Raft
	 * @param width
	 * @param height
	 * @param xposition
	 * @param yposition
	 * @param movement speed
	 */
	public Raft(int w, int h, int xpos, int ypos, double s) {
		setImage(new Image("file:Resources/WaterStuff/Raft.png", w, h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	/**
	 * reset raft when out of bound
	 */
	public void ResetRaft() {
		
		if (getX()>600 && speed>0)
			setX(-100);
		if (getX()<-300 && speed<0)
			setX(700);
		
	}
	
	/**
	 * to know whether raft is going towards left
	 * @return status on whether raft is moving towards left
	 */
	public boolean getLeft() {
		return speed < 0;
	}
	
}
