package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Frogger.Manager.MovementManager;

class MovementManagerTest {

	@Test
	void testGetMovement() {
		double movement;
		
		MovementManager manager = new MovementManager();
		movement = manager.getMovement();
		
		assertEquals(movement, 13.3333333*2);
	}
	
	@Test
	void testGetMovementX() {
		double movementX;
		
		MovementManager manager = new MovementManager();
		movementX = manager.getMovementX();
		
		assertEquals(movementX, 13.3333333*2);
	}
	
	@Test
	void testGetNoMove() {
		boolean noMove;
		
		MovementManager manager = new MovementManager();
		noMove = manager.getNoMove();
		
		assertEquals(noMove, manager.noMove);
	}
	
	@Test
	void testSetNoMove() {
		boolean noMove;
		
		MovementManager manager = new MovementManager();
		manager.setNoMove(true);
		
		noMove = manager.getNoMove();
		
		assertEquals(noMove, true);
	}

}
