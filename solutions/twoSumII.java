class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // setting up two pointers
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int curSum = numbers[l] + numbers[r];

            if (curSum > target) {
                // decrement right pointer if sum > target, decreasing sum
                r--;
            } else if (curSum < target) {
                // increment left pointer if sum < target, increasing sum
                l++;
            } else {
                // add 1 to result indices to mimic 1-indexing
                return new int[] { l + 1, r + 1 };
            }
        }
        return new int[0];
    }
}