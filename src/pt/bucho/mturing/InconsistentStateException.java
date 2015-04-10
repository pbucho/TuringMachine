package pt.bucho.mturing;

public class InconsistentStateException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InconsistentStateException(){
		super();
	}
	
	public InconsistentStateException(String message){
		super(message);
	}

}
