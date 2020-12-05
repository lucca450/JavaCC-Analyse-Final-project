package ast;

import executions.*;
import statements.*;
import visitor.*;
import utilities.*;

public class ParameterDeclaration extends ASTNode {
	private String type;
	private String parameterName;
	
	public ParameterDeclaration(String type, String parameterName) 
	{
		this.type = type;
		this.parameterName = parameterName;
	}
	
	public ParameterDeclaration() 
	{

	}
	
	public String getType() {
		return type;
	}
	
	public String getParameterName() {
		return parameterName;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public void accept(VisitorPrint visitor) {
		visitor.PreVisit();
		visitor.visit(this);
		visitor.PostVisit();
	}

	@Override
	public Object interpret(Context context) {
		System.out.println("Parameter_declaration ne devrait pas se faire interpreter");
		return null;
	}

}
