package ast;

public class LogExpression extends Expression{
	private String connector;

	public LogExpression() {
		
	}
	
	public String getConnector() {
		return connector;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}

	@Override
	public void accept(VisitorPrint visitor) {
		visitor.PreVisit();
		visitor.visit(this);
		visitor.PostVisit();
	}

	@Override
	public Object interpret(Context context) {		
		Object oLeft = getGauche().interpret(context);
		Object oRight = getDroite().interpret(context);
		
		if(oLeft instanceof Boolean && oRight instanceof Boolean) 
		{
			boolean left = Boolean.valueOf(oLeft.toString());
			boolean right = Boolean.valueOf(oRight.toString());
			
			switch(connector)
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
