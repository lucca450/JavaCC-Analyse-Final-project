package ast;

// Expression * ou / ou %
public class Arithmetic_expression extends Expression{

	private Arithmetic_operation arithmetic_operation;


	public Arithmetic_expression() {
		
	}

	public Arithmetic_expression(Expression expr_gauche, Arithmetic_operation arithmetic_operation, Expression expr_droite) {
		super(expr_gauche,expr_droite);
		this.arithmetic_operation = arithmetic_operation;
	}

	public Arithmetic_operation getArithmetic_operation() {
		return arithmetic_operation;
	}



	public void setArithmetic_operation(Arithmetic_operation arithmetic_operation) {
		this.arithmetic_operation = arithmetic_operation;
	}



	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

	@Override
	public Object interpret(Context context) {
		Object oLeft = getGauche().interpret(context);
		Object oRight = getDroite().interpret(context);
		
		Double dLeft = Double.valueOf(oLeft.toString());
		Double dRight = Double.valueOf(oRight.toString());
		
		switch(arithmetic_operation.getOperation())
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
}
