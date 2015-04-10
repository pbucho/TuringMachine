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
		else
			return true;
			
	}
	
	public void runMachine(char[] inputString){
		tape = new Tape(inputString);
		
		while(true){
			
		}
	}

}
