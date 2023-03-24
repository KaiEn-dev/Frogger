package Frogger.Manager;


/**
 * Class for ScoreManager
 * Handle game scores
 * @author leeka
 *
 */
public class ScoreManager {
	
	public static int points = 0;
	public static boolean changeScore = false;
	
	/**
	 * get whether changing scores is allowed
	 * @return changeScore boolean
	 */
	public static boolean getChangeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	/**
	 * get total Points
	 * @return points
	 */
	public static int getPoints() {
		return points;
	}
	
	/**
	 * add value to total points
	 * @param value to be added
	 */
	public static void addPoints(int x) {
		points += x;
	}
	
	/**
	 * set whether change score is allowed
	 * @param boolean
	 */
	public static void setChangeScore(boolean x) {
		changeScore = x;
	}
	
	/**
	 * Reset total points to zero
	 */
	public static void resetScore() {
		points = 0;
		changeScore = false;
	}
	
	/**
	 * handle score change when frog dies
	 */
	public static void collideScore() {
		if (points>50) { //minus score
			addPoints(-50);
			setChangeScore(true);
		}
	}
	
	/**
	 * handle score change when frog reaches the end
	 */
	public static void endScore() {
		ScoreManager.addPoints(50);
		ScoreManager.setChangeScore(true);
	}
	
	/**
	 * handle score change when frog moves to unexplored y axis
	 */
	public static void forwardScore() {
		ScoreManager.addPoints(10);
		ScoreManager.setChangeScore(true);
	}
}
