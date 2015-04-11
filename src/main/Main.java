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
		try {
			List<State> states = new LinkedList<State>();
			
			State[] st = new State[5];
			
			st[0] = new State("q1");
			st[1] = new State("q0", State.initial);
			st[2] = new State("q2");
			st[3] = new State("q3");
			st[4] = new State("qa", State.accept);
			
			Transition[] ts = new Transition[7];
			
			ts[0] = new Transition('1', '1', Transition.right, st[0]);
			ts[1] = new Transition('1', '1', Transition.right, st[2]);
			ts[2] = new Transition('1', '1', Transition.right, st[1]);
			ts[3] = new Transition(blankChar, blankChar, Transition.stay, st[4]);
			ts[4] = new Transition(blankChar, '1', Transition.right, st[3]);
			ts[5] = new Transition(blankChar, '1', Transition.left, st[4]);
			ts[6] = new Transition(blankChar, '1', Transition.stay, st[4]);
			
			st[0].addTransition(ts[0]);
			st[0].addTransition(ts[3]);
			st[1].addTransition(ts[1]);
			st[1].addTransition(ts[4]);
			st[2].addTransition(ts[2]);
			st[2].addTransition(ts[6]);
			st[3].addTransition(ts[5]);
			
			for(State s : st)
				states.add(s);
			
			Machine mq = new Machine(states);
			
			mq.runMachine("".toCharArray());
			
			System.out.println(mq);

			
		} catch (InconsistentStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
