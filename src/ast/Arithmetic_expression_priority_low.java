package ast;

import java.util.ArrayList;
import java.util.List;

public class Arithmetic_expression_priority_low extends ASTNode{
	private List<Arithmetic_expression> arithmetic_expressionList = new ArrayList<Arithmetic_expression>();
	private List<Arithmetic_operation_piority_low> arithmetic_operation_piority_lowList = new ArrayList<Arithmetic_operation_piority_low>();
	
	
	public Arithmetic_expression_priority_low() {
	}


	public Arithmetic_expression_priority_low(List<Arithmetic_expression> arithmetic_expressionList, List<Arithmetic_operation_piority_low> arithmetic_operation_piority_lowList) {
		this.arithmetic_expressionList = arithmetic_expressionList;
		this.arithmetic_operation_piority_lowList = arithmetic_operation_piority_lowList;
	}


	public List<Arithmetic_expression> getArithmetic_expressionList() {
		return arithmetic_expressionList;
	}


	public void setArithmetic_expressionList(List<Arithmetic_expression> arithmetic_expressionList) {
		this.arithmetic_expressionList = arithmetic_expressionList;
	}


	public List<Arithmetic_operation_piority_low> getArithmetic_operation_piority_lowList() {
		return arithmetic_operation_piority_lowList;
	}


	public void setArithmetic_operation_piority_lowList(List<Arithmetic_operation_piority_low> arithmetic_operation_piority_lowList) {
		this.arithmetic_operation_piority_lowList = arithmetic_operation_piority_lowList;
	}


	public void accept(VisitorPrint visitor, int nbrOfSpaces) {
		visitor.visit(this,nbrOfSpaces);
	}




}
