package pt.bucho.turing.api.entities;

import pt.bucho.turing.api.exceptions.TuringException;

public interface Tape {

	public TapeChar moveLeft() throws TuringException;
	public TapeChar moveRight() throws TuringException;
	public void setChar(TapeChar character) throws TuringException;
	public TapeChar getChar() throws TuringException;
	
}
