package ast;

public class Logical_connector {
	private String connector;

	public Logical_connector(String connector) {
		this.connector = connector;
	}
	
	public Logical_connector() {

	}

	public String getConnector() {
		return connector;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}

	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}
}
