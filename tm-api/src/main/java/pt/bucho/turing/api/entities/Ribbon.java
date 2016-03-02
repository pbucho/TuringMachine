package pt.bucho.turing.api.entities;

import pt.bucho.turing.api.exceptions.TuringException;

public interface Ribbon {

	public RibbonChar moveLeft() throws TuringException;
	public RibbonChar moveRight() throws TuringException;
	public void setChar(RibbonChar character) throws TuringException;
	public RibbonChar getChar() throws TuringException;
	
}
