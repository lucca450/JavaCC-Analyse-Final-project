package ast;

import java.util.ArrayList;

public class WhileLoop extends Statement{

	private Item expression;
	private ArrayList<Statement> body;
	
	public WhileLoop() {}
	
	public Item getExpression() {
		return expression;
	}

	public void setExpression(Item expression) {
		this.expression = expression;
	}

	public ArrayList<Statement> getBody() {
		return body;
	}

	public void setBody(ArrayList<Statement> body) {
		this.body = body;
	}

	@Override
	public Object interpret(Context context) {
		System.out.println("Interpret while pas implémenté");
		return null;
	}

	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

}
