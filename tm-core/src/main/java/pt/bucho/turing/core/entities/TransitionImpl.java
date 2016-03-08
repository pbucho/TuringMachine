package pt.bucho.turing.core.entities;

import pt.bucho.turing.api.entities.Direction;
import pt.bucho.turing.api.entities.State;
import pt.bucho.turing.api.entities.TapeChar;
import pt.bucho.turing.api.entities.Transition;

public class TransitionImpl implements Transition {

	private State departingState;
	private State arrivingState;
	private TapeChar conditionChar;
	private TapeChar newChar;
	private Direction direction;
	
	public State getDepartingState() {
		return departingState;
	}

	public void setDepartingState(State state) {
		this.departingState = state;
	}

	public State getArrivingState() {
		return arrivingState;
	}

	public void setArrivingState(State state) {
		this.arrivingState = state;
	}

	public TapeChar getConditionChar() {
		return conditionChar;
	}

	public void setConditionChar(TapeChar character) {
		this.conditionChar = character;
	}

	public TapeChar getNewChar() {
		return newChar;
	}

	public void setNewChar(TapeChar character) {
		this.newChar = character;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return departingState + "--" + conditionChar + "->" + newChar + "," + direction + "--" + arrivingState;
	}

}
