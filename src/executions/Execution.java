package executions;

import java.util.ArrayList;

public class Execution {
	private ArrayList<Variable> randomValues = new ArrayList<Variable>();
	private ArrayList<Integer> path;
	
	public void SetPath(ArrayList<Integer> path) {
		this.path = path;
	}
	
	public String BuildTrace() {
		String trace = "";
		for(int i = 0 ; i < path.size();i++) {
			trace += path.get(i).toString();
			if(i != path.size()-1)
				trace += ",";
		}
		return trace;
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
