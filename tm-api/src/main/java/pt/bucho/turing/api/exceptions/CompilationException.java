package pt.bucho.turing.api.exceptions;

public class CompilationException extends TuringException {

	private static final long serialVersionUID = -461722704256757059L;
	
	public CompilationException() {
		super();
	}
	
	public CompilationException(String reason) {
		super(reason);
	}

}
