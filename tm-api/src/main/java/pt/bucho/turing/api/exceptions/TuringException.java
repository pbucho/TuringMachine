package pt.bucho.turing.api.exceptions;

public class TuringException extends Exception {

	private static final long serialVersionUID = -8004489606576438032L;
	
	public TuringException(String reason){
		super(reason);
	}

}
