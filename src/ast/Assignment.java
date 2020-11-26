package ast;

public class Assignment extends ASTNode {
	private String identifier;
	private String assign;
	//private Expression expression;
	private Expression expr;
	
	public Assignment(String identifier, String assign, Expression expr/*Expression expression*/) {
		super();
		this.identifier = identifier;
		this.assign = assign;
		//this.expression = expression;
		this.expr = expr;
	}
	
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

	/*public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}*/
	
	public Expression getExpr() {
		return expr;
	}

	public void setExpr(Expression expr) {
		this.expr = expr;
	}
	
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
		
		//expression.accept(visitor);
	}



}
