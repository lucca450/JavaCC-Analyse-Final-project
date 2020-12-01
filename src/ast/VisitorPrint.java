package ast;

public class VisitorPrint {
    
	int nbTab = 0;
	String tab = "";
	
    public VisitorPrint() {

	}
	
	public void PreVisit() {
		nbTab++;
		UpdateTab();
	}
	public void PostVisit() {
		nbTab--;
		UpdateTab();
	}
	
	private void UpdateTab() {
		tab = "";
		for(int i = 0; i< nbTab;i++) {
			tab+= '\t';
		}
	}
	
	public String spacesGenerator(int nbrOfSpaces) {
    	String spaces = "";
    	
    	for (int i = 0; i < nbrOfSpaces; i++) {
    		  spaces += "	";
    	}
    	
    	return spaces;
	}
	
	public void visit(Function function) {
        System.out.println("Fonction : « " + function.getFunctionName() + " »");
    }
    
    public void visit(ParameterDeclaration parameterDeclaration) {
        System.out.println(tab + "Paramètre " + parameterDeclaration.getParameterName() + " : " + parameterDeclaration.getType());
    }
    
    public void visit(FunctionBody functionBody) {
        System.out.println(tab + "Corps de la fonction");

		for (VariableDeclaration vd : functionBody.getVariableDeclarations()) {
			vd.accept(this);
		}

		for (Statement sl : functionBody.getStatements()) {
			sl.accept(this);
			System.out.println();
		}
    }
    
    public void visit(VariableDeclaration variableDeclaration) {    	
        System.out.println(tab + "Déclaration de variable");
     
        for (Assignment a : variableDeclaration.getAssignments()) 
        { 	 
            System.out.print(tab  + "\t" + variableDeclaration.getType() + " ");
        	a.accept(this);
        	System.out.println();
        }
    }    
    public void visit(ReturnStatement rStatement) {
    	System.out.println(tab + "Retourne");
    	rStatement.getExpression().accept(this);
    }
    
    public void visit(WhileLoop whileLoop) {
    	System.out.println("While Loop");
    	
    	whileLoop.getExpression().accept(this);
    	
    	for(Statement s : whileLoop.getBody()) {
    		s.accept(this);
    	}
    }
    
    public void visit(ForLoop forLoop) {
    	System.out.println(tab + "Boucle For"); 
    	
    	Assignment sAssignment = forLoop.getStartAssignment();
    	if(sAssignment != null) {
    		this.PreVisit();
    		sAssignment.accept(this);
    		this.PostVisit();
    	}
    	
    	Item item = forLoop.getExpression();
    	if(item != null) {
    		this.PreVisit();
    		item.accept(this);
    		this.PostVisit();
    	}
    	
    	Assignment iAssignment = forLoop.getIterationAssignment();
    	if(iAssignment != null) {
    		this.PreVisit();
    		iAssignment.accept(this);
    		this.PostVisit();
    	}
    	
    	for(Statement s : forLoop.getBody()) {
    		s.accept(this);
    	}
    }
    
    public void visit(ConditionalStatement cStatement) {
    	System.out.println(tab + "Expression conditionnelle");
    	
    	cStatement.getExpression().accept(this);
    	System.out.println();
    	if(cStatement.getIfBody().size() != 0){
    		System.out.println(tab + "Corps du if");
    	}
    	System.out.print("\t" + tab);
		for(Statement iS : cStatement.getIfBody()) {
			iS.accept(this);
		}
		
		if(cStatement.getElseBody().size() != 0) {
			System.out.println("\n" + tab + "Corps du else");
		}
		
		for(Statement eS : cStatement.getElseBody()) {
			eS.accept(this);
		}
    }
    
    public void visit(Assignment assignment) {
    	System.out.print(assignment.getIdentifier() + " " + assignment.getAssign());
    	
    	assignment.getExpression().accept(this);
    }
    
    public void visit(LogExpression logExpression) {   	    	
    	if(logExpression.getConnector() != null) {
    		System.out.println(tab + "Logical connector: " + logExpression.getConnector());	
    	}
    	logExpression.getGauche().accept(this);
    	System.out.println();
    	logExpression.getDroite().accept(this);
    } 
        
    public void visit(ComparaisonExpression comparaisonExpression) {
    	System.out.print(tab + "Condition ");
    	
    	String op = comparaisonExpression.getOperator();
    	
    	if(op == ">") {		
        	System.out.print("PLUS_GRAND," );	
    	}
    	
    	if(op == "<") {  		
        	System.out.print("PLUS_PETIT," );	
    	}
    		
    	if(op == ">=") {  		
        	System.out.print("PLUS_GRAND_EGAL," );	
    	}
    	
    	if(op == "<=") {  		
        	System.out.print("PLUS_PETIT_EGAL,");	
    	}
    	
    	if(op== "==") {  		
        	System.out.print("EGAL," );	
    	}
    	
    	if(op == "<>") {  		
        	System.out.print("PAS_EGAL," );	
    	}
    	comparaisonExpression.getGauche().accept(this);
    	comparaisonExpression.getDroite().accept(this);
    }

	public void visit(LowPriorityArithmeticExpression lAExpression) {
    	lAExpression.getGauche().accept(this);
	}

	public void visit(ArithmeticExpression arithmeticExpression) {    	
		System.out.print("Opérateur ");
		String op = arithmeticExpression.getOperator();
		
		if(op == "+") {		
        	System.out.print("PLUS");	
    	}
    	if(op == "-") {  		
        	System.out.print("MOINS");	
    	}
    	
    	arithmeticExpression.getGauche().accept(this);
    	arithmeticExpression.getDroite().accept(this);
	}
	public void visit(UnaryExpression unaryExpression) {
    	System.out.println(unaryExpression.getOperator());
    	this.PreVisit();
    	unaryExpression.getTerm().accept(this);
    	this.PostVisit();
	}
	
	public void visit(Term term) {
		Object termValue = term.getValue();
		if(termValue instanceof String) {
			String strType = "";
			
			try
			{
				Integer.parseInt(termValue.toString());
				strType = "INTEGER";
			}catch(Exception e)
			{
				try
				{
					Double.parseDouble(termValue.toString());
					strType = "DOUBLE";
				}catch(Exception e1)
				{
					if(termValue.equals("true") || termValue.equals("false"))
					{
						strType = "BOOLEAN";
					}else 
					{
						strType = "IDENTIFIER";
					}
				}
			}			
			
			System.out.print(" " + termValue + " : " + strType + " " );
		}else if(termValue instanceof FunctionCall) {
			this.visit((FunctionCall)termValue);
			return;
		}	
	}
	
	public void visit(FunctionCall fC) {    	
		System.out.println(tab + "Appel de fonction : " + fC.getIdentifier());
		
		if(fC.getParameters().size() != 0) {
			this.PreVisit();
			System.out.println(tab + "Paramètres de fonction");
		}
		
		for(Item p : fC.getParameters()) {
			p.accept(this);
		}
		this.PostVisit();
	}
}
