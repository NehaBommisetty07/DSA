import java.util.*;

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int c = 0;

            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                c++;
            }

            res[i] = c + (stack.isEmpty() ? 0 : 1);

            stack.push(heights[i]); // 🔥 VERY IMPORTANT
        }

        return res;
    }
}