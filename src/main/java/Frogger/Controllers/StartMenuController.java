package Frogger.Controllers;

import Frogger.Entity.Frog;
import Frogger.GameState.StartMenu;
import Frogger.HUD.Button;
import Frogger.HUD.MenuCursor;
import Frogger.Manager.GameStateManager;
import Frogger.Manager.MovementManager;
import Frogger.Manager.ScoreManager;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * A class that controls the movements of cursor in the StartMenu
 * @author leeka
 *
 */
public class StartMenuController {
	
	private boolean second = false;
	
	/**
	 * construct a named instance of StartMenuController
	 * @param cursor to be controlled
	 * @param button to be act on
	 * @param button to be act on
	 * @param StartMenu object containing the cursor
	 */
	public StartMenuController(MenuCursor cursor, Button start, Button tutorial, StartMenu menu) {
		handleKeyRelease(cursor, start, tutorial, menu);
	}
	
	
	/**
	 * handle movements and other actions when key is released
	 * @param cursor to be controlled
	 * @param button to be act on
	 * @param button to be act on
	 * @param StartMenu object containing the cursor
	 */
	public void handleKeyRelease(MenuCursor cursor, Button start, Button tutorial, StartMenu menu) {
				cursor.setOnKeyReleased(new EventHandler<KeyEvent>() {
					public void handle(KeyEvent event) {
						if (event.getCode() == KeyCode.UP) {
							if(cursor.getFlag() == 0) {
								start.setButton(true);
								cursor.setFlag(1);
							}
							else if(cursor.getFlag() == 2) {
								start.setButton(true);
			                	tutorial.setButton(false);
			                	cursor.setFlag(1);
			                }							
			                second = false;
			            }
			            else if (event.getCode() == KeyCode.DOWN) {	    
			            	if(cursor.getFlag() == 0) {
								start.setButton(true);
								cursor.setFlag(1);
							}
			            	else if(cursor.getFlag() == 1) {
			                	tutorial.setButton(true);
			                	start.setButton(false);
			                	cursor.setFlag(2);
			                }
			            	 second = false;
			            }
			            else if (event.getCode() == KeyCode.ENTER) {	            	
			            	if(cursor.getFlag() == 1) {
			            		menu.removeState();
								menu.stop();
								GameStateManager.MainManager.launchLevelOne();
			            	}
			            	if(cursor.getFlag() == 2) {
			            		menu.removeState();
								menu.stop();
								GameStateManager.MainManager.launchTutorial();
			            	}
			            	 second = false;
			            }
			        
					}
					
				});
	}
	
	
} 
	
