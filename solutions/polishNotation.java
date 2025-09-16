class Solution {
    public int evalRPN(String[] tokens) {
        // initialize our stack
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // switch statement handles logic for range of characters encountered
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    // variables are declared here to preserve order necessary for operation
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    // variables are declared here to preserve order necessary for operation
                    int bDiv = stack.pop();
                    int aDiv = stack.pop();
                    stack.push(aDiv / bDiv);
                    break;
                default:
                    // if token isn't an operator, push onto stack
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        // returns remaining integer in our stack
        return stack.pop();
    }
}