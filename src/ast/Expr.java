package ast;

public abstract class Expr extends ASTNode{

	public Expr() {

	}


	public abstract void accept(VisitorPrint visitor) ;

}
