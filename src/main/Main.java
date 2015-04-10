package main;

import java.util.LinkedList;
import java.util.List;

import pt.bucho.mturing.InconsistentStateException;
import pt.bucho.mturing.Machine;
import pt.bucho.mturing.Position;
import pt.bucho.mturing.State;
import pt.bucho.mturing.Transition;

public class Main {

	public static final char blankChar = Position.blankChar;
	
	public static void main(String[] args) {
		
		List<State> states = new LinkedList<State>();
		
		State aceitacao, inicial, intermedio;
		try {
			aceitacao = new State("qa", 1);
			inicial = new State("q0", 0);
			intermedio = new State("q1", 1);
			
			List<Transition> trInicial= new LinkedList<Transition>();
			List<Transition> trInter= new LinkedList<Transition>();
			
			trInicial.add(new Transition('0', '0', 1, intermedio));
			trInicial.add(new Transition('1', '1', 1, intermedio));
			trInicial.add(new Transition(blankChar, blankChar, 1, aceitacao));
			trInter.add(new Transition('0', '0', 1, inicial));
			trInter.add(new Transition('1', '1', 1, inicial));
			
			inicial.addTransitions(trInicial);
			intermedio.addTransitions(trInter);
			
			states.add(inicial);
			states.add(intermedio);
			states.add(aceitacao);
			
			Machine turing = new Machine(states);
			
			turing.runMachine(("01" + blankChar).toCharArray());
			
			System.out.println(turing);
			
		} catch (InconsistentStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
