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
		if(Utilities.TryParseInt(expressionResult)) {
			if(functionType.equals("int")) {
				context.setResult(expressionResult);
			}else {
				context.setHasError(new ExecutionError("L'expression de retour doit être un entier"));
			}
		}else if(Utilities.TryParseDouble(expressionResult)) {
			if(functionType.equals("double")) {
				context.setResult(expressionResult);
			}else {
				context.setHasError(new ExecutionError("L'expression de retour doit être un nombre décimal"));
			}
		}else if(expressionResult instanceof Boolean) {
			if(functionType.equals("bool")) {
				context.setResult(expressionResult);
			}else {
				context.setHasError(new ExecutionError("L'expression de retour doit être un booléen"));
			}
		}else if(expressionResult instanceof ASTNode) {
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
