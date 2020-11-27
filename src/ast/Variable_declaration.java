package ast;

public class Variable_declaration extends ASTNode {
	private String type;
	private AssignmentList assignment_list; 
	
	
	public Variable_declaration() {

	}
	
	public Variable_declaration(String type, AssignmentList assignment_list) {
		this.type = type;
		this.assignment_list = assignment_list;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AssignmentList getAssignment_list() {
		return assignment_list;
	}

	public void setAssignment_list(AssignmentList assignment_list) {
		this.assignment_list = assignment_list;
	}

	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

	@Override
	public Object interpret(Context context) {
		assignment_list.interpret(context);
		return null;
	}
}
