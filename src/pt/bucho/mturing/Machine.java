package pt.bucho.mturing;

import java.util.LinkedList;
import java.util.List;

// uma MT contém

//	Conjunto de estados
//	Linguagem
//	Função de transição
//	estado de iniciação
//	conjunto de estados de terminação

public class Machine {
	
	List<State> states = new LinkedList<State>();
	Tape tape;
	boolean halted = false;
	boolean accepted = false;
	
	public Machine(State s){
		states.add(s);
		checkInitialState();
	}
	
	public Machine(List<State> sl){
		states.addAll(sl);
		checkInitialState();
	}
	
	private boolean checkInitialState(){
		boolean one = false;
		for(State s : states){
			if(s.initialState){
				if(!one)
					one = true;
				else
					throw new MultipleInitialStatesException("Machine has multiple initial states. Last found: " + s.name);
			}
		}
		if(!one)
			throw new NoInitialStateException("Machine has no initial state");
		else{
			if(!states.get(0).initialState){
				int count = 0;
				for(State s : states){
					if(s.initialState){
						states.remove(count);
						states.add(0, s);
					}
					count++;
				}
			}
			return true;
		}	
	}
	
	public void runMachine(char[] inputString){
		tape = new Tape(inputString);
		
		State currentState = states.get(0);
		while(true){
			boolean compatibleState = false;
			Transition[] trans = currentState.getTransitionsArray();
			for(Transition t : trans){
				if(t.initialChar == tape.getCurrentChar()){
					tape.setCurrentChar(t.finalChar);
					switch(t.move){
						case -1:
							tape.moveLeft();
							break;
						case 1:
							tape.moveRight();
					}
					currentState = t.finalState;
					compatibleState = true;
					if(currentState.isAcceptState()){
						halted = true;
						accepted = true;
					}else if(currentState.isRejectState()){
						halted = true;
					}
					break;
				}
			}
			if(!compatibleState){
				String currCh = "" + tape.getCurrentChar();
				if(tape.getCurrentChar() == Position.blankChar)
					currCh = "BLANK";
				
				String msg = "There is no transition for char " + currCh + " in state " + currentState.name;
				throw new HaltedException(msg);
			}
			if(halted)
				break;
		}
	}
	
	public boolean isHalted(){
		return halted;
	}
	
	public boolean hasAccepted(){
		if(halted)
			return accepted;
		else
			return false;
	}
	
	public boolean hasRejected(){
		if(halted)
			return !accepted;
		else
			return false;
	}
	
	@Override
	public String toString(){
		String out = "";
		out += tape.toString() + ", ";
		out += "Halted: " + halted + ", ";
		out += "Accepted: " + hasAccepted();
		
		return out;
	}

}
