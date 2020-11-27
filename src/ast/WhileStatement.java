package ast;

public class WhileStatement extends Statement {
	
	private Expression expression;
	private StatementList whileBody;

	public WhileStatement(Conditional_statement conditional_statement, Assignment assignment) {
		super(conditional_statement, assignment);
		// TODO Auto-generated constructor stub
	}

	public WhileStatement() {
		// TODO Auto-generated constructor stub
	}

}
