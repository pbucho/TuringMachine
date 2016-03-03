package pt.bucho.turing.api.exceptions;

/**
 * Thrown when the machine terminates the execution abruptly
 * @author Pedro
 *
 */
public class HaltException extends RuntimeException {

	private static final long serialVersionUID = -6731055659389268218L;

	public HaltException(){
		super();
	}
	
	public HaltException(String reason) {
		super(reason);
	}
	
}
