package executions;

import java.util.ArrayList;

public class Context {
	private ArrayList<Variable> variables;
	private Object result;
	private String resultType;
	public Boolean isEmpty = true;
	private ExecutionError error;
	private ArrayList<Integer> executedPath;

	public Context() {
		variables = new ArrayList<Variable>();
		executedPath = new ArrayList<Integer>();
		result = null;
	}
	
	public void AddIDInPath(int id) {
		executedPath.add(id);
	}
	
	public ArrayList<Integer> GetExecutedPath(){
		return executedPath;
	}
	
	public boolean HasResult() {
		return result != null;
	}
	
	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	
	public boolean getHasError() {
		return error != null;
	}

	public void setHasError(ExecutionError e) {
		this.error = e;
	}
	
	public void AddVariable(int ID, String identificator, String type, Object value) {
		AddVariable(new Variable(ID, identificator, type, value));
	}
	
	public void AddVariable(Variable v) {
		if(!VariableExists(v)) {
			variables.add(v);
			isEmpty = false;
		}else {
			this.setHasError(new ExecutionError("La variable " + v.getIdentificator() + " existe déjà."));
		}
	}
	
	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
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

	public Variable FindVariable(String identificator) {
		for(Variable v : variables) {
			if(v.getIdentificator().equals(identificator))
				return v;
		}
		return null;
	}
	






}
