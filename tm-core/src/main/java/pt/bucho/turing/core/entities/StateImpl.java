package pt.bucho.turing.core.entities;

import java.util.ArrayList;
import java.util.List;

import pt.bucho.turing.api.entities.State;
import pt.bucho.turing.api.entities.Transition;

public class StateImpl implements State {

	private String name;
	private List<Transition> transitions;
	private boolean acceptingState;
	private boolean initialState;
	
	public StateImpl(String stateName) {
		transitions = new ArrayList<Transition>();
		this.name = stateName;
	}
	
	public StateImpl() {
		this("");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}

	public void addTransition(Transition transition) {
		transitions.add(transition);
	}

	public boolean isAcceptingState() {
		return acceptingState;
	}

	public void setAcceptingState(boolean accepting) {
		this.acceptingState = accepting;
	}

	public boolean isInitialState() {
		return initialState;
	}

	public void setInitialState(boolean initial) {
		this.initialState = initial;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(!(obj instanceof State)){
			return false;
		}
		State other = (State) obj;
		if(!name.equals(other.getName())){
			return false;
		}
		if(acceptingState ^ other.isAcceptingState()){
			return false;
		}
		return !(initialState ^ other.isInitialState());
	}

}
