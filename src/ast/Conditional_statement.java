package ast;

import java.util.ArrayList;
import java.util.List;

public class Conditional_statement extends ASTNode {
	
	private Expression expression;
	private List<Statement> statement_list = new ArrayList<Statement>();
	
	public Conditional_statement(Expression expression, List<Statement> statement_list) {
		this.expression = expression;
		this.statement_list = statement_list;
	}

	public Conditional_statement() {
		
	}
	
	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public List<Statement> getStatement_list() {
		return statement_list;
	}

	public void setStatement_list(List<Statement> statement_list) {
		this.statement_list = statement_list;
	}

	public void ShowMessage() {
		System.out.println("Expression conditionnelle"); 
	}

	@Override
	public String toString() {
		return "Conditional_statement [expression=" + expression + ", statement_list=" + statement_list + "]";
	}
	
	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
		
		expression.accept(visitor);

        for (Statement s : statement_list) {
            s.accept(visitor);
        }
	}
	
}
