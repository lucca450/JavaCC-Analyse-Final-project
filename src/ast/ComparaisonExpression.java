package ast;

import java.security.KeyPair;

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
		
		boolean comparaisonOk = Utilities.CompareTypes(oLeft, oRight);
		
		if(comparaisonOk) {
			if(oLeft instanceof Boolean || oRight instanceof Boolean) {
				switch(operator)
				{
					case "==":
						return Boolean.valueOf(oLeft.toString())==Boolean.valueOf(oRight.toString());
					case "<>":
						return Boolean.valueOf(oLeft.toString())!=Boolean.valueOf(oRight.toString());
				}
			}else {
				if(!(oLeft instanceof ASTNode || oRight instanceof ASTNode)){
					double left = Double.valueOf(oLeft.toString());
					double right = Double.valueOf(oRight.toString());
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
					}
				}else {
					return this;
				}
			}
			context.setHasError(new ExecutionError("Mauvais opérateur dans Comparaison_expression selon les types"));
		}else {
			context.setHasError(new ExecutionError("Les types de la comparaison ne peuvent être comparés ensemble"));
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
