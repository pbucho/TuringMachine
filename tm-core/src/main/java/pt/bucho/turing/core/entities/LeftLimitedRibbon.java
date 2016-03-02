package pt.bucho.turing.core.entities;

import pt.bucho.turing.api.entities.Ribbon;
import pt.bucho.turing.api.entities.RibbonChar;
import pt.bucho.turing.api.exceptions.TuringException;

public class LeftLimitedRibbon implements Ribbon {

	private RibbonChar[] ribbon;
	private int currentPosition = 0;
	
	public LeftLimitedRibbon() {
		ribbon = new RibbonCharImpl[10];
	}
	
	public RibbonChar moveLeft() throws TuringException {
		currentPosition--;
		return getChar();
	}

	public RibbonChar moveRight() throws TuringException {
		currentPosition++;
		return getChar();
	}

	public void setChar(RibbonChar character) throws TuringException {
		ribbon[currentPosition] = character;
	}

	public RibbonChar getChar() throws TuringException {
		try {
			return ribbon[currentPosition];
		}catch (IndexOutOfBoundsException e){
			currentPosition = 0;
			throw new TuringException("Reached left end of ribbon");
		}
	}

}
