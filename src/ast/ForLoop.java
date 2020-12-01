package ast;

import java.util.ArrayList;

public class ForLoop extends Statement{

	Assignment startAssignment;
	Item expression;
	Assignment iterationAssignment;
	ArrayList<Statement> body;
	
	public ForLoop() {}
	
	public ArrayList<Statement> getBody() {
		return body;
	}

	public void setBody(ArrayList<Statement> body) {
		this.body = body;
	}

	public Assignment getStartAssignment() {
		return startAssignment;
	}

	public void setStartAssignment(Assignment startAssignment) {
		this.startAssignment = startAssignment;
	}

	public Item getExpression() {
		return expression;
	}

	public void setExpression(Item expression) {
		this.expression = expression;
	}

	public Assignment getIterationAssignment() {
		return iterationAssignment;
	}

	public void setIterationAssignment(Assignment iterationAssignment) {
		this.iterationAssignment = iterationAssignment;
	}

	@Override
	public Object interpret(Context context) {
		if(startAssignment != null) {
			startAssignment.interpret(context);			
		}
		
		if(expression == null) {
			while(true) {
				for(Statement s : body) {
					s.interpret(context);
				}
				System.out.println("For infini");
				if(context.getHasError())
					return null;
			}
		}
		
		Object expressionResult = expression.interpret(context);
		if(expressionResult instanceof Boolean) {
			boolean result = (boolean)expressionResult;
			while(result) {
				for(Statement s : body) {
					s.interpret(context);
					if(context.getHasError())
						return null;
				}
				if(iterationAssignment != null) {
					iterationAssignment.interpret(context);
				}
				expressionResult = expression.interpret(context);					
				result = (boolean)expressionResult;
			}
		}else if(expressionResult instanceof ASTNode) {}
		else {
			context.setHasError(new ExecutionError("Le résultat de l'expression du for doit être un booléen"));
		}
		
		return null;
	}

	@Override
	public void accept(VisitorPrint visitor) {
		visitor.PreVisit();
		visitor.visit(this);
		visitor.PostVisit();
	}

}
