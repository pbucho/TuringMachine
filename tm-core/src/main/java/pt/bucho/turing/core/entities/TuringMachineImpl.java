package pt.bucho.turing.core.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pt.bucho.turing.api.entities.State;
import pt.bucho.turing.api.entities.TapeChar;
import pt.bucho.turing.api.entities.Transition;
import pt.bucho.turing.api.entities.TuringMachine;
import pt.bucho.turing.api.exceptions.TuringException;

public class TuringMachineImpl implements TuringMachine {

	private Map<String, State> states;

	public TuringMachineImpl() {
		states = new HashMap<String, State>();
	}

	public void run() {
		// TODO Auto-generated method stub

	}

	public Map<String, State> getStates() {
		return states;
	}

	public void setStates(Map<String, State> states) {
		// TODO Auto-generated method stub

	}

	public boolean isHalted() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setHalted(boolean halted) {

	}

	public void setInput(TapeChar[] input) {
		// TODO Auto-generated method stub

	}

	public void addState(State state) throws TuringException {
		try {
			if (states.get(state.getName()) != null) {
				throw new TuringException("No duplicate state names can exist");
			}
			states.put(state.getName(), state);
		} catch (NullPointerException e) {
			throw new TuringException("State can't be null");
		}
	}

	public List<Transition> getTransitions() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTransitions(List<Transition> transitions) {
		// TODO Auto-generated method stub

	}

	public void addTransition(Transition transition) {
		// TODO Auto-generated method stub

	}

	public TapeChar[] getInput() {
		// TODO Auto-generated method stub
		return null;
	}

}
