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
    
    public void visit(Parameter_declaration parameter_declaration) {
        System.out.println("Paramètre " + parameter_declaration.getParameter_name() + " : " + parameter_declaration.getType());
    }
    
    public void visit(Function_body function_body) {
        System.out.println("Corps de la fonction");
    }
    
    public void visit(Variable_declaration variable_declaration) {
    	//String returnString = "";
    	
        System.out.println("Déclaration de variable");
        
        
      
        for (Assignment a : variable_declaration.getAssignment_list().getAssignmentList()) 
        { 	 
            System.out.print( variable_declaration.getType() + " ");
        	 a.accept(this);
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
    
    public void visit(Statement statement) {
    	
    	System.out.print("\n");
    	
    	
        if(statement.getConditional_statement() != null) {
        	statement.getConditional_statement().accept(this);
        }
            
        if(statement.getAssignment() != null) {
        	statement.getAssignment().accept(this);
        }
       	
    }
    


    
    public void visit(Conditional_statement conditional_statement) {
    	System.out.println("Expression conditionnelle");

    		conditional_statement.getExpression().accept(this);

    	
    	
    	if(conditional_statement.getIfBody() != null) {
    	conditional_statement.getIfBody().accept(this);
    	}


    }
    
    public void visit(Assignment assignment) {
    	

    	System.out.print(assignment.getIdentifier() + " " + assignment.getAssign());
    	
    	assignment.getExpr().accept(this);
    	
    	/*String returnString = "";
    	
    	Comparaison_expressionList myComparaisonExpressionList = assignment.getExpression().getComparaison_expressionList();
	    String comparaisonString = "";
	    for(Comparaison_expression ce : myComparaisonExpressionList.getComparaison_expressionList()) {
	    	comparaisonString += ce.getValue() + " " + ce.getComparaison_operator() + " " +  ce.getValue2() ;
	    }
		returnString += assignment.getIdentifier() + " " + assignment.getAssign() + " " + comparaisonString.replace("null", "").replace(" ", "") + ";\n";
    	
		System.out.println(spacesGenerator(nbrOfSpaces) + returnString);*/
	
    }
    
    public void visit(LogExpression logExpression) {   	

    	if(logExpression.getLogical_connector() != null) {
        	logExpression.getLogical_connector().accept(this);
    	}

    	//System.out.println(
    	logExpression.getGauche().accept(this);
    	//);
    	
    	if(logExpression.getDroite() != null) {
    		logExpression.getDroite().accept(this);
    	}
    	
	
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
    public void visit(Comparaison_expressionList comparaison_expressionList) {
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
    public void visit(Logical_connector logical_connector) {
    	System.out.println("Logical connector: " + logical_connector.getConnector());	
    }
    
    public void visit(Comparaison_expression comparaison_expression) {
    	
    	System.out.print("Condition ");
    	comparaison_expression.getComparaison_operator().accept(this);
    	comparaison_expression.getGauche().accept(this);
    	comparaison_expression.getDroite().accept(this);
    	System.out.print("\n");
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

	public void visit(Comparaison_operator comparaison_operator) {
    	if(comparaison_operator.getComparaison_operator().toString() == ">") {		
        	System.out.print("PLUS_GRAND," );	
    	}
    	
    	if(comparaison_operator.getComparaison_operator().toString() == "<") {  		
        	System.out.print("PLUS_PETIT," );	
    	}
    		
    	if(comparaison_operator.getComparaison_operator().toString() == ">=") {  		
        	System.out.print("PLUS_GRAND_EGAL," );	
    	}
    	
    	if(comparaison_operator.getComparaison_operator().toString() == "<=") {  		
        	System.out.print("PLUS_PETIT_EGAL,");	
    	}
    	
    	if(comparaison_operator.getComparaison_operator().toString() == "==") {  		
        	System.out.print("EGAL," );	
    	}
    	
    	if(comparaison_operator.getComparaison_operator().toString() == "<>") {  		
        	System.out.print("PAS_EGAL," );	
    	}
		/*System.out.print(comparaison_operator.getComparaison_operator() + " ");*/
	}

	public void visit(Arithmetic_expression_priority_low arithmetic_expression_priority_low) {
		
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

	public void visit(Arithmetic_expression arithmetic_expression) {
    /*	for(Arithmetic_operation ao : arithmetic_expression.getArithmetic_operationList()) {
    		ao.accept(this, nbrOfSpaces);

    	}
    	
    	for(Unary_expression ue : arithmetic_expression.getUnary_expressionList()) {
    		ue.accept(this, nbrOfSpaces);
    	}*/
	}

	public void visit(Arithmetic_operation_priority_low arithmetic_operation_piority_low) {		
		System.out.print(" " + arithmetic_operation_piority_low.getOperation());	
	}

	public void visit(Arithmetic_operation arithmetic_operation) {
		System.out.print(arithmetic_operation.getOperation());
	}

	public void visit(Unary_expression unary_expression) {
		if(unary_expression.getUnary_operator() != null) {
			unary_expression.getUnary_operator().accept(this);
		}
		unary_expression.getTerm().accept(this);
	}

	public void visit(Unary_operator unary_operator) {
		System.out.println(unary_operator.getOperator());
	}

	public void visit(Term term) {

		if(term.getExpression() != null) {
			term.getExpression().accept(this);
		}
		
		if(term.getValue() != null) {
			term.getValue().accept(this);
		}
		
	}

	public void visit(Value value) {
		String strType = "";

		try {
			int a = Integer.parseInt(value.getIdentificateur());
			strType = "INTEGER";
		}
		catch(Exception e1){
			try {
				double b = Double.parseDouble(value.getIdentificateur());
				strType = "DOUBLE";
			}
			catch(Exception e2){
					if(value.getIdentificateur().trim().equals("true") || value.getIdentificateur().trim().equals("false")){
						strType = "BOOLEAN";
					}else {
						strType = "IDENTIFIER";
					}
			}
		}

		
		
		
		value.getIdentificateur();
		
		System.out.print( " " + value.getIdentificateur() + " : " + strType + " " );
		
		
	}

	public void visit(Expression expr) {
		System.out.println("JE SUIS DANS VISIT EXPR");
	}
}
