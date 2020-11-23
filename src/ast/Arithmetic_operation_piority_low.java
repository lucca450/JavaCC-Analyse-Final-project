package ast;

public class Arithmetic_operation_piority_low extends ASTNode{
	private String operation;

	public Arithmetic_operation_piority_low(String operation) {
		this.operation = operation;
	}

	public Arithmetic_operation_piority_low() {
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void accept(VisitorPrint visitor, int nbrOfSpaces) {
		visitor.visit(this, nbrOfSpaces);
	}
	
	
}
