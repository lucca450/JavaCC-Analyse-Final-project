package ast;

public class ArithmeticExpression extends Expression{

	private String operator;
	
	public ArithmeticExpression() {}
	
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
		
		switch(operator)
		{
		case "*":
			return dLeft*dRight;
		case "/":
			if(dRight != 0)
				return dLeft/dRight;
			else 
			{
				context.setHasError(new ExecutionError("Impossible de diviser par 0"));
			}
		case "%":
			if(dRight != 0)
				return dLeft%dRight;
			else 
			{
				context.setHasError(new ExecutionError("Impossible de moduler par 0"));
			}
		default:
			context.setHasError(new ExecutionError("Mauvais operateur dans Arithmetic_expression"));
		}
		return null;
	}

	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

}
