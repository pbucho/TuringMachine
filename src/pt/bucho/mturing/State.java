package pt.bucho.mturing;

import java.util.LinkedList;
import java.util.List;

public class State {
	
	public static final int reject = -1;
	public static final int initial = 0;
	public static final int accept = 1;
	
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
			case reject:
				rejectState = true;
				break;
			case initial:
				initialState = true;
				break;
			case accept:
				acceptState = true;
		}
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
	
	public boolean isRejectState() {
		return rejectState;
	}

	public void setRejectState(boolean rejectState) {
		this.rejectState = rejectState;
		if(rejectState)
			this.acceptState = false;
	}

	public boolean isAcceptState() {
		return acceptState;
	}

	public void setAcceptState(boolean acceptState) {
		this.acceptState = acceptState;
		if(acceptState)
			this.rejectState = false;
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
