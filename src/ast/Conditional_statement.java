package ast;

import java.util.ArrayList;
import java.util.List;

public class Conditional_statement extends Statement {
	
	private Expression expression;
	private StatementList ifBody;
	private StatementList elseBody;
	
	public Conditional_statement(Expression expression, StatementList ifB, StatementList elseB) {
		super();
		this.expression = expression;
		this.ifBody = ifB;
		this.elseBody = elseB;
	}

	public Conditional_statement() {
		
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public StatementList getIfBody() {
		return ifBody;
	}

	public void setIfBody(StatementList ifBody) {
		this.ifBody = ifBody;
	}

	public StatementList getElseBody() {
		return elseBody;
	}

	public void setElseBody(StatementList elseBody) {
		this.elseBody = elseBody;
	}

	public void ShowMessage() {
		System.out.println("Expression conditionnelle"); 
	}
	
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	
		/*if( statement_list.getStatement_list().size() != 0) {
	        for (Statement s : statement_list.getStatement_list()) {
	            s.accept(visitor);
	        }
		}*/
	}
	
}
