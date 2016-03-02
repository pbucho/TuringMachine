package pt.bucho.turing.core.entities;

import pt.bucho.turing.api.entities.TapeChar;
import pt.bucho.turing.api.exceptions.TuringException;

public class TapeCharImpl implements TapeChar {

	private char character;
	private static final char RESERVED = '|';
	
	public TapeCharImpl() {
		this.character = ' ';
	}
	
	public TapeCharImpl(char character) throws TuringException {
		setChar(character);
	}
	
	public void setChar(char character) throws TuringException {
		if(character == RESERVED){
			throw new TuringException("Can't use character \'|\'");
		}
		this.character = character;
	}

	public char getChar() {
		return character;
	}

}
