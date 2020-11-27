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
		
		boolean isDouble = (oLeft instanceof Double || oRight instanceof Double);
		
		if(isDouble) {
			double left = (double)oLeft;
			double right = (double)oRight;
			
			if(arithmetic_operation_priority_low.getOperation() == "+") {
				return left + right;
			}else if(arithmetic_operation_priority_low.getOperation() == "-")
			{
				return left - right;
			}else 
			{
				context.setHasError(new ExecutionError("Doit être un + ou un -"));
			}
		}else {
			int left = (int)oLeft;
			int right = (int)oRight;
			if(arithmetic_operation_priority_low.getOperation() == "+") {
				return left + right;
			}else if(arithmetic_operation_priority_low.getOperation() == "-")
			{
				return left - right;
			}else 
			{
				context.setHasError(new ExecutionError("Doit être un + ou un -"));
			}
		}
		return null;
	}





}
