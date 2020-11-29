package ast;

public class LogExpression extends Expression {
	
	private Logical_connector logical_connector;

	public LogExpression() {
		
	}
	
	public LogExpression(Expression expr_gauche, Logical_connector logical_connector, Expression expr_droite) {
		super(expr_gauche,expr_droite);
		this.logical_connector = logical_connector;
	}

	public LogExpression(Logical_connector logical_connector) {
		super();
		this.logical_connector = logical_connector;
	}

	public Logical_connector getLogical_connector() {
		return logical_connector;
	}

	public void setLogical_connector(Logical_connector logical_connector) {
		this.logical_connector = logical_connector;
	}

	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

	@Override
	public Object interpret(Context context) {		
		Object oLeft = getGauche().interpret(context);
		Object oRight = getDroite().interpret(context);
		
		if(oLeft instanceof Boolean && oRight instanceof Boolean) 
		{
			boolean left = Boolean.valueOf(oLeft.toString());
			boolean right = Boolean.valueOf(oRight.toString());
			
			switch(logical_connector.getConnector())
			{
				case "&&":
					return left&&right;
				case "||":
					return left||right;
				default:
					context.setHasError(new ExecutionError("Mauvais opérateur dans LogExpression"));
					return null;
			}
		}else 
		{
			context.setHasError(new ExecutionError("Gauche ou droite n'est pas un booléen"));
			return null;
		}
	}
	
}
