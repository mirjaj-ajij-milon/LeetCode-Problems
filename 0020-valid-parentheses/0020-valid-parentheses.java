import java.util.*;

class Solution {
    public boolean isValid(String s) {
        // Use a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If it's an opening bracket, push it to the stack
            if (ch == '('|| ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // If stack is empty but we see a closing bracket, it's invalid
                if (stack.isEmpty()) {
                    return false;
                }
                // Check if the top of the stack matches the closing bracket
                char top = stack.peek();
                if ((top == '(' && ch == ')') 
                   || (top == '{' && ch == '}') 
                   || (top == '[' && ch == ']')) {
                    stack.pop();  // Pop if it matches
                } else {
                    // Mismatched bracket
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}