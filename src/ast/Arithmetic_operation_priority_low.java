package ast;

public class Arithmetic_operation_priority_low extends Expr{
	private String operation;

	public Arithmetic_operation_priority_low(String operation) {
		this.operation = operation;
	}

	public Arithmetic_operation_priority_low() {
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
