package ast;

public class Expr extends ASTNode{

	public Expr() {

	}


	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
	}

}
