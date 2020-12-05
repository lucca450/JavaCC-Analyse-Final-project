package ast;

import executions.*;
import statements.*;
import visitor.*;
import utilities.*;

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
		
		if(oLeft instanceof ASTNode || oRight instanceof ASTNode)
			return this;
		
		switch(operator)
		{
		case "*":
			return Utilities.Multiply(oLeft, oRight);
		case "/":
			if(Double.valueOf(oRight.toString()) != 0)			// Si diviseur différent de 0
				return Utilities.Divide(oLeft, oRight);
			else 
			{
				context.setHasError(new ExecutionError("Impossible de diviser par 0"));
			}
		case "%":
			if(Double.valueOf(oRight.toString()) != 0)			// Si modulo différent de 0
				return Utilities.Modulo(oLeft, oRight);
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
	public void accept(VisitorPrint visitor) {
		visitor.PreVisit();
		visitor.visit(this);
		visitor.PostVisit();
	}

}
