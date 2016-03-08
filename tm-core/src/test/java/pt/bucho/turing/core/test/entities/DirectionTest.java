package pt.bucho.turing.core.test.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import pt.bucho.turing.api.entities.Direction;

public class DirectionTest {

	@Test
	public void leftTest() {
		assertEquals("L", Direction.LEFT.toString());
	}
	
	@Test
	public void rightTest() {
		assertEquals("R", Direction.RIGHT.toString());
	}
	
	@Test
	public void stayTest() {
		assertEquals("S", Direction.STAY.toString());
	}

}
