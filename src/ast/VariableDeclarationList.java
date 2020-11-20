package ast;

import java.util.ArrayList;
import java.util.List;

public class VariableDeclarationList {
	List<Variable_declaration> variable_declarationList = new ArrayList<Variable_declaration>();

	public VariableDeclarationList(List<Variable_declaration> variable_declarationList) {
		this.variable_declarationList = variable_declarationList;
	}

	public VariableDeclarationList() {
		
	}

	public List<Variable_declaration> getVariable_declarationList() {
		return variable_declarationList;
	}

	public void setVariable_declarationList(List<Variable_declaration> variable_declarationList) {
		this.variable_declarationList = variable_declarationList;
	}

	public void add(Variable_declaration vd) {
		variable_declarationList.add(vd);
	}
}
