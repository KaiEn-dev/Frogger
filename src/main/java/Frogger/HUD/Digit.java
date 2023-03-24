package Frogger.HUD;

import Frogger.Entity.Actor;
import javafx.scene.image.Image;

/**
 * Class for Digits
 * To display score
 * @author leeka
 *
 */
public class Digit extends Actor{
	int dim;
	Image im1;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Create named instance for digit based on given integer
	 * @param number
	 * @param size
	 * @param x position
	 * @param y position
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:Resources/HUD/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
