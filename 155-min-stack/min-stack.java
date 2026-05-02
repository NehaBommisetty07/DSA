import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int val) {//-2,0,3
        stack.push(val);//-2,0,3
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);//-2
        }
    }
    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();//3
    }
    public int getMin() {
        return minStack.peek();//-2
    }
   
    }
