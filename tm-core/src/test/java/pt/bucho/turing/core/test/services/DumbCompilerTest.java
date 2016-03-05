package pt.bucho.turing.core.test.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.turing.api.entities.TuringMachine;
import pt.bucho.turing.api.exceptions.TuringException;
import pt.bucho.turing.api.services.Compiler;
import pt.bucho.turing.core.services.DumbCompiler;

public class DumbCompilerTest {

	private Compiler compiler;
	private TuringMachine tm;
	
	private List<State> expectedStates;
	
	@Before
	public void setUp() throws Exception {
		compiler = new DumbCompiler();
	}

	@Test
	public void compileTest() throws TuringException {
		tm = compiler.compile("IS: q0\n\nq0 _ _ R Accept\nq0 0 0 R q0\nq0 1 1 R q1\n\nq1 _ _ R Reject\nq1 0 0 R q1\nq1 1 1 R q0");
		assertNotNull(tm);
	}
	
	@Test
	public void parseProgram() {
		
	}

}
