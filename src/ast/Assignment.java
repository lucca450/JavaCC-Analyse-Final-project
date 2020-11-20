package ast;

public class Assignment extends ASTNode {
	private String identifier;
	private String assign;
	private Expression expression;
	
	public Assignment(String identifier, String assign, Expression expression) {
		this.identifier = identifier;
		this.assign = assign;
		this.expression = expression;
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

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

}
