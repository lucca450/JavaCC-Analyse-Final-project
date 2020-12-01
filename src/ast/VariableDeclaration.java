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
		for(Assignment a : assignments) {
			a.interpret(context);
			if(context.getHasError() || context.HasResult())
				return null;
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
