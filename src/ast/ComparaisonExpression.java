package ast;

import java.security.KeyPair;
import executions.*;
import statements.*;
import visitor.*;
import utilities.*;

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
		
		boolean objetsAreBools = Utilities.AreObjetsBool(oLeft, oRight); // S'arrive que si un des 2 obj est boolean que les 2 le soi
		
		if(objetsAreBools) {
			switch(operator)
			{
				case "==":
					return Boolean.valueOf(oLeft.toString())==Boolean.valueOf(oRight.toString());
				case "<>":
					return Boolean.valueOf(oLeft.toString())!=Boolean.valueOf(oRight.toString());
			}
		}else {
			if(!(oLeft instanceof ASTNode || oRight instanceof ASTNode)){	//	Si aucun objet dérive d'un appel de fonction
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
		return null;
	}

	@Override
	public void accept(VisitorPrint visitor) {
		visitor.PreVisit();
		visitor.visit(this);
		visitor.PostVisit();
	}

}
