package ast;

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
		
		if(Utilities.TryParseInt(o1) && Utilities.TryParseInt(o2)) {
			return Integer.valueOf(o1.toString()) + Integer.valueOf(o2.toString());
		}else {
			return Double.valueOf(o1.toString()) + Double.valueOf(o2.toString());
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
	
}
