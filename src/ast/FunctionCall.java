package ast;

import java.util.ArrayList;

public class FunctionCall extends Statement {
	String identifier;
	ArrayList<Expression> parameters;

	public FunctionCall() {
		parameters = new ArrayList<Expression>();
	}
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public ArrayList<Expression> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<Expression> parameters) {
		this.parameters = parameters;
	}
	
	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

	@Override
	public Object interpret(Context context) {
		context.setHasError(new ExecutionError("Interpret de Function call n'est pas supposé ce faire appeler"));
		return null;
	}
	

}
