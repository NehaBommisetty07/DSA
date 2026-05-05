class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indicesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    // This closing paren has no matching open paren
                    indicesToRemove.add(i);
                } else {
                    // Match found, pop the opening paren index
                    stack.pop();
                }
            }
        }
        
        // Any remaining indices in the stack are unmatched '('
        while (!stack.isEmpty()) {
            indicesToRemove.add(stack.pop());
        }
        
        // Build the final string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indicesToRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
        
    }
}