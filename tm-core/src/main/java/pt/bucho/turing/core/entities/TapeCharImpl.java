package pt.bucho.turing.core.entities;

import pt.bucho.turing.api.entities.TapeChar;
import pt.bucho.turing.api.exceptions.TuringException;

public class TapeCharImpl implements TapeChar {

	private char character;
	private static final char EMPTY_CHAR = '_';
	private static final char RESERVED = '|';

	public TapeCharImpl() {
		this.character = EMPTY_CHAR;
	}

	public TapeCharImpl(char character) throws TuringException {
		setChar(character);
	}

	public void setChar(char character) throws TuringException {
		if (character == RESERVED) {
			throw new TuringException("Can't use character \'" + RESERVED + "\'");
		}
		this.character = character;
	}

	public char getChar() {
		return character;
	}

	public boolean isEmpty() {
		return character == EMPTY_CHAR;
	}
	
	@Override
	public String toString() {
		return "" + character;
	}

}
