package ast;

public class Variable_declaration extends ASTNode {

	
	
	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
	}
}
