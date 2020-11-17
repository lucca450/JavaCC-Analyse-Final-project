package ast;

public class Value extends ASTNode {
	String identificateur;
	String type;

	public Value(String identificateur, String type) {
		this.identificateur = identificateur;
		this.type = type;
	}


	public String getIdentificateur() {
		return identificateur;
	}

	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void setIdentificateur(String identificateur) {
		this.identificateur = identificateur;
	}


	@Override
	public String toString() {
		return identificateur.toString() ;
	}


}
