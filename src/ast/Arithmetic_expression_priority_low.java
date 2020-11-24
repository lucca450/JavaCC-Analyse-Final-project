package ast;

import java.util.ArrayList;
import java.util.List;

public class Arithmetic_expression_priority_low extends Expr{
	
	private Expr expr_gauche;
	private Arithmetic_operation_priority_low arithmetic_operation_piority_low;
	private Expr expr_droite;
	
	
	
	public Arithmetic_expression_priority_low() {
	}

	public Arithmetic_expression_priority_low(Expr expr_gauche,Arithmetic_operation_priority_low arithmetic_operation_piority_low, Expr expr_droite) {
		super();
		this.expr_gauche = expr_gauche;
		this.arithmetic_operation_piority_low = arithmetic_operation_piority_low;
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

	public Arithmetic_operation_priority_low getArithmetic_operation_piority_low() {
		return arithmetic_operation_piority_low;
	}



	public void setArithmetic_operation_piority_low(Arithmetic_operation_priority_low arithmetic_operation_piority_low) {
		this.arithmetic_operation_piority_low = arithmetic_operation_piority_low;
	}


	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
	}




}
