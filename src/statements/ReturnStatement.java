package statements;

import executions.*;
import visitor.*;
import utilities.*;
import ast.*;

public class ReturnStatement extends Statement{

	private Item expression;
	
	public Item getExpression() {
		return expression;
	}

	public void setExpression(Item expression) {
		this.expression = expression;
	}

	@Override
	public Object interpret(Context context) {
		String functionType = context.getResultType();
		Object expressionResult = expression.interpret(context);
		if(Utilities.TryParseInt(expressionResult)) {			//	Si c'est un int
			if(functionType.equals("int")) {
				context.setResult(expressionResult);
			}else {
				context.setHasError(new ExecutionError("L'expression de retour doit �tre un entier"));
			}
		}else if(Utilities.TryParseDouble(expressionResult)) {	//	Si c'est un double
			if(functionType.equals("double")) {
				context.setResult(expressionResult);
			}else {
				context.setHasError(new ExecutionError("L'expression de retour doit �tre un nombre d�cimal"));
			}
		}else if(expressionResult instanceof Boolean) {			//	Si c'est un bool�en
			if(functionType.equals("bool")) {
				context.setResult(expressionResult);
			}else {
				context.setHasError(new ExecutionError("L'expression de retour doit �tre un bool�en"));
			}
		}else if(expressionResult instanceof ASTNode) {			// Si l'expression d�rive d'un appel de fonction
			context.setResult(expressionResult);
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
