package pt.bucho.turing.core.test.entities;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.turing.api.entities.State;
import pt.bucho.turing.api.entities.TuringMachine;
import pt.bucho.turing.core.entities.StateImpl;
import pt.bucho.turing.core.entities.TuringMachineImpl;

public class TuringMachineTest {

	private TuringMachine turingMachine;
	
	private Map<String,State> states;
	private State state1, state2;
	
	@Before
	public void setUp() throws Exception {
		turingMachine = new TuringMachineImpl();
		
		state1 = new StateImpl("state1");
		state2 = new StateImpl("state2");
		states = new HashMap<String, State>();
		states.put("state1", state1);
		states.put("state2", state2);
		
		turingMachine.setStates(states);
		turingMachine.setHalted(false);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
