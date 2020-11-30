package ast;

public class ReturnStatement extends Statement{

	private Item expression;
	
	public Item getExpression() {
		return expression;
	}

	public void setExpression(Item expression) {
		this.expression = expression;
	}

	@Override
	public Object interpret(Context context) {
		context.setResult(expression.interpret(context));
		return null;
	}

	@Override
	public void accept(VisitorPrint visitor) {
		visitor.visit(this);		
	}

}
