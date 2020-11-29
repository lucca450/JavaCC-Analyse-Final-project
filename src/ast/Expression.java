package ast;

public abstract class Expression extends Item{
	
	protected Item gauche;
	protected Item droite;
	
	public Expression() {

	}

	public Expression(Expression expr_gauche, Expression expr_droite) {
		gauche = expr_gauche;
		droite = expr_droite;
	}
	
	public Item getGauche() {
		return gauche;
	}


	public void setGauche(Item gauche) {
		this.gauche = gauche;
	}


	public Item getDroite() {
		return droite;
	}


	public void setDroite(Item droite) {
		this.droite = droite;
	}
}
