package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class for bird entity
 * @author leeka
 *
 */
public class Bird extends Actor {

	private double speed;	
	Image bird1;
	Image bird2;
	Image bird3;
	Image bird4;
	Image bird5;
	
	@Override
	public void act(long now) {
		BirdAnimation(now);
		move(speed, 0);
		ResetBird();
	}
	
	/**
	 * Create named instance of Bird
	 * @param width
	 * @param height
	 * @param x position
	 * @param y position
	 * @param movement speed
	 */
	public Bird(int w, int h, int xpos, int ypos, double s) {
		bird1 = new Image("file:Resources/Bird/b1.png", w, h, true, true);
		bird2 = new Image("file:Resources/Bird/b2.png", w, h, true, true);
		bird3 = new Image("file:Resources/Bird/b3.png", w, h, true, true);
		bird4 = new Image("file:Resources/Bird/b4.png", w, h, true, true);
		bird5 = new Image("file:Resources/Bird/b5.png", w, h, true, true);
		setImage(bird1);
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	/**
	 * Create Bird animation
	 * @param animation time
	 */
	public void BirdAnimation(long now) {
		if (now/100000000  % 4 ==0) {
			setImage(bird1);
			
		}
		else if (now/100000000 % 4 == 1) {
			setImage(bird2);
		}
		else if (now/100000000 %4 == 2) {
			setImage(bird3);
		} else if (now/100000000 %4 == 3) {
			setImage(bird4);
		}
		 else if (now/100000000 %4 == 4) {
				setImage(bird5);
			}
	}
	
	/**
	 * Reset Bird when out of bound
	 */
	public void ResetBird() {
		if (getX()<-100 && speed<0)
			setX(550);
	}

}
