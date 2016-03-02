package pt.bucho.turing.core.test.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import pt.bucho.turing.api.entities.TapeChar;
import pt.bucho.turing.api.exceptions.TuringException;
import pt.bucho.turing.core.entities.TapeCharImpl;

public class TapeCharTest {

	private TapeChar character;
	
	@Test
	public void noArgConstructorTest() {
		character = new TapeCharImpl();
		assertEquals(' ', character.getChar());
	}
	
	@Test
	public void argConstructorTest() throws TuringException {
		character = new TapeCharImpl('a');
		assertEquals('a', character.getChar());
	}
	
	@Test
	public void setterTest() throws TuringException {
		character = new TapeCharImpl();
		character.setChar('a');
		assertEquals('a', character.getChar());
	}
	
	@Test
	public void invalidCharThrowsException() {
		character = new TapeCharImpl();
		try {
			character.setChar('|');
			fail("Should have thrown exception");
		}catch (TuringException e){
			// all good
		}
		
		try {
			character = new TapeCharImpl('|');
			fail("Should have thrown exception");
		}catch (TuringException e){
			// all good
		}
	}

}
