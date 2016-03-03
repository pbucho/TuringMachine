package pt.bucho.turing.api.entities;

import pt.bucho.turing.api.exceptions.TuringException;

public interface Tape {

	public TapeChar moveLeft();
	public TapeChar moveRight();
	public void setChar(TapeChar character);
	public TapeChar getChar();
	
}
