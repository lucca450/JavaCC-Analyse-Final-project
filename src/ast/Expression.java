package ast;

public class Expression extends ASTNode {
	private Comparaison_expression comparaison_expression;

	public Expression(Comparaison_expression comparaison_expression) {
		this.comparaison_expression = comparaison_expression;
	}
	
	public Expression() {
		
	}

	public Comparaison_expression getComparaison_expression() {
		return comparaison_expression;
	}

	public void setComparaison_expression(Comparaison_expression comparaison_expression) {
		this.comparaison_expression = comparaison_expression;
	}

	@Override
	public String toString() {
		return "Expression [comparaison_expression=" + comparaison_expression + "]";
	}
	
	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
		
		comparaison_expression.accept(visitor);
	}
	
}
