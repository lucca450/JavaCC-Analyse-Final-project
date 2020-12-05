package statements;

import java.util.ArrayList;
import executions.*;
import visitor.*;
import ast.*;

public class FunctionCall extends Statement{

	String identifier;
	ArrayList<Item> parameters;

	public FunctionCall() {
		parameters = new ArrayList<Item>();
	}
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public ArrayList<Item> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<Item> parameters) {
		this.parameters = parameters;
	}
	
	@Override
	public Object interpret(Context context) {
		return this;							// Retourne this pour plus tard ignorer l'appel
	}

	@Override
	public void accept(VisitorPrint visitor) {
		visitor.PreVisit();
		visitor.visit(this);
		visitor.PostVisit();
	}

}
