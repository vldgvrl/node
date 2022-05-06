import java.util.*;

public class Postfix {

    // Method to evaluate value of a postfix expression
    static int evaluatePostfix(String exp) {
        //create a stack
        Stack<Integer> stack = new Stack<>();
         
        // Scan all characters one by one
        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            System.out.println("current character: " + c);
             
            if(c == ' ')
                continue;
             
            // If the scanned character is an operand
            // (number here),extract the number
            // Push it to the stack.
            else if(Character.isDigit(c)) {
                int n = 0;
                 
                //extract the characters and store it in num
                while(Character.isDigit(c)) {
                    n = n*10 + (int)(c-'0');
                    i++;
                    c = exp.charAt(i);
                }
                i--;
 
                //push the number in stack
                stack.push(n);
                System.out.println("Stack at this point is: ");
                System.out.println(stack);
            }
             
            // If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                 
                switch(c) {
                    case '+':
                    stack.push(val2+val1);
                    System.out.println("Sum: " + val2 + " + " + val1 + " = " + stack.lastElement());
                    break;
                     
                    case '-':
                    stack.push(val2- val1);
                    System.out.println("Difference: " + val2 + " - " + val1 + " = " + stack.lastElement());
                    break;
                     
                    case '/':
                    stack.push(val2/val1);
                    System.out.println("Division: " + val2 + " / " + val1+ " = " + stack.lastElement());
                    break;
                     
                    case '*':
                    stack.push(val2*val1);
                    System.out.println("Multiply: " + val2 + " * " + val1+ " = " + stack.lastElement());
                    break;
                }
                
                System.out.println("Stack after calculation:" );
                System.out.println(stack);
            }
        }
        return stack.pop();
    }
     
    // Driver program to test above functions
    public static void main(String[] args)
    {
        String exp = "3 4 + 5 2 / *";
        System.out.println("Final result: " + evaluatePostfix(exp));
    }
}
 
// Algoritm was taken from https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
