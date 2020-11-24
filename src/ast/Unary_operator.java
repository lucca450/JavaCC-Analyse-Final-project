package ast;

public class Unary_operator extends Expr{
	private String operator;

	public Unary_operator() {
	}
	
	public Unary_operator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
	}
	
	
}
