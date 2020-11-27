package ast;

import java.util.ArrayList;

public class Context {
	private ArrayList<Variable> variables;
	public Boolean isEmpty = true;
	
	public Context() {
		variables = new ArrayList<Variable>();
	}
	
	public void AddVariable(int ID, String identificator, String type, Object value) {
		AddVariable(new Variable(ID, identificator, type, value));
	}
	
	public void AddVariable(Variable v) {
		if(!VariableExists(v)) {
			variables.add(v);
			isEmpty = false;
		}else {
			System.out.println("La variable " + v.getIdentificator() + " existe déjà");
		}
	}
	
	public Variable FindVariable(int ID) {
		for(Variable v : variables){
			if(v.getID() == ID) {
				return v;
			}
		}
		return null;
	}
	public Variable FindVariable(Variable v) {
		return FindVariable(v.getID());
	}
	
	public void SetVariable(int ID, Object newValue) {
		Variable v = FindVariable(ID);
		if(v != null) {
			v.setValue(newValue);
		}else {
			System.out.println("La variable avec l'ID: " + ID + " est introuvable");
		}
	}
	
	private Boolean VariableExists(Variable v) {
		return FindVariable(v) != null;
	}
	






}
