package ast;

import java.util.ArrayList;

public class ConditionalStatement extends Statement{

	private Item expression;
	private ArrayList<Statement> ifBody;
	private ArrayList<Statement> elseBody;
	
	public ConditionalStatement() {}
	
	public Item getExpression() {
		return expression;
	}

	public void setExpression(Item expression) {
		this.expression = expression;
	}

	public ArrayList<Statement> getIfBody() {
		return ifBody;
	}

	public void setIfBody(ArrayList<Statement> ifBody) {
		this.ifBody = ifBody;
	}

	public ArrayList<Statement> getElseBody() {
		return elseBody;
	}

	public void setElseBody(ArrayList<Statement> elseBody) {
		this.elseBody = elseBody;
	}

	public void ShowMessage() {
		System.out.println("Expression conditionnelle"); 
	}
	
	@Override
	public Object interpret(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
		
		for(Statement s : ifBody) {
			s.accept(visitor, nbTab+1);
		}
		
	}

}
