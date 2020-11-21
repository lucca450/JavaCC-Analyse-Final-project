package ast;

import java.util.ArrayList;
import java.util.List;

public class Logical_connectorList  {

	List<Logical_connector> logical_connectorList = new ArrayList<Logical_connector>();
	
	public Logical_connectorList(List<Logical_connector> logical_connectorList) {
		this.logical_connectorList = logical_connectorList;
	}
	
	public Logical_connectorList() {
	
	}
	
	public List<Logical_connector> getLogical_connectorList() {
		return logical_connectorList;
	}

	public void setLogical_connectorList(List<Logical_connector> logical_connectorList) {
		this.logical_connectorList = logical_connectorList;
	}

	public void add(Logical_connector lc) {
		logical_connectorList.add(lc);
	}
	
	public void accept(VisitorPrint visitor,int nbrOfSpaces) {
		visitor.visit(this,nbrOfSpaces);
	}
}
