package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class for Train Button entity
 * @author leeka
 *
 */
public class TrainButton extends Actor {

	Train train;
	public static boolean status = false;
	int w;
	int h;
	
	/**
	 * on runtime if button pushed set button image and move the train
	 */
	@Override
	public void act(long now) {
		if(status) {
			setImage(new Image("file:Resources/Train/On.png", w, h, true, true));
			train.moveTrain();
		}
	}
	
	/**
	 * Create named instance of TrainButton
	 * @param width
	 * @param height
	 * @param xposition
	 * @param yposition
	 * @param train to act on
	 */
	public TrainButton(int w, int h, int xpos, int ypos, Train train) {
		this.train = train;
		this.w = w;
		this.h = h;
		setImage(new Image("file:Resources/Train/Off.png", w, h, true, true));
		setX(xpos);
		setY(ypos);
	}
	
	/**
	 * set status whether button is pushed 
	 */
	public static void setStatus() {
		status = true;
	}
	
}
