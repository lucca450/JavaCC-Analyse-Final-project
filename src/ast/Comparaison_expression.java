package ast;

import java.util.ArrayList;
import java.util.List;

public class Comparaison_expression extends Expr {
	
	private Expr expr_gauche;
	private Comparaison_operator comparaison_operator;
	private Expr expr_droite;


	public Comparaison_expression() {

	}

	

	public Comparaison_expression(Expr expr_gauche, Comparaison_operator comparaison_operator, Expr expr_droite) {
		super();
		this.expr_gauche = expr_gauche;
		this.comparaison_operator = comparaison_operator;
		this.expr_droite = expr_droite;
	}



	public Expr getExpr_gauche() {
		return expr_gauche;
	}



	public void setExpr_gauche(Expr expr_gauche) {
		this.expr_gauche = expr_gauche;
	}



	public Expr getExpr_droite() {
		return expr_droite;
	}



	public void setExpr_droite(Expr expr_droite) {
		this.expr_droite = expr_droite;
	}



	public Comparaison_operator getComparaison_operator() {
		return comparaison_operator;
	}


	public void setComparaison_operator(Comparaison_operator comparaison_operator) {
		this.comparaison_operator = comparaison_operator;
	}



	public void accept(VisitorPrint visitor, int nbrOfSpaces) {
	
		visitor.visit(this,nbrOfSpaces);
	}
	
}
