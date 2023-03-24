package Frogger.Manager;

/**
 * Class for Movement Manager
 * To enable or disable entities to move and set values for each movement
 * @author leeka
 *
 */
public class MovementManager {
	public static boolean noMove = false;
	public static final double movement = 13.3333333*2;
	public static final double movementX = 13.3333333*2;
	
	/**
	 * get Movement variable
	 * @return Movement
	 */
	public static double getMovement() {
		return movement;
	}
	
	/**
	 * get MovementX variable
	 * @return Movement X
	 */
	public static double getMovementX() {
		return movementX;
	}
	
	/**
	 * get whether entities can move
	 * @return noMove boolean
	 */
	public static boolean getNoMove() {
		return noMove;
	}
	
	/**
	 * set whether entities can move
	 * @param boolean
	 */
	public static void setNoMove(boolean x) {
		noMove = x;
	}
	
}
