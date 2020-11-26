package ast;

import java.util.ArrayList;
import java.util.List;

public class Comparaison_expression extends Expression {
	
	private Comparaison_operator comparaison_operator;


	public Comparaison_expression() {

	}

	

	public Comparaison_expression(Expression expr_gauche, Comparaison_operator comparaison_operator, Expression expr_droite) {
		super(expr_gauche, expr_droite);
		this.comparaison_operator = comparaison_operator;
	}

	public Comparaison_operator getComparaison_operator() {
		return comparaison_operator;
	}


	public void setComparaison_operator(Comparaison_operator comparaison_operator) {
		this.comparaison_operator = comparaison_operator;
	}

	public void accept(VisitorPrint visitor, int nbTab) {	
		visitor.visit(this, nbTab);
	}
	
}
