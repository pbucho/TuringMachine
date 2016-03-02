package pt.bucho.turing.api.exceptions;

public class ReachedLeftTapeEnd extends TuringException {

	private static final long serialVersionUID = 2623382852304051554L;

	public ReachedLeftTapeEnd() {
		super();
	}
	
	public ReachedLeftTapeEnd(String reason) {
		super(reason);
	}
	
}
