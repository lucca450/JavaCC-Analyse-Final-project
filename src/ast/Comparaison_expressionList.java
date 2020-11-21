package ast;

import java.util.ArrayList;
import java.util.List;

public class Comparaison_expressionList  {
	
	List<Comparaison_expression> comparaison_expressionList = new ArrayList<Comparaison_expression>();

	public Comparaison_expressionList(List<Comparaison_expression> comparaison_expressionList) {
		this.comparaison_expressionList = comparaison_expressionList;
	}
		
	public Comparaison_expressionList() {
		
	}

	public List<Comparaison_expression> getComparaison_expressionList() {
		return comparaison_expressionList;
	}
	
	public void setComparaison_expressionList(List<Comparaison_expression> comparaison_expressionList) {
		this.comparaison_expressionList = comparaison_expressionList;
	}

	public void add(Comparaison_expression ce) {
		comparaison_expressionList.add(ce);
	}

	public void accept(VisitorPrint visitor, int nbrOfSpaces) {

		visitor.visit(this,nbrOfSpaces+1);
	}
}
