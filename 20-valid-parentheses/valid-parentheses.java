import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char i : s.toCharArray()) {

            if (i == '(' || i == '{' || i == '[') {
                st.push(i);
            } 
            else if (!st.isEmpty() && 
                    ((i == ')' && st.peek() == '(') ||
                     (i == '}' && st.peek() == '{') ||
                     (i == ']' && st.peek() == '['))) {

                st.pop();
            } 
            else {
                return false;
            }
        }

        return st.isEmpty();
    }
}