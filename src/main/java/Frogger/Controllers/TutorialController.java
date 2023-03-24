package Frogger.Controllers;

import Frogger.Entity.Frog;
import Frogger.GameState.Tutorial;
import Frogger.Manager.GameStateManager;
import Frogger.Manager.MovementManager;
import Frogger.Manager.ScoreManager;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * A class that controls the movements of the frog in the tutorial
 * @author leeka
 *
 */
public class TutorialController {

	Image imgW1,imgA1,imgS1,imgD1,imgW2,imgA2,imgS2,imgD2;
	private boolean second = false;
	double movement = MovementManager.getMovement();
	double movementX = MovementManager.getMovementX();
	Frog frog;
	int imgSize = Frog.imgSize;
	Tutorial tutorial;
	
	/**
	 * construct a named instance of TutorialController
	 * @param frog to be controlled
	 * @param tutorial object where frog is situated
	 */
	public TutorialController(Frog frog, Tutorial tutorial) {
		this.frog = frog;
		this.tutorial = tutorial;
		createSprite();
		handleKeyPress(frog);
		handleKeyRelease(frog);		
	}
	
	/**
	 * Set up frog graphics/Sprite
	 */
	public void createSprite() {
		imgW1 = new Image("file:Resources/Frog/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:Resources/Frog/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:Resources/Frog/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:Resources/Frog/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:Resources/Frog/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:Resources/Frog/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:Resources/Frog/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:Resources/Frog/froggerRightJump.png", imgSize, imgSize, true, true);
		
	}
	
	/**
	 * handle movement and other actions when key is pressed
	 * @param frog to be act on
	 */
	public void handleKeyPress(Frog frog) {
		frog.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (MovementManager.getNoMove()) {
					
				}
				else {
				if (second) {
					if (event.getCode() == KeyCode.W) {	  
		                frog.move(0, -movement);
		                frog.setImage(imgW1);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 frog.move(-movementX, 0);
		            	 frog.setImage(imgA1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 frog.move(0, movement);
		            	 frog.setImage(imgS1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 frog.move(movementX, 0);
		            	 frog.setImage(imgD1);
		            	 second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {	            	
					frog.move(0, -movement);
					frog.setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 frog.move(-movementX, 0);
	            	 frog.setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 frog.move(0, movement);
	            	 frog.setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 frog.move(movementX, 0);
	            	 frog.setImage(imgD2);
	            	 second = true;
	            }
	        }
			}
		});
	} 
	
	/**
	 * handle movements and other actions when key is released
	 * @param frog to be act on
	 */
	public void handleKeyRelease(Frog frog) {
		//Frog movement when key released
				frog.setOnKeyReleased(new EventHandler<KeyEvent>() {
					public void handle(KeyEvent event) {
						if (MovementManager.getNoMove()) {}
						else {
							if (event.getCode() == KeyCode.W) {	  
								frog.move(0, -movement);
								frog.setImage(imgW1);
				                second = false;
				            }
				            else if (event.getCode() == KeyCode.A) {	            	
				            	 frog.move(-movementX, 0);
				            	 frog.setImage(imgA1);
				            	 second = false;
				            }
				            else if (event.getCode() == KeyCode.S) {	            	
				            	 frog.move(0, movement);
				            	 frog.setImage(imgS1);
				            	 second = false;
				            }
				            else if (event.getCode() == KeyCode.D) {	            	
				            	 frog.move(movementX, 0);
				            	 frog.setImage(imgD1);
				            	 second = false;
				            }
						}
						if(event.getCode() == KeyCode.ENTER) {
							if(Tutorial.getStep() == 1) {
								Tutorial.setStep(2);
								tutorial.stepTwo();
							}
							else if(Tutorial.getStep() == 2) {
								tutorial.removeState();
								GameStateManager.MainManager.launchStartMenu();
							}
							}
					}
					
				});
	}
}
