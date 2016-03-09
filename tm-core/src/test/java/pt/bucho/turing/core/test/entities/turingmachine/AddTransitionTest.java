package pt.bucho.turing.core.test.entities.turingmachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.turing.api.entities.Transition;
import pt.bucho.turing.api.exceptions.TuringException;

public class AddTransitionTest extends AbstractDeterministicTuringMachineTest {

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void happyPath() throws TuringException {
		turingMachine.addTransition(transition);
		List<Transition> actualTransitions = turingMachine.getTransitions();

		assertEquals(1, actualTransitions.size());
		assertSame(transition, actualTransitions.get(0));

	}

	@Test
	public void noAmbiguousTransitionsTest() {
		try {
			turingMachine.addTransition(transition);
			turingMachine.addTransition(transition);
			fail("Should have thrown exception");
		} catch (TuringException e) {
			// all ok
		}
	}

	@Test
	public void noAmbiguousTransitionsTestSetMethodTest() {
		List<Transition> transitions = new ArrayList<Transition>();
		transitions.add(transition);
		transitions.add(transition);
		try {
			turingMachine.setTransitions(transitions);
			fail("Should have thrown exception");
		} catch (TuringException e) {
			// all ok
		}
	}

}
