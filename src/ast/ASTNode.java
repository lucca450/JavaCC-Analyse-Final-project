package ast;

import executions.*;
import visitor.*;

public abstract class ASTNode {

	static int ctrID;
	private int ID;


	public ASTNode() {
		ID = ++ctrID;
	}

	public abstract Object interpret(Context context);
	public abstract void accept(VisitorPrint visitor);
	
	public void setID(int iD) {
		ID = iD;
	}

	public int getID() {
		return ID;
	}
}
