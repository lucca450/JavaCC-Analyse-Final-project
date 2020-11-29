package ast;

import java.util.ArrayList;

public class FunctionBody extends ASTNode {
	private ArrayList<VariableDeclaration> variableDeclarations;
	private ArrayList<Statement> statements;

	public FunctionBody() {}
	
	public ArrayList<VariableDeclaration> getVariableDeclarations() {
		return variableDeclarations;
	}

	public void setVariableDeclarations(ArrayList<VariableDeclaration> variableDeclarations) {
		this.variableDeclarations = variableDeclarations;
	}

	public ArrayList<Statement> getStatements() {
		return statements;
	}

	public void setStatements(ArrayList<Statement> statements) {
		this.statements = statements;
	}

	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}
	
	@Override
	public Object interpret(Context context) {
		
		for(VariableDeclaration vD : variableDeclarations)
		{
			if(!context.getHasError()) {
				vD.interpret(context);				
			}else {
				return null;
			}
		}
				
		for(Statement s : statements)
		{
			if(!context.getHasError()) {
				if(s instanceof ReturnStatement) {
					s.interpret(context);
				}
				s.interpret(context);				
			}else {
				return null;
			}
		}
		return null;
	}
}
