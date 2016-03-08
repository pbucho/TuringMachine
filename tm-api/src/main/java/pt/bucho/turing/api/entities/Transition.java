package pt.bucho.turing.api.entities;

public interface Transition {
	
	public State getDepartingState();
	public void setDepartingState(State state);
	
	public State getArrivingState();
	public void setArrivingState(State state);
	
	public TapeChar getConditionChar();
	public void setConditionChar(TapeChar character);
	
	public TapeChar getNewChar();
	public void setNewChar(TapeChar character);

	// one?
	public Direction getDirection();
	public void setDirection(Direction direction);
	
}
