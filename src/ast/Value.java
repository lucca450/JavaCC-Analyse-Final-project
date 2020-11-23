package ast;

public class Value extends ASTNode {
	String identificateur;

	public Value(String identificateur) {
		this.identificateur = identificateur;
	}

	public Value() {
		
	}

	public String getIdentificateur() {
		return identificateur;
	}

	public void setIdentificateur(String identificateur) {
		this.identificateur = identificateur;
	}


	@Override
	public String toString() {
		return identificateur.toString() ;
	}

	public void accept(VisitorPrint visitor, int nbrOfSpaces) {
		visitor.visit(this,nbrOfSpaces);
	}


}
