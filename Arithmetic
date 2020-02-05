
public class ArithmeticExpressionEvaluator {
	

	public static void main(String[] args) {
		String b = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) ";
		System.out.println(InfixToPostfix(b));
		
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
		//make val stack
		//make oper stack
		String postfix = new String("");
		Stack<String> stack = new Stack<>();
		String[] words = item.split(" ");
		for (int i =0; i<words.length;i++) {
			if (!(words[i].equals("(") ||words[i].equals(")") || words[i].equals("+") ||words[i].equals("-") ||words[i].equals("*") ||words[i].equals("/") ||words[i].equals("^"))) {
				postfix += words[i];
			}
			else if (words[i].equals("(")) {
				stack.push(words[i]);
			}
			else if (words[i].equals(")")) {
				while(!stack.isEmpty() && stack.peek().equals("(")) {
					postfix += stack.pop();
				}
				if (stack.isEmpty() && stack.peek().equals("(")) 
					stack.pop();
			}
			else {
				while(!stack.isEmpty() && precedance(words[i])<= precedance(stack.peek())){
					postfix +=stack.pop();
				}
			
				stack.push(words[i]);
			}
		}
		while(!stack.isEmpty()) {
			if(!stack.peek().equals("("))
				postfix += stack.pop();
		}
		return postfix;
 	}
	public void EvaluatePostfix(String item) {
		
	}
	
		
}
