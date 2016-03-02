package pt.bucho.turing.core.test.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.turing.api.entities.Tape;
import pt.bucho.turing.api.entities.TapeChar;
import pt.bucho.turing.api.exceptions.TuringException;
import pt.bucho.turing.core.entities.LeftLimitedTape;
import pt.bucho.turing.core.entities.TapeCharImpl;

public class LeftLimitedTapeTest {

	private Tape tape;
	
	private TapeChar character;
	
	@Before
	public void setUp() throws Exception {
		tape = new LeftLimitedTape();
		
		character = new TapeCharImpl('a');
	}

	@Test
	public void addCharMoveRight() throws TuringException {
		tape.setChar(character);
		tape.moveRight();
		assertEquals(character, tape.moveLeft());
	}
	
	@Test
	public void addCharMoveLeftFail() {
		try {
			tape.setChar(character);
			tape.moveLeft();
			fail("Should have thrown exception");
		} catch (TuringException e){
			// all good
		}
	}

}
