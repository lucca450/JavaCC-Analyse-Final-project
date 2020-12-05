package ast;

import executions.*;
import statements.*;
import visitor.*;
import utilities.*;

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
		
		if(oLeft instanceof ASTNode || oRight instanceof ASTNode) {	// Si un des 2 objet dérive d'un appel de fonction
			return this;	//	ignore
		}
		
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
	public void accept(VisitorPrint visitor) {
		visitor.PreVisit();
		visitor.visit(this);
		visitor.PostVisit();
		
	}

}
