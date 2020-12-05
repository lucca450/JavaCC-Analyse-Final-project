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
		Object expressionResult = expression.interpret(context);
		if(!context.getHasError()) {
			if(expressionResult instanceof Boolean) {			// Si l'expression est un booléen
				boolean result = (boolean)expressionResult;
				if(result)
					context.AddIDInPath(getID());				// Ajoute le ID du while dans le chemin parcouru
				while(result) {
					for(Statement s : body) {
						s.interpret(context);
						if(context.getHasError())
							return null;
					}
					expressionResult = expression.interpret(context);	//	Recalcule l'expression
					result = (boolean)expressionResult;
				}
			}else if(expressionResult instanceof ASTNode) {}			//	Si l'expression dérive d'un appel de fonction
			else {
				context.setHasError(new ExecutionError("Le résultat de l'expression du while doit être un booléen"));
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
