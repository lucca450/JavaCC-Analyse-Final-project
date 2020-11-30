package ast;

public class LowPriorityArithmeticExpression extends Expression {

	private String operator;

	public LowPriorityArithmeticExpression() {}
	
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	@Override
	public Object interpret(Context context) {
		Object oLeft = getGauche().interpret(context);
		Object oRight = getDroite().interpret(context);
				
		if(operator == "+") {
			return Utilities.Add(oLeft, oRight);
		}else if(operator == "-") {
			return Utilities.Subtract(oLeft, oRight);
		}else {
			context.setHasError(new ExecutionError("Doit être un + ou un -"));
		}

		return null;
	}

	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
		
	}

}
