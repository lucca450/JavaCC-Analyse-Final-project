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

	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
	}
	
}
