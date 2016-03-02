package pt.bucho.turing.core.entities;

import pt.bucho.turing.api.entities.Ribbon;
import pt.bucho.turing.api.entities.RibbonChar;
import pt.bucho.turing.api.exceptions.TuringException;

public class LeftLimitedRibbon implements Ribbon {

	private RibbonChar[] ribbon;
	
	
	public LeftLimitedRibbon() {
		ribbon = new RibbonCharImpl[10];
	}
	
	public RibbonChar moveLeft() throws TuringException {
		// TODO Auto-generated method stub
		return null;
	}

	public RibbonChar moveRight() throws TuringException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setChar(RibbonChar character) throws TuringException {
		// TODO Auto-generated method stub
		
	}

	public RibbonChar getChar() throws TuringException {
		// TODO Auto-generated method stub
		return null;
	}

}
