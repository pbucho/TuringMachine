package pt.bucho.mturing;

import java.util.LinkedList;
import java.util.List;

public class State {
	
	public final String name;
	List<Transition> transitions = new LinkedList<Transition>();
	boolean acceptState;
	boolean rejectState;
	boolean initialState;

	public State(String name){
		this.name = name;
	}
	
	public State(String name, int stateType) throws InconsistentStateException{ // -1 rejeição, 0 iniciação, 1 aceitação, 2 normal
		this(name);
		switch(stateType){
			case -1:
				rejectState = true;
				break;
			case 0:
				initialState = true;
				break;
			case 1:
				acceptState = true;
		}
		checkStateConsistency();
	}
	
	public State(String name, int stateType, List<Transition> t) throws InconsistentStateException{
		this(name, stateType);
		transitions.addAll(t);
	}
	
	public State(String name, Transition t){
		this(name);
		transitions.add(t);
	}
	
	public State(String name, List<Transition> t){
		this(name);
		transitions.addAll(t);
	}
	
	public List<Transition> getTransitions(){
		return transitions;
	}
	
	public Transition[] getTransitionsArray(){
		Transition[] trans = new Transition[transitions.size()];
		for(int i = 0; i < transitions.size(); i++){
			trans[i] = transitions.get(i);
		}
		return trans;
	}
	
	public void addTransition(Transition t){
		transitions.add(t);
	}
	
	public void addTransitions(List<Transition> t){
		transitions.addAll(t);
	}
	
	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}

	private boolean checkStateConsistency() throws InconsistentStateException{
		if(acceptState && rejectState)
			throw new InconsistentStateException("State " + name + " is both accept and reject state");
		else
			return true;
	}
	
	public boolean isRejectState() {
		return rejectState;
	}

	public void setRejectState(boolean rejectState) throws InconsistentStateException {
		this.rejectState = rejectState;
		checkStateConsistency();
	}

	public boolean isAcceptState() {
		return acceptState;
	}

	public void setAcceptState(boolean acceptState) throws InconsistentStateException {
		this.acceptState = acceptState;
		checkStateConsistency();
	}

	public boolean isInitialState() {
		return initialState;
	}

	public void setInitialState(boolean initialState) {
		this.initialState = initialState;
	}
	
	@Override
	public String toString(){
		return name;
	}
}
