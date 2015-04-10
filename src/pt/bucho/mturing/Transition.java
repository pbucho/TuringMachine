package pt.bucho.mturing;

public class Transition {

	public final char initialChar;
	public final char finalChar;
	public final int move;	// -1 left, 0 stay, 1 right
	public final State finalState;
	
	public Transition(char i, char f, int m, State s){
		this.initialChar = i;
		this.finalChar = f;
		this.move = m;
		this.finalState = s;
	}
	
}
