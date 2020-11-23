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
    	
        System.out.println("\n" + spacesGenerator(nbrOfSpaces) +"Déclaration de variable");
        
        
      
        for (Assignment a : variable_declaration.getAssignment_list().getAssignmentList()) 
        { 	 
            System.out.print(spacesGenerator(nbrOfSpaces) +  variable_declaration.getType());
        	 a.accept(this, nbrOfSpaces);
        } 
        
        
        /*
        returnString += (spacesGenerator(nbrOfSpaces) + variable_declaration.getType() + " ");
        
        AssignmentList myAssignmentListList = variable_declaration.getAssignment_list();
        for (Assignment a : myAssignmentListList.getAssignmentList()) 
        { 	 
        	    Comparaison_expressionList myComparaisonExpressionList = a.getExpression().getComparaison_expressionList();
        	    String comparaisonString = "";
        	    for(Comparaison_expression ce : myComparaisonExpressionList.getComparaison_expressionList()) {
        	    //	comparaisonString += ce.getValue() + " " + ce.getComparaison_operator() + " " +  ce.getValue2() ;
        	    }
        		returnString += a.getIdentifier() + " " + a.getAssign() + " " + comparaisonString.replace("null", "").replace(" ", "") + ";\n";
        } 
        
        System.out.println(returnString);
        */
    }
    
    public void visit(Statement statement,int nbrOfSpaces) {
    	
    	System.out.print("\n");
    	
    	
        if(statement.getConditional_statement() != null) {
        	statement.getConditional_statement().accept(this,nbrOfSpaces+1);
        }
            
        if(statement.getAssignment() != null) {
        	statement.getAssignment().accept(this,nbrOfSpaces+1);
        }
       	
    }
    
    public void visit(Conditional_statement conditional_statement, int nbrOfSpaces) {
    	System.out.println("\n" + spacesGenerator(nbrOfSpaces) +"Expression conditionnelle");
		System.out.print(spacesGenerator(nbrOfSpaces));
    }
    
    public void visit(Assignment assignment, int nbrOfSpaces) {
    	
    	System.out.print(spacesGenerator(nbrOfSpaces-1));
    	System.out.print(assignment.getIdentifier() + assignment.getAssign());
    	
    	/*String returnString = "";
    	
    	Comparaison_expressionList myComparaisonExpressionList = assignment.getExpression().getComparaison_expressionList();
	    String comparaisonString = "";
	    for(Comparaison_expression ce : myComparaisonExpressionList.getComparaison_expressionList()) {
	    	comparaisonString += ce.getValue() + " " + ce.getComparaison_operator() + " " +  ce.getValue2() ;
	    }
		returnString += assignment.getIdentifier() + " " + assignment.getAssign() + " " + comparaisonString.replace("null", "").replace(" ", "") + ";\n";
    	
		System.out.println(spacesGenerator(nbrOfSpaces) + returnString);*/
	
    }
    
    public void visit(Expression expression, int nbrOfSpaces) {   	


    	/*
    	for(int i = 0; i < expression.getComparaison_expressionList().getComparaison_expressionList().size() ; i++) {
           	expression.getComparaison_expressionList().getComparaison_expressionList().get(i).accept(this, nbrOfSpaces); 
        	for(int j = 0; j < expression.getLogical_connectorList().getLogical_connectorList().size() ; j++) {
        		if(i == j) {
        			expression.getLogical_connectorList().getLogical_connectorList().get(j).accept(this, nbrOfSpaces);  
        		}
        	}
    	}
    	*/
    /*	for(Comparaison_expression ce : expression.getComparaison_expressionList().getComparaison_expressionList()) {
    		ce.accept(this, nbrOfSpaces);   			
    	}
    	
        for(Logical_connector lc : expression.getLogical_connectorList().getLogical_connectorList()) {
    		lc.accept(this, nbrOfSpaces);   		
    	}*/
    } 
    
    /*
    public void visit(Comparaison_expressionList comparaison_expressionList, int nbrOfSpaces) {
    	nbrOfSpaces++;
    	for(Comparaison_expression ce : comparaison_expressionList.getComparaison_expressionList()) {
    		ce.accept(this, nbrOfSpaces);   		
    	}
    }
    
    public void visit(Logical_connectorList logical_connectorList, int nbrOfSpaces) {
    	for(Logical_connector lc : logical_connectorList.getLogical_connectorList()) {
    		lc.accept(this, nbrOfSpaces);
    	}
    }
*/
    public void visit(Logical_connector logical_connector, int nbrOfSpaces) {
    	System.out.print(logical_connector.getConnector() + " ");	
    }
    
    public void visit(Comparaison_expression comparaison_expression, int nbrOfSpaces) {
    	/*

    	for(int i = 0; i < comparaison_expression.getArithmetic_expression_priority_lowList().size() ; i++) {
    		comparaison_expression.getArithmetic_expression_priority_lowList().get(i).accept(this, nbrOfSpaces); 
        	for(int j = 0; j < comparaison_expression.getComparaison_operatorList().size() ; j++) {
        		if(i == j) {
        			comparaison_expression.getComparaison_operatorList().get(j).accept(this, nbrOfSpaces);  
        		}
        	}
    	}*/
    	
    	
    	/*
    	for(Comparaison_operator co : comparaison_expression.getComparaison_operatorList()) {
    		co.accept(this, nbrOfSpaces);
    	}
    	
    	for(Arithmetic_expression_priority_low aepl : comparaison_expression.getArithmetic_expression_priority_lowList()) {
    		aepl.accept(this, nbrOfSpaces);
    	}*/
    }

	public void visit(Comparaison_operator comparaison_operator, int nbrOfSpaces) {
    	/*if(comparaison_operator.getComparaison_operator().toString() == ">") {		
        	System.out.println(spacesGenerator(nbrOfSpaces) +"Condition PLUS_GRAND, " );	
    	}
    	
    	if(comparaison_operator.getComparaison_operator().toString() == "<") {  		
        	System.out.println(spacesGenerator(nbrOfSpaces) +"Condition PLUS_PETIT , " );	
    	}
    		
    	if(comparaison_operator.getComparaison_operator().toString() == ">=") {  		
        	System.out.println(spacesGenerator(nbrOfSpaces) +"Condition PLUS_GRAND_EGAL , " );	
    	}
    	
    	if(comparaison_operator.getComparaison_operator().toString() == "<=") {  		
        	System.out.println(spacesGenerator(nbrOfSpaces) +"Condition PLUS_PETIT_EGAL , ");	
    	}
    	
    	if(comparaison_operator.getComparaison_operator().toString() == "==") {  		
        	System.out.println(spacesGenerator(nbrOfSpaces) +"Condition EGAL , " );	
    	}
    	
    	if(comparaison_operator.getComparaison_operator().toString() == "<>") {  		
        	System.out.println(spacesGenerator(nbrOfSpaces) +"Condition PAS_EGAL , " );	
    	}*/
		System.out.print(comparaison_operator.getComparaison_operator() + " ");
	}

	public void visit(Arithmetic_expression_priority_low arithmetic_expression_priority_low, int nbrOfSpaces) {
		
    /*	for(int i = 0; i < arithmetic_expression_priority_low.getArithmetic_expressionList().size() ; i++) {
    		arithmetic_expression_priority_low.getArithmetic_expressionList().get(i).accept(this, nbrOfSpaces); 
        	for(int j = 0; j < arithmetic_expression_priority_low.getArithmetic_operation_piority_lowList().size() ; j++) {
        		if(i == j) {
        			arithmetic_expression_priority_low.getArithmetic_operation_piority_lowList().get(j).accept(this, nbrOfSpaces);  
        		}
        	}
    	}*/
		
    	/*	
    	for(Arithmetic_expression ae : arithmetic_expression_priority_low.getArithmetic_expressionList()) {
    		ae.accept(this, nbrOfSpaces);
    	}
    	
    	for(Arithmetic_operation_piority_low aopl : arithmetic_expression_priority_low.getArithmetic_operation_piority_lowList()) {
    		aopl.accept(this, nbrOfSpaces);
    	}
    	*/
    	
	}

	public void visit(Arithmetic_expression arithmetic_expression, int nbrOfSpaces) {
    /*	for(Arithmetic_operation ao : arithmetic_expression.getArithmetic_operationList()) {
    		ao.accept(this, nbrOfSpaces);

    	}
    	
    	for(Unary_expression ue : arithmetic_expression.getUnary_expressionList()) {
    		ue.accept(this, nbrOfSpaces);
    	}*/
	}

	public void visit(Arithmetic_operation_priority_low arithmetic_operation_piority_low, int nbrOfSpaces) {		
		System.out.print(" " + arithmetic_operation_piority_low.getOperation());	
	}

	public void visit(Arithmetic_operation arithmetic_operation, int nbrOfSpaces) {
		System.out.print(arithmetic_operation.getOperation());
	}

	public void visit(Unary_expression unary_expression, int nbrOfSpaces) {
		if(unary_expression.getUnary_operator() != null) {
			unary_expression.getUnary_operator().accept(this,nbrOfSpaces);
		}
		unary_expression.getTerm().accept(this,nbrOfSpaces);
	}

	public void visit(Unary_operator unary_operator, int nbrOfSpaces) {
		System.out.println(unary_operator.getOperator());
	}

	public void visit(Term term, int nbrOfSpaces) {
		

		if(term.getExpression() != null) {
			term.getExpression().accept(this, nbrOfSpaces);
		}
		
		if(term.getValue() != null) {
			term.getValue().accept(this, nbrOfSpaces);
		}
		
	}

	public void visit(Value value, int nbrOfSpaces) {
		System.out.print( value.getIdentificateur() + " " );
	}
}
