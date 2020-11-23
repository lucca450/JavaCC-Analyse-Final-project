package ast;

import java.util.ArrayList;
import java.util.List;

public class Expression extends ASTNode {
	
	private Comparaison_expressionList comparaison_expressionList;
	private Logical_connectorList logical_connectorList;

	
	
	public Expression(Comparaison_expressionList comparaison_expressionList, Logical_connectorList logical_connectorList ) {
		this.comparaison_expressionList = comparaison_expressionList;
		this.logical_connectorList = logical_connectorList;
		
	}
	
	public Expression() {
		
	}
	
	public Comparaison_expressionList getComparaison_expressionList() {
		return comparaison_expressionList;
	}

	public void setComparaison_expressionList(Comparaison_expressionList comparaison_expressionList) {
		this.comparaison_expressionList = comparaison_expressionList;
	}

	public Logical_connectorList getLogical_connectorList() {
		return logical_connectorList;
	}

	public void setLogical_connectorList(Logical_connectorList logical_connectorList) {
		this.logical_connectorList = logical_connectorList;
	}

	@Override
	public String toString() {
		return ""+ comparaison_expressionList  + " " +  logical_connectorList;
	}
	
	public void accept(VisitorPrint visitor,int nbrOfSpaces) {
		visitor.visit(this,nbrOfSpaces);
	}
	
}
