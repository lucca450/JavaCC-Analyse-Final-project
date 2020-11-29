package ast;

import java.util.ArrayList;

public class VariableDeclaration extends ASTNode{

	private String type;
	private ArrayList<Assignment> assignments; 
	
	public VariableDeclaration() {
		assignments = new ArrayList<Assignment>();
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
	}





	@Override
	public Object interpret(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		// TODO Auto-generated method stub
		
	}

}
