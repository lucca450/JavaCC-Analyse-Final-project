package ast;



public class ASTNode <T> {

	
	static int ctrID;
	private int ID;
	private T obj; 


	public ASTNode(int iD, T obj) {
		ID = ++ctrID;
		this.obj = obj;
	}


	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
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
