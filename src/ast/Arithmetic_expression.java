package ast;

import java.util.ArrayList;
import java.util.List;

public class Arithmetic_expression extends ASTNode{

	private List<Unary_expression> unary_expressionList = new ArrayList<Unary_expression>();
	private List<Arithmetic_operation> arithmetic_operationList = new ArrayList<Arithmetic_operation>();
	
	
	public Arithmetic_expression(List<Unary_expression> unary_expressionList, List<Arithmetic_operation> arithmetic_operationList) {
		this.unary_expressionList = unary_expressionList;
		this.arithmetic_operationList = arithmetic_operationList;
	}

	public Arithmetic_expression() {
		
	}

	public List<Unary_expression> getUnary_expressionList() {
		return unary_expressionList;
	}

	public void setUnary_expressionList(List<Unary_expression> unary_expressionList) {
		this.unary_expressionList = unary_expressionList;
	}

	public List<Arithmetic_operation> getArithmetic_operationList() {
		return arithmetic_operationList;
	}

	public void setArithmetic_operationList(List<Arithmetic_operation> arithmetic_operationList) {
		this.arithmetic_operationList = arithmetic_operationList;
	}

	public void accept(VisitorPrint visitor, int nbrOfSpaces) {
		visitor.visit(this, nbrOfSpaces);
	}
	
	
}
