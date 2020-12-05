package utilities;

import java.util.ArrayList;
import executions.*;

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
	
	public static Object Add(Object o1, Object o2) {
		Double result = Double.valueOf(o1.toString()) + Double.valueOf(o2.toString());	// Effectue l'addition
		
		if(result == Math.floor(result)) {							// Si le resultat est un entier
			return Integer.valueOf((int)Math.round(result));			// retourne le résultat en Integer
		}else {
			return Double.valueOf(result.toString());					// retourne le résultate en Double
		}
	}
	public static Object Subtract(Object o1, Object o2) {
		Double result = Double.valueOf(o1.toString()) - Double.valueOf(o2.toString());
		
		if(result == Math.floor(result)) { 							// Si le resultat est un entier
			return Integer.valueOf((int)Math.round(result));
		}else {
			return Double.valueOf(result.toString());
		}
	}
	public static Object Multiply(Object o1, Object o2) {
		Double result = Double.valueOf(o1.toString()) * Double.valueOf(o2.toString());
		
		if(result == Math.floor(result)) {							// Si le resultat est un entier
			return Integer.valueOf((int)Math.round(result));
		}else {
			return Double.valueOf(result.toString());
		}
	}
	public static Object Divide(Object o1, Object o2) {
		Double result = Double.valueOf(o1.toString()) / Double.valueOf(o2.toString());
		
		if(result == Math.floor(result)) {							// Si le resultat est un entier
			return Integer.valueOf((int)Math.round(result));
		}else {
			return Double.valueOf(result.toString());
		}
	}
	public static Object Modulo(Object o1, Object o2) {
		Double result = Double.valueOf(o1.toString()) % Double.valueOf(o2.toString());
		
		if(result == Math.floor(result)) { 							// Si le resultat est un entier
			return Integer.valueOf((int)Math.round(result));
		}else {
			return Double.valueOf(result.toString());
		}
	}
	
	public static boolean AreObjetsBool(Object o1, Object o2) {
		Object c1 = o1.getClass();
		Object c2 = o2.getClass();
		
		if(o1 instanceof Boolean || o2 instanceof Boolean)
			return c1 == c2;
		else 
			return false;
	}
	
	// Construction des chemins exécutés à partir de la trace de chaque exécutions
	public static String[] BuildPath(ArrayList<Execution> executions) {
		ArrayList<String> paths = new ArrayList<String>();
		for(int i =0 ;i < executions.size();i++) {
			Execution e = executions.get(i);
			
			String trace = e.BuildTrace();
			paths.add(trace);
		}
		String[] p = new String[paths.size()];
		paths.toArray(p);
		return p;
	
	}
}
