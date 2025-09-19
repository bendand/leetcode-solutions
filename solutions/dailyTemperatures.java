public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // result array initialized with 0 values
        int[] res = new int[temperatures.length];
        // [[temp, index]]
        Stack<int[]> stack = new Stack<>(); 


        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            // while stack and t > last element in stack 
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                // pop t, i from stack
                int[] pair = stack.pop();
                // i value of popped pair is assigned diff of curr index and popped pair index 
                res[pair[1]] = i - pair[1];
            }

            // push t, i onto stack to continue monotonic pattern
            stack.push(new int[]{t, i});
        }
        
        return res;
    }
}