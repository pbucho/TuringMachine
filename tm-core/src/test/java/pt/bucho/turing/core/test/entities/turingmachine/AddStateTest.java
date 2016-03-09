package pt.bucho.turing.core.test.entities.turingmachine;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.turing.api.entities.State;
import pt.bucho.turing.api.exceptions.TuringException;
import pt.bucho.turing.core.entities.StateImpl;

public class AddStateTest extends AbstractDeterministicTuringMachineTest {

	private State state1, state2;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		state1 = new StateImpl("state1");
		state2 = new StateImpl("state2");
	}

	@Test
	public void happyPath() throws TuringException {
		turingMachine.addState(state1);
		turingMachine.addState(state2);

		assertSame(state1, turingMachine.getStates().get("state1"));
		assertSame(state2, turingMachine.getStates().get("state2"));
	}

	@Test
	public void noDuplicateStateNamesTest() {
		state2.setName("state1");
		try {
			turingMachine.addState(state1);
			turingMachine.addState(state2);
			fail("Should have thrown exception");
		} catch (TuringException e) {
			// all ok
		}
	}

	@Test
	public void nullAsStateThrowsExceptionTest() {
		try {
			turingMachine.addState(null);
			fail("Should have thrown exception");
		} catch (TuringException e) {
			// all ok
		}
	}

}
