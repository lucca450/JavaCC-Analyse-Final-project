package statements;

import java.util.ArrayList;
import executions.*;
import visitor.*;
import utilities.*;
import ast.*;

public class ConditionalStatement extends Statement{

	private Item expression;
	private ArrayList<Statement> ifBody;
	private ArrayList<Statement> elseBody;
	
	public ConditionalStatement() {}
	
	public Item getExpression() {
		return expression;
	}

	public void setExpression(Item expression) {
		this.expression = expression;
	}

	public ArrayList<Statement> getIfBody() {
		return ifBody;
	}

	public void setIfBody(ArrayList<Statement> ifBody) {
		this.ifBody = ifBody;
	}

	public ArrayList<Statement> getElseBody() {
		return elseBody;
	}

	public void setElseBody(ArrayList<Statement> elseBody) {
		this.elseBody = elseBody;
	}

	public void ShowMessage() {
		System.out.println("Expression conditionnelle"); 
	}
	
	@Override
	public Object interpret(Context context) {
		Object expressionResult = expression.interpret(context);
		if(expressionResult instanceof Boolean) {
			boolean result = (boolean)expressionResult;
			if(result) {
				context.AddIDInPath(getID());		//	Ajoute le ID du conditional statement dans le chemin parcouru
				for(Statement s : ifBody){
					if(context.getHasError())
						return null;
					s.interpret(context);
				}
			}else{
				for(Statement s : elseBody){
					if(context.getHasError())
						return null;
					s.interpret(context);
				}
			}
		}else if(expressionResult instanceof ASTNode){	//	Si expression d?rive d'un appel de fonction, ignore
		}else {
			context.setHasError(new ExecutionError("Le r?sultat du if doit ?tre un bool?en"));
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
