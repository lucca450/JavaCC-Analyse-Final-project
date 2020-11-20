package ast;

import java.util.ArrayList;
import java.util.List;

public class Function_body extends ASTNode{

	private VariableDeclarationList variable_declaration_list;
	private StatementList statement_list ;
	private Return_statement return_statement;
	
	public Function_body(VariableDeclarationList variable_declaration_list, StatementList statement_list, Return_statement return_statement)
	{
		this.variable_declaration_list = variable_declaration_list;
		this.statement_list = statement_list;
		this.return_statement = return_statement;
	}
	
	public Function_body()
	{

	}
	
	public VariableDeclarationList getVariable_declaration_list() {
		return variable_declaration_list;
	}

	public void setVariable_declaration_list(VariableDeclarationList variable_declaration_list) {
		this.variable_declaration_list = variable_declaration_list;
	}

	public StatementList getStatement_list() {
		return statement_list;
	}

	public void setStatement_list(StatementList statement_list) {
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

        for (Variable_declaration vd : variable_declaration_list.getVariable_declarationList()) {
            vd.accept(visitor);
        }
        
        for (Statement sl : statement_list.getStatement_list()) {
            sl.accept(visitor,nbrOfSpaces);
        }

	}
	
}
