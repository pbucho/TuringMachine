package pt.bucho.turing.core.test.entities.turingmachine;

import pt.bucho.turing.core.entities.DeterministicTuringMachine;

public abstract class AbstractDeterministicTuringMachineTest extends AbstractTuringMachineTest{

	@Override
	public void setUp() throws Exception {
		super.setUp();
		turingMachine = new DeterministicTuringMachine();
	}
	
}
