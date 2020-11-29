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
    
    public void visit(FunctionBody functionBody, int nbTab) {
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
        System.out.println(tab + "Corps de la fonction");

		for (VariableDeclaration vd : functionBody.getVariableDeclarations()) {
			vd.accept(this, nbTab + 1);
		}

		for (Statement sl : functionBody.getStatements()) {
			sl.accept(this, nbTab + 1);
		}
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
        	a.accept(this, nbTab+1);
        } 
    }
    
    /*public void visit(Statement statement, int nbTab) {    	
    	if(statement instanceof ConditionalStatement) {
    		this.visit((ConditionalStatement)statement, nbTab);
    	}else if(statement instanceof WhileLoop) {
    		this.visit((WhileLoop)statement, nbTab);
    	}else if(statement instanceof Assignment) {
    		this.visit((Assignment)statement, nbTab);
    	}else if(statement instanceof FunctionCall) {
    		this.visit((FunctionCall)statement, nbTab);
    	}else if(statement instanceof ForLoop) {
    		this.visit((ForLoop)statement, nbTab);
    	}else if(statement instanceof ReturnStatement){
    		this.visit((ReturnStatement)statement, nbTab);	
    	}else {
    		System.out.println("Statement non calculé");
    	}
    }*/
    
    public void visit(ReturnStatement rStatement, int nbTab) {
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
    	
    	System.out.println("\n" + tab + "Retourne");
    	rStatement.getExpression().accept(this, nbTab+1);
    }
    
    public void visit(WhileLoop whileLoop, int nbTab) {
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
    	System.out.println(tab + "While Loop");
    	
    	whileLoop.getExpression().accept(this,nbTab+1);
    	
    	for(Statement s : whileLoop.getBody()) {
    		s.accept(this, nbTab + 2);
    	}
    }
    
    public void visit(ForLoop forLoop, int nbTab) {
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
    	System.out.println(tab + "For Loop");
    	
    	//checker si sont pas null 
    	
    	forLoop.getStartAssignment().accept(this, nbTab+1);
    	forLoop.getExpression().accept(this,nbTab+1);
    	forLoop.getIterationAssignment().accept(this, nbTab+1);
    	
    	for(Statement s : forLoop.getBody()) {
    		s.accept(this, nbTab+2);
    	}
    }
    
    public void visit(ConditionalStatement cStatement, int nbTab) {
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
    	System.out.println();
    	System.out.println(tab + "Expression conditionnelle");
    	cStatement.getExpression().accept(this, nbTab);
    	
    	if(cStatement.getIfBody().size() != 0){
    		System.out.println("\n\t" + tab + "Corps de fonction");
    	}
    	
		for(Statement iS : cStatement.getIfBody()) {
			iS.accept(this, nbTab + 2);
		}
		
		if(cStatement.getElseBody().size() != 0) {
			System.out.println("\n" + tab + "\t" + "SINON");
		}
		
		for(Statement eS : cStatement.getElseBody()) {
			eS.accept(this, nbTab + 2);
		}
    }
    
    public void visit(Assignment assignment, int nbTab) {
    	String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}

    	System.out.print(assignment.getIdentifier() + " " + assignment.getAssign());
    	
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
    	comparaisonExpression.getGauche().accept(this, nbTab);
    	comparaisonExpression.getDroite().accept(this, nbTab);
    	
    	System.out.println();
    }

	public void visit(LowPriorityArithmeticExpression lAExpression, int nbTab) {
		String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
    	System.out.print(tab);
    	lAExpression.getGauche().accept(this, nbTab);
	}

	public void visit(ArithmeticExpression arithmeticExpression, int nbTab) {
		String tab = "";
    	for(int i = 0; i< nbTab;i++) {
    		tab += '\t';
    	}
    	
		System.out.print(tab + "Opérateur ");
		String op = arithmeticExpression.getOperator();
		
		if(op == "+") {		
        	System.out.print("PLUS" );	
    	}
    	if(op == "-") {  		
        	System.out.print("MOINS" );	
    	}
    	
    	arithmeticExpression.getGauche().accept(this, nbTab);
    	arithmeticExpression.getDroite().accept(this, nbTab);
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
			
			System.out.print(" " + termValue + " : " + strType + " " );
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
		
		if(fC.getParameters().size() != 0) {
			System.out.println(tab + "\t" + "Paramètres de fonction");
		}
		
		for(Item p : fC.getParameters()) {
			System.out.print(tab + "\t" + "\t");
			p.accept(this, nbTab+1);
		}
	}
}
