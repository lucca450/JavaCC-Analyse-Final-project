package ast;

public class Value extends ASTNode {
	Object identificateur;

	public Value(Object identificateur) {
		this.identificateur = identificateur;
	}

	public Value() {
		
	}

	public Object getIdentificateur() {
		return identificateur;
	}

	public void setIdentificateur(Object identificateur) {
		this.identificateur = identificateur;
	}


	@Override
	public String toString() {
		return identificateur.toString();
	}

	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

	@Override
	public Object interpret(Context context) {
		return identificateur;
	}


}
