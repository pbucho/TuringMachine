package pt.bucho.mturing;

import java.util.ArrayList;
import java.util.List;

public class Tape {
	
	List<Position> positions = new ArrayList<Position>();
	int current = 0;
	
	public Tape(char[] string){
		if(string.toString().isEmpty())
			positions.add(new Position(Position.blankChar));
		else{
			for(Character c : string){
				positions.add(new Position(c));
			}
		}
	}
	
	public int getCurrentPositionIndex(){
		return current;
	}
	
	public void moveLeft(){
		if(current > 0)
			current--;
	}
	
	public void moveRight(){
		current++;
	}
	
	public Position getCurrentPosition(){
		Position pos;
		try{
			pos = positions.get(current);
		}catch(IndexOutOfBoundsException e){
			for(int i = positions.size(); i <= current; i++)
				positions.add(i, new Position(Position.blankChar));
			pos = positions.get(current);
		}
		return pos;
	}
	
	public char getCurrentChar(){
		Position pos = getCurrentPosition();
		return pos.value;
	}
	
	public void setCurrentChar(char c){
		try{
			positions.get(current).setValue(c);
		}catch(IndexOutOfBoundsException e){
			for(int i = positions.size(); i <= current; i++)
				positions.add(i, new Position());
			positions.get(current).setValue(c);
		}
	}
	
	public void setCurrentCharBlank(){
		setCurrentChar('\0');
	}
	
	@Override
	public String toString(){
		String out = "(";
		int count = 0;
		for(Position p : positions){
			out += p.value;
			if(count == current)
				out += "*";
			out += ",";
			count++;
		}
		out += ")";
		return out;
	}

}
