package ast;

import java.util.ArrayList;
import java.util.List;

public class Function_body extends ASTNode{

	 
	private List<Variable_declaration> variable_declaration_list = new ArrayList<Variable_declaration>();
	private List<Statement> statement_list = new ArrayList<Statement>();
	private Return_statement return_statement;
	
	public Function_body(List<Variable_declaration> variable_declaration_list, List<Statement> statement_list, Return_statement return_statement)
	{
		this.variable_declaration_list = variable_declaration_list;
		this.statement_list = statement_list;
		this.return_statement = return_statement;
	}
	
	public Function_body()
	{

	}
	
	public List<Variable_declaration> getVariable_declaration_list() {
		return variable_declaration_list;
	}

	public void setVariable_declaration_list(List<Variable_declaration> variable_declaration_list) {
		this.variable_declaration_list = variable_declaration_list;
	}

	public List<Statement> getStatement_list() {
		return statement_list;
	}

	public void setStatement_list(List<Statement> statement_list) {
		this.statement_list = statement_list;
	}

	public Return_statement getReturn_statement() {
		return return_statement;
	}

	public void setReturn_statement(Return_statement return_statement) {
		this.return_statement = return_statement;
	}

	public void ShowMessage() {
		System.out.println("Corps de la fonction");
	}

	@Override
	public String toString() {
		return "Function_body [variable_declaration_list=" + variable_declaration_list + ", statement_list="
				+ statement_list + ", return_statement=" + return_statement + "]";
	}
	
	public void accept(VisitorPrint visitor, int nbrOfSpaces) {
		visitor.visit(this,nbrOfSpaces);

        for (Variable_declaration vd : variable_declaration_list) {
            vd.accept(visitor);
        }
        
        for (Statement sl : statement_list) {
            sl.accept(visitor,nbrOfSpaces);
        }

	}
	
}
