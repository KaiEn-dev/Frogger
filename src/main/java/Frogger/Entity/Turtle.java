package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class for Turtle Entity
 * @author leeka
 *
 */
public class Turtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	private int speed;
	int i = 1;
	boolean bool = true;
	
	@Override
	public void act(long now) {
		TurtleAnimation(now);
			
		move(speed , 0);
		
		ResetTurtle();
	}
	
	
	/**
	 * Create named instance of turtle
	 * @param xposition
	 * @param yposition
	 * @param movement speed
	 * @param width
	 * @param height
	 */
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:Resources/Turtle/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:Resources/Turtle/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:Resources/Turtle/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	
	/**
	 * Set turtle's animation
	 * @param now
	 */
	//turtle animation
	public void TurtleAnimation(long now) {
		if (now/900000000  % 3 ==0) {
			setImage(turtle2);
			
		}
		else if (now/900000000 % 3 == 1) {
			setImage(turtle1);
			
		}
		else if (now/900000000 %3 == 2) {
			setImage(turtle3);
			
		}
	}
	
	/**
	 * reset turtle if out of bound
	 */
	//reset turtle if out of bound
	public void ResetTurtle() {
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
}
