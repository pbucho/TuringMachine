package pt.bucho.mturing;

public class HaltedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public HaltedException(){
		super();
	}
	
	public HaltedException(String message){
		super(message);
	}

}
