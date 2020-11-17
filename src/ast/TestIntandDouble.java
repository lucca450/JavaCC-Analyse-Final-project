package ast;

import ast.*;

public class TestIntandDouble {
/*
	public int tryParseInt(String value) {  
		     try {  
		         int returningValue = Integer.parseInt(value);  
		         return returningValue;    
		      } catch (NumberFormatException e) {  
		         return -999999999;  
		      }  
		}
	
	public double tryParseDouble(String value) {  
		     try {     
		    	 double returningValue = Double.parseDouble(value);  
		    	 return returningValue;
		      } catch (NumberFormatException e) {  
		    	 return -999999999;  
		      }  
		}
*/
	
	public boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;    
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}

public boolean tryParseDouble(String value) {  
	     try {     
	    	 Double.parseDouble(value);  
	    	 return true;
	      } catch (NumberFormatException e) {  
	    	 return false;  
	      }  
	}
}
