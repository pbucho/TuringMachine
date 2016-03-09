package pt.bucho.turing.core.test.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.turing.api.entities.Direction;
import pt.bucho.turing.api.entities.State;
import pt.bucho.turing.api.entities.TapeChar;
import pt.bucho.turing.api.entities.Transition;
import pt.bucho.turing.core.entities.StateImpl;
import pt.bucho.turing.core.entities.TapeCharImpl;
import pt.bucho.turing.core.entities.TransitionImpl;

public class TransitionTest {

	private Transition transition;
	
	private State state, state2;
	private TapeChar character, char2;
	
	@Before
	public void setUp() throws Exception {
		transition = new TransitionImpl();
		
		state = new StateImpl("state");
		state2 = new StateImpl("state2");
		character = new TapeCharImpl('a');
		char2 = new TapeCharImpl('b');
	}

	@Test
	public void departingStateTest() {
		transition.setDepartingState(state);
		assertEquals(state, transition.getDepartingState());
	}
	
	@Test
	public void arrivingStateTest() {
		transition.setArrivingState(state);
		assertEquals(state, transition.getArrivingState());
	}
	
	@Test
	public void conditionCharTest() {
		transition.setConditionChar(character);
		assertEquals(character, transition.getConditionChar());
	}
	
	@Test
	public void newCharTest(){
		transition.setNewChar(character);
		assertEquals(character, transition.getNewChar());
	}
	
	@Test
	public void directionTest() {
		transition.setDirection(Direction.RIGHT);
		assertEquals(Direction.RIGHT, transition.getDirection());
	}
	
	@Test
	public void toStringTest() {
		transition.setDepartingState(state);
		transition.setConditionChar(character);
		transition.setNewChar(char2);
		transition.setDirection(Direction.STAY);
		transition.setArrivingState(state2);
		
		assertEquals("state--a->b,S--state2", transition.toString());
	}
	
	@Test
	public void equalsTest() {
		Transition tr1 = newTransition();
		Transition tr2 = newTransition();
		Transition tr3 = newTransition();
		tr3.setConditionChar(char2);
		
		assertTrue(tr1.equals(tr1));
		assertTrue(tr2.equals(tr2));
		assertTrue(tr3.equals(tr3));
		
		assertTrue(tr1.equals(tr2));
		assertTrue(tr2.equals(tr1));
		
		assertFalse(tr1.equals(tr3));
		assertFalse(tr3.equals(tr2));
		
		assertFalse(tr1.equals(null));
		
	}
	
	private Transition newTransition() {
		Transition tr = new TransitionImpl();
		tr.setDepartingState(state);
		tr.setArrivingState(state2);
		tr.setDirection(Direction.RIGHT);
		tr.setConditionChar(character);
		tr.setNewChar(char2);
		return tr;
	}

}
