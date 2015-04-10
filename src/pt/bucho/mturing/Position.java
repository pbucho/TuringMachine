package pt.bucho.mturing;

public class Position {

	char value;

	public Position(){
		value = '\0';
	}
	
	public Position(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}
	
	public void setBlank(){
		value = '\0';
	}
	
	public boolean isBlank(){
		if(value == '\0')
			return true;
		else
			return false;
	}
	
	@Override
	public String toString(){
		return "" + value;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Position))
			return false;
		Position pos = (Position) o;
		if(pos.value == this.value)
			return true;
		else
			return false;
	}
	
}
