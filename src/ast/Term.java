package ast;

public class Term extends Item{
	private Object value;

	public Term() {}
	
	public void setValue(Object value) {
		this.value = value;
	}
	

	public Object getValue() {
		return value;
	}

	@Override
	public Object interpret(Context context) {
		
		if(value != null) {
			if(value.toString().equals("true") || value.toString().equals("false"))
				return value.toString().equals("true");
			
			if(value instanceof String) {
				String identificator = value.toString();
				if(Utilities.TryParseDouble(value))								// Si c'est un nombre
					return (String)value;
				else {															// Si c'est une variable
					Variable v = context.FindVariable(identificator);			
					if(v != null) {
						return v.getValue();
					}else {
						context.setHasError(new ExecutionError("La variable " + identificator + " n'a pas été déclarée"));
						return null;
					}
				}
			}else if(value instanceof Item) {
				return ((Item) value).interpret(context);
			}else if(value instanceof FunctionCall) {
				return ((FunctionCall)value).interpret(context);
			}
			
		}
		context.setHasError(new ExecutionError("Le terme est vide"));
		return null;
	}

	@Override
	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
	}

}
