package ast;

// Expression avec + ou -
public class Arithmetic_expression_priority_low extends Expression{
	
	private Arithmetic_operation_priority_low arithmetic_operation_priority_low;
	
	public Arithmetic_expression_priority_low() {
	}

	public Arithmetic_expression_priority_low(Expression expr_gauche,Arithmetic_operation_priority_low arithmetic_operation_priority_low, Expression expr_droite) {
		super(expr_gauche, expr_droite);
		this.arithmetic_operation_priority_low = arithmetic_operation_priority_low;
	}

	public Arithmetic_operation_priority_low getArithmetic_operation_priority_low() {
		return arithmetic_operation_priority_low;
	}

	public void setArithmetic_operation_priority_low(Arithmetic_operation_priority_low arithmetic_operation_priority_low) {
		this.arithmetic_operation_priority_low = arithmetic_operation_priority_low;
	}

	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
		
	}

	@Override
	public Object interpret(Context context) {
		Object oLeft = getGauche().interpret(context);
		Object oRight = getDroite().interpret(context);
		
		Double dLeft = Double.valueOf(oLeft.toString());
		Double dRight = Double.valueOf(oRight.toString());
		
		if(arithmetic_operation_priority_low.getOperation() == "+") {
			return dLeft + dRight;
		}else if(arithmetic_operation_priority_low.getOperation() == "-")
		{
			return dLeft - dRight;
		}else 
		{
			context.setHasError(new ExecutionError("Doit être un + ou un -"));
		}

		return null;
	}
}
