package ast;

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
		if(v != null) {
			Object o = expression.interpret(context);
			if(!context.getHasError()) {
				if(!(o instanceof ASTNode)) {
					if(v.getType() == "int") {
						if(Utilities.TryParseInt(o)) {
							v.setValue(Integer.valueOf(o.toString()));			
						}else {
							context.setHasError(new ExecutionError("Le résultat de l'expression doit être un entier, " + v.getIdentificator()));
							return null;
						}
					}
					else if(v.getType() == "double")
						if(Utilities.TryParseDouble(o) || Utilities.TryParseInt(o)) {
							v.setValue(Double.valueOf(o.toString()));			
						}else {
							context.setHasError(new ExecutionError("Le résultat de l'expression doit être un nombre, " + v.getIdentificator()));
							return null;
						}	
					else
						v.setValue(Boolean.valueOf(o.toString()));	
				}else
					v.setValue(o);
			}else
				return null;
		}
		return null;
	}

}
