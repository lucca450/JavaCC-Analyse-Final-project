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
		
		// vérifier que c'est bien des booleans
		
		
		Boolean left = (Boolean)this.getGauche().interpret(context);
		Boolean right = (Boolean)this.getDroite().interpret(context);
		
		switch(logical_connector.getConnector())
		{
		case "&&":
			return left&&right;
		case "||":
			return left||right;
			default:
				System.out.println("Something went wrong interpret LogExpression");
				return null;
		}
	}
	
}
