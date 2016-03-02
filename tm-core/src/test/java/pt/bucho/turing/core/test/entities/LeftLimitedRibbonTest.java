package pt.bucho.turing.core.test.entities;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.turing.api.entities.Ribbon;
import pt.bucho.turing.api.entities.RibbonChar;
import pt.bucho.turing.api.exceptions.TuringException;
import pt.bucho.turing.core.entities.LeftLimitedRibbon;
import pt.bucho.turing.core.entities.RibbonCharImpl;

public class LeftLimitedRibbonTest {

	private Ribbon ribbon;
	
	private RibbonChar character;
	
	@Before
	public void setUp() throws Exception {
		ribbon = new LeftLimitedRibbon();
		
		character = new RibbonCharImpl('a');
	}

	@Test
	public void addCharMoveRight() throws TuringException {
		ribbon.setChar(character);
		ribbon.moveRight();
		assertEquals(character, ribbon.moveLeft());
	}
	
	@Test
	public void addCharMoveLeftFail() {
		try {
			ribbon.setChar(character);
			ribbon.moveLeft();
			fail("Should have thrown exception");
		} catch (TuringException e){
			// all good
		}
	}

}
