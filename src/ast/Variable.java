package ast;

public class Variable {
	private int ID;
	private String identificator;
	private String type;
	private Object value;
	
	public Variable(int ID, String identificator, String type, Object value) {
		this.ID = ID;
		this.identificator = identificator;
		this.type = type;
		this.value = value;
	}
	
	public String getIdentificator() {
		return identificator;
	}

	public String getType() {
		return type;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

}
