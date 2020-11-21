package ast;

import java.util.ArrayList;
import java.util.List;

public class Expression extends ASTNode {
	private Comparaison_expression comparaison_expression;
	private Logical_connector logical_connector;

	
	
	public Expression(Comparaison_expression comparaison_expression, Logical_connector logical_connector) {
		this.comparaison_expression = comparaison_expression;
		this.logical_connector = logical_connector;
	}


	
	public Expression() {
		
	}

	public Comparaison_expression getComparaison_expression() {
		return comparaison_expression;
	}

	public void setComparaison_expression(Comparaison_expression comparaison_expression) {
		this.comparaison_expression = comparaison_expression;
	}
	
	

	public Logical_connector getLogical_connector() {
		return logical_connector;
	}

	public void setLogical_connector(Logical_connector logical_connector) {
		this.logical_connector = logical_connector;
	}

	@Override
	public String toString() {
		return ""+comparaison_expression + " " + logical_connector;
	}
	
	public void accept(VisitorPrint visitor,int nbrOfSpaces) {
		visitor.visit(this);
		
		comparaison_expression.accept(visitor, nbrOfSpaces);
		
		logical_connector.accept(visitor,  nbrOfSpaces);
		
		comparaison_expression.accept(visitor, nbrOfSpaces);
	}
	
}
