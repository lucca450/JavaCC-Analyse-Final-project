package ast;

public class Unary_expression  extends Expression{

	private Unary_operator unary_operator;
	private Term term;
	
	public Unary_expression(Unary_operator unary_operator, Term term) {
		super();
		this.unary_operator = unary_operator;
		this.term = term;
	}
	
	public Unary_expression() {
		
	}

	public Unary_operator getUnary_operator() {
		return unary_operator;
	}

	public void setUnary_operator(Unary_operator unary_operator) {
		this.unary_operator = unary_operator;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

	@Override
	public Object interpret(Context context) {
		Object o = term.interpret(context);
		
		switch(unary_operator.getOperator())
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
				return d-1;
			}else 
			{
				context.setHasError(new ExecutionError("Doit être un nombre pour faire --"));
				return null;
			}
		case "++":
			if(o instanceof Double || o instanceof Integer) 
			{
				Double d = Double.valueOf(o.toString());
				return d+1;
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
	
	
	
	
}
