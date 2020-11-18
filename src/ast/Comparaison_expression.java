package ast;

public class Comparaison_expression extends ASTNode {
	private Value value;
	private Comparaison_operator comparaison_operator;
	private Value value2;
	
	
	public Comparaison_expression(Value value, Comparaison_operator comparaison_operator, Value value2) {
		this.value = value;
		this.comparaison_operator = comparaison_operator;
		this.value2 = value2;
	}
	
	public Comparaison_expression() {

	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public Value getValue2() {
		return value2;
	}

	public void setValue2(Value value2) {
		this.value2 = value2;
	}

	public Comparaison_operator getComparaison_operator() {
		return comparaison_operator;
	}

	public void setComparaison_operator(Comparaison_operator comparaison_operator) {
		this.comparaison_operator = comparaison_operator;
	}

	@Override
	public String toString() {
		return "Comparaison_expression [value=" + value + ", comparaison_operator=" + comparaison_operator + ", value2="
				+ value2 + "]";
	}

	public void accept(VisitorPrint visitor, int nbrOfSpaces) {
		/*value.accept(visitor);
		comparaison_operator.accept(visitor);
		value2.accept(visitor);*/
		
		visitor.visit(this,nbrOfSpaces+1);
	}



	
}
