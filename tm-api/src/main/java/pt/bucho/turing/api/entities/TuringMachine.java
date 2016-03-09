package pt.bucho.turing.api.entities;

import java.util.List;
import java.util.Map;

import pt.bucho.turing.api.exceptions.TuringException;

public interface TuringMachine {
	
	public Map<String,State> getStates();
	public void setStates(Map<String,State> states);
	public void addState(State state) throws TuringException;
	
	public List<Transition> getTransitions();
	public void setTransitions(List<Transition> transitions) throws TuringException;
	public void addTransition(Transition transition) throws TuringException;
	
	public void execute(TapeChar[] input);
	
	public boolean isHalted();
	public void setHalted(boolean halted);
	
}
