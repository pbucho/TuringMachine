package pt.bucho.turing.api.entities;

import java.util.Map;

public interface TuringMachine extends Runnable {
	
	public Map<String,State> getStates();
	public void setStates(Map<String,State> states);
	
	public void setInput(TapeChar[] input);
	
	public boolean isHalted();
	public void setHalted(boolean halted);
	
}
