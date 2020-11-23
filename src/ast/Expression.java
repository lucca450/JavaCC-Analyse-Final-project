package ast;

import java.util.ArrayList;
import java.util.List;

public class Expression extends Expr {
	
	private Expr expr_gauche;
	private Logical_connector logical_connector;
	private Expr expr_droite;


	public Expression() {
		
	}
	
	public Expression(Expr expr_gauche, Logical_connector logical_connector, Expr expr_droite) {
		super();
		this.expr_gauche = expr_gauche;
		this.logical_connector = logical_connector;
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

	public Logical_connector getLogical_connector() {
		return logical_connector;
	}

	public void setLogical_connector(Logical_connector logical_connector) {
		this.logical_connector = logical_connector;
	}



	public void accept(VisitorPrint visitor,int nbrOfSpaces) {
		visitor.visit(this,nbrOfSpaces);
	}
	
}
