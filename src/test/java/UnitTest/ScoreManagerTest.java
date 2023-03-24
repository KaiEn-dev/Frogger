package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Frogger.Manager.ScoreManager;

class ScoreManagerTest {

	@Test
	void testAddPoints() {
		ScoreManager manager = new ScoreManager();
		int points = manager.points;
		manager.addPoints(50);
		
		assertEquals(manager.points, points + 50);
	}
	
	@Test
	void testResetScore() {		
		ScoreManager manager = new ScoreManager();
		manager.resetScore();
		
		assertEquals(manager.points, 0);
		assertEquals(manager.changeScore, false);
	}
	
	@Test
	void testEndScore() {		
		ScoreManager manager = new ScoreManager();
		int score = manager.points;
		manager.endScore();
		
		assertEquals(manager.points, score+50);
		assertEquals(manager.changeScore, true);
	}
	
	
}
