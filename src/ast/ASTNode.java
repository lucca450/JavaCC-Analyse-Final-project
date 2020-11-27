package ast;



public abstract class ASTNode{

	static int ctrID;
	private int ID;


	public ASTNode() {
		ID = ++ctrID;
	}

	public abstract Object interpret(Context context);
	
	
	public void setID(int iD) {
		ID = iD;
	}

	public int getID() {
		return ID;
	}
	
	
}
