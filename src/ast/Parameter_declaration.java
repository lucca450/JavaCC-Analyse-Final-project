package ast;

public class Parameter_declaration extends ASTNode {
	private String type;
	private String parameter_name;
	
	public Parameter_declaration(String type, String parameter_name) 
	{
		this.type = type;
		this.parameter_name = parameter_name;
	}
	
	public Parameter_declaration() 
	{

	}
	
	public String getType() {
		return type;
	}
	
	public String getParameter_name() {
		return parameter_name;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void setParameter_name(String parameter_name) {
		this.parameter_name = parameter_name;
	}

	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

	@Override
	public Object interpret(Context context) {
		System.out.println("Parameter_declaration ne devrait pas se faire interpreter");
		return null;
	}

}
