package ast;

public class VisitorPrint {
    
    public VisitorPrint() {

	}	
	
	public String spacesGenerator(int nbrOfSpaces) {
    	String spaces = "";
    	
    	for (int i = 0; i < nbrOfSpaces; i++) {
    		  spaces += "	";
    	}
    	
    	return spaces;
	}
	
	public void visit(Function function, int nbTab) {
        System.out.println("Fonction : « " + function.getFunctionName() + " »");
    }
    
    public void visit(ParameterDeclaration parameterDeclaration, int nbTab) {
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
        System.out.println(tab + "Paramètre " + parameterDeclaration.getParameterName() + " : " + parameterDeclaration.getType());
    }
    
    public void visit(FunctionBody FunctionBody, int nbTab) {
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
        System.out.println(tab + "Corps de la fonction");
    }
    
    public void visit(VariableDeclaration variableDeclaration, int nbTab) {
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
    	
        System.out.println(tab + "Déclaration de variable");
     
        for (Assignment a : variableDeclaration.getAssignments()) 
        { 	 
            System.out.print(tab + '\t' + variableDeclaration.getType() + " ");
        	a.accept(this, 0);
        } 
    }
    
    public void visit(Statement statement, int nbTab) {
    	System.out.println("Je suis dans visit statement");
    	
    	
    	if(statement instanceof ConditionalStatement) {
    		this.visit((ConditionalStatement)statement, nbTab);
    	}else if(statement instanceof WhileLoop) {
    		System.out.println("Visit de While à faire");
    		this.visit((WhileLoop)statement, nbTab);
    	}else if(statement instanceof Assignment) {
    		this.visit((Assignment)statement, nbTab);
    	}else if(statement instanceof FunctionCall) {
    		this.visit((FunctionCall)statement, nbTab);
    	}else if(statement instanceof ForLoop) {
    		System.out.println("Visit de For à faire");
    		this.visit((ForLoop)statement, nbTab);
    	}else {
    		System.out.println("Statement non calculé");
    	}
    }
    
    public void visit(ConditionalStatement cStatement, int nbTab) {
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
    	
    	System.out.println(tab + "Expression conditionnelle");
    	cStatement.getExpression().accept(this, nbTab + 1);
    	
    	if(cStatement.getIfBody() != null) {
    		for(Statement iS : cStatement.getIfBody()) {
    			iS.accept(this, nbTab + 1);
    		}
    	}
    	if(cStatement.getElseBody() != null) {
    		for(Statement eS : cStatement.getElseBody()) {
    			eS.accept(this, nbTab + 1);
    		}
    	}
    }
    
    public void visit(Assignment assignment, int nbTab) {
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}

    	System.out.print(tab + assignment.getIdentifier() + " " + assignment.getAssign());
    	
    	assignment.getExpression().accept(this, nbTab);
    }
    
    public void visit(LogExpression logExpression, int nbTab) {   	
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
    	
    	if(logExpression.getConnector() != null) {
    		System.out.println(tab + "Logical connector: " + logExpression.getConnector());	
    	}

    	logExpression.getGauche().accept(this, nbTab + 1);
    	logExpression.getDroite().accept(this, nbTab + 1);
    } 
        
    public void visit(ComparaisonExpression comparaisonExpression, int nbTab) {
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
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
    	comparaisonExpression.getGauche().accept(this, 0);
    	comparaisonExpression.getDroite().accept(this, 0);
    	
    	System.out.println();
    }

	public void visit(LowPriorityArithmeticExpression lAExpression, int nbTab) {
		    	
	}

	public void visit(ArithmeticExpression arithmetic_expression, int nbTab) {

	}
	public void visit(UnaryExpression unaryExpression, int nbTab) {
		String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
    	System.out.println(tab + unaryExpression.getOperator());
    	unaryExpression.getTerm().accept(this, nbTab);
	}

	public void visit(Term term, int nbTab) {
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
			
			System.out.print( " " + termValue + " : " + strType + " " );
		}else if(termValue instanceof FunctionCall) {
			this.visit((FunctionCall)termValue, nbTab + 1);
			return;
		}	
	}

	public void visit(Expression expr, int nbTab) {
		System.out.println("JE SUIS DANS VISIT EXPR");
	}
	
	public void visit(FunctionCall fC, int nbTab) {
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
    	
		System.out.println(tab + "Appel de fonction : " + fC.getIdentifier());
		
		for(Item p : fC.getParameters()) {
			p.accept(this, nbTab+1);
		}
	}
}
