package ast;

import java.util.ArrayList;

public class VariableDeclaration extends ASTNode{

	private String type;
	private ArrayList<Assignment> assignments; 
	
	public VariableDeclaration() {
		assignments = new ArrayList<Assignment>();
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
	}

	@Override
	public Object interpret(Context context) {
		for(Assignment a : assignments) {
			Variable v = context.FindVariable(a.getID());
			if(v != null) {
				Object o = a.interpret(context);
				if(!context.getHasError()) {
					if(!(o instanceof ASTNode)) {
						if(v.getType() == "int") {
							if(Utilities.TryParseInt(o)) {
								v.setValue(Integer.valueOf(o.toString()));			
							}else {
								context.setHasError(new ExecutionError("Le résultat de l'expression doit être un entier, " + v.getIdentificator()));
								return null;
							}
						}
						else if(v.getType() == "double")
							if(Utilities.TryParseDouble(o) || Utilities.TryParseInt(o)) {
								v.setValue(Double.valueOf(o.toString()));			
							}else {
								context.setHasError(new ExecutionError("Le résultat de l'expression doit être un nombre, " + v.getIdentificator()));
								return null;
							}	
						else
							v.setValue(Boolean.valueOf(o.toString()));	
					}else
						v.setValue(o);
				}else
					return null;
			}
		}
		return null;
	}

	@Override
	public void accept(VisitorPrint visitor, int nbTab) {
		visitor.visit(this, nbTab);
	}

}
