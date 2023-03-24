package Frogger.Controllers;

import Frogger.Entity.Frog;
import Frogger.Manager.MovementManager;
import Frogger.Manager.ScoreManager;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * A class that controls the movements of the frog in the level stages
 * @author leeka
 *
 */
public class LevelController {
	
	Image imgW1,imgA1,imgS1,imgD1,imgW2,imgA2,imgS2,imgD2;
	private boolean second = false;
	double movement = MovementManager.getMovement();
	double movementX = MovementManager.getMovementX();
	Frog frog;
	int imgSize = Frog.imgSize;
	
	/**
	 * construct a named instance of LevelController in LevelOne & LevelTwo
	 * @param frog to be controlled
	 */
	public LevelController(Frog frog) {
		this.frog = frog;
		createSpriteOne();
		handleKeyPress(frog);
		handleKeyRelease(frog);		
	}
	
	/**
	 * construct a named instance of LevelController in LevelThree
	 * @param frog to be controlled
	 * @param indication that controller to be created is for LevelThree
	 */
	public LevelController(Frog frog, boolean x) {
		this.frog = frog;
		createSpriteTwo();
		handleKeyPress(frog);
		handleKeyRelease(frog);		
	}
	
	/**
	 * Set up frog graphics/Sprite for LevelOne & Two
	 */
	public void createSpriteOne() {
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
	 * Set up frog graphics/Sprite for LevelOne & Three
	 */
	public void createSpriteTwo() {
		imgSize = 80;
		imgW1 = new Image("file:Resources/Frog/BalloonUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:Resources/Frog/BalloonLeft2.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:Resources/Frog/BalloonDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:Resources/Frog/BalloonRight2.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:Resources/Frog/BalloonUp.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:Resources/Frog/BalloonLeft1.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:Resources/Frog/BalloonDown.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:Resources/Frog/BalloonRight1.png", imgSize, imgSize, true, true);
	}
	
	/**
	 * handle movements and other actions when key is pressed
	 * @param frog to be act on
	 */
	public void handleKeyPress(Frog frog) {
		frog.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (MovementManager.getNoMove()) {}
				else {
				if (second) {
					if (event.getCode() == KeyCode.W) {	  
		                frog.move(0, -movement);
		                ScoreManager.setChangeScore(false);
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
							if (frog.getY() < frog.getW()) {
								ScoreManager.forwardScore();
								frog.setW(frog.getY());
							}
							
							if(frog.getReachEnd() == true) {
								frog.setImage(imgW1);
				                second = false;
							}
							else {
								frog.move(0, -movement);
								frog.setImage(imgW1);
				                second = false;
							}
							frog.resetReachEnd();
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
					}
					
				});
	}
}
