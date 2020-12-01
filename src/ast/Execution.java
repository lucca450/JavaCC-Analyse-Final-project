package ast;

import java.util.ArrayList;

public class Execution {
	private ArrayList<Variable> randomValues = new ArrayList<Variable>();
	private ArrayList<Integer> path;
	
	public void SetPath(ArrayList<Integer> path) {
		this.path = path;
	}
	
	public ArrayList<Integer> GetPath(){
		return path;
	}
	
	public void AddRandomValues(Variable v) {
		randomValues.add(v);
	}

	public ArrayList<Variable> getRandomValues() {
		return randomValues;
	}
	
	
	public String toString() {
		String output = "(";
		for(int i = 0 ; i < randomValues.size() ; i++) {
			Variable v = randomValues.get(i);
			output += v.Output();
			if(i != randomValues.size() - 1)
				output += ", ";
		}
		return output + ") ";
	}
}
