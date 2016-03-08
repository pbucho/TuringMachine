package pt.bucho.turing.core.test.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pt.bucho.turing.api.entities.State;
import pt.bucho.turing.core.entities.StateImpl;
import pt.bucho.turing.core.entities.TransitionImpl;

public class StateTest {

	private State state, state2, state3;
	
	@Test
	public void stateNoArgConstructorTest() {
		state = new StateImpl();
		state.setName("state");
		
		assertEquals("state", state.getName());
	}
	
	@Test
	public void stateArgConstructorTest() {
		state = new StateImpl("state");
		
		assertEquals("state", state.getName());
	}
	
	@Test
	public void acceptingStateTest() {
		state = new StateImpl();
		
		assertFalse(state.isAcceptingState());
		
		state.setAcceptingState(true);
		
		assertTrue(state.isAcceptingState());
	}
	
	@Test
	public void initialStateTest() {
		state = new StateImpl();
		
		assertFalse(state.isInitialState());
		
		state.setInitialState(true);
		
		assertTrue(state.isInitialState());
	}
	
	@Test
	public void toStringTest() {
		state = new StateImpl("state");
		
		assertEquals("state", state.toString());
	}
	
	@Test
	public void equalsTest() {
		state = new StateImpl("state");
		state.addTransition(new TransitionImpl());
		state.setAcceptingState(true);
		state.setInitialState(true);
		
		state2 = new StateImpl("state");
		state2.addTransition(new TransitionImpl());
		state2.setAcceptingState(true);
		state2.setInitialState(true);
		
		state3 = new StateImpl("state3");
		state3.addTransition(null);
		state3.setAcceptingState(false);
		state3.setInitialState(true);
		
		assertFalse(state.equals(null));
		assertFalse(state.equals(new Object()));
		assertTrue(state.equals(state2));
		assertFalse(state.equals(state3));
		
	}

}
