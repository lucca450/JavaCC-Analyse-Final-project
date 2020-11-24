package ast;

public class Arithmetic_operation extends Expr{
	private String operation;

	public Arithmetic_operation(String operation) {
		this.operation = operation;
	}

	public Arithmetic_operation() {
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
	}
	
	
}
