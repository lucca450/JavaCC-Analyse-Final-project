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
		
		Double dLeft = Double.valueOf(oLeft.toString());
		Double dRight = Double.valueOf(oRight.toString());
		
		if(operator == "+") {
			return dLeft + dRight;
		}else if(operator == "-")
		{
			return dLeft - dRight;
		}else 
		{
			context.setHasError(new ExecutionError("Doit être un + ou un -"));
		}

		return null;
	}

	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
		
	}

}
