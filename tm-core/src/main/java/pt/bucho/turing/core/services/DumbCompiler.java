package pt.bucho.turing.core.services;

import pt.bucho.turing.api.entities.TuringMachine;
import pt.bucho.turing.api.exceptions.TuringException;
import pt.bucho.turing.api.services.Compiler;
import pt.bucho.turing.core.entities.TuringMachineImpl;

public class DumbCompiler implements Compiler {

	public TuringMachine compile(String program) throws TuringException {
		return new TuringMachineImpl();
	}

}
