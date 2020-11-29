package ast;

public class ComparaisonExpression extends Expression{

	private String operator;
	
	public ComparaisonExpression() {
		
	}
	
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
		
		Double left = Double.valueOf(oLeft.toString());
		Double right = Double.valueOf(oRight.toString());
		
		switch(operator)
		{
		case ">":
			return left>right;
		case ">=":
			return left>=right;
		case "<":
			return left<right;
		case "<=":
			return left<=right;
		case "==":
			return left==right;
		case "<>":
			return left!=right;
			default:
				context.setHasError(new ExecutionError("Mauvais opérateur dans Comparaison_expression"));
				return null;
		}
	}

	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

}
