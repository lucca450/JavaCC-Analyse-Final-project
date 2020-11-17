package ast;



public class ASTNode{

	
	static int ctrID;
	private int ID;


	public ASTNode() {
		ID = ++ctrID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID() {
		return ID;
	}
	
	@Override
	public String toString() {
		return "ASTNode [ID=" + ID + "]";
	}
}
