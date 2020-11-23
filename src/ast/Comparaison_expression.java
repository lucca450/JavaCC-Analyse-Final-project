package ast;

import java.util.ArrayList;
import java.util.List;

public class Comparaison_expression extends ASTNode {
	
	List<Arithmetic_expression_priority_low> arithmetic_expression_priority_lowList = new ArrayList<Arithmetic_expression_priority_low>();
	List<Comparaison_operator> comparaison_operatorList = new ArrayList<Comparaison_operator>();

	public Comparaison_expression() {

	}
	
	public Comparaison_expression(List<Arithmetic_expression_priority_low> arithmetic_expression_priority_lowList,List<Comparaison_operator> comparaison_operatorList) {
		this.arithmetic_expression_priority_lowList = arithmetic_expression_priority_lowList;
		this.comparaison_operatorList = comparaison_operatorList;
	}


	public List<Arithmetic_expression_priority_low> getArithmetic_expression_priority_lowList() {
		return arithmetic_expression_priority_lowList;
	}

	public void setArithmetic_expression_priority_lowList(List<Arithmetic_expression_priority_low> arithmetic_expression_priority_lowList) {
		this.arithmetic_expression_priority_lowList = arithmetic_expression_priority_lowList;
	}

	public List<Comparaison_operator> getComparaison_operatorList() {
		return comparaison_operatorList;
	}

	public void setComparaison_operatorList(List<Comparaison_operator> comparaison_operatorList) {
		this.comparaison_operatorList = comparaison_operatorList;
	}

	public void accept(VisitorPrint visitor, int nbrOfSpaces) {
	
		visitor.visit(this,nbrOfSpaces);
	}
	
}
