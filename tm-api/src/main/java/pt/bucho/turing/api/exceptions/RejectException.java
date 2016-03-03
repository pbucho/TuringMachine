package pt.bucho.turing.api.exceptions;

public class RejectException extends HaltException {

	private static final long serialVersionUID = -7808860988371226285L;

	public RejectException() {
		super();
	}
	
	public RejectException(String reason) {
		super(reason);
	}
	
}
