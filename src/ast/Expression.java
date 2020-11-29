package ast;

public abstract class Expression extends ASTNode{

	protected Expression gauche;
	protected Expression droite;
	
	public Expression() {

	}

	public Expression(Expression expr_gauche, Expression expr_droite) {
		gauche = expr_gauche;
		droite = expr_droite;
	}
	
	public abstract void accept(VisitorPrint visitor, int nbTab);


	public Expression getGauche() {
		return gauche;
	}


	public void setGauche(Expression gauche) {
		this.gauche = gauche;
	}


	public Expression getDroite() {
		return droite;
	}


	public void setDroite(Expression droite) {
		this.droite = droite;
	}

	
	
	
	
}
