package pt.bucho.turing.core.test.entities;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.turing.api.entities.Tape;
import pt.bucho.turing.api.entities.TapeChar;
import pt.bucho.turing.api.exceptions.ReachedLeftTapeEnd;
import pt.bucho.turing.api.exceptions.TuringException;
import pt.bucho.turing.core.entities.LeftLimitedTape;
import pt.bucho.turing.core.entities.TapeCharImpl;

public class LeftLimitedTapeTest {

	private Tape tape;
	
	private TapeChar character;
	
	@Before
	public void setUp() throws Exception {
		character = new TapeCharImpl('a');
	}

	@Test
	public void toStringTest() throws TuringException {
		tape = new LeftLimitedTape("Word");
		
		assertEquals(ansi().fg(RED).a("W").reset() + "ord", tape.toString());
		
		tape.moveRight();
		
		assertEquals("W" + ansi().fg(RED).a("o").reset() + "rd", tape.toString());
	}
	
	@Test
	public void addCharMoveRight() throws TuringException {
		tape = new LeftLimitedTape();
		
		tape.setChar(character);
		tape.moveRight();
		assertEquals(character, tape.moveLeft());
	}
	
	@Test
	public void addCharMoveLeftFail() {
		tape = new LeftLimitedTape();
		try {
			tape.setChar(character);
			tape.moveLeft();
			fail("Should have thrown exception");
		} catch (TuringException e) {
			if (!(e instanceof ReachedLeftTapeEnd)) {
				fail("Exception is not an instance of ReachedLeftTapeEnd");
			}
		}
	}
	
	@Test
	public void blankSpacesAreNotNull() throws TuringException {
		tape = new LeftLimitedTape();

		assertNotNull(tape.getChar());
		for (int i = 0; i < 9; i++) {
			assertNotNull(tape.moveRight());
		}

	}
	
	@Test
	public void newTapeWithExistingWord() throws TuringException {
		tape = new LeftLimitedTape("Word");
		
		assertEquals('W', tape.getChar().getChar());
		assertEquals('o', tape.moveRight().getChar());
		assertEquals('r', tape.moveRight().getChar());
		assertEquals('d', tape.moveRight().getChar());
	}
	
	@Test
	public void tapeAutomaticRightExpansion() throws TuringException {
		tape = new LeftLimitedTape("a");
		
		assertNotNull(tape.moveRight());
		assertTrue(tape.getChar().isEmpty());
		
		assertEquals('a', tape.moveLeft().getChar());
	}
	
}
