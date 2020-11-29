package ast;

import java.util.ArrayList;

public class ForLoop extends Statement{

	Assignment startAssignment;
	Item expression;
	Assignment iterationAssignment;
	ArrayList<Statement> body;
	
	public ForLoop() {}
	
	public ArrayList<Statement> getBody() {
		return body;
	}

	public void setBody(ArrayList<Statement> body) {
		this.body = body;
	}

	public Assignment getStartAssignment() {
		return startAssignment;
	}

	public void setStartAssignment(Assignment startAssignment) {
		this.startAssignment = startAssignment;
	}

	public Item getExpression() {
		return expression;
	}

	public void setExpression(Item expression) {
		this.expression = expression;
	}

	public Assignment getIterationAssignment() {
		return iterationAssignment;
	}

	public void setIterationAssignment(Assignment iterationAssignment) {
		this.iterationAssignment = iterationAssignment;
	}

	@Override
	public Object interpret(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		// TODO Auto-generated method stub
		
	}

}
