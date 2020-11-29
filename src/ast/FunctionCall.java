package ast;

import java.util.ArrayList;

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
		context.setHasError(new ExecutionError("Interpret de Function call n'est pas supposé ce faire appeler"));
		return null;
	}

	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

}
