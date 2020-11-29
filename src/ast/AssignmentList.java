package ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AssignmentList extends ASTNode{
	List<Assignment> assignmentList = new ArrayList<Assignment>();

	public AssignmentList(List<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}

	public AssignmentList() {
	}

	public List<Assignment> getAssignmentList() {
		return assignmentList;
	}

	public void setAssignmentList(List<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}

	public void add(Assignment a) {
		assignmentList.add(a);
	}

	@Override
	public Object interpret(Context context) {
		for(Assignment a : assignmentList) 
		{
			if(!context.getHasError()) 
			{
				Variable v = context.FindVariable(a.getID());
				if(v != null) 
				{
					Object o = a.interpret(context);	
					switch(v.getType()) 
					{
					case "int":
						v.setValue((int)o);
						break;
					case "double":
						v.setValue((double)o);
						break;
					case "boolean":
						v.setValue((boolean)o);
						break;
					default:
						context.setHasError(new ExecutionError("Type de variable inconnu"));
						break;
					}
				}
			}else 
			{
				return null;
			}
		}
		return null;
	}



}
