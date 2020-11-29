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
		
		if(value instanceof String) {
			return (String)value;
		}else if(value instanceof Expression) {
			return ((Expression) value).interpret(context);
		}
		
		context.setHasError(new ExecutionError("Le terme est vide"));
		return null;
	}

	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

}
