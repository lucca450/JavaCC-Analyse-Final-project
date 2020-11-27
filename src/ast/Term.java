package ast;

public class Term extends Expression{
	private Value value;
	private LogExpression expression;
	
	public Term(Value value, LogExpression expression) {
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
	public LogExpression getExpression() {
		return expression;
	}
	public void setExpression(LogExpression expression) {
		this.expression = expression;
	}
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}
	@Override
	public Object interpret(Context context) {
		if(value != null) {
			return value.interpret(context);
		}else if(expression != null)
		{
			return expression.interpret(context);
		}
		context.setHasError(new ExecutionError("Le terme n'a pas de valeur ni de Log Expression"));
		return null;
	}
	
	
}
