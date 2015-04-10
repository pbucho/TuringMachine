package pt.bucho.mturing;

public class NoInitialStateException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoInitialStateException(){
		super();
	}
	
	public NoInitialStateException(String message){
		super(message);
	}

}
