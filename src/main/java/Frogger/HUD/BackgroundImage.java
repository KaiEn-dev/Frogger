package Frogger.HUD;

import Frogger.Entity.Actor;
import javafx.scene.image.Image;

/**
 * Class for Background Image
 * to setup background image of scene
 * @author leeka
 *
 */
public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
	}
	
	/**
	 * Create named instance of Background Image
	 * @param imageLink
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}

}
