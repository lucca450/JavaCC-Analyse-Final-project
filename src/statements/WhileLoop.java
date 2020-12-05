package statements;

import java.util.ArrayList;
import executions.*;
import visitor.*;
import utilities.*;
import ast.*;

public class WhileLoop extends Statement{

	private Item expression;
	private ArrayList<Statement> body;
	
	public WhileLoop() {}
	
	public Item getExpression() {
		return expression;
	}

	public void setExpression(Item expression) {
		this.expression = expression;
	}

	public ArrayList<Statement> getBody() {
		return body;
	}

	public void setBody(ArrayList<Statement> body) {
		this.body = body;
	}

	@Override
	public Object interpret(Context context) {
		context.AddIDInPath(getID());
		Object expressionResult = expression.interpret(context);
		
		if(!context.getHasError()) {
			if(expressionResult instanceof Boolean) {
				boolean result = (boolean)expressionResult;
				if(result)
					context.AddIDInPath(getID());
				while(result) {
					for(Statement s : body) {
						s.interpret(context);
						if(context.getHasError())
							return null;
					}
					expressionResult = expression.interpret(context);
					result = (boolean)expressionResult;
				}
			}else if(expressionResult instanceof ASTNode) {}
			else {
				context.setHasError(new ExecutionError("Le r�sultat de l'expression du while doit �tre un bool�en"));
			}
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