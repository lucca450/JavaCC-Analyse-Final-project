package ast;

public class Statement extends ASTNode {
	private Conditional_statement conditional_statement;
	private Assignment assignment;
	private FunctionCall functionCall;
	
	public Statement() {

	}
	
	public FunctionCall getFunctionCall() {
		return functionCall;
	}

	public void setFunctionCall(FunctionCall fonctionCall) {
		this.functionCall = fonctionCall;
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
	
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab + 1);
		
		/*
        try {
            conditional_statement.accept(visitor,nbrOfSpaces+1);
        }
        catch(Exception e) {
        	assignment.accept(visitor,nbrOfSpaces+1);
        }
*/
     
	}

	@Override
	public Object interpret(Context context) {
		if(conditional_statement != null) {
			conditional_statement.interpret(context);			
		}
		
		if(assignment != null){			
			Variable v = context.FindVariable(assignment.getID());
			if(v != null) 
			{
				Object o = assignment.interpret(context);
				if(v.getType() == "int")
				{
					v.setValue((int)o);
				}else if(v.getType() == "double")
				{
					v.setValue((double)o);
				}else
				{
					v.setValue((boolean)o);
				}
				
			}
		}
		return null;
	}
}
