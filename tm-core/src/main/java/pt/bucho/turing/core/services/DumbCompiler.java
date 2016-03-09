package pt.bucho.turing.core.services;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import pt.bucho.turing.api.entities.State;
import pt.bucho.turing.api.entities.Transition;
import pt.bucho.turing.api.entities.TuringMachine;
import pt.bucho.turing.api.exceptions.CompilationException;
import pt.bucho.turing.api.exceptions.TuringException;
import pt.bucho.turing.api.services.Compiler;
import pt.bucho.turing.core.entities.DeterministicTuringMachine;
import pt.bucho.turing.core.entities.StateImpl;
import pt.bucho.turing.core.entities.TransitionImpl;

public class DumbCompiler implements Compiler {
	
	private int lineNumber;
	private TuringMachine compiledMachine;

	public TuringMachine compile(String program) throws TuringException {

		byte[] programBinary = program.getBytes();

		InputStream is = new ByteArrayInputStream(programBinary);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		compiledMachine = new DeterministicTuringMachine();
		
		try {
			String line;
			lineNumber = 0;
			while ((line = br.readLine()) != null) {
				lineNumber++;
				interpretLine(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new DeterministicTuringMachine();
	}

	private void interpretLine(String line) throws CompilationException {
		String[] parse1 = line.split(" ");
		if (parse1.length == 2) {
			if (!parse1[0].equals("IS:")) {
				throw new CompilationException("Incorrect syntax in line " + lineNumber);
			}
			State initialState = new StateImpl(parse1[1]);
			initialState.setInitialState(true);
			compiledMachine.getStates().put(parse1[1], initialState);
		} else if (parse1.length == 5) {
			State departingState = compiledMachine.getStates().get(parse1[0]);
			State arrivingState = compiledMachine.getStates().get(parse1[4]);
			Transition transition = new TransitionImpl();
		}
	}

}
