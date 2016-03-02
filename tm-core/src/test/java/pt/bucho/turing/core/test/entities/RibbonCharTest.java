package pt.bucho.turing.core.test.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import pt.bucho.turing.api.entities.RibbonChar;
import pt.bucho.turing.api.exceptions.TuringException;
import pt.bucho.turing.core.entities.RibbonCharImpl;

public class RibbonCharTest {

	private RibbonChar character;
	
	@Test
	public void noArgConstructorTest() {
		character = new RibbonCharImpl();
		assertEquals(' ', character.getChar());
	}
	
	@Test
	public void argConstructorTest() throws TuringException {
		character = new RibbonCharImpl('a');
		assertEquals('a', character.getChar());
	}
	
	@Test
	public void setterTest() throws TuringException {
		character = new RibbonCharImpl();
		character.setChar('a');
		assertEquals('a', character.getChar());
	}
	
	@Test
	public void invalidCharThrowsException() {
		character = new RibbonCharImpl();
		try {
			character.setChar('|');
			fail("Should have thrown exception");
		}catch (TuringException e){
			// all good
		}
		
		try {
			character = new RibbonCharImpl('|');
			fail("Should have thrown exception");
		}catch (TuringException e){
			// all good
		}
	}

}
