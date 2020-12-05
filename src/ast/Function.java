package ast;

import java.util.ArrayList;
import java.util.List;
import executions.*;
import statements.*;
import visitor.*;
import utilities.*;

public class Function extends ASTNode{

	private String type;
	private String functionName;
	private List<ParameterDeclaration> parameterDeclarations = new ArrayList<ParameterDeclaration>();
	private FunctionBody functionBody;
	private int nbConditions = 0;	
	
	public Function(String type, String function_name, List<ParameterDeclaration> parameterDeclarations, FunctionBody functionBody) {
		this.type = type;
		this.functionName = function_name;
		this.parameterDeclarations = parameterDeclarations;
		this.functionBody = functionBody;
	}

	public Function( String type, String function_name) {
		this.type = type;
		this.functionName = function_name;
	}

	public void IncrementNbConditions() {
		nbConditions++;
	}
	
	public int GetNbPaths() {
		return nbConditions + 1;
	}

	@Override
	public String toString() {
		return "Function [type=" + type + ", function_name=" + functionName + ", parameterDeclarations="
				+ parameterDeclarations + ", FunctionBody=" + functionBody + "]";
	}
	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getFunctionName() {
		return functionName;
	}


	public void setFunctionName(String function_name) {
		this.functionName = function_name;
	}


	public List<ParameterDeclaration> getParameterDeclarations() {
		return parameterDeclarations;
	}


	public void setParameterDeclarations(List<ParameterDeclaration> parameterDeclarations) {
		this.parameterDeclarations = parameterDeclarations;
	}


	public FunctionBody getFunctionBody() {
		return functionBody;
	}


	public void setFunctionBody(FunctionBody functionBody) {
		this.functionBody = functionBody;
	}
	
	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
		
		
        for (ParameterDeclaration pd : parameterDeclarations) {
            pd.accept(visitor);
        }
        functionBody.accept(visitor);
	}

	@Override
	public Object interpret(Context context) {
		functionBody.interpret(context);
		if(!context.getHasError()  && (context.getResult() == null && !type.equals("void")))
			context.setHasError(new ExecutionError("La fonction a un type de retour, mais n'a pas de return statement"));
		return null;
	}
	
}
