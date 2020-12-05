package statements;

import executions.*;
import visitor.*;
import utilities.*;
import ast.*;

public class Assignment extends Statement{
	private String identifier;
	private String assign;
	private Item expression;
	
	public Assignment() {

	}
	
	
	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}


	public String getAssign() {
		return assign;
	}


	public void setAssign(String assign) {
		this.assign = assign;
	}


	public Item getExpression() {
		return expression;
	}


	public void setExpression(Item expression) {
		this.expression = expression;
	}


	@Override
	public void accept(VisitorPrint visitor) {
		visitor.PreVisit();
		visitor.visit(this);
		visitor.PostVisit();
	}

	@Override
	public Object interpret(Context context) {
		Variable v = context.FindVariable(identifier);
		if(v != null) {									//	si la variable existe
			Object o = expression.interpret(context);
			if(!context.getHasError()) {
				if(!(o instanceof ASTNode)) {				//	si l'objet ne dérive pas d'un appel de fonction
					if(v.getType().equals("int")) {					//	si entier
						if(Utilities.TryParseInt(o)) {
							v.setValue(Integer.valueOf(o.toString()));			
						}else {
							context.setHasError(new ExecutionError("Le résultat de l'expression doit être un entier, " + v.getIdentificator()));
							return null;
						}
					}
					else if(v.getType().equals("double"))			// si double
						if(Utilities.TryParseDouble(o) || Utilities.TryParseInt(o)) {
							v.setValue(Double.valueOf(o.toString()));			
						}else {
							context.setHasError(new ExecutionError("Le résultat de l'expression doit être un nombre, " + v.getIdentificator()));
							return null;
						}	
					else											// else donc booléen
						if(!(Utilities.TryParseDouble(o) || Utilities.TryParseInt(o)))
							v.setValue(Boolean.valueOf(o.toString()));
						else {
							context.setHasError(new ExecutionError("Le résultat de l'expression doit être un bouléen"));
							return null;
						}
				}else
					v.setValue(o);
			}else
				return null;
		}
		return null;
	}

}
