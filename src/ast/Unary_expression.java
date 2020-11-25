package ast;

import java.util.ArrayList;
import java.util.List;

public class Unary_expression  extends Expression{

	private Unary_operator unary_operator;
	private Term term;
	
	public Unary_expression(Unary_operator unary_operator, Term term) {
		super();
		this.unary_operator = unary_operator;
		this.term = term;
	}
	
	public Unary_expression() {
		
	}

	public Unary_operator getUnary_operator() {
		return unary_operator;
	}

	public void setUnary_operator(Unary_operator unary_operator) {
		this.unary_operator = unary_operator;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
	}
	
	
	
	
}
