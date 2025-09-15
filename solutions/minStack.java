class MinStack {
    // define our stack and minStack
    private Stack<Integer> stack;
    // the use of minStack here makes accessing minimum value in constant time possible
    private Stack<Integer> minStack;

    public MinStack() {
        // initialize our stack and minStack
        stack = new Stack<>();
        minStack = new Stack<>();        
    }
    
    public void push(int val) {
        stack.push(val);
        // if val <= current min or minStack is empty, val is our new current min
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        // pop from stack
        int top = stack.pop();
        // if popped value is our minimum
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();        
    }
    
    public int getMin() {
        return minStack.peek();        
    }
}