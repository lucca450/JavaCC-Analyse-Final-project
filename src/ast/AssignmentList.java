package ast;

import java.util.ArrayList;
import java.util.List;

public class AssignmentList {
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
}
