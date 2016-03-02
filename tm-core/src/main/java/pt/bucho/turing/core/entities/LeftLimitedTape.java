package pt.bucho.turing.core.entities;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.RED;

import pt.bucho.turing.api.entities.Tape;
import pt.bucho.turing.api.entities.TapeChar;
import pt.bucho.turing.api.exceptions.ReachedLeftTapeEnd;
import pt.bucho.turing.api.exceptions.TuringException;

public class LeftLimitedTape implements Tape {

	private TapeChar[] tape;
	private int currentPosition = 0;

	public LeftLimitedTape() {
		tape = new TapeCharImpl[10];
		initBlankSpaces();
	}

	public LeftLimitedTape(String word) throws TuringException {
		tape = new TapeCharImpl[word.length()];
		for (int i = 0; i < word.length(); i++) {
			tape[i] = new TapeCharImpl(word.charAt(i));
		}
		initBlankSpaces();
	}

	public TapeChar moveLeft() throws TuringException {
		currentPosition--;
		if(currentPosition < 0){
			currentPosition = 0;
			throw new ReachedLeftTapeEnd("Reached left end of tape");
		}
		return getChar();
	}

	public TapeChar moveRight() {
		currentPosition++;
		if (currentPosition >= tape.length) {
			expandTape();
		}
		return getChar();
	}

	public void setChar(TapeChar character) {
		tape[currentPosition] = character;
	}

	public TapeChar getChar() {
		return tape[currentPosition];
	}

	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < tape.length; i++) {
			if (i == currentPosition) {
				output += ansi().fg(RED).a(tape[i].getChar()).reset();
			} else {
				output += tape[i].getChar();
			}
		}
		return output;
	}

	protected void expandTape() {
		TapeChar[] newTape = new TapeCharImpl[tape.length * 2];
		for (int i = 0; i < tape.length; i++) {
			newTape[i] = tape[i];
		}
		tape = newTape;
		initBlankSpaces();
	}

	// taylor swift ?
	private void initBlankSpaces() {
		for (int i = 0; i < tape.length; i++) {
			if (tape[i] == null) {
				tape[i] = new TapeCharImpl();
			}
		}
	}

}
