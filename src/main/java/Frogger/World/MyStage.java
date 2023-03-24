package Frogger.World;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * Class for MyStage
 * @author leeka
 *
 */
public class MyStage extends World{
	MediaPlayer mediaPlayer;
	
	/**
	 * Play Music
	 */
	public void playMusic() {
		String musicFile = "Resources/Music/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	/**
	 * Stop Music
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
