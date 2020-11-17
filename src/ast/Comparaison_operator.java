package ast;

public class Comparaison_operator extends ASTNode {
	private String comparaison_operator;

	public Comparaison_operator(String comparaison_operator) {
		this.comparaison_operator = comparaison_operator;
	}
	
	public Comparaison_operator() {
		
	}

	public String getComparaison_operator() {
		return comparaison_operator;
	}

	public void setComparaison_operator(String comparaison_operator) {
		this.comparaison_operator = comparaison_operator;
	}

	@Override
	public String toString() {
		return comparaison_operator.toString();
	}
	
	
	
}
