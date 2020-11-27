package ast;

import java.util.ArrayList;

public class Execution {
	private ArrayList<Variable> randomValues = new ArrayList<Variable>();
	
	public void AddRandomValues(Variable v) {
		randomValues.add(v);
	}

	public ArrayList<Variable> getRandomValues() {
		return randomValues;
	}
	
}
