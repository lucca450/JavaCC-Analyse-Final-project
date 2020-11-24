package ast;

public class Term extends Expr{
	private Value value;
	private Expression expression;
	
	public Term(Value value, Expression expression) {
		super();
		this.value = value;
		this.expression = expression;
	}
	public Term() {
	}
	
	public Value getValue() {
		return value;
	}
	public void setValue(Value value) {
		this.value = value;
	}
	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
	}
	
	
}
