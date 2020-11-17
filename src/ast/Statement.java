package ast;

public class Statement extends ASTNode {
	private Conditional_statement conditional_statement;
	private Assignment assignment;
	 
	public Statement(Conditional_statement conditional_statement, Assignment assignment) {
		this.conditional_statement = conditional_statement;
		this.assignment = assignment;
	}
	
	public Statement() {

	}

	public Conditional_statement getConditional_statement() {
		return conditional_statement;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setConditional_statement(Conditional_statement conditional_statement) {
		this.conditional_statement = conditional_statement;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	@Override
	public String toString() {
		return "Statement [conditional_statement=" + conditional_statement + ", assignment=" + assignment + "]";
	}
	
	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
		
        conditional_statement.accept(visitor);
        //PAS IMPLEMENT/ ENCORE  assignment.accept(visitor);
	}
}
