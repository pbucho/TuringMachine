package pt.bucho.turing.api.entities;

import java.util.List;

public interface State {
	
	public String getName();
	public void setName(String name);
	
	public List<Transition> getTransitions();
	public void setTransitions(List<Transition> transitions);
	public void addTransition(Transition transition);
	
	public boolean isAcceptingState();
	public void setAcceptingState(boolean accepting);
	
	public boolean isInitialState();
	public void setInitialState(boolean initial);
	
}
