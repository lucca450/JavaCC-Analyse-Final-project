package ast;

import java.util.ArrayList;

public class DataGenerator {
	private int max =  10000; 
	private int min = -10000; 
	private int range = max - min;
	private Function function;	
    

	public DataGenerator(Function f) {
    	function = f;
    }
    
    public ArrayList<Execution> GenerateData() {
    	ArrayList<Execution> executions = new ArrayList<Execution>();
		
    	for (int i = 0; i < 10; i++) {
    		Execution execution = new Execution();
    	
	    	for(Parameter_declaration pd : function.getParameter_declaration_list())
	        {
	    		String type = pd.getType();
	    		Object randomValue;
	    		
    			if(type.equals("int") || type.equals("double"))
    				randomValue = (Math.random() * range + 1);
    	    	else
    	    		randomValue = ((Math.random() * 2)) == 0;
    			
    			execution.AddRandomValues(new Variable(pd.getID(), pd.getParameter_name(), type, randomValue));	
	        }
	    	executions.add(execution);
    	}
    	return executions;
    }
    
    public Context GenerateContext(Execution path) {
    	Context context = new Context();
    	
    	for(Variable v : path.getRandomValues()) {	//Paramètres
    		context.AddVariable(v);
    	}
    	
    	for(Variable_declaration vD : function.getFunction_body().getVariable_declaration_list().getVariable_declarationList()) {	// Déclaration
    		String type = vD.getType();
    		for(Assignment a : vD.getAssignment_list().getAssignmentList()) {
    			int ID = a.getID();
    			Object value = a.getExpr();
    			context.AddVariable(ID, a.getIdentifier(), type, value);
    		}
    	}
    	
    	
    	// Peut-être les déclarations de for (voir avec Alex)
    	
    	
    	
    	return context;
    }
}
