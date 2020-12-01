package ast;

import java.util.ArrayList;

public abstract class Utilities {
	
	public static boolean TryParseInt(Object o) {
		try {
			Integer.parseInt(o.toString());
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	public static boolean TryParseDouble(Object o) {
		try {
			Double.parseDouble(o.toString());
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean TryParseBool(Object o) {
		try {
			Boolean.parseBoolean(o.toString());
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static Object Add(Object o1, Object o2) {
		Double result = Double.valueOf(o1.toString()) + Double.valueOf(o2.toString());
		
		if(result == Math.floor(result)) { // if result is an integer
			return Integer.valueOf((int)Math.round(result));
		}else {
			return Double.valueOf(result.toString());
		}
	}
	public static Object Subtract(Object o1, Object o2) {
		Double result = Double.valueOf(o1.toString()) - Double.valueOf(o2.toString());
		
		if(result == Math.floor(result)) { // if result is an integer
			return Integer.valueOf((int)Math.round(result));
		}else {
			return Double.valueOf(result.toString());
		}
	}
	public static Object Multiply(Object o1, Object o2) {
		Double result = Double.valueOf(o1.toString()) * Double.valueOf(o2.toString());
		
		if(result == Math.floor(result)) { // if result is an integer
			return Integer.valueOf((int)Math.round(result));
		}else {
			return Double.valueOf(result.toString());
		}
	}
	public static Object Divide(Object o1, Object o2) {
		Double result = Double.valueOf(o1.toString()) / Double.valueOf(o2.toString());
		
		if(result == Math.floor(result)) { // if result is an integer
			return Integer.valueOf((int)Math.round(result));
		}else {
			return Double.valueOf(result.toString());
		}
	}
	public static Object Modulo(Object o1, Object o2) {
		Double result = Double.valueOf(o1.toString()) % Double.valueOf(o2.toString());
		
		if(result == Math.floor(result)) { // if result is an integer
			return Integer.valueOf((int)Math.round(result));
		}else {
			return Double.valueOf(result.toString());
		}
	}
	
	public static boolean CompareTypes(Object o1, Object o2) {
		Object c1 = o1.getClass();
		Object c2 = o2.getClass();
		
		if(o1 instanceof Boolean || o2 instanceof Boolean)
			return c1 == c2;
		else 
			return true;
	}
	
	public static int CalculateDifferentPaths(ArrayList<Execution> workedExecutions) {
		ArrayList<Execution> differentExecutions = new ArrayList<Execution>();
		Execution first = workedExecutions.remove(0);
		differentExecutions.add(first);
		
		for(Execution e : workedExecutions) {
			boolean foundIdentical = false;
			for(Execution dE : differentExecutions) {
				if(IfExecutionIdentical(e, dE)) {
					foundIdentical = true;
					break;
				}
			}
			if(!foundIdentical)
				differentExecutions.add(e);
		}
		return differentExecutions.size();
	}
	
	public static boolean IfExecutionIdentical(Execution e1, Execution e2) {
		ArrayList<Integer> idsE1 = e1.GetPath();
		ArrayList<Integer> idsE2 = e2.GetPath();
		int e1PathSize = idsE1.size();
		int e2PathSize = idsE2.size();
		
		
		if(e1PathSize != e2PathSize)
			return false;
		
		for(int i = 0 ; i < e1PathSize; i++) {
			int id1 = idsE1.get(i);
			int id2 = idsE2.get(i);
			if(id1 != id2) {
				return false;
			}
		}
		return true;		
	}
}
