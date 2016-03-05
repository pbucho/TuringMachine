package pt.bucho.turing.api.services;

import pt.bucho.turing.api.entities.TuringMachine;
import pt.bucho.turing.api.exceptions.TuringException;

public interface Compiler {

	/**
	 * Transforms a string into a Turing Machine :o
	 * @param program
	 * @return
	 */
	public TuringMachine compile(String program) throws TuringException;
	
}
