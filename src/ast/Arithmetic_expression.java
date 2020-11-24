package ast;

import java.util.ArrayList;
import java.util.List;

public class Arithmetic_expression extends Expr{

	private Expr expr_gauche;
	private Arithmetic_operation arithmetic_operation;
	private Expr expr_droite;


	public Arithmetic_expression() {
		
	}

	public Arithmetic_expression(Expr expr_gauche, Arithmetic_operation arithmetic_operation, Expr expr_droite) {
		super();
		this.expr_gauche = expr_gauche;
		this.arithmetic_operation = arithmetic_operation;
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

	public Arithmetic_operation getArithmetic_operation() {
		return arithmetic_operation;
	}



	public void setArithmetic_operation(Arithmetic_operation arithmetic_operation) {
		this.arithmetic_operation = arithmetic_operation;
	}



	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
	}
	
	
}
