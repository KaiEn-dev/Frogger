package Frogger.GameState;

import Frogger.Controllers.StartMenuController;
import Frogger.HUD.BackgroundImage;
import Frogger.HUD.Button;
import Frogger.HUD.MenuCursor;
import Frogger.World.MyStage;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class for StartMenu GameState
 * @author leeka
 *
 */
public class StartMenu extends GameState {
	
	BackgroundImage startmenuback;
	Button start;
	Button tutorial;
	MenuCursor cursor;
	
	
	/**
	 * Start GameState and initialize all actors
	 * @param primaryStage
	 * @param menu
	 */
	public void start(Stage primaryStage, StartMenu menu)  {
		background = new MyStage();
	    Scene scene  = new Scene(background,558,780);	    

		startmenuback = new BackgroundImage("file:Resources/Landscape/MainMenu.png");
	    
		background.add(startmenuback);
		
		
		start = new Button(1);
		tutorial = new Button(2);
		cursor = new MenuCursor();
		StartMenuController controller = new StartMenuController(cursor, start, tutorial, menu);
		
		background.add(cursor);
		background.add(start);
		background.add(tutorial);
		
		
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start();  
	}
	
	/**
	 * Remove GameState
	 */
	public void removeState() {
		background.remove(start);
		background.remove(tutorial);
		background.remove(cursor);
		background.remove(startmenuback);
		background.stopMusic();
	}
	
}
