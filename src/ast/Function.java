package ast;

import java.util.ArrayList;
import java.util.List;


public class Function extends ASTNode{




	private String type;
	private String function_name;
	private List<Parameter_declaration> parameter_declaration_list = new ArrayList<Parameter_declaration>();
	private Function_body function_body;
	


	public Function(String type, String function_name, List<Parameter_declaration> parameter_declaration_list, Function_body function_body) {
		this.type = type;
		this.function_name = function_name;
		this.parameter_declaration_list = parameter_declaration_list;
		this.function_body = function_body;
	}

	public Function( String type, String function_name) {
		this.type = type;
		this.function_name = function_name;
	}



	@Override
	public String toString() {
		return "Function [type=" + type + ", function_name=" + function_name + ", parameter_declaration_list="
				+ parameter_declaration_list + ", function_body=" + function_body + "]";
	}
	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getFunction_name() {
		return function_name;
	}


	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}


	public List<Parameter_declaration> getParameter_declaration_list() {
		return parameter_declaration_list;
	}


	public void setParameter_declaration_list(List<Parameter_declaration> parameter_declaration_list) {
		this.parameter_declaration_list = parameter_declaration_list;
	}


	public Function_body getFunction_body() {
		return function_body;
	}


	public void setFunction_body(Function_body function_body) {
		this.function_body = function_body;
	}


	public void accept(VisitorPrint visitor) {
		visitor.visit(this);
		
        for (Parameter_declaration pd : parameter_declaration_list) {
            pd.accept(visitor, 1);
        }
		
        function_body.accept(visitor,1);
	}
	
}
