package ast;

public class Return_statement extends ASTNode {

	private Expression expression;
	
	public Return_statement() {
		super();
	}
	
	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public Object interpret(Context context) {
		context.setResult(expression.interpret(context));
		return null;
	}
}
