package pt.bucho.turing.api.entities;

public enum Direction {

	LEFT, RIGHT, STAY;
	
	@Override
	public String toString() {
		return super.toString().substring(0,1);
	}
	
}
