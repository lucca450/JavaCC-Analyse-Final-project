package ast;

import java.util.ArrayList;
import java.util.List;

public class Arithmetic_expression_priority_low extends Expression{
	
	private Arithmetic_operation_priority_low arithmetic_operation_piority_low;
	
	public Arithmetic_expression_priority_low() {
	}

	public Arithmetic_expression_priority_low(Expression expr_gauche,Arithmetic_operation_priority_low arithmetic_operation_piority_low, Expression expr_droite) {
		super(expr_gauche, expr_droite);
		this.arithmetic_operation_piority_low = arithmetic_operation_piority_low;
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
