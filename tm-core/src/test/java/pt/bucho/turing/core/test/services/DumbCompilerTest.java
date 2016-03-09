package pt.bucho.turing.core.test.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.turing.api.entities.State;
import pt.bucho.turing.api.entities.TuringMachine;
import pt.bucho.turing.api.exceptions.TuringException;
import pt.bucho.turing.api.services.Compiler;
import pt.bucho.turing.core.entities.StateImpl;
import pt.bucho.turing.core.services.DumbCompiler;

public class DumbCompilerTest {

	private Compiler compiler;
	private TuringMachine tm;
	
	private List<State> expectedStates;
	private State q0, q1, qa, qr;
	
	@Before
	public void setUp() throws Exception {
		compiler = new DumbCompiler();
		
		q0 = new StateImpl("q0");
		q1 = new StateImpl("q0");
		qa = new StateImpl("q0");
		qr = new StateImpl("q0");
		
		q0.setInitialState(true);
		qa.setAcceptingState(true);
		
		expectedStates = new ArrayList<State>();
		expectedStates.add(q0);
		expectedStates.add(q1);
		expectedStates.add(qa);
		expectedStates.add(qr);
	}

	@Test
	public void compileTest() throws TuringException {
		tm = compiler.compile("IS: q0\n\nq0 _ _ R Accept\nq0 0 0 R q0\nq0 1 1 R q1\n\nq1 _ _ R Reject\nq1 0 0 R q1\nq1 1 1 R q0");
		assertNotNull(tm);
	}
	
	@Test
	public void parseProgram() throws TuringException {
		// TODO: finish test implementation
//		compileTest();
//		Map<String,State> actualStates = tm.getStates();
//
//		assertEquals(expectedStates.size(), actualStates.size());
//		
//		for(State expectedState : expectedStates) {
//			State actualState = actualStates.get(expectedState.getName());
//			assertNotNull(actualState);
//			assertEquals(expectedState, actualState);
//		}
	}

}
