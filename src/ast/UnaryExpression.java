package ast;

import executions.*;
import statements.*;
import visitor.*;
import utilities.*;

public class UnaryExpression extends Item{
	private String operator;
	private Term term;
	
	public UnaryExpression() {}
	
	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}
	
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	@Override
	public Object interpret(Context context) {
		Object o = term.interpret(context);
		if(o instanceof ASTNode)
			return this;
		
		switch(operator)
		{
		case "!":
			if(o instanceof Boolean) {
				return !(boolean)o;
			}else
			{
				context.setHasError(new ExecutionError("Doit être un bouléen pour faire !"));
				return null;
			}
		case "--":
			if(o instanceof Double || o instanceof Integer) 
			{
				Double d = Double.valueOf(o.toString());
				return Utilities.Subtract(d, 1);
			}else 
			{
				context.setHasError(new ExecutionError("Doit être un nombre pour faire --"));
				return null;
			}
		case "++":
			if(o instanceof Double || o instanceof Integer) 
			{
				Double d = Double.valueOf(o.toString());
				Variable v = context.FindVariable(term.getValue().toString());
				v.setValue(Utilities.Add(d, 1));
				
				return Utilities.Add(d, 1);
			}else 
			{
				context.setHasError(new ExecutionError("Doit être un nombre pour faire ++"));
				return null;
			}
			default:
				context.setHasError(new ExecutionError("Mauvais opérateur dans Unary_Expression"));
				return null;
		}
	}
	
	@Override
	public void accept(VisitorPrint visitor) {
		visitor.PreVisit();
		visitor.visit(this);
		visitor.PostVisit();
	}	
}
