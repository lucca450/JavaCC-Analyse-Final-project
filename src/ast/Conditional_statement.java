package ast;

import java.util.ArrayList;
import java.util.List;

public class Conditional_statement extends Statement {
	
	private Expression expression;
	private StatementList statement_list;
	
	public Conditional_statement(Expression expression, StatementList statement_list) {
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

	public StatementList getStatement_list() {
		return statement_list;
	}

	public void setStatement_list(StatementList statement_list) {
		this.statement_list = statement_list;
	}

	public void ShowMessage() {
		System.out.println("Expression conditionnelle"); 
	}

	@Override
	public String toString() {
		return "Conditional_statement [expression=" + expression + ", statement_list=" + statement_list + "]";
	}
	
	public void accept(VisitorPrint visitor, int nbrOfSpaces) {
		visitor.visit(this,nbrOfSpaces);
		
		expression.accept(visitor, nbrOfSpaces);

		
        for (Statement s : statement_list.getStatement_list()) {
            s.accept(visitor,nbrOfSpaces);
        }

	}
	
}
