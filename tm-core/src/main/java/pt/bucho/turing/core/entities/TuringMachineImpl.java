package pt.bucho.turing.core.entities;

import java.util.HashMap;
import java.util.Map;

import pt.bucho.turing.api.entities.State;
import pt.bucho.turing.api.entities.TapeChar;
import pt.bucho.turing.api.entities.TuringMachine;

public class TuringMachineImpl implements TuringMachine {

	private Map<String,State> states;
	
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
	
}
