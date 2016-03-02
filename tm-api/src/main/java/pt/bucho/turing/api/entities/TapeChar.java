package pt.bucho.turing.api.entities;

import pt.bucho.turing.api.exceptions.TuringException;

public interface TapeChar {
	
	// The thrown exception may indicate that the given charecter is not part of the 
	// language alphabet or the working alphabet (reserved character)
	public void setChar(char character) throws TuringException;
	public char getChar();

}
