package pt.bucho.turing.core.entities;

import pt.bucho.turing.api.entities.Tape;
import pt.bucho.turing.api.entities.TapeChar;
import pt.bucho.turing.api.exceptions.TuringException;

public class LeftLimitedTape implements Tape {

	private TapeChar[] tape;
	private int currentPosition = 0;
	
	public LeftLimitedTape() {
		tape = new TapeCharImpl[10];
	}
	
	public TapeChar moveLeft() throws TuringException {
		currentPosition--;
		return getChar();
	}

	public TapeChar moveRight() throws TuringException {
		currentPosition++;
		return getChar();
	}

	public void setChar(TapeChar character) throws TuringException {
		tape[currentPosition] = character;
	}

	public TapeChar getChar() throws TuringException {
		try {
			return tape[currentPosition];
		}catch (IndexOutOfBoundsException e){
			currentPosition = 0;
			throw new TuringException("Reached left end of tape");
		}
	}

}
