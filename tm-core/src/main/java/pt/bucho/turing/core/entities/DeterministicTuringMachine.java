package pt.bucho.turing.core.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pt.bucho.turing.api.entities.State;
import pt.bucho.turing.api.entities.TapeChar;
import pt.bucho.turing.api.entities.Transition;
import pt.bucho.turing.api.entities.TuringMachine;
import pt.bucho.turing.api.exceptions.TuringException;

public class DeterministicTuringMachine implements TuringMachine {

	private Map<String, State> states;
	private List<Transition> transitions;
	private boolean isHalted;

	public DeterministicTuringMachine() {
		states = new HashMap<String, State>();
		transitions = new ArrayList<Transition>();
		isHalted = false;
	}

	public Map<String, State> getStates() {
		return states;
	}

	public void setStates(Map<String, State> states) {
		this.states = states;
	}

	public boolean isHalted() {
		return isHalted;
	}

	public void setHalted(boolean halted) {
		this.isHalted = halted;
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
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) throws TuringException {
		for(Transition transition : transitions){
			addTransition(transition);
		}
	}

	public void addTransition(Transition transition) throws TuringException {
		for (Transition existingTransition : transitions) {
			if (transition.equals(existingTransition)) {
				throw new TuringException(
						"Deterministic machine can't have ambiguous transitions");
			}
		}
		transitions.add(transition);
	}

	public void execute(TapeChar[] input) {
		// TODO Auto-generated method stub
		
	}

}
