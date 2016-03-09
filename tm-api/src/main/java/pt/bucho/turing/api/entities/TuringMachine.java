package pt.bucho.turing.api.entities;

import java.util.List;
import java.util.Map;

import pt.bucho.turing.api.exceptions.TuringException;

public interface TuringMachine extends Runnable {
	
	public Map<String,State> getStates();
	public void setStates(Map<String,State> states);
	public void addState(State state) throws TuringException;
	
	public List<Transition> getTransitions();
	public void setTransitions(List<Transition> transitions);
	public void addTransition(Transition transition);
	
	public TapeChar[] getInput();
	public void setInput(TapeChar[] input);
	
	public boolean isHalted();
	public void setHalted(boolean halted);
	
}
