package Frogger.HUD;

import Frogger.Entity.Actor;

/**
 * Class for MenuCursor
 * used to navigate through menu buttons
 * @author leeka
 *
 */
public class MenuCursor extends Actor {

	public int flag = 0;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Get Flag
	 * @return flag boolean
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * Set Flag
	 * @param flag boolean
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
	
}
