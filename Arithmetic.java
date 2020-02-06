
public class ArithmeticExpressionEvaluator {
	

	public static void main(String[] args) {
		
		String b = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) ";
		String p = InfixToPostfix(b);
		StdOut.println(p);
		StdOut.println(EvaluatePostfix(p));
	}
	
	//( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) 
	//1 2 3 + 4 5 * * +
	public static int precedance(String operator){ 
        switch (operator) 
        { 
        case "+": 
        case "-": 
            return 1; 
       
        case "*": 
        case "/": 
            return 2; 
       
        case "^": 
            return 3; 
        } 
        return -1; 
    } 
	
	public static String InfixToPostfix(String item) {
		
		//( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) 
		//1 2 3 + 4 5 * * +
		//stack = ( + ( ( * ( 
		//postfix = 1 2 3 + 4 5 *
		//make val stack
		//make oper stack
		
		String postfix = new String("");
		Stack<String> stack = new Stack<>();
		String[] words = item.split(" ");
		
		for (int i = 0; i<words.length;i++) {
			if (!(words[i].equals("(") ||words[i].equals(")") || words[i].equals("+") ||words[i].equals("-") ||words[i].equals("*") ||words[i].equals("/") ||words[i].equals("^"))) {
				postfix += words[i];
			}
			else if (words[i].equals("(")) {
				stack.push(words[i]);
			}
			else if (words[i].equals(")")) {
				while(!stack.isEmpty() && !stack.peek().equals("(")) {
					postfix += stack.pop();
					
				}
				if (!stack.isEmpty() && stack.peek().equals("(")) 
					stack.pop();
			}
			else {
				while(!stack.isEmpty() && precedance(words[i])<= precedance(stack.peek())){
					postfix +=stack.pop();
				}
				stack.push(words[i]);
			}
		}

		return postfix;
 	}
	
	public static double EvaluatePostfix(String item) {
		Stack<String> vals = new Stack<>();
		Stack<String> opr = new Stack<>();
		String[] words = item.split("");
		double v = 0;
		String op = "";
		
		//123+45**+
		//stack vals = 1 100 
		//stack opr = 
		//v = 5
		//op = *
		
		for (int i = 0; i < words.length; i++) {
			if (!(words[i].equals("+") ||words[i].equals("-") ||words[i].equals("*") ||words[i].equals("/") ||words[i].equals("^"))) {
				vals.push(words[i]);
			}
			else {
				opr.push(words[i]);
				v = Double.parseDouble(vals.pop());
				
				op = opr.pop();
				
				if (op.equals("+")) {
					v = Double.parseDouble(vals.pop()) + v;
					vals.push(Double.toString(v));
					
				}
				else if (op.equals("-")) {
					v = Double.parseDouble(vals.pop()) - v;
					vals.push(Double.toString(v));
					}
				else if (op.equals("*")) {
					v = Double.parseDouble(vals.pop()) * v;
					vals.push(Double.toString(v));
				}
				else if (op.equals("/")) {
					v = Double.parseDouble(vals.pop()) / v;
					vals.push(Double.toString(v));
				}
				
			}
			
			
		}
		return v;
	}
	
		
}
