package ast;

import java.util.ArrayList;

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
		Object expressionResult = expression.interpret(context);
		
		if(expressionResult instanceof Boolean) {
			boolean result = (boolean)expressionResult;
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
			context.setHasError(new ExecutionError("Le résultat de l'expression du while doit être un booléen"));
		}
		return null;
	}

	@Override
	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
	}

}
