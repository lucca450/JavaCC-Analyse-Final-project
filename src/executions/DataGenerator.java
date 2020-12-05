package executions;

import java.util.ArrayList;
import java.util.Random;
import executions.*;
import statements.*;
import visitor.*;
import utilities.*;
import ast.*;

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
    	
	    	for(ParameterDeclaration pd : function.getParameterDeclarations())
	        {
	    		String type = pd.getType();
	    		Object randomValue;
	    		
    			if(type.equals("double"))
    				randomValue = (Math.random() * range + min);
    	    	else if(type.equals("int")) {
    	    		randomValue = (int)Math.floor((Math.random() * range + min));
    	    	}else {
    	    		double d = Math.floor(Math.random() * 2);			
    	    		randomValue = Math.floor(Math.random() * 2) == 0;
    	    	}
    			
    			execution.AddRandomValues(new Variable(pd.getID(), pd.getParameterName(), type, randomValue));	
	        }
	    	executions.add(execution);
    	}
    	return executions;
    }
    
    public Context GenerateContext(Execution path) {
    	Context context = new Context();
    	
    	for(Variable v : path.getRandomValues()) {	// paramètres
    		if(!context.getHasError())
    			context.AddVariable(v.Clone());
    		else
    			return context;
    	}
    	
    	for(VariableDeclaration vD : function.getFunctionBody().getVariableDeclarations()) {	// Déclaration
    		String type = vD.getType();
    		for(Assignment a : vD.getAssignments()) {
    			int ID = a.getID();
    			Object value = a.getExpression();
    			context.AddVariable(ID, a.getIdentifier(), type, value);
    			
    			if(context.getHasError())
    				return context;
    		}
    	}    	
    	
    	return context;
    }
}
