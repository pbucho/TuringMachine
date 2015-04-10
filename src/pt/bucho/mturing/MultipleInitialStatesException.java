package pt.bucho.mturing;

public class MultipleInitialStatesException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MultipleInitialStatesException(){
		super();
	}
	
	public MultipleInitialStatesException(String message){
		super(message);
	}
	
}
