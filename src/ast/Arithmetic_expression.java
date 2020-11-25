package ast;

import java.util.ArrayList;
import java.util.List;

public class Arithmetic_expression extends Expression{

	private Arithmetic_operation arithmetic_operation;


	public Arithmetic_expression() {
		
	}

	public Arithmetic_expression(Expression expr_gauche, Arithmetic_operation arithmetic_operation, Expression expr_droite) {
		super(expr_gauche,expr_droite);
		this.arithmetic_operation = arithmetic_operation;
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
