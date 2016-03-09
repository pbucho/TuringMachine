package pt.bucho.turing.core.test.entities.turingmachine;

import java.util.HashMap;
import java.util.Map;

import pt.bucho.turing.api.entities.Direction;
import pt.bucho.turing.api.entities.State;
import pt.bucho.turing.api.entities.TapeChar;
import pt.bucho.turing.api.entities.Transition;
import pt.bucho.turing.api.entities.TuringMachine;
import pt.bucho.turing.core.entities.StateImpl;
import pt.bucho.turing.core.entities.TapeCharImpl;
import pt.bucho.turing.core.entities.TransitionImpl;
import pt.bucho.turing.core.entities.DeterministicTuringMachine;

public abstract class AbstractTuringMachineTest {

	protected TuringMachine turingMachine;
	
	protected Map<String,State> states;
	protected State state1, state2;
	protected Transition transition;
	protected TapeChar conditionChar, newChar;
	
	protected void setUp() throws Exception {
		turingMachine = new DeterministicTuringMachine();
		
		state1 = new StateImpl("state1");
		state2 = new StateImpl("state2");
		states = new HashMap<String, State>();
		states.put("state1", state1);
		states.put("state2", state2);
		
		conditionChar = new TapeCharImpl('a');
		newChar = new TapeCharImpl('b');
		
		transition = new TransitionImpl();
		transition.setDepartingState(state1);
		transition.setArrivingState(state2);
		transition.setConditionChar(conditionChar);
		transition.setNewChar(newChar);
		transition.setDirection(Direction.RIGHT);
		
		turingMachine.addTransition(transition);
	}

}
