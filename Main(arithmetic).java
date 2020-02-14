/****************************************************
* CIS27 Lab 1 Q2 Evaluating Arithmetic Expressions  *
* -Main Function and class execution                *
* Participant : Uneeb Javed, Taeho Lee              *
*****************************************************/
public class Main{
    public static void main(String[] args) {
        String b = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) ";
        String p = ArithmeticExpressionEvaluator.InfixToPostfix(b);
        StdOut.println(p);
        StdOut.println(ArithmeticExpressionEvaluator.EvaluatePostfix(p));
        //      <results>
        // 		123+45**+                                                                                                                                     
        //         101.0
        
        b = "( 35 - ( 20 / ( 15 / 3 ) ) )";
        p = ArithmeticExpressionEvaluator.InfixToPostfix(b);
        StdOut.println(p);
        StdOut.println(ArithmeticExpressionEvaluator.EvaluatePostfix(p));
        //      <results>
        //      35 20 15 3 / / -                                                                                                                              
        //      31.0
        
    }
}
