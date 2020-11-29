package ast;

public class Assignment extends Statement{
	private String identifier;
	private String assign;
	private Item expression;
	
	public Assignment() {

	}
	
	
	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}


	public String getAssign() {
		return assign;
	}


	public void setAssign(String assign) {
		this.assign = assign;
	}


	public Item getExpression() {
		return expression;
	}


	public void setExpression(Item expression) {
		this.expression = expression;
	}


	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

	@Override
	public Object interpret(Context context) {
		return expression.interpret(context);
	}

}
