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
		
		boolean isDouble = (oLeft instanceof Double || oRight instanceof Double);
		
		if(isDouble) {
			double left = (double)oLeft;
			double right = (double)oRight;
			
			switch(arithmetic_operation.getOperation())
			{
			case "*":
				return left*right;
			case "/":
				if(right != (double)0)
					return left/right;
				else 
				{
					System.out.println("Impossible de diviser par 0");
					return null;
				}
			case "%":
				if(right != (double)0)
					return left%right;
				else 
				{
					System.out.println("Impossible de moduler par 0");
					return null;
				}
			default:
				System.out.println("Something went wrong interpret Arithmetic_expression");
				return null;
			}
		}else 
		{
			int left = (int)oLeft;
			int right = (int)oRight;
			
			switch(arithmetic_operation.getOperation())
			{
			case "*":
				return left*right;
			case "/":
				if(right != (int)0)
					return left/right;
				else 
				{
					System.out.println("Impossible de diviser par 0");
					return null;
				}
			case "%":
				if(right != (int)0)
					return left/right;
				else 
				{
					System.out.println("Impossible de moduler par 0");
					return null;
				}
				default:
					System.out.println("Something went wrong interpret Arithmetic_expression");
					return null;
			}
		}
	}
}
