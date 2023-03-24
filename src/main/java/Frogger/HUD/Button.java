package Frogger.HUD;

import Frogger.Entity.Actor;
import javafx.scene.image.Image;

/**
 * Class for Menu Button
 * to display and handle options in menu
 * @author leeka
 *
 */
public class Button extends Actor {
	
	public boolean button = false;
	public int id;
	
	/**
	 * Create named instance of Button and assign it a integer id
	 * @param id
	 */
	public Button(int id) {
		this.id = id;
		if(id == 1) {
			startButton();
		}
		if(id == 2) {
			tutorialButton();
		}
		
	}
	
	/**
	 * Set
	 * @param x
	 */
	public void setButton(boolean x) {
		button = x;
	}
	
	/**
	 * Set image and position for Start Button
	 */
	public void startButton() {
		setImage(new Image("file:Resources/Buttons/StartOff.png", 150, 50, true, true));
		setX(215);
		setY(550);
	}
	
	/**
	 * Set image and position for Tutorial Button
	 */
	public void tutorialButton() {
		setImage(new Image("file:Resources/Buttons/TutorialOff.png", 200, 100, true, true));
		setX(197);
		setY(650);
	}
	
	/**
	 * change appearance of button in run time 
	 * param animation time
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if(button == true && id == 1){
			setImage(new Image("file:Resources/Buttons/StartOn.png", 150, 50, true, true));
			setX(215);
			setY(550);
		}
		if(button == true && id == 2){
			setImage(new Image("file:Resources/Buttons/TutorialOn.png", 200, 100, true, true));
			setX(197);
			setY(650);
		}
		if(button == false && id == 1){
			setImage(new Image("file:Resources/Buttons/StartOff.png", 150, 50, true, true));
			setX(215);
			setY(550);
		}
		if(button == false && id == 2){
			setImage(new Image("file:Resources/Buttons/TutorialOff.png", 200, 100, true, true));
			setX(197);
			setY(650);
		}
		
	}
	
}
