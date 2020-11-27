package ast;

public class Assignment extends ASTNode {
	private String identifier;
	private String assign;
	private Expression expr;
	
	public Assignment(String identifier, String assign, Expression expr) {
		super();
		this.identifier = identifier;
		this.assign = assign;
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
	public Expression getExpr() {
		return expr;
	}

	public void setExpr(Expression expr) {
		this.expr = expr;
	}
	
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

	@Override
	public Object interpret(Context context) {
		return expr.interpret(context);
	}



}
