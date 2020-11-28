import java.util.Stack;

public class TestingStuff {

	public TestingStuff() {
		// TODO Auto-generated constructor stub
	}
	public static Object o() {
		int d = 2;
		int d2 = 3;
		return 0.00;
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		
		double d = 2.01;
		double d1 = 2.5;
		double d2 = 6.6;
		
		int i = 10;
		int i1 = 20;
		int i2 = 30;
		
		stack.push(d);
		stack.push(d1);
		stack.push(d2);
		stack.push(i);
		stack.push(i1);
		stack.push(i2);
		
		
		
		Object parsed = (Object)stack.pop();
		String str = parsed.toString();
		double parsedD = (int)parsed;
		
		Object o = "allo";
		
		boolean b = Boolean.valueOf(o.toString());
		
		
		double pd = Double.valueOf(o.toString());
		
		boolean t = pd != 0;
		
		int j = 0;
		
		
		
	}

}
