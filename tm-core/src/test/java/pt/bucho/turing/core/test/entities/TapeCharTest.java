package pt.bucho.turing.core.test.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
		assertEquals('_', character.getChar());
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
	public void invalidCharThrowsExceptionTest() {
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
	
	@Test
	public void emptyCharTest() throws TuringException {
		character = new TapeCharImpl();
		
		assertTrue(character.isEmpty());
		
		character.setChar('a');
		
		assertFalse(character.isEmpty());
	}
	
	@Test
	public void toStringTest() throws TuringException {
		character = new TapeCharImpl('5');
		
		assertEquals("5", character.toString());
	}
	
}
