package ast;

import ast.*;

public class VisitorPrint {
	private int nbrOfSpaces;
	
	

    public VisitorPrint(int nbrOfSpaces) {
		this.nbrOfSpaces = nbrOfSpaces;
	}
    
    public VisitorPrint() {

	}

	public int getNbrOfSpaces() {
		return nbrOfSpaces;
	}

	public void setNbrOfSpaces(int nbrOfSpaces) {
		this.nbrOfSpaces = nbrOfSpaces;
	}
	
	
	
	public String spacesGenerator(int nbrOfSpaces) {
    	String spaces = "";
    	
    	for (int i = 0; i < nbrOfSpaces; i++) {
    		  spaces += "	";
    	}
    	
    	return spaces;
	}
	
	

	public void visit(Function function) {
        System.out.println("Fonction : « " + function.getFunction_name() + " »");
    }
    
    public void visit(Parameter_declaration parameter_declaration, int nbrOfSpaces) {
        System.out.println(spacesGenerator(nbrOfSpaces) + "Paramètre " + parameter_declaration.getParameter_name() + " : " + parameter_declaration.getType());
    }
    
    public void visit(Function_body function_body, int nbrOfSpaces) {
        System.out.println(spacesGenerator(nbrOfSpaces) +"Corps de la fonction");
    }
    
    public void visit(Variable_declaration variable_declaration, int nbrOfSpaces) {
    	String returnString = "";
    	
        System.out.println(spacesGenerator(nbrOfSpaces) +"Déclaration de variable");
        
        returnString += (spacesGenerator(nbrOfSpaces) + variable_declaration.getType() + " ");
        
        AssignmentList myAssignmentListList = variable_declaration.getAssignment_list();
        for (Assignment a : myAssignmentListList.getAssignmentList()) 
        { 	 
        		returnString += a.getIdentifier() + " " + a.getAssign() + " " + a.getExpression().getComparaison_expression() + ";\n";
        } 
        
        System.out.println(returnString);
        
    }
    
    public void visit(Statement statement) {
        //System.out.println("STATEMENT. - PAS IMPLEMENTÉ");
    }
    
    public void visit(Conditional_statement conditional_statement, int nbrOfSpaces) {
    	System.out.println(spacesGenerator(nbrOfSpaces) +"Expression conditionnelle");
    }
    
    public void visit(Expression expression) {
    	//System.out.println("Expression ");
    }
    
    public void visit(Logical_connector logical_connector, int nbrOfSpaces) {
    	System.out.println(spacesGenerator(nbrOfSpaces) +"test :" + logical_connector.getConnector());	
    }
    
    public void visit(Comparaison_expression comparaison_expression, int nbrOfSpaces) {
    	

    	if(comparaison_expression.getComparaison_operator().toString() == ">") {		
        	System.out.println(spacesGenerator(nbrOfSpaces) +"Condition PLUS_GRAND, " + comparaison_expression.getValue().toString() + ", " + comparaison_expression.getValue2().toString());	
    	}
    	
    	if(comparaison_expression.getComparaison_operator().toString() == "<") {  		
        	System.out.println(spacesGenerator(nbrOfSpaces) +"Condition PLUS_PETIT , " + comparaison_expression.getValue().toString() + ", " + comparaison_expression.getValue2().toString());	
    	}
    		
    	if(comparaison_expression.getComparaison_operator().toString() == ">=") {  		
        	System.out.println(spacesGenerator(nbrOfSpaces) +"Condition PLUS_GRAND_EGAL , " + comparaison_expression.getValue().toString() + ", " + comparaison_expression.getValue2().toString());	
    	}
    	
    	if(comparaison_expression.getComparaison_operator().toString() == "<=") {  		
        	System.out.println(spacesGenerator(nbrOfSpaces) +"Condition PLUS_PETIT_EGAL , " + comparaison_expression.getValue().toString() + ", " + comparaison_expression.getValue2().toString());	
    	}
    	
    	if(comparaison_expression.getComparaison_operator().toString() == "==") {  		
        	System.out.println(spacesGenerator(nbrOfSpaces) +"Condition EGAL , " + comparaison_expression.getValue().toString() + ", " + comparaison_expression.getValue2().toString());	
    	}
    	
    	if(comparaison_expression.getComparaison_operator().toString() == "<>") {  		
        	System.out.println(spacesGenerator(nbrOfSpaces) +"Condition PAS_EGAL , " + comparaison_expression.getValue().toString() + ", " + comparaison_expression.getValue2().toString());	
    	}
    	
    }
}
