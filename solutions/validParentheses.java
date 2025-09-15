class Solution {
    public boolean isValid(String s) {
        // initialize stack
        Stack<Character> stack = new Stack<>();
        // initialize hashmap, our parentheses key
        Map<Character, Character> parenthesesKey = new HashMap<>();
        parenthesesKey.put(')', '(');
        parenthesesKey.put(']', '[');
        parenthesesKey.put('}', '{');

        for (char c : s.toCharArray()) {
            // if stack is empty & top element in stack is our matching character
            if (!stack.isEmpty() && stack.peek() == parenthesesKey.get(c)) {
                // eliminate the matching element from the stack, effectively eliminating this match
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}